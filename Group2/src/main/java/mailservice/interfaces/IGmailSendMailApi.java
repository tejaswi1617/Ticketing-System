//Author : Akshay Garg

package mailservice.interfaces;

public interface IGmailSendMailApi {

	boolean sendMail(String mailConfiguration, String userConfiguration, IMailMessage mailMessage) throws Exception;

}