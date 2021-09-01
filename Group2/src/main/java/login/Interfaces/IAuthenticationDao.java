//Author : Vamsi Krishna Utla

package login.Interfaces;

public interface IAuthenticationDao
{
    String getPassword(String employeeID);
    IParameterizedUser getUserDetails(String employeeID);
}
