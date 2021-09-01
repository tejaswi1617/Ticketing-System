package menucontroller;

import login.Interfaces.IParameterizedUser;
import menucontroller.interfaces.IMenuTask;
import userinterface.IInputOutputHandler;
import userinterface.IRatingScreen;
import userinterface.abstractFactory.*;

public class RatingMenuTask implements IMenuTask {

	@Override
	public void runMenuTask(IParameterizedUser user, IInputOutputHandler inputOutputHandler) {
		IUserInterfaceFactory userInterfaceFactory = UserInterfaceFactory.instance();
		IRatingScreen ratingScreen = userInterfaceFactory.getRatingScreen(inputOutputHandler);
		ratingScreen.displayRatingScreen(user);
	}
}
