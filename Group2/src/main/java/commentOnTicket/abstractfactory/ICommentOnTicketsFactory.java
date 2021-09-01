package commentOnTicket.abstractfactory;

import commentOnTicket.interfaces.ICommentOnTickets;
import database.intefaces.IConnectionManager;

public interface ICommentOnTicketsFactory 
{
	ICommentOnTickets postComment(IConnectionManager connectionManager);
}
