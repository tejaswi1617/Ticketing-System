//Author : Vamsi Krishna Utla

package login;

import mailservice.interfaces.IMail;
import mailservice.interfaces.IMailMessage;

public class MailMock implements IMail
{
    public boolean sendMail(String mailConfiguration, String userConfiguration, IMailMessage message) throws Exception
    {
        return true;
    }
}
