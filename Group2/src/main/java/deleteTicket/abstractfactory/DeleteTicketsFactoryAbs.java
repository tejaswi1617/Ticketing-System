package deleteTicket.abstractfactory;


import database.intefaces.IConnectionManager;
import deleteTicket.interfaces.IDeleteTickets;


public abstract class DeleteTicketsFactoryAbs
{
	public abstract IDeleteTickets deleteticket(IConnectionManager IConnectionMng);

}
