package twitterPosting;

import twitterPosting.Interfaces.IInputPostingDetails;

public class InputPostingDetails implements IInputPostingDetails
{
    private String ticketId = null;

    public InputPostingDetails(String ticketId) 
    {
    	this.ticketId = ticketId;
    }
    
    public String getTicketId() 
    {
        return ticketId;
    }
}