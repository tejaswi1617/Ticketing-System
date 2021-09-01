//Author : Akshay Garg

package mailservice.abstractfactory;

import mailservice.Gmail;
import mailservice.GmailSendMailApi;
import mailservice.MailMessage;
import mailservice.interfaces.IGmailSendMailApi;
import mailservice.interfaces.IMail;
import mailservice.interfaces.IMailMessage;

public class MailFactory implements IMailFactory {

	public final String GMAIL = "gmail";

	private static IMailFactory uniqueInstance = null;

	private MailFactory() {
	}

	public static IMailFactory instance() {
		if (null == uniqueInstance) {
			uniqueInstance = new MailFactory();
		}
		return uniqueInstance;
	}

	@Override
	public IMail makeMailObject(String mailType) {

		if (mailType == null) {
			return null;
		}

		if (mailType.equalsIgnoreCase(GMAIL)) {
			IGmailSendMailApi gmailSendMailApi = new GmailSendMailApi();
			return new Gmail(gmailSendMailApi);
		}

		return null;
	}

	@Override
	public IMailMessage makeMailMessageObject() {
		return new MailMessage();
	}
}
