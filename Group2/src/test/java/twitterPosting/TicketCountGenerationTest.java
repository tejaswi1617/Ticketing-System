package twitterPosting;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;

import twitterPosting.Interfaces.IFetchProjectDetailsDB;
import twitterPosting.Interfaces.ITwitterOperations;
import twitterPosting.abstractfactory.ITwitterPostingTest;
import twitterPosting.abstractfactory.TwitterPostingTest;
import userinterface.IInputOutputHandler;

public class TicketCountGenerationTest 
{

	ITwitterPostingTest postHandlingFactoryTest = TwitterPostingTest.instance();
	IFetchProjectDetailsDB twitterOperations;
    @Before
    public void initialize()
    {
		twitterOperations = postHandlingFactoryTest.fetchticket();
    } 
	@Test
	public void getticketCountsDBIfExist() {
		try {
			assertTrue(twitterOperations.getticketCountsDB());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
