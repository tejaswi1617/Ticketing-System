package menucontroller;

import login.Interfaces.IParameterizedUser;
import menucontroller.interfaces.IMenuTask;
import userinterface.IInputOutputHandler;
import userinterface.ISearchTicketScreen;
import userinterface.abstractFactory.IUserInterfaceFactory;
import userinterface.abstractFactory.UserInterfaceFactory;

public class SearchTicketMenuTask implements IMenuTask {

	@Override
	public void runMenuTask(IParameterizedUser user, IInputOutputHandler inputOutputHandler)
	{
		IUserInterfaceFactory userInterfaceFactory = UserInterfaceFactory.instance();
		ISearchTicketScreen getsearchticketscreen = userInterfaceFactory.getsearchTicketScreen(inputOutputHandler);
		getsearchticketscreen.searchTicketScreen(user);
	}
}
