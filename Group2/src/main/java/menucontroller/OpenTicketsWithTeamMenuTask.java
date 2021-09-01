package menucontroller;

import login.Interfaces.IParameterizedUser;
import menucontroller.interfaces.IMenuTask;
import userinterface.IInputOutputHandler;
import userinterface.IManagerTeamTrackingScreen;
import userinterface.abstractFactory.IUserInterfaceFactory;
import userinterface.abstractFactory.UserInterfaceFactory;

public class OpenTicketsWithTeamMenuTask implements IMenuTask {

	@Override
	public void runMenuTask(IParameterizedUser user, IInputOutputHandler inputOutputHandler) {
		IUserInterfaceFactory userInterfaceFactory = UserInterfaceFactory.instance();
		IManagerTeamTrackingScreen managerTeamTrackingScreen = userInterfaceFactory.getmangerTeamTrackingScreen(inputOutputHandler);
		managerTeamTrackingScreen.displayManagerTrackingScreen(user);
	}
}
