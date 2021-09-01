//Author : Akshay Garg

package userinterface;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import login.Interfaces.IParameterizedUser;
import menucontroller.MenuHandler;
import menucontroller.abstractfactory.IMenuHandlerFactory;
import menucontroller.abstractfactory.MenuHandlerFactory;
import menucontroller.interfaces.IMenuHandler;
import roles.abstractfactory.IRoleFactory;
import roles.abstractfactory.RoleFactory;
import roles.interfaces.IMenuItemsByRole;
import validations.StringValidations;

public class HomePageScreen implements IHomePageScreen {

	private final String INVALID_INPUT_MESSAGE = "Please provide valid value for emp name and user type";
	private final String MENU_ITEMS_SELECTION_MESSAGE = "Please select the item from menu (provide corresponding menu item number) : ";
	private final String ERROR_MESSAGE = "You have provided wrong input. Please choose the correct input from menu.";
	public final String UNSUCCESSFUL_DATA_FETCH = "Error while fetching data from DB. Please contact admin.";
	private final int MINIMUM_MENU_ITEMS = 1;

	private IMenuItemsByRole menuItemsByRole;
	private IInputOutputHandler inputOutputHandler;
	private Map<Integer, String> menuMap;
	private IMenuHandler menuHandler;
	IRoleFactory roleFactory;

	public HomePageScreen(IInputOutputHandler inputOutputHandler) {
		this.inputOutputHandler = inputOutputHandler;
		this.menuMap = new HashMap<Integer, String>();
		IMenuHandlerFactory menuHandlerFactory = MenuHandlerFactory.instance();
		this.menuHandler = menuHandlerFactory.makeMenuHandlerObject();
	}

	public void handleHomePageMenu(IParameterizedUser user) {

		String firstName = user.getfirstName();
		String userType = user.getUserType();

		if (StringValidations.isStringValid(firstName) && StringValidations.isStringValid(userType)) {

			String welcomeUser = "Hello " + firstName + "\n\nMenu\n";
			inputOutputHandler.displayMethod(welcomeUser);

			try {
				int maximumMenuItems = displayMenuItems(userType);

				if (maximumMenuItems > 0) {

					boolean isUserSelecting = true;

					while (isUserSelecting) {
						inputOutputHandler.displayMethod(MENU_ITEMS_SELECTION_MESSAGE);
						String menuItemSelection = inputOutputHandler.input();

						try {
							int selectedMenuItem = Integer.parseInt(menuItemSelection);
							boolean isValidMenuSelection = isValidMenuInput(MINIMUM_MENU_ITEMS, maximumMenuItems,
									selectedMenuItem);

							if (isValidMenuSelection == false) {
								throw new IllegalArgumentException();
							}

							MenuHandler.Menu menuItem = MenuHandler.Menu.valueOf(menuMap.get(selectedMenuItem));

							menuHandler.runMenuTask(menuItem, user, inputOutputHandler);

						} catch (Exception e) {
							inputOutputHandler.displayMethod(ERROR_MESSAGE);
							continue;
						}
					}
				} else {
					inputOutputHandler.displayMethod(INVALID_INPUT_MESSAGE);
				}
			} catch (Exception e) {
				inputOutputHandler.displayMethod(UNSUCCESSFUL_DATA_FETCH);
			}

		} else {
			inputOutputHandler.displayMethod(INVALID_INPUT_MESSAGE);
		}
	}

	private int displayMenuItems(String userType) throws Exception {
		roleFactory = RoleFactory.instance();
		menuItemsByRole = roleFactory.makeMenuItemsByRoleObject();
		List<String> menuItemsList = menuItemsByRole.fetchMenuItemsByRole(userType);
		int i = 0;

		for (; i < menuItemsList.size(); i++) {
			int menuoption = i + 1;
			String menuItem = menuItemsList.get(i);
			String displayMenuItem = "" + menuoption + ". " + menuItem;
			inputOutputHandler.displayMethod(displayMenuItem + "\n");
			menuMap.put(menuoption, menuItem);
		}
		return i;
	}

	private boolean isValidMenuInput(int minMenuOption, int maxMenuoption, int menuItemSelection) {
		if (menuItemSelection < minMenuOption && menuItemSelection > maxMenuoption) {
			return false;
		}
		return true;
	}

}
