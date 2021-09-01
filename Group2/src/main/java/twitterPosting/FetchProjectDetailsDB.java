package twitterPosting;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import twitterPosting.Interfaces.IFetchProjectDetailsDB;
import twitterPosting.Interfaces.IInputPostingDetails;
import twitterPosting.Interfaces.ITwitterOperations;
import twitterPosting.abstractFactory.IPostHandlingFactory;
import twitterPosting.abstractFactory.PostHandlingFactory;
import database.ConnectionManager;
import database.intefaces.IConnectionManager;
import userinterface.IInputOutputHandler;

public class FetchProjectDetailsDB implements IFetchProjectDetailsDB 
{
	private Connection connection;
	private String ConfigurationFile = "ConfigurationFile.txt"; 
 
	IConnectionManager IConnectionMng = new ConnectionManager(ConfigurationFile);
	IPostHandlingFactory posthandling = PostHandlingFactory.instance();
	IInputPostingDetails postDetails;
	ITwitterOperations twitterPost;
	IInputOutputHandler inputOutputHandler;
	 
	public FetchProjectDetailsDB(IInputPostingDetails postDetails, IInputOutputHandler inputOutputHandler)
    {
        this.postDetails = postDetails;
        this.inputOutputHandler = inputOutputHandler;
    }
	
	public boolean getticketCountsDB() throws ParseException
	{
		connection = IConnectionMng.establishConnection();
        boolean success = false;
        boolean hasResult = false;
        ResultSet resultset = null;
        String postDescription = null;
		try 
		{   
			CallableStatement statement = (CallableStatement) connection.prepareCall("{call tweetDescriptionGenerator(?)}");
			
			statement.setString(1, postDetails.getTicketId());
            hasResult = statement.execute();
           
            if(hasResult)  
            {  
            	resultset = statement.getResultSet();
            	twitterPost = posthandling.getpostOperations(resultset, inputOutputHandler);
            	postDescription = twitterPost.generateTweetContent();
            	twitterPost.tweetTicket(postDescription); 
            }
            else 
            {
            	inputOutputHandler.displayMethod("Ticket ID not found");
    			return false;
            }
			return true;
		} 
		catch (SQLException e) 
		{
			System.out.print("SQL Exception");
			e.printStackTrace();
		}
        return success;
	}	
}