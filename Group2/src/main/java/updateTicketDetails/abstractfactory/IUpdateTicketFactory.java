package updateTicketDetails.abstractfactory;

import database.intefaces.IConnectionManager;
import updateTicketDetails.interfaces.IUpdateTicket;

public interface IUpdateTicketFactory 
{
	IUpdateTicket UpdateTicket(IConnectionManager connectionMng);
}
