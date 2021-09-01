package menucontroller;

import login.Interfaces.IParameterizedUser;
import menucontroller.interfaces.IMenuTask;
import userinterface.IInputOutputHandler;
import userinterface.ISortTciketScreen;
import userinterface.abstractFactory.IUserInterfaceFactory;
import userinterface.abstractFactory.UserInterfaceFactory;

public class SortTicketMenuTask implements IMenuTask {
	
	@Override
	public void runMenuTask(IParameterizedUser user, IInputOutputHandler inputOutputHandler) {
		IUserInterfaceFactory userInterfaceFactory = UserInterfaceFactory.instance();
		ISortTciketScreen sortTicketscreen = userInterfaceFactory.getsortTicketScreen(inputOutputHandler);
		sortTicketscreen.sortticketscreen(user);
	}
}
