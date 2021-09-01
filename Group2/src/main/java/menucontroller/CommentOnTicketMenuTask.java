package menucontroller;

import login.Interfaces.IParameterizedUser;
import menucontroller.interfaces.IMenuTask;
import userinterface.ICommentOnTicketScreen;
import userinterface.IInputOutputHandler;
import userinterface.abstractFactory.IUserInterfaceFactory;
import userinterface.abstractFactory.UserInterfaceFactory;

public class CommentOnTicketMenuTask implements IMenuTask {
	
	@Override
	public void runMenuTask(IParameterizedUser user, IInputOutputHandler inputOutputHandler)  {
		IUserInterfaceFactory userInterfaceFactory = UserInterfaceFactory.instance();
		ICommentOnTicketScreen commentonticketscreen = userInterfaceFactory.getCommentOnTicketScreen(inputOutputHandler);
		commentonticketscreen.commentonticketscreen(user);
	}
}
