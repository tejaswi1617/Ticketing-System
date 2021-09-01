//Author : Vamsi Krishna Utla

package userinterface;

import java.io.IOException;
import login.Interfaces.IForgotPassword;
import login.Interfaces.IForgotPasswordDao;
import login.abstractfactory.ILoginFactory;
import login.abstractfactory.LoginFactory;
import mailservice.abstractfactory.IMailFactory;
import mailservice.abstractfactory.MailFactory;
import mailservice.interfaces.IMail;
import userinterface.abstractFactory.IUserInterfaceFactory;
import userinterface.abstractFactory.UserInterfaceFactory;

public class ForgotPasswordScreen implements IForgotPasswordScreen
{
	private final String GMAIL = "gmail";
	
    IInputOutputHandler inputOutputHandler;
    ILoginFactory loginFactory = LoginFactory.instance();
    IUserInterfaceFactory userInterfaceFactory = UserInterfaceFactory.instance();
    IMailFactory mailFactory = MailFactory.instance();

    public ForgotPasswordScreen(IInputOutputHandler inputOutputHandler)
    {
        this.inputOutputHandler = inputOutputHandler;
    }

    public void getForgotPasswordScreen()
    {
        IServiceNowWelcomeScreen serviceNowWelcomeScreen;
        IMail mail = mailFactory.makeMailObject(GMAIL);
        IForgotPasswordDao persistenceForgotPasswordOperations = null;
        serviceNowWelcomeScreen = userInterfaceFactory.getServiceNowWelcomeScreen(inputOutputHandler);

        try
        {
            persistenceForgotPasswordOperations = loginFactory.getPersistenceForgotPasswordOperations();
        }
        catch (IOException e)
        {
            inputOutputHandler.displayMethod("Forgot password process encountered an issue. Please contact system administrator.");
        }

        if(persistenceForgotPasswordOperations == null)
        {
            serviceNowWelcomeScreen.displayLoginScreen();
            return;
        }

        IForgotPassword forgotPassword = loginFactory.getForgotPassword(mail, persistenceForgotPasswordOperations);
        String employeeID;
        String newPassword;
        int otp;

        inputOutputHandler.displayMethod("Enter employeeID:\n");
        employeeID = inputOutputHandler.input();

        if(forgotPassword.sendOTP(employeeID))
        {
            inputOutputHandler.displayMethod("Please enter the OTP that has been sent to registered email address.");
            otp = inputOutputHandler.inputInt();

            inputOutputHandler.displayMethod("Please enter the new password.");
            newPassword = inputOutputHandler.input();

            if(forgotPassword.updatePassword(otp, newPassword))
            {
                inputOutputHandler.displayMethod("Password updated successfully.");
            }
            else
            {
                inputOutputHandler.displayMethod("Invalid OTP. Please try again.");
            }

            serviceNowWelcomeScreen.displayLoginScreen();
        }
    }
}