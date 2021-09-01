package menucontroller;

import login.Interfaces.IParameterizedUser;
import menucontroller.interfaces.IMenuTask;
import userinterface.IInputOutputHandler;
import userinterface.IModifyUserRoleScreen;
import userinterface.abstractFactory.IUserInterfaceFactory;
import userinterface.abstractFactory.UserInterfaceFactory;

public class ModifyUserRoleMenuTask implements IMenuTask {

	@Override
	public void runMenuTask(IParameterizedUser user, IInputOutputHandler inputOutputHandler) {
		IUserInterfaceFactory userInterfaceFactory = UserInterfaceFactory.instance();
		IModifyUserRoleScreen modifyUserRoleScreen = userInterfaceFactory.getModifyUserRoleScreen(inputOutputHandler);
		modifyUserRoleScreen.displayModifyUserRoleScreen(user);
	}
}
