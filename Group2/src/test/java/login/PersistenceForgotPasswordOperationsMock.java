//Author : Vamsi Krishna Utla

package login;

import login.Interfaces.IForgotPasswordDao;

public class PersistenceForgotPasswordOperationsMock implements IForgotPasswordDao
{
    public String getEmail(String employeeID)
    {
        return "dummy@gmail.com";
    }
    public boolean updatePassword(String employeeID, String newPassword)
    {
        return false;
    }
}
