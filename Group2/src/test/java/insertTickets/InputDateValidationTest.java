package insertTickets;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Test;

import insertTicket.Interfaces.IInputDateValidation;
import insertTickets.abstractfactory.IInsertTicketTestFactory;
import insertTickets.abstractfactory.InsertTicketTestFactory;
import userinterface.abstractFactory.IUserInterfaceFactory;
import userinterface.abstractFactory.UserInterfaceFactory;

public class InputDateValidationTest 
{

	IInsertTicketTestFactory insertTicketTestFactory = InsertTicketTestFactory.instance();
	IUserInterfaceFactory userInterfactory = UserInterfaceFactory.instance();
	
	IInputDateValidation inputDateValidation = insertTicketTestFactory.dateValidation(userInterfactory.getInputOutputHandler());
	
	@Test 
	public void isDurationValid () throws ParseException 
	{
		assertTrue(inputDateValidation.isDurationValid("2020-01-01 12:00:01", "2020-01-01 14:00:00"));
	}
	 
	@Test
	public void isExpectedEndValid() throws ParseException 
	{
		assertFalse(inputDateValidation.isDurationValid("2020-01-01 10:04:02", "2019-12-23 12:00:00"));
	}

	@Test
	public void isExpectedEndTimeValid() throws ParseException 
	{
		assertTrue(inputDateValidation.isDurationValid("2020-01-01 12:00:00", "2020-01-01 12:00:01"));
	}
	
	@Test
	public void isExpectedEndDateValid() throws ParseException 
	{
		assertTrue(inputDateValidation.isDurationValid("2020-01-01 14:23:43", "2021-01-05 12:23:12"));
	}
	
	@Test
	public void isDateFormatValid () throws ParseException 
	{
		assertTrue(inputDateValidation.isDateFormatValid("2020-01-01 12:23:34"));
	}
}
