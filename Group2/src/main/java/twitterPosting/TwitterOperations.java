package twitterPosting;
import java.sql.ResultSet;
import java.sql.SQLException;

import twitterPosting.Interfaces.ITwitterOperations;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import userinterface.IInputOutputHandler;

public class TwitterOperations implements ITwitterOperations {

		static String consumerKeyStr = "P1h3b6FpRWRXcZ6CR4NRFC1Ve";
		static String consumerSecretStr = "mxmHZiASD0NjX7iMQaHAsxBj9HXEPX9TB8FUlka3URCFQCfLKB";
		static String accessTokenStr = "1363841955441090562-Br3xfe5mKLTWqF1cqq1K2CIfHv4yKc";
		static String accessTokenSecretStr = "LuMAwH640LFId3mZCFLNbPhcjBubCoimzw3CJSTy2S5Fp";

		ResultSet resultSet;
		IInputOutputHandler inputOutputHandler;
		
		public TwitterOperations(ResultSet resultSet,IInputOutputHandler inputOutputHandler)
		{
			this.resultSet = resultSet;
			this.inputOutputHandler = inputOutputHandler;
		} 
		
		public String generateTweetContent() throws SQLException 
		{
			String description = null;
			String resolutionHours = null;
			String startDate = null;
			String endDate = null;
			String ticketType = null;
	    	String postDescription = null;

			while(resultSet.next()) 
			{	    		 
	    		description = resultSet.getString("description");
	    		resolutionHours = resultSet.getString("resolutionHours");
	    		startDate = resultSet.getString("startDate");
	    		endDate = resultSet.getString("endDate");
	    		ticketType = resultSet.getString("ticketType");
			}
    		
			postDescription = "Hey, I just finished working on this " +ticketType + " of ticket." +"Following are the details: " +"\n" +
					"Title: " +description + "\n" + "Time taken: " + resolutionHours + "(" + startDate + "to" + endDate + ")" +"\n" + 
					"Kindly let me know if further issues are found regarding this.";
    		
			return postDescription;
		}

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

				inputOutputHandler.displayMethod("Successfully updated the status in Twitter.");
				return true;

			} 
			catch (TwitterException e)
			{
				e.printStackTrace();
				return false;
			}
		
		}
}

