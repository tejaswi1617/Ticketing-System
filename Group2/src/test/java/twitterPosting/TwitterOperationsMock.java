package twitterPosting;

import java.sql.ResultSet;
import java.sql.SQLException;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitterPosting.Interfaces.ITwitterOperations;
import userinterface.IInputOutputHandler;

public class TwitterOperationsMock implements ITwitterOperations {

	ResultSet resultset = null;
	public TwitterOperationsMock(ResultSet resultset,IInputOutputHandler inputOutputHandler)
	{
		
	}
	static String consumerKeyStr = "P1h3b6FpRWRXcZ6CR4NRFC1Ve";
	static String consumerSecretStr = "mxmHZiASD0NjX7iMQaHAsxBj9HXEPX9TB8FUlka3URCFQCfLKB";
	static String accessTokenStr = "1363841955441090562-Br3xfe5mKLTWqF1cqq1K2CIfHv4yKc";
	static String accessTokenSecretStr = "LuMAwH640LFId3mZCFLNbPhcjBubCoimzw3CJSTy2S5Fp";

	
	public boolean tweetTicket(String postDescription) 
	{
		try 
		{
			Twitter twitter = new TwitterFactory().getInstance();

			twitter.setOAuthConsumer(consumerKeyStr, consumerSecretStr);
			AccessToken accessToken = new AccessToken(accessTokenStr,
					accessTokenSecretStr);

			twitter.setOAuthAccessToken(accessToken);

			twitter.updateStatus(postDescription);

			return true;

		} 
		catch (TwitterException e)
		{
			e.printStackTrace();
			return false;
		}
	
	}

	@Override
	public String generateTweetContent() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}
