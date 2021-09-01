package twitterPosting.abstractfactory;

import java.sql.ResultSet;

import twitterPosting.Interfaces.IFetchProjectDetailsDB;
import twitterPosting.Interfaces.IInputPostingDetails;
import twitterPosting.Interfaces.ITwitterOperations;
import userinterface.IInputOutputHandler;

public interface ITwitterPostingTest 
{
    public IInputPostingDetails getInputPosting(String ticketId);
    public ITwitterOperations getpostOperations(ResultSet resultset,IInputOutputHandler inputOutputHandler);
	public IFetchProjectDetailsDB fetchticket();
}
