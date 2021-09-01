package twitterPosting.abstractFactory;

import java.sql.ResultSet;

import twitterPosting.FetchProjectDetailsDB;
import twitterPosting.InputPostingDetails;
import twitterPosting.TwitterOperations;
import twitterPosting.Interfaces.IFetchProjectDetailsDB;
import twitterPosting.Interfaces.IInputPostingDetails;
import twitterPosting.Interfaces.ITwitterOperations;
import userinterface.IInputOutputHandler;

public class PostHandlingFactory implements IPostHandlingFactory {

	private static IPostHandlingFactory uniqueInstance = null;

    private PostHandlingFactory()
    {
    	
    }
 
    public static IPostHandlingFactory instance()
    {
        if(null == uniqueInstance)
        {
            uniqueInstance = new PostHandlingFactory();
        }
        return uniqueInstance;
    }
	
	public ITwitterOperations getpostOperations(ResultSet resultset,IInputOutputHandler inputOutputHandler)
	{
		return new TwitterOperations(resultset, inputOutputHandler);
	}

	public IInputPostingDetails inputposting(String ticketId) 
	{
		return new InputPostingDetails(ticketId);
	}

	public IFetchProjectDetailsDB fetchticket( IInputPostingDetails inputposting, IInputOutputHandler inputOutputHandler)
	{
		return new FetchProjectDetailsDB(inputposting,inputOutputHandler);
	}
}
