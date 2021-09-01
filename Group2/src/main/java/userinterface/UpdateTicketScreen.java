package userinterface;

import java.text.ParseException;

import database.abstractfactory.DatabaseFactory;
import database.abstractfactory.IDatabaseFactory;
import database.intefaces.IConnectionManager;
import login.Interfaces.IParameterizedUser;
import reuseablePackage.abstractFactory.IReuseableClasssFactory;
import reuseablePackage.abstractFactory.ReuseableClasssFactory;
import reuseablePackage.interfaces.ICheckTicketsExists;
import reuseablePackage.interfaces.IGetListOfTickets;
import reuseablePackage.interfaces.IStoreTicketData;
import roles.abstractfactory.IRoleFactory;
import updateTicketDetails.abstractfactory.IUpdateTicketFactory;
import updateTicketDetails.abstractfactory.UpdateTicketFactory;
import updateTicketDetails.interfaces.IUpdateTicket;
import userinterface.abstractFactory.IUserInterfaceFactory;
import userinterface.abstractFactory.UserInterfaceFactory;

public class UpdateTicketScreen implements IUpdateTicketScreen
{
	private String ticketId = null;
	private String userRole = "manager";
	private boolean result=false;
	private String configurationFile = "ConfigurationFile";	
	
	IBackToHomePageScreen backToHomePageScreen;
	IUserInterfaceFactory userInterfaceFactory;
	IRoleFactory roleFactory;
		
	private static IConnectionManager connectionManager;
	private String projectConfigurationFile = "ProjectConfiguration.properties";
	private String dbConfigurationKey = "DBConfiguration";
	private final IDatabaseFactory databaseFactory = DatabaseFactory.instance();
		
	private IUpdateTicketFactory updateticketfactory = UpdateTicketFactory.instance(); 
	private IReuseableClasssFactory reusableFactory = ReuseableClasssFactory.instance();
	private IReuseableClasssFactory reuseableclassfactory = ReuseableClasssFactory.instance();
	
	private ICheckTicketsExists checkticketexists;
	private IStoreTicketData storeticketdata;
	private IGetListOfTickets getalltickets;
	private IInputOutputHandler inputoutputhandler;
	private IUpdateTicket updateTicket;
	
	
	public UpdateTicketScreen(IInputOutputHandler inputoutputhandler)
	{
		this.inputoutputhandler = inputoutputhandler;
		connectionManager = databaseFactory.getConnectionManager(configurationFile);
		checkticketexists = reusableFactory.checkticketexists(connectionManager);
		storeticketdata = reusableFactory.storeTicketData();
		getalltickets = reusableFactory.getalltickets(connectionManager);
		updateTicket = updateticketfactory.UpdateTicket(connectionManager);
	}
	
	public void updateticketscreen(IParameterizedUser user)
	{
		String output="";
		String userenterRole = user.getUserType().toLowerCase();
		inputoutputhandler.displayMethod("Enter your role:"+userenterRole);
		inputoutputhandler.displayMethod("Tickets Details");
		output = getalltickets.listOfTickets();
		inputoutputhandler.displayMethod(output);
			
		if(userRole.equals(userenterRole))
		{
			do {
				inputoutputhandler.displayMethod("Enter Ticket Id you want to update:");
				inputoutputhandler.displayMethod("Enter exit to go to main menu");
				ticketId = inputoutputhandler.input();
				if(ticketId.toLowerCase().equals("exit")) 
				{
					break;
				}
				result=checkticketexists.ticketExists(ticketId);
				if(result == true)
				{
					inputoutputhandler.displayMethod("1. Expected Date"+"\n"+"2. Reporter ID"+"\n"+"3. Assignee Name"+"\n"+"4. priority"+"\n"+"5. urgency"+
							"\n"+"6. impact"+"\n"+"7. status of ticket"+"\n"+"8. exit");
					
					inputoutputhandler.displayMethod("Please provide your choice");
					int choiceToUpdate =inputoutputhandler.inputInt();
					if(choiceToUpdate==8)
					{
						break;
					}
					inputoutputhandler.displayMethod("Enter Update Value:");
					String value = inputoutputhandler.input();
					result = updateTicket.updateValueOfTicketForManager(ticketId,choiceToUpdate,value);
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
				
			}while(true);
					
		}
		else
		{
			String employeeID=user.getEmployeeID();
			inputoutputhandler.displayMethod(employeeID);
			do 
			{
				
				inputoutputhandler.displayMethod("Enter Ticket Id you want to update:");
				inputoutputhandler.displayMethod("Enter exit to go to main menu");
				ticketId = inputoutputhandler.input();
				if(ticketId.toLowerCase().equals("exit")) 
				{
					break;
				}
				result = checkticketexists.ticketExistForNotManager(ticketId, employeeID);
				if(result == true)
				{
					inputoutputhandler.displayMethod("Change Ticket Status");
					inputoutputhandler.displayMethod("Enter Ticket Status:");
					String value = inputoutputhandler.input();
					
				try {
						result = updateTicket.updateValueOfTicketForNotManager(ticketId,value);
					} catch (ParseException e) {
						inputoutputhandler.displayMethod("Error");
					}
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
				
			}while(true);
			
		}
		userInterfaceFactory = UserInterfaceFactory.instance();
		backToHomePageScreen = userInterfaceFactory.getBackToHomePageScreen(inputoutputhandler);
		backToHomePageScreen.displayGoBackToHomePageOption(user);

	}
}
		
