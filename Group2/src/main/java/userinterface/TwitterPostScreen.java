package userinterface;

import java.text.ParseException;
import java.util.Scanner;

import twitterPosting.Interfaces.IFetchProjectDetailsDB;
import twitterPosting.Interfaces.IInputPostingDetails;
import twitterPosting.abstractFactory.IPostHandlingFactory;
import twitterPosting.abstractFactory.PostHandlingFactory;
import employeeMilestones.abstractfactory.EmployeeMilestoneFactory;
import employeeMilestones.abstractfactory.IEmployeeMilestoneFactory;
import login.Interfaces.IParameterizedUser;
import userinterface.abstractFactory.IUserInterfaceFactory;
import userinterface.abstractFactory.UserInterfaceFactory;

public class TwitterPostScreen implements ITwitterPostScreen {
	private final IInputOutputHandler inputOutputHandler;
    private IUserInterfaceFactory userInterfaceFactory;
    private IBackToHomePageScreen backToHomePageScreen;
	private IPostHandlingFactory posthandling = PostHandlingFactory.instance();

    public  TwitterPostScreen(IInputOutputHandler inputOutputHandler)
    {
        this.inputOutputHandler = inputOutputHandler;
        this.userInterfaceFactory = UserInterfaceFactory.instance();
    }

    public void displayTwitterPostScreen(IParameterizedUser user)
    {
		IFetchProjectDetailsDB fetchticket;
		IInputPostingDetails inputposting;
		String ticketID = null;
	  
		inputOutputHandler.displayMethod("Enter ticket ID:");
		ticketID = inputOutputHandler.input();

		inputposting = posthandling.inputposting(ticketID);
		
		fetchticket = posthandling.fetchticket(inputposting,inputOutputHandler);
		try
		{
			if(fetchticket.getticketCountsDB()==true) {
	            inputOutputHandler.displayMethod("Twitter Posting done successfully.\n");
			}
			else 
			{
	            inputOutputHandler.displayMethod("Issue found while posting on twitter.\n");
			}
		} 
		catch (ParseException e)
		{
			// TODO Auto-generated catch block
			inputOutputHandler.displayMethod(e.toString());
			e.printStackTrace();
		}
	    backToHomePageScreen = userInterfaceFactory.getBackToHomePageScreen(inputOutputHandler);
	    backToHomePageScreen.displayGoBackToHomePageOption(user);
    }
}
