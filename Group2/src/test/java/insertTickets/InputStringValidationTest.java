package insertTickets;

import static org.junit.Assert.*;
import org.junit.Test;
import insertTicket.Interfaces.IInputStringValidation;
import insertTickets.abstractfactory.IInsertTicketTestFactory;
import insertTickets.abstractfactory.InsertTicketTestFactory;
import userinterface.abstractFactory.IUserInterfaceFactory;
import userinterface.abstractFactory.UserInterfaceFactory;

public class InputStringValidationTest 
{	
	IInsertTicketTestFactory insertTicketTestFactory = InsertTicketTestFactory.instance();
	IUserInterfaceFactory userInterfactory = UserInterfaceFactory.instance();
	IInputStringValidation ticketStringValidation = insertTicketTestFactory.ticketStringValidation(userInterfactory.getInputOutputHandler());
	 
	@Test
	public void isStringNull() 
	{
		assertTrue(ticketStringValidation.isStringNull(" "));
		assertFalse(ticketStringValidation.isStringNull("Ticket123"));
	}
	 
	@Test
	public void isStringEmployeeAndReporterID() 
	{
		assertTrue(ticketStringValidation.isStringEmployeeAndReporterID("Emp123"));
		assertFalse(ticketStringValidation.isStringEmployeeAndReporterID("123"));
		assertFalse(ticketStringValidation.isStringEmployeeAndReporterID("Employee124"));
	}
	
	@Test
	public void isStringContainsSpecialCharacters() {
		assertTrue(ticketStringValidation.isStringContainsSpecialCharacters("J@nvi"));
		assertTrue(ticketStringValidation.isStringContainsSpecialCharacters("%Emp12"));
		assertTrue(ticketStringValidation.isStringContainsSpecialCharacters("Manager_44"));
		assertFalse(ticketStringValidation.isStringContainsSpecialCharacters("Develop new feature of ticket creation"));
	}

}
