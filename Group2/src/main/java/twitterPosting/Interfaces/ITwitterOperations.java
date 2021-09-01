package twitterPosting.Interfaces;

import java.sql.SQLException;

public interface ITwitterOperations 
{
	public boolean tweetTicket(String description);
	public String generateTweetContent() throws SQLException; 
}
