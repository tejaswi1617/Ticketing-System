//Author : Akshay Garg

package mailservice.abstractfactory;

import mailservice.interfaces.IMail;
import mailservice.interfaces.IMailMessage;

public interface IMailFactory {

	IMail makeMailObject(String mailType);

	IMailMessage makeMailMessageObject();

}