package twitterPosting;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import twitterPosting.Interfaces.IInputPostingDetails;
import twitterPosting.abstractfactory.ITwitterPostingTest;
import twitterPosting.abstractfactory.TwitterPostingTest;

public class InputValidationTest
{	    
    ITwitterPostingTest postHandlingFactoryTest = TwitterPostingTest.instance();
    IInputPostingDetails inputPosting;
	@Before
    public void initialize()
    {
		String ticketId = "111";
		inputPosting = postHandlingFactoryTest.getInputPosting(ticketId);
    } 
 
    @Test
    public void getInputValidation() 
    {
    	assertEquals("111",inputPosting.getTicketId());
    }
    
    @Test
    public void getInputNotValidation() 
    {
    	assertNotEquals("123",inputPosting.getTicketId());
    }
}