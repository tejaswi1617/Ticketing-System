//Author : Vamsi Krishna Utla

package login.abstractfactory;

import login.*;
import login.Interfaces.*;
import mailservice.interfaces.IMail;
import userinterface.IInputOutputHandler;
import java.io.IOException;

public class LoginFactory implements ILoginFactory
{
    private static ILoginFactory uniqueInstance = null;

    private LoginFactory()
    {

    }

    public static ILoginFactory instance()
    {
        if(null == uniqueInstance)
        {
            uniqueInstance = new LoginFactory();
        }
        return uniqueInstance;
    }

    public IAuthentication getAuthentication(IAuthenticationDao authenticationOperations)
    {
        return new Authentication(authenticationOperations);
    }

    public IAuthenticationDao getAuthenticationOperations() throws IOException
    {
        return new AuthenticationDao();
    }

    public IEncryption getEncryption()
    {
        return new Encryption();
    }

    public IForgotPassword getForgotPassword(IMail mail, IForgotPasswordDao persistenceForgotPasswordOperations)
    {
        return new ForgotPassword(mail, persistenceForgotPasswordOperations);
    }

    public IParameterizedUser getParameterizedUser(String employeeID, String firstName, String lastName, String email, String user_type, String manager)
    {
        return new ParameterizedUser(employeeID, firstName, lastName, email, user_type, manager);
    }

    public IPasswordValidations getPasswordValidations()
    {
        return new PasswordValidations();
    }

    public IForgotPasswordDao getPersistenceForgotPasswordOperations() throws IOException
    {
        return new ForgotPasswordDao();
    }

    public IUserRegistrationDao getPersistenceUserRegistrationOperations() throws IOException
    {
        return new UserRegistrationDao();
    }

    public IRegister getRegister(IUserRegistrationDao userRegistrationOperations, IInputOutputHandler inputOutputHandler)
    {
        return new Registration(userRegistrationOperations, inputOutputHandler);
    }
}
