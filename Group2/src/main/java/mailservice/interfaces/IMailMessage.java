//Author : Akshay Garg

package mailservice.interfaces;

import java.util.List;

public interface IMailMessage {

	void addRecipient(String recipient);

	boolean removeRecipient(String recipient);

	List<String> getRecipients();

	String getSubject();

	void addSubject(String subject);

	String getBody();

	void addBody(String body);

}