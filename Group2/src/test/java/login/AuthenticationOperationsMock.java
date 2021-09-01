//Author : Vamsi Krishna Utla

package login;

import login.Interfaces.IParameterizedUser;
import login.Interfaces.IAuthenticationDao;

public class AuthenticationOperationsMock implements IAuthenticationDao
{
    public String getPassword(String employeeID) {
        return "AcegD68:";
    }

    public IParameterizedUser getUserDetails(String employeeID)
    {
        return null;
    }
}
