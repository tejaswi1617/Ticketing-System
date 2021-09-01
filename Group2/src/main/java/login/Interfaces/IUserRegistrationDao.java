//Author : Vamsi Krishna Utla

package login.Interfaces;

public interface IUserRegistrationDao
{
    boolean registerUserDatabase(IParameterizedUser user, String user_password);
    boolean checkDuplicateEmployeeID(String employeeID);
}
