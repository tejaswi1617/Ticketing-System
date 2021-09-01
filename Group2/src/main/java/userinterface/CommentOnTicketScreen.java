package userinterface;

import java.util.Scanner;

import commentOnTicket.abstractfactory.CommentOnTicketsFactory;
import commentOnTicket.abstractfactory.ICommentOnTicketsFactory;
import commentOnTicket.interfaces.ICommentOnTickets;
import database.abstractfactory.DatabaseFactory;
import database.abstractfactory.IDatabaseFactory;
import database.intefaces.IConnectionManager;
import login.Interfaces.IParameterizedUser;
import managerfeatures.abstractfactory.IManagerFeaturesFactory;
import reuseablePackage.abstractFactory.IReuseableClasssFactory;
import reuseablePackage.abstractFactory.ReuseableClasssFactory;
import reuseablePackage.interfaces.ICheckTicketsExists;
import reuseablePackage.interfaces.IGetListOfTickets;
import reuseablePackage.interfaces.IStoreTicketData;
import userinterface.abstractFactory.IUserInterfaceFactory;
import userinterface.abstractFactory.UserInterfaceFactory;

public class CommentOnTicketScreen implements ICommentOnTicketScreen
{
	Scanner sc = new Scanner(System.in);
	
	private String ticketId = null;
	private String commentString = null;
	private boolean result = false;
	private boolean commentPostResult=false;
	private String employeeID;
	private String currentUserRole;
	private static String userRole="manager";
	private String configurationFile = "ConfigurationFile";

	IBackToHomePageScreen backToHomePageScreen;
	IUserInterfaceFactory userInterfaceFactory;
	IManagerFeaturesFactory managerFeaturesFactory;

	private IConnectionManager connectionManager;
	private IDatabaseFactory databaseFactory = DatabaseFactory.instance();
	IReuseableClasssFactory reuseableclassfactory = ReuseableClasssFactory.instance();
	
	ICommentOnTicketsFactory commentonticketfactory = CommentOnTicketsFactory.instance();
	IInputOutputHandler inputoutputhandler;
	ICommentOnTickets postcomment;
	ICheckTicketsExists checkticketexists;
	IStoreTicketData storeTicketData;
	IGetListOfTickets getalltickets;
	
	public CommentOnTicketScreen(IInputOutputHandler inputoutputhandler)
	{
		this.inputoutputhandler = inputoutputhandler;
		connectionManager = databaseFactory.getConnectionManager(configurationFile);
		checkticketexists=reuseableclassfactory.checkticketexists(connectionManager);
		getalltickets = reuseableclassfactory.getalltickets(connectionManager);
		storeTicketData = reuseableclassfactory.storeTicketData();
		postcomment = commentonticketfactory.postComment(connectionManager);
	}
	
	public  void commentonticketscreen(IParameterizedUser user)
	{
		currentUserRole = user.getUserType().toLowerCase();
		
		if(currentUserRole.equals(userRole))
		{
			employeeID = user.getManager();
		}
		else
		{
			employeeID = user.getEmployeeID();
		}
		
		String output = "";
		output = getalltickets.listOfTickets();
		inputoutputhandler.displayMethod(output);
		
		do {
			
			inputoutputhandler.displayMethod("Enter Ticket Id you want to post comment on.:");
			inputoutputhandler.displayMethod("Enter exit to go to main page");
			inputoutputhandler.displayMethod("\n");
			ticketId = inputoutputhandler.input();
			
			if(ticketId.toLowerCase().equals("exit"))
			{
				break;
			}
			result = checkticketexists.ticketExists(ticketId);
			
			if(result == true)
			{
				inputoutputhandler.displayMethod("Write comment you want to post");
				commentString = inputoutputhandler.input();
				commentPostResult = postcomment.postCommentOnticket(ticketId,employeeID,commentString);
				if(commentPostResult == true)
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
				inputoutputhandler.displayMethod("Ticket with " + ticketId + "does not exists. Please provide valid ticketId.");
			}
		}while(true);
	
		userInterfaceFactory = UserInterfaceFactory.instance();
		backToHomePageScreen = userInterfaceFactory.getBackToHomePageScreen(inputoutputhandler);
		backToHomePageScreen.displayGoBackToHomePageOption(user);
 
	}
}
