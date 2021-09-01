package comments.abstractfactory;

import commentOnTicket.interfaces.ICommentOnTickets;
import comments.CommentOnTicketMock;

public class CommentOnTicketFactoryTest implements ICommentOnTicketFactoryTest
{
	private static CommentOnTicketFactoryTest uniqueInstance = null;

    private CommentOnTicketFactoryTest()
    {

    }

    public static ICommentOnTicketFactoryTest instance()
    {
        if(null == uniqueInstance)
        {
            uniqueInstance = new CommentOnTicketFactoryTest();
        }
        return uniqueInstance;
    }

	public ICommentOnTickets commentonticketMock()
	{
		return new CommentOnTicketMock();
	}
	
}
