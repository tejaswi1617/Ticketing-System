//Author : Vamsi Krishna Utla

package login.Interfaces;

public interface IAuthentication
{
    boolean authenticateUser(String employeeID, String user_password);
    IParameterizedUser getUserDetails(String employeeID);
}
