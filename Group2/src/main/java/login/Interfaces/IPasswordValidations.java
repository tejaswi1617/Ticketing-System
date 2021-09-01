//Author : Vamsi Krishna Utla

package login.Interfaces;

public interface IPasswordValidations
{
    boolean checkUpperCaseRule(String user_password);
    boolean checkLowerCaseRule(String user_password);
    boolean checkNumberRule(String user_password);
    boolean checkSpecialCharacterRule(String user_password);
    boolean checkLengthRule(String user_password);
}
