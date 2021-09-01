//Author : Vamsi Krishna Utla

package login.Interfaces;

public interface IForgotPasswordDao
{
    String getEmail(String employeeID);
    boolean updatePassword(String employeeID, String newPassword);
}
