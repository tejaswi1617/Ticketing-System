//Author : Vamsi Krishna Utla

package login;

import login.Interfaces.*;
import login.abstractfactory.*;
import userinterface.IInputOutputHandler;
import userinterface.InputOutputHandler;

public class Authentication implements IAuthentication
{
    ILoginFactory loginFactory = LoginFactory.instance();
    private final IAuthenticationDao authenticationOperations;
    private final IEncryption encryption = loginFactory.getEncryption();
    private final IInputOutputHandler inputOutputHandler = new InputOutputHandler();

    public Authentication(IAuthenticationDao authenticationOperations)
    {
        this.authenticationOperations = authenticationOperations;
    }

    public boolean authenticateUser(String employeeID, String user_password)
    {
        boolean result;
        final String failedMessage = "Error: User does not exist. Please try with correct username.";
        final String successfulMessage = "Login Successful";
        String actual_password;
        
        user_password = encryption.encryptPassword(user_password);
        actual_password = authenticationOperations.getPassword(employeeID);
        if(actual_password == null)
        {
            return false;
        }
        if(actual_password.equals(user_password))
        {
            inputOutputHandler.displayMethod(successfulMessage);
            result = true;
            return result;
        }
        else
        {
            inputOutputHandler.displayMethod(failedMessage);
            result = false;
            return result;
        }
    }

    public IParameterizedUser getUserDetails(String employeeID)
    {
        return authenticationOperations.getUserDetails(employeeID);
    }
}
