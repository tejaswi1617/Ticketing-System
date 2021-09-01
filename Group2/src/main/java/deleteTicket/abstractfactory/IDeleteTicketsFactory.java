package deleteTicket.abstractfactory;

import database.intefaces.IConnectionManager;
import deleteTicket.interfaces.IDeleteTickets;


public interface IDeleteTicketsFactory 
{
	IDeleteTickets deleteticket(IConnectionManager IConnectionMng);

}
