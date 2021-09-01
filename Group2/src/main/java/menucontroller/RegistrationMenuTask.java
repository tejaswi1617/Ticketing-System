package menucontroller;

import login.Interfaces.IParameterizedUser;
import menucontroller.interfaces.IMenuTask;
import userinterface.IInputOutputHandler;
import userinterface.IRegistrationScreen;
import userinterface.abstractFactory.*;

public class RegistrationMenuTask implements IMenuTask {

	@Override
	public void runMenuTask(IParameterizedUser user, IInputOutputHandler inputOutputHandler) {
		IUserInterfaceFactory userInterfaceFactory = UserInterfaceFactory.instance();
		IRegistrationScreen registrationScreen = userInterfaceFactory.getRegistrationScreen(inputOutputHandler);
		registrationScreen.displayRegistrationScreen();
	}
}
