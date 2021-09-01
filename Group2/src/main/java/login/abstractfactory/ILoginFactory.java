//Author : Vamsi Krishna Utla

package login.abstractfactory;

import login.Interfaces.*;
import mailservice.interfaces.IMail;
import userinterface.IInputOutputHandler;
import java.io.IOException;

public interface ILoginFactory
{
    IAuthentication getAuthentication(IAuthenticationDao authenticationOperations);
    IAuthenticationDao getAuthenticationOperations() throws IOException;
    IEncryption getEncryption();
    IForgotPassword getForgotPassword(IMail mail, IForgotPasswordDao persistenceForgotPasswordOperations);
    IParameterizedUser getParameterizedUser(String employeeID, String firstName, String lastName, String email, String user_type, String manager);
    IPasswordValidations getPasswordValidations();
    IForgotPasswordDao getPersistenceForgotPasswordOperations() throws IOException;
    IUserRegistrationDao getPersistenceUserRegistrationOperations() throws IOException;
    IRegister getRegister(IUserRegistrationDao userRegistrationOperations, IInputOutputHandler inputOutputHandler);
}
