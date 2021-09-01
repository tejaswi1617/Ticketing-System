//Author : Akshay Garg

package mailservice;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.apache.commons.lang3.StringUtils;
import mailservice.interfaces.IGmailSendMailApi;
import mailservice.interfaces.IMailMessage;

public class GmailSendMailApi implements IGmailSendMailApi {
	private final String WRONG_FILE_PATH_MESSAGE = "Please check configuration files path.";
	private final String MAIL_FAILURE_EXCEPTION = "Exception occurred while sending mail.";
	private final String USERNAME_KEY = "username";
	private final String PASSWORD_KEY = "password";

	@Override
	public boolean sendMail(String mailConfiguration, String userConfiguration, IMailMessage mailMessage)
			throws Exception {

		if (StringUtils.isBlank(mailConfiguration) || StringUtils.isBlank(userConfiguration) || mailMessage == null) {
			return false;
		}

		boolean messageSendSuccesfully = true;

		Properties mailConfigurationProperties = null;
		Properties userConfigurationProperties = null;

		try {
			mailConfigurationProperties = ReadPropertiesFile.readConfigPropertyFile(mailConfiguration);
			userConfigurationProperties = ReadPropertiesFile.readConfigPropertyFile(userConfiguration);
		} catch (IOException e) {
			throw new IllegalArgumentException(WRONG_FILE_PATH_MESSAGE);
		}

		final String username = userConfigurationProperties.getProperty(USERNAME_KEY);
		final String password = userConfigurationProperties.getProperty(PASSWORD_KEY);

		try {
			Session session = Session.getDefaultInstance(mailConfigurationProperties, new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			});

			Message mimeMessage = new MimeMessage(session);
			prepareMimeMessage(mimeMessage, mailMessage, username);
			Transport.send(mimeMessage);

		} catch (MessagingException e) {
			messageSendSuccesfully = false;
			throw new Exception(MAIL_FAILURE_EXCEPTION);
		}
		return messageSendSuccesfully;
	}

	private Message prepareMimeMessage(Message mimeMessage, IMailMessage mailMessage, String username)
			throws AddressException, MessagingException {
		mimeMessage.setFrom(new InternetAddress(username));
		String commaSeparatedRecipients = StringUtils.join(mailMessage.getRecipients(), ',');
		mimeMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(commaSeparatedRecipients, false));
		mimeMessage.setSubject(mailMessage.getSubject());
		mimeMessage.setText(mailMessage.getBody());
		mimeMessage.setSentDate(new Date());
		return mimeMessage;
	}
}
