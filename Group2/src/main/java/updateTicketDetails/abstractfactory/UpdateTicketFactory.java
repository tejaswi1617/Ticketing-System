package updateTicketDetails.abstractfactory;

import database.intefaces.IConnectionManager;
import updateTicketDetails.UpdateTicket;
import updateTicketDetails.interfaces.IUpdateTicket;

public class UpdateTicketFactory implements IUpdateTicketFactory
{
	private static IUpdateTicketFactory uniqueInstance = null;

    private UpdateTicketFactory()
    {

    }

    public static IUpdateTicketFactory instance()
    {
        if(null == uniqueInstance)
        {
            uniqueInstance = new UpdateTicketFactory();
        }
        return uniqueInstance;
    }

	public IUpdateTicket UpdateTicket(IConnectionManager connectionMng) {
		return new UpdateTicket(connectionMng);
	}

}
