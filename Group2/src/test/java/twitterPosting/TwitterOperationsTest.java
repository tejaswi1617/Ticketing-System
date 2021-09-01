package twitterPosting;

import org.junit.Before;
import org.junit.Test;

import twitterPosting.Interfaces.ITwitterOperations;
import twitterPosting.abstractfactory.ITwitterPostingTest;
import twitterPosting.abstractfactory.TwitterPostingTest;
import userinterface.IInputOutputHandler;

public class TwitterOperationsTest
{
	 	ITwitterPostingTest postHandlingFactoryTest = TwitterPostingTest.instance();
	    ITwitterOperations twitterOperations;
	    IInputOutputHandler inputOutputHandler;
	    TwitterOperationsMock twitterOperationsMock;
	    @Before
	    public void initialize()
	    {
			twitterOperations = postHandlingFactoryTest.getpostOperations(null,inputOutputHandler);
	    }
 
	    @Test
	    public void checkPosting() 
	    {
	    	/*String postDescription = "Hey, I just finished working on this ticketype of ticket." +"Following are the details: " +"\n" +
					"Title: " + "Login feature" + "\n" + "Time taken: "+ "20 hours"+ "(" + "2021-04-04" + "to" + "2021-04-06" + ")" +"\n" + 
					"Kindly let me know if further issues are found regarding this.";	    
			assertTrue(twitterOperations.tweetTicket(postDescription));*/
//	    	String postDescription = "Hey, I just finished working on this ticketype of ticket." +"Following are the details: " +"\n" +
//					"Title: " + "Login feature" + "\n" + "Time taken: "+ "20 hours"+ "(" + "2021-04-04" + "to" + "2021-04-06" + ")" +"\n" + 
//					"Kindly let me know if further issues are found regarding this.";	    
//			assertTrue(twitterOperations.tweetTicket(postDescription));

	    }
}