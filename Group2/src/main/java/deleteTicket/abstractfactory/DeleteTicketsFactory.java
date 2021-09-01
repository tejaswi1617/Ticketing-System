package deleteTicket.abstractfactory;

import database.intefaces.IConnectionManager;
import deleteTicket.DeleteTickets;
import deleteTicket.interfaces.IDeleteTickets;

public class DeleteTicketsFactory implements IDeleteTicketsFactory
{
	private static IDeleteTicketsFactory uniqueInstance = null;

    private DeleteTicketsFactory()
    {

    }

    public static IDeleteTicketsFactory instance()
    {
        if(null == uniqueInstance)
        {
            uniqueInstance = new DeleteTicketsFactory();
        }
        return uniqueInstance;
    }


	public IDeleteTickets deleteticket(IConnectionManager IConnectionMng)
	{		
		return new DeleteTickets(IConnectionMng);
	}

}
