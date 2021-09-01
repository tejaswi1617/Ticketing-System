package twitterPosting;

import twitterPosting.Interfaces.IFetchProjectDetailsDB;

public class FetchProjectDetailsMock implements IFetchProjectDetailsDB
{	
	String ticketId = null;

	public boolean getticketCountsDB()
	{
		ticketId = "111";
		if(ticketId == "111") 
		{
			return true;
		}
		else if (ticketId == "1555")
		{
			return false;
		}
		return false;
	}
} 
