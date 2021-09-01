package mailservice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import mailservice.abstractfactory.IMailFactory;
import mailservice.abstractfactory.MailFactoryMock;
import mailservice.interfaces.IMailMessage;

public class MailMessageTest {

	private final String RECIPIENT = "abc@gmail.com";
	private final String RECIPIENT2 = "def@gmail.com";
	private final String SUBJECT = "TEST";
	private final String BODY = "Testing MailMessage class";
	private final String NULL_OBJECT = null;
	private final String EMPTY = "";

	private IMailMessage mailMessage;

	@Before
	public void init() {
		IMailFactory mailFactory = MailFactoryMock.instance();
		mailMessage = mailFactory.makeMailMessageObject();
	}

	@Test
	public void addRecipientNullTest() {
		mailMessage.addRecipient(NULL_OBJECT);
		List<String> recipients = mailMessage.getRecipients();
		boolean noObjectInRecipients = recipients.size() == 0;
		assertTrue(noObjectInRecipients);
	}

	@Test
	public void addRecipientEmptyTest() {
		mailMessage.addRecipient(EMPTY);
		List<String> recipients = mailMessage.getRecipients();
		boolean noObjectInRecipients = recipients.size() == 0;
		assertTrue(noObjectInRecipients);
	}

	@Test
	public void addRecipientTest() {
		mailMessage.addRecipient(RECIPIENT);
		List<String> recipients = mailMessage.getRecipients();
		boolean isRecipientAdded = recipients.contains(RECIPIENT);
		assertTrue(isRecipientAdded);
	}

	@Test
	public void removeRecipientNullTest() {
		mailMessage.addRecipient(RECIPIENT);
		boolean isRecipientRempoved = mailMessage.removeRecipient(NULL_OBJECT);
		assertFalse(isRecipientRempoved);
	}

	@Test
	public void removeRecipientEmptyTest() {
		mailMessage.addRecipient(RECIPIENT);
		boolean isRecipientRempoved = mailMessage.removeRecipient(EMPTY);
		assertFalse(isRecipientRempoved);
	}

	@Test
	public void removeRecipientTest() {
		mailMessage.addRecipient(RECIPIENT);
		List<String> recipients = mailMessage.getRecipients();
		boolean isRecipientAdded = recipients.contains(RECIPIENT);
		assertTrue(isRecipientAdded);
		mailMessage.removeRecipient(RECIPIENT);
		recipients = mailMessage.getRecipients();
		boolean isRecipientRemoved = recipients.size() == 0;
		assertTrue(isRecipientRemoved);
	}

	@Test
	public void getRecipientsTest() {
		mailMessage.addRecipient(RECIPIENT);
		mailMessage.addRecipient(RECIPIENT2);
		List<String> recipients = mailMessage.getRecipients();
		boolean isRecipientAdded = recipients.size() == 2;
		assertTrue(isRecipientAdded);
	}

	@Test
	public void addSubjectTest() {
		mailMessage.addSubject(SUBJECT);
		String subject = mailMessage.getSubject();
		assertEquals(SUBJECT, subject);
	}

	@Test
	public void addBodyTest() {
		mailMessage.addBody(BODY);
		String body = mailMessage.getBody();
		assertEquals(BODY, body);
	}
}
