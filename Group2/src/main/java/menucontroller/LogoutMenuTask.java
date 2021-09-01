package menucontroller;

import login.Interfaces.IParameterizedUser;
import menucontroller.interfaces.IMenuTask;
import userinterface.*;
import userinterface.abstractFactory.IUserInterfaceFactory;
import userinterface.abstractFactory.UserInterfaceFactory;

public class LogoutMenuTask implements IMenuTask {

	@Override
	public void runMenuTask(IParameterizedUser user, IInputOutputHandler inputOutputHandler) {
		IUserInterfaceFactory userInterfaceFactory = UserInterfaceFactory.instance();
		IServiceNowWelcomeScreen serviceNowWelcomeScreen = userInterfaceFactory
				.getServiceNowWelcomeScreen(inputOutputHandler);
		serviceNowWelcomeScreen.displayLoginScreen();
	}
}
