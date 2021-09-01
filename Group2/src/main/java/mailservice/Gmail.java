//Author : Akshay Garg

package mailservice;

import org.apache.commons.lang3.StringUtils;
import mailservice.interfaces.IGmailSendMailApi;
import mailservice.interfaces.IMail;
import mailservice.interfaces.IMailMessage;

public class Gmail implements IMail {

	private IGmailSendMailApi gmailSendMailApi = null;

	public Gmail(IGmailSendMailApi gmailSendMailApi) {
		super();
		this.gmailSendMailApi = gmailSendMailApi;
	}

	@Override
	public boolean sendMail(String mailConfiguration, String userConfiguration, IMailMessage mailMessage)
			throws Exception {
		boolean messageSendSuccesfully = false;

		if (StringUtils.isBlank(mailConfiguration) || StringUtils.isBlank(userConfiguration) || mailMessage == null) {
			return false;
		}

		messageSendSuccesfully = gmailSendMailApi.sendMail(mailConfiguration, userConfiguration, mailMessage);
		
		return messageSendSuccesfully;
	}

}
