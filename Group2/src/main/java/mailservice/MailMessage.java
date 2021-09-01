//Author : Akshay Garg

package mailservice;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import mailservice.interfaces.IMailMessage;

public class MailMessage implements IMailMessage {

	private List<String> recipients;
	private String subject;
	private String body;

	public MailMessage() {
		recipients = new ArrayList<String>();
	}

	@Override
	public void addRecipient(String recipient) {
		if (StringUtils.isNotBlank(recipient)) {
			recipients.add(recipient);
		}
	}

	@Override
	public boolean removeRecipient(String recipient) {
		boolean isRecipentRemoved = false;

		if (StringUtils.isBlank(recipient)) {
			return isRecipentRemoved;
		}

		if (recipients.contains(recipient)) {
			isRecipentRemoved = recipients.remove(recipient);
			isRecipentRemoved = true;
		}

		return isRecipentRemoved;
	}

	@Override
	public List<String> getRecipients() {
		List<String> clonedList = new ArrayList<String>(recipients);
		return clonedList;
	}

	@Override
	public String getSubject() {
		return subject;
	}

	@Override
	public void addSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String getBody() {
		return body;
	}

	@Override
	public void addBody(String body) {
		this.body = body;
	}

}
