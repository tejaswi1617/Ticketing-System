package sortTickets.abstractfactory;


import database.intefaces.IConnectionManager;
import reuseablePackage.interfaces.IStoreTicketData;
import sortTickets.SortTicket;
import sortTickets.interfaces.ISortTicket;

public class SortTicketFactory implements ISortTicketFactory
{

	private static ISortTicketFactory uniqueInstance = null;

    private SortTicketFactory()
    {

    }

    public static ISortTicketFactory instance()
    {
        if(null == uniqueInstance)
        {
            uniqueInstance = new SortTicketFactory();
        }
        return uniqueInstance;
    }


	
	public ISortTicket sortTicketobj(IStoreTicketData storeTicketData,IConnectionManager connectionManager)
	{
		return new SortTicket(storeTicketData,connectionManager);
	}
	
}
