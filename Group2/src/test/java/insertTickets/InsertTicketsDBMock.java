package insertTickets;
  
import java.text.ParseException;

import insertTicket.Interfaces.ICreateTicket;
import insertTicket.Interfaces.ITicketOperationsDB;
 
public class InsertTicketsDBMock implements ITicketOperationsDB
{
	ICreateTicket createTicket;
	 
	public InsertTicketsDBMock(ICreateTicket createTicket)
	{
		this.createTicket = createTicket;
	}
	public boolean insertTicket() throws ParseException
	{
		if(createTicket.equals(null)) 
		{
			return false;
		}
		return true;
	}
	public boolean duplicateTicket() throws ParseException 
	{
		if(createTicket.getTicketID() == "111") 	//duplicate key found
		{
			return false;
		}
		return true;
	}
}
