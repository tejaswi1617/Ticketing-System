package insertTickets;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Test;

import insertTicket.Interfaces.IUserInputValidation;
import insertTickets.abstractfactory.IInsertTicketTestFactory;
import insertTickets.abstractfactory.InsertTicketTestFactory;
import insertTicket.EnumValidation;
public class UserInputValidationTest 
{

	IInsertTicketTestFactory insertTicketTestFactory = InsertTicketTestFactory.instance();

	IUserInputValidation userinputvalidation = insertTicketTestFactory.userInputValidation();
	@Test 
	public void NullTicketID() {
		try {
			assertFalse(userinputvalidation.validation(" ",EnumValidation.VALIDATETICKETID));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void SpecialCharactersInDescription() {
		try {
			assertFalse(userinputvalidation.validation("New feature development && bug",EnumValidation.VALIDATEDESCRIPTION));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void DateDurationValidation() {
		try {
			//invalidate expected date
			assertFalse(userinputvalidation.validation("2020-01-01 12:00:00",EnumValidation.VALIDATEEXPECTEDENDDATE));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void DateValidation() {
		try {
			//invalidate expected date
			assertTrue(userinputvalidation.validation("2021-05-01 12:00:00",EnumValidation.VALIDATEEXPECTEDENDDATE));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void RangeValidation() {
		try {
			//invalidate expected date
			assertTrue(userinputvalidation.validation("1",EnumValidation.VALIDATEPRIORITY));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
