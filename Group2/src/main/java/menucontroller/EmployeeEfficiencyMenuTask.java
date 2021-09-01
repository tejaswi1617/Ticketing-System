package menucontroller;

import login.Interfaces.IParameterizedUser;
import menucontroller.interfaces.IMenuTask;
import userinterface.IEmployeeMilestoneScreen;
import userinterface.IInputOutputHandler;
import userinterface.abstractFactory.IUserInterfaceFactory;
import userinterface.abstractFactory.UserInterfaceFactory;

public class EmployeeEfficiencyMenuTask implements IMenuTask {

	@Override
	public void runMenuTask(IParameterizedUser user, IInputOutputHandler inputOutputHandler) {
		IUserInterfaceFactory userInterfaceFactory = UserInterfaceFactory.instance();
		IEmployeeMilestoneScreen employeeMilestoneScreen = userInterfaceFactory
				.getEmployeeMilestoneScreen(inputOutputHandler);
		employeeMilestoneScreen.displayEmployeeMileStoneScreen(user);
	}
}
