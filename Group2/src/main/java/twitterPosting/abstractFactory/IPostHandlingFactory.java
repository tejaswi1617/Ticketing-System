package twitterPosting.abstractFactory;

import java.sql.ResultSet;

import twitterPosting.Interfaces.IFetchProjectDetailsDB;
import twitterPosting.Interfaces.IInputPostingDetails;
import twitterPosting.Interfaces.ITwitterOperations;
import userinterface.IInputOutputHandler;

public interface IPostHandlingFactory
{
	public ITwitterOperations getpostOperations(ResultSet resultset,IInputOutputHandler inputOutputHandler);
	public IInputPostingDetails inputposting(String ticketId);
	public IFetchProjectDetailsDB fetchticket(IInputPostingDetails inputposting, IInputOutputHandler inputOutputHandler);
}
