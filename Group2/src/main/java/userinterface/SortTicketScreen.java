package userinterface;

import database.abstractfactory.DatabaseFactory;
import database.abstractfactory.IDatabaseFactory;
import database.intefaces.IConnectionManager;
import login.Interfaces.IParameterizedUser;
import managerfeatures.abstractfactory.IManagerFeaturesFactory;
import reuseablePackage.abstractFactory.IReuseableClasssFactory;
import reuseablePackage.abstractFactory.ReuseableClasssFactory;
import reuseablePackage.interfaces.IOpenTicket;
import reuseablePackage.interfaces.IStoreTicketData;
import sortTickets.abstractfactory.ISortTicketFactory;
import sortTickets.abstractfactory.SortTicketFactory;
import sortTickets.interfaces.ISortTicket;
import userinterface.abstractFactory.IUserInterfaceFactory;
import userinterface.abstractFactory.UserInterfaceFactory;

public class SortTicketScreen implements ISortTciketScreen
{

	private int choice = 0;
	private String configurationFile = "ConfigurationFile";
	private static String printOnScreenString = "";
	
	IBackToHomePageScreen backToHomePageScreen;
	IUserInterfaceFactory userInterfaceFactory;
	IManagerFeaturesFactory managerFeaturesFactory;

	private static IConnectionManager connectionManager;
	private final IDatabaseFactory databaseFactory = DatabaseFactory.instance();

	static IInputOutputHandler inputoutputhandler;
	
	static IReuseableClasssFactory resuableclassfactore = ReuseableClasssFactory.instance();
	static ISortTicketFactory sortticketfactory = SortTicketFactory.instance();
	static IStoreTicketData storeTicketData = resuableclassfactore.storeTicketData();

	public SortTicketScreen(IInputOutputHandler inputoutputhandler)
	{
		this.inputoutputhandler = inputoutputhandler;
		connectionManager = databaseFactory.getConnectionManager(configurationFile);
	}
	
	public void sortticketscreen(IParameterizedUser user)
	{
		String output="";
		printOnScreenString = "Sort Ticket BY:" + "\n\n" + "1. Priority" + "\n" + "2. Urgency" + "\n" + "3. impact"
				+ " \n" + "4. exit" + "\n";
		inputoutputhandler.displayMethod(printOnScreenString);
		do {
			inputoutputhandler.displayMethod("Enter your choice:");
			choice = inputoutputhandler.inputInt();
			ISortTicket sortTicketobj = sortticketfactory.sortTicketobj(storeTicketData,connectionManager);
			if (choice <= 3 && choice >= 1) {
				output = sortTicketobj.sortTickets(choice);
				inputoutputhandler.displayMethod(output);
				open();
			}
		} while (choice != 4);
		
		userInterfaceFactory = UserInterfaceFactory.instance();
		backToHomePageScreen = userInterfaceFactory.getBackToHomePageScreen(inputoutputhandler);
		backToHomePageScreen.displayGoBackToHomePageOption(user);
	}

	private static void open() {
		int choice = 0;
		String output="";
		String ticketID = null;
		IOpenTicket openticket = resuableclassfactore.openticket(storeTicketData,connectionManager);

		printOnScreenString = "1. open Ticket" + " \n" + "2. exit";
		inputoutputhandler.displayMethod(printOnScreenString);

		do {
			try {
				inputoutputhandler.displayMethod("Choose Operation you want to perform");
				inputoutputhandler.displayMethod("\n");
				choice = inputoutputhandler.inputInt();

				if (choice == 1) {
					inputoutputhandler.displayMethod("Enter Ticket ID:");
					inputoutputhandler.displayMethod("\n");
					ticketID = inputoutputhandler.input();
					output = openticket.openticket(ticketID);
					inputoutputhandler.displayMethod(output);
				}
				else
				{
					inputoutputhandler.displayMethod("invalid input");
				}
			} catch (NumberFormatException e) {

			}
		} while (choice != 2);
	
	}

}
