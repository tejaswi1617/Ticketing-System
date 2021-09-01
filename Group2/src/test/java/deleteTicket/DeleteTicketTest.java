package deleteTicket;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import deleteTicket.abstractfactory.DeleteTicketfactoryTest;
import deleteTicket.abstractfactory.IDeleteTicketfactoryTest;
import deleteTicket.interfaces.IDeleteTickets;
import reuseableClasses.abstractfactory.IReuseableClassesFactoryTest;
import reuseableClasses.abstractfactory.ReuseableClassFactoryTest;
import reuseablePackage.interfaces.ICheckTicketsExists;
import reuseablePackage.interfaces.IGetListOfTickets;
import userinterface.IInputOutputHandler;
import userinterface.InputOutputHandler;

public class DeleteTicketTest 
{
	
	IInputOutputHandler inputoutputhandler = new InputOutputHandler();
	IDeleteTicketfactoryTest deleteticketfactory = DeleteTicketfactoryTest.instance();
	IDeleteTickets deleteticket = deleteticketfactory.deleteTicketMock();
	
	IReuseableClassesFactoryTest resueableclassesfactory = ReuseableClassFactoryTest.instance();
	IGetListOfTickets getlistofticket = resueableclassesfactory.getlistofticketsMock();
	ICheckTicketsExists checkticketexist = resueableclassesfactory.checkticketexistMock();
	
	
	@Test
	public void deleteTicketWithValidTicketIdandEmployeeId()
	{
		String ticketId = "111";
		String employeeId = "emp123";
		String output = getlistofticket.listOfTickets();
		inputoutputhandler.displayMethod(output);
		boolean result = checkticketexist.ticketExists(ticketId);
		if(result == true)
		{
			assertTrue(deleteticket.deleteticket(ticketId));
		}
		
	}
	
	@Test
	public void deleteTicketWithInValidTicketIdandEmployeeId()
	{
		String ticketId = "1112";
		String employeeId = "emp123";
		String output = getlistofticket.listOfTickets();
		inputoutputhandler.displayMethod(output);
		boolean result = checkticketexist.ticketExists(ticketId);
		if(result == true)
		{
			assertTrue(deleteticket.deleteticket(ticketId));
		}
		
	}
	
	@Test
	public void deleteTicketWithValidTicketIdandInEmployeeId()
	{
		String ticketId = "111";
		String employeeId = "emp1233";
		String output = getlistofticket.listOfTickets();
		inputoutputhandler.displayMethod(output);
		boolean result = checkticketexist.ticketExists(ticketId);
		if(result == true)
		{
			assertTrue(deleteticket.deleteticket(ticketId));
		}
		
	}

}
