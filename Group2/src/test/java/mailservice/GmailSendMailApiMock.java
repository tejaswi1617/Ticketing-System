package mailservice;

import org.apache.commons.lang3.StringUtils;

import mailservice.interfaces.IGmailSendMailApi;
import mailservice.interfaces.IMailMessage;

public class GmailSendMailApiMock implements IGmailSendMailApi {

	@Override
	public boolean sendMail(String mailConfiguration, String userConfiguration, IMailMessage mailMessage)
			throws Exception {

		boolean isMessageSentSuccessfully = false;

		if (StringUtils.isBlank(mailConfiguration) || StringUtils.isBlank(userConfiguration) || mailMessage == null) {
			return isMessageSentSuccessfully;
		}

		isMessageSentSuccessfully = true;

		return isMessageSentSuccessfully;
	}

}
