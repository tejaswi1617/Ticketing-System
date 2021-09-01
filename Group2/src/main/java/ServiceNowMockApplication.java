import userinterface.IInputOutputHandler;
import userinterface.IServiceNowWelcomeScreen;
import userinterface.abstractFactory.*;
public class ServiceNowMockApplication
{
    public static void main(String[] args)
    {
        IUserInterfaceFactory userInterfaceFactory = UserInterfaceFactory.instance();
        IInputOutputHandler inputOutputHandler = userInterfaceFactory.getInputOutputHandler();
        IServiceNowWelcomeScreen serviceNowWelcomeScreen = userInterfaceFactory.getServiceNowWelcomeScreen(inputOutputHandler);
        serviceNowWelcomeScreen.displayLoginScreen();
        inputOutputHandler.closeScanner();
    }
}
