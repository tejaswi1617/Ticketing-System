package menucontroller;

import login.Interfaces.IParameterizedUser;
import menucontroller.interfaces.IMenuTask;
import userinterface.IInputOutputHandler;
import userinterface.ITwitterPostScreen;
import userinterface.abstractFactory.IUserInterfaceFactory;
import userinterface.abstractFactory.UserInterfaceFactory;

public class TwitterPostingMenuTask implements IMenuTask {

	public void runMenuTask(IParameterizedUser user, IInputOutputHandler inputOutputHandler) {
		IUserInterfaceFactory userInterfaceFactory = UserInterfaceFactory.instance();
		ITwitterPostScreen twitterPost = userInterfaceFactory.getTwitterPostScreen(inputOutputHandler);
		twitterPost.displayTwitterPostScreen(user);
	}
}
