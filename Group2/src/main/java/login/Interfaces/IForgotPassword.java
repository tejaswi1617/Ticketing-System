//Author : Vamsi Krishna Utla

package login.Interfaces;

public interface IForgotPassword
{
    boolean sendOTP(String employeeID);
    public boolean updatePassword(int otp, String newPassword);
}
