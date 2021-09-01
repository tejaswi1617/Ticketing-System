package userinterface;

import database.abstractfactory.DatabaseFactory;
import database.abstractfactory.IDatabaseFactory;
import database.intefaces.IConnectionManager;
import deleteTicket.abstractfactory.DeleteTicketsFactory;
import deleteTicket.abstractfactory.IDeleteTicketsFactory;
import deleteTicket.interfaces.IDeleteTickets;
import login.Interfaces.IParameterizedUser;
import managerfeatures.abstractfactory.IManagerFeaturesFactory;
import reuseablePackage.abstractFactory.IReuseableClasssFactory;
import reuseablePackage.abstractFactory.ReuseableClasssFactory;
import reuseablePackage.interfaces.ICheckTicketsExists;
import reuseablePackage.interfaces.IGetListOfTickets;
import userinterface.abstractFactory.IUserInterfaceFactory;
import userinterface.abstractFactory.UserInterfaceFactory;

public class DeleteTicketScreen implements IDeleteTicketScreen
{
	private String ticketId = null;
	private String userRole = "admin";
	private boolean result=false;
	private String configurationFile = "ConfigurationFile";
	
	IBackToHomePageScreen backToHomePageScreen;
	IUserInterfaceFactory userInterfaceFactory;
	IManagerFeaturesFactory managerFeaturesFactory;


	private IReuseableClasssFactory reusableFactory = ReuseableClasssFactory.instance();
	private IDeleteTicketsFactory deleteticketfactory = DeleteTicketsFactory.instance();
	private final IDatabaseFactory databaseFactory = DatabaseFactory.instance();
	private IConnectionManager connectionManager;
	private IInputOutputHandler inputoutputhandler;
	private ICheckTicketsExists checkticketexists;
	private IGetListOfTickets getalltickets;
	private IDeleteTickets deleteticket;
	
	public DeleteTicketScreen(IInputOutputHandler inputoutputhandler)
	{
		this.inputoutputhandler = inputoutputhandler;
		connectionManager = databaseFactory.getConnectionManager(configurationFile);
		getalltickets = reusableFactory.getalltickets(connectionManager);
	    checkticketexists = reusableFactory.checkticketexists(connectionManager);
	    getalltickets = reusableFactory.getalltickets(connectionManager);
	    deleteticket = deleteticketfactory.deleteticket(connectionManager);
	}
	
	public void deleteTicketScreen(IParameterizedUser user)
	{
		String output;
		String userenterRole = user.getUserType().toLowerCase();
		inputoutputhandler.displayMethod("Tickets Details");
		output = getalltickets.listOfTickets();
		
		inputoutputhandler.displayMethod(output);
		
		if(userRole.equals(userenterRole))
		{
			inputoutputhandler.displayMethod("Enter Ticket Id you want to delete:");
			ticketId = inputoutputhandler.input();
			result = checkticketexists.ticketExists(ticketId);
			if(result == true)
			{
				result = deleteticket.deleteticket(ticketId);
				if(result == true)
				{
					inputoutputhandler.displayMethod("true");
				}
				else
				{
					inputoutputhandler.displayMethod("false");
				}
			}
			else
			{
				inputoutputhandler.displayMethod("Please provide valid ticket id. You are either not allow to update tickets data, or ticket with given id does not exists");
			}
		}
		else
		{
			inputoutputhandler.displayMethod("Sorry you can't delete ticket");
		}
		userInterfaceFactory = UserInterfaceFactory.instance();
		backToHomePageScreen = userInterfaceFactory.getBackToHomePageScreen(inputoutputhandler);
		backToHomePageScreen.displayGoBackToHomePageOption(user);

	}

}
