//Author : Vamsi Krishna Utla

package login;

import static org.junit.Assert.*;
import login.abstractfactory.ILoginFactory;
import login.abstractfactory.ILoginFactoryTest;
import login.abstractfactory.LoginFactory;
import login.abstractfactory.LoginFactoryTest;
import org.junit.Test;
import userinterface.*;
import login.Interfaces.*;
import userinterface.abstractFactory.IUserInterfaceFactory;
import userinterface.abstractFactory.UserInterfaceFactory;

public class RegistrationTest
{
	ILoginFactoryTest loginFactoryTest = LoginFactoryTest.instance();
	IUserInterfaceFactory userInterfaceFactory = new UserInterfaceFactory();
	IInputOutputHandler inputOutputHandler = userInterfaceFactory.getInputOutputHandler();
	IUserRegistrationDao databaseUserMock = loginFactoryTest.getPersistenceUserRegistrationOperationsMock();

	@Test
	public void registerUserTestSuccessfull()
	{
		ParameterizedUser user = new ParameterizedUser("111", "Daniel", "Howards", "custom@gmail.com", "End_User", "emp_666");
		IRegister registration = new Registration(databaseUserMock, inputOutputHandler);
		assertTrue("Test failed.", registration.registerUser(user, "Abcd@123"));
	}

	@Test
	public void registerUserTestUnsuccessfull_Duplicate()
	{
		IParameterizedUser user = new ParameterizedUser("112", "Daniel", "Howards", "custom@gmail.com", "End_User", "emp_222");
		IRegister registration = new Registration(databaseUserMock, inputOutputHandler);
		assertFalse("Test failed.", registration.registerUser(user, "Abcd@123"));
	}

	@Test
	public void checkPasswordRules()
	{
		IParameterizedUser user_one = new ParameterizedUser("114", "Daniel", "Howards", "custom@gmail.com", "End_User", "emp_111");
		IParameterizedUser user_two = new ParameterizedUser("115", "Daniel", "Howards", "custom@gmail.com", "End_User", "emp_000");
		IParameterizedUser user_three = new ParameterizedUser("116", "Daniel", "Howards", "custom@gmail.com", "End_User", "emp_099");
		IRegister registration = new Registration(databaseUserMock, inputOutputHandler);

		assertFalse("Test failed.", registration.registerUser(user_one, "abcd@123"));

		assertFalse("Test failed.", registration.registerUser(user_one, "ABCD@123"));

		assertFalse("Test failed.", registration.registerUser(user_one, "ABCD@abcd"));

		assertFalse("Test failed.", registration.registerUser(user_one, "ADa1@"));

		assertFalse("Test failed.", registration.registerUser(user_one, "ADa112349"));

	}
}
