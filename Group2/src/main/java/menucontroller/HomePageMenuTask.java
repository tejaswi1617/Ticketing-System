package menucontroller;

import login.Interfaces.IParameterizedUser;
import menucontroller.interfaces.IMenuTask;
import userinterface.IHomePageScreen;
import userinterface.IInputOutputHandler;
import userinterface.abstractFactory.IUserInterfaceFactory;
import userinterface.abstractFactory.UserInterfaceFactory;

public class HomePageMenuTask implements IMenuTask {

	@Override
	public void runMenuTask(IParameterizedUser user, IInputOutputHandler inputOutputHandler) {
		IUserInterfaceFactory userInterfaceFactory = UserInterfaceFactory.instance();
		IHomePageScreen homePageScreen = userInterfaceFactory.getHomePageScreen(inputOutputHandler);
		homePageScreen.handleHomePageMenu(user);
	}
}
