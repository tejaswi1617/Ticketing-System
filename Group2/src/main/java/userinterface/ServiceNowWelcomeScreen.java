//Author : Vamsi Krishna Utla

package userinterface;

import menucontroller.MenuHandler;
import menucontroller.abstractfactory.IMenuHandlerFactory;
import menucontroller.abstractfactory.MenuHandlerFactory;
import menucontroller.interfaces.IMenuHandler;
import userinterface.abstractFactory.*;

public class ServiceNowWelcomeScreen implements IServiceNowWelcomeScreen
{
    IUserInterfaceFactory userInterfaceFactory = UserInterfaceFactory.instance();
    private final IInputOutputHandler inputOutputHandler;
    private final IMenuHandlerFactory menuHandlerFactory = MenuHandlerFactory.instance();
    private IMenuHandler menuHandler;

    public ServiceNowWelcomeScreen(IInputOutputHandler inputOutputHandler)
    {
        this.inputOutputHandler = inputOutputHandler;
        this.menuHandler = menuHandlerFactory.makeMenuHandlerObject();
    }

    public void displayLoginScreen()
    {

        int choice;
        inputOutputHandler.displayMethod("Welcome to ServiceNow Mock application\n\n Press 1 to login\n Press 2 to register as a new user\n Press 3 if you forgot password");
        choice = inputOutputHandler.inputInt();
        if(choice == 1)
        {
            MenuHandler.Menu menuTaskName = MenuHandler.Menu.LOGIN;
            menuHandler.runMenuTask(menuTaskName, null, inputOutputHandler);
        }
        else if(choice == 2)
        {
            MenuHandler.Menu menuTaskName = MenuHandler.Menu.REGISTRATION;
            menuHandler.runMenuTask(menuTaskName, null, inputOutputHandler);
        }
        else if(choice == 3)
        {
            MenuHandler.Menu menuTaskName = MenuHandler.Menu.FORGOT_PASSWORD;
            menuHandler.runMenuTask(menuTaskName, null, inputOutputHandler);
        }
        else
        {
        	IServiceNowWelcomeScreen serviceNowWelcomeScreen = userInterfaceFactory.getServiceNowWelcomeScreen(inputOutputHandler);
            serviceNowWelcomeScreen.displayLoginScreen();
        }
    }
}
