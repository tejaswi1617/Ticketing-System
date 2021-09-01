//Author : Akshay Garg

package mailservice.interfaces;

public interface IMail {
	public boolean sendMail(String mailConfiguration, String userConfiguration, IMailMessage message) throws Exception;
}
