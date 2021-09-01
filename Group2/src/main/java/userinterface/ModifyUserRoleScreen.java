//Author : Akshay Garg

package userinterface;

import login.Interfaces.IParameterizedUser;
import roles.abstractfactory.IRoleFactory;
import roles.abstractfactory.RoleFactory;
import roles.interfaces.IModifyUserRole;
import userinterface.abstractFactory.IUserInterfaceFactory;
import userinterface.abstractFactory.UserInterfaceFactory;

public class ModifyUserRoleScreen implements IModifyUserRoleScreen {

	public final String SUCCESSFUL_USER_ROLE_UPDATE = "User role is updated successfully.";
	public final String UNSUCCESSFUL_USER_ROLE_UPDATE = "Error while updating user role. Please contact admin.";

	private IInputOutputHandler inputOutputHandler;
	private IModifyUserRole modifyUserRole;
	IBackToHomePageScreen backToHomePageScreen;
	IUserInterfaceFactory userInterfaceFactory;
	IRoleFactory roleFactory;

	public ModifyUserRoleScreen(IInputOutputHandler inputOutputHandler) {
		this.inputOutputHandler = inputOutputHandler;
	}

	public void displayModifyUserRoleScreen(IParameterizedUser user) {

		try {
			roleFactory = RoleFactory.instance();
			modifyUserRole = roleFactory.makeModifyUserRoleObject();

			inputOutputHandler.displayMethod("Enter employee ID of the user whose role needs to be updated:");
			String inputEmpId = inputOutputHandler.input();
			inputOutputHandler.displayMethod("\nEnter new role:");
			String inputUserType = inputOutputHandler.input();
			boolean isUserRoleModified = modifyUserRole.modifyUserRole(inputEmpId, inputUserType);
			if (isUserRoleModified) {
				inputOutputHandler.displayMethod(SUCCESSFUL_USER_ROLE_UPDATE);
			} else {
				inputOutputHandler.displayMethod(UNSUCCESSFUL_USER_ROLE_UPDATE);
			}

		} catch (Exception e) {
			inputOutputHandler.displayMethod(UNSUCCESSFUL_USER_ROLE_UPDATE);
		}

		userInterfaceFactory = UserInterfaceFactory.instance();
		backToHomePageScreen = userInterfaceFactory.getBackToHomePageScreen(inputOutputHandler);
		backToHomePageScreen.displayGoBackToHomePageOption(user);
	}

}
