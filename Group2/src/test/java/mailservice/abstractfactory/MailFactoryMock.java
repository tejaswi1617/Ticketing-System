package mailservice.abstractfactory;

import mailservice.Gmail;
import mailservice.GmailSendMailApiMock;
import mailservice.MailMessage;
import mailservice.interfaces.IGmailSendMailApi;
import mailservice.interfaces.IMail;
import mailservice.interfaces.IMailMessage;

public class MailFactoryMock implements IMailFactory {

	public final String GMAIL = "gmail";

	private static IMailFactory uniqueInstance = null;

	private MailFactoryMock() {
	}

	public static IMailFactory instance() {
		if (null == uniqueInstance) {
			uniqueInstance = new MailFactoryMock();
		}
		return uniqueInstance;
	}

	@Override
	public IMail makeMailObject(String mailType) {

		if (mailType == null) {
			return null;
		}

		if (mailType.equalsIgnoreCase(GMAIL)) {
			IGmailSendMailApi gmailSendMailApi = new GmailSendMailApiMock();
			return new Gmail(gmailSendMailApi);
		}
		return null;
	}

	@Override
	public IMailMessage makeMailMessageObject() {
		// TODO Auto-generated method stub
		return new MailMessage();
	}

}
