package menucontroller;

import login.Interfaces.IParameterizedUser;
import menucontroller.interfaces.IMenuTask;
import userinterface.IForgotPasswordScreen;
import userinterface.IInputOutputHandler;
import userinterface.abstractFactory.*;

public class ForgotPasswordMenuTask implements IMenuTask {

	@Override
	public void runMenuTask(IParameterizedUser user, IInputOutputHandler inputOutputHandler) {
		IUserInterfaceFactory userInterfaceFactory = UserInterfaceFactory.instance();
		IForgotPasswordScreen forgotPasswordScreen = userInterfaceFactory.getForgotPasswordScreen(inputOutputHandler);
		forgotPasswordScreen.getForgotPasswordScreen();
	}
}
