package twitterPosting.abstractfactory;

import java.sql.ResultSet;

import login.AuthenticationOperationsMock;
import login.Interfaces.IAuthenticationDao;
import login.abstractfactory.ILoginFactoryTest;
import login.abstractfactory.LoginFactoryTest;
import twitterPosting.FetchProjectDetailsDB;
import twitterPosting.FetchProjectDetailsMock;
import twitterPosting.InputPostingDetails;
import twitterPosting.TwitterOperations;
import twitterPosting.TwitterOperationsMock;
import twitterPosting.Interfaces.IFetchProjectDetailsDB;
import twitterPosting.Interfaces.IInputPostingDetails;
import twitterPosting.Interfaces.ITwitterOperations;
import userinterface.IInputOutputHandler;

public class TwitterPostingTest implements ITwitterPostingTest 
{
    private static ITwitterPostingTest uniqueInstance = null;

    private TwitterPostingTest()
    {

    }

    public static ITwitterPostingTest instance()
    {
        if(null == uniqueInstance)
        {
            uniqueInstance = new TwitterPostingTest();
        }
        return uniqueInstance;
    }

    public IInputPostingDetails getInputPosting(String ticketId) 
    {
        return new InputPostingDetails(ticketId);
    }
    
    public ITwitterOperations getpostOperations(ResultSet resultset,IInputOutputHandler inputOutputHandler)
	{
		return new TwitterOperationsMock(resultset, inputOutputHandler);
	}

	public IFetchProjectDetailsDB fetchticket()
	{
		return new FetchProjectDetailsMock();
	}
}
