package menucontroller;

import login.Interfaces.IParameterizedUser;
import menucontroller.interfaces.IMenuTask;
import userinterface.ICustomerAnalysisScreen;
import userinterface.IInputOutputHandler;
import userinterface.abstractFactory.IUserInterfaceFactory;
import userinterface.abstractFactory.UserInterfaceFactory;

public class CustomerAnalysisMenuTask implements IMenuTask {
	
	@Override
	public void runMenuTask(IParameterizedUser user, IInputOutputHandler inputOutputHandler) {
		IUserInterfaceFactory userInterfaceFactory = UserInterfaceFactory.instance();
		ICustomerAnalysisScreen customerAnalysisScreen = userInterfaceFactory
				.getCustomerAnalysisScreen(inputOutputHandler);
		customerAnalysisScreen.displayCustomerAnalysisScreen(user);
	}
}
