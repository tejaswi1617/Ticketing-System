//Author : Akshay Garg

package userinterface;

import login.Interfaces.IParameterizedUser;
import menucontroller.MenuHandler;
import menucontroller.abstractfactory.IMenuHandlerFactory;
import menucontroller.abstractfactory.MenuHandlerFactory;
import menucontroller.interfaces.IMenuHandler;

public class BackToHomePageOption implements IBackToHomePageScreen {

	public final String CHOSE_INVALID_OPTION_MESSAGE = "You chose an invalid option, Please choose an option from the list.";
	
	private IInputOutputHandler inputOutputHandler;
	private IMenuHandler menuHandler;
	
	public BackToHomePageOption(IInputOutputHandler inputOutputHandler) {
		this.inputOutputHandler = inputOutputHandler;
		IMenuHandlerFactory menuHandlerFactory = MenuHandlerFactory.instance();
		this.menuHandler = menuHandlerFactory.makeMenuHandlerObject();
	}

	@Override
	public void displayGoBackToHomePageOption(IParameterizedUser user) {
		boolean isUserSelecting = true;

		while (isUserSelecting) {
			try {
				inputOutputHandler.displayMethod("\n\n");
				inputOutputHandler.displayMethod("Press 1 to go back to HomePage ");

				int choice = inputOutputHandler.inputInt();

				if (choice == 1) {
					MenuHandler.Menu menuTaskName = MenuHandler.Menu.HOME_PAGE;
					menuHandler.runMenuTask(menuTaskName, user, inputOutputHandler);
				} else {
					inputOutputHandler.displayMethod(CHOSE_INVALID_OPTION_MESSAGE);
				}
			} catch (NumberFormatException e) {
				inputOutputHandler.displayMethod(CHOSE_INVALID_OPTION_MESSAGE);
			}
		}
	}
	
}
