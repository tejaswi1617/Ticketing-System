//Author : Vamsi Krishna Utla

package login.abstractfactory;

import login.Interfaces.*;
import mailservice.interfaces.IMail;

public interface ILoginFactoryTest
{
    IAuthenticationDao getAuthenticationOperationsMock();
    IMail getMailMock();
    IForgotPasswordDao getPersistenceForgotPasswordOperationsMock();
    IUserRegistrationDao getPersistenceUserRegistrationOperationsMock();
}
