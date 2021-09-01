package menucontroller;

import login.Interfaces.IParameterizedUser;
import menucontroller.interfaces.IMenuTask;
import userinterface.IDeleteTicketScreen;
import userinterface.IInputOutputHandler;
import userinterface.abstractFactory.IUserInterfaceFactory;
import userinterface.abstractFactory.UserInterfaceFactory;

public class DeleteTicketMenuTask implements IMenuTask {

	@Override
	public void runMenuTask(IParameterizedUser user, IInputOutputHandler inputOutputHandler)
	{
		IUserInterfaceFactory userInterfaceFactory = UserInterfaceFactory.instance();
		IDeleteTicketScreen deleteticketscreen = userInterfaceFactory.getdeleteTicketScreen(inputOutputHandler);
		deleteticketscreen.deleteTicketScreen(user);

	}
}
