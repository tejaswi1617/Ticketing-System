package insertTicket;

import java.text.ParseException;

import insertTicket.Interfaces.ICreateTicket;
import insertTicket.Interfaces.IInsertTicket;
import insertTicket.Interfaces.ITicketOperationsDB;
import insertTicket.abstractFactory.IInsertTicketFactory;
import insertTicket.abstractFactory.InsertTicketFactory;

public class InsertTicket implements IInsertTicket
{
	IInsertTicketFactory  insertTicketFactory = InsertTicketFactory.instance();

	ITicketOperationsDB ticketOperationDB;
	ICreateTicket createTicket;
	
	public InsertTicket(ICreateTicket createTicket)
	{
		this.createTicket = createTicket;
	}
	 
	public boolean successfulInsertion() throws ParseException
	{
		boolean result = false;
	
		try 
		{
			ticketOperationDB = insertTicketFactory.insertTicketDB(createTicket);
			result = ticketOperationDB.duplicateTicket();
			if(result==false)
			{ 
				result = ticketOperationDB.insertTicket();
				System.out.print(result);
				return result;
			}
			else 
			{
				return result;
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
