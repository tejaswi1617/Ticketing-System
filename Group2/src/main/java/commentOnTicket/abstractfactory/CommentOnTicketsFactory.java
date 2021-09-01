package commentOnTicket.abstractfactory;

import commentOnTicket.CommentOnTickets;
import commentOnTicket.interfaces.ICommentOnTickets;
import database.intefaces.IConnectionManager;

public class CommentOnTicketsFactory implements ICommentOnTicketsFactory
{
	private static CommentOnTicketsFactory uniqueInstance = null;

    private CommentOnTicketsFactory()
    {

    }

    public static ICommentOnTicketsFactory instance()
    {
        if(null == uniqueInstance)
        {
            uniqueInstance = new CommentOnTicketsFactory();
        }
        return uniqueInstance;
    }

	public ICommentOnTickets postComment(IConnectionManager connectionManager)
	{
		return new CommentOnTickets(connectionManager);
	}

}
