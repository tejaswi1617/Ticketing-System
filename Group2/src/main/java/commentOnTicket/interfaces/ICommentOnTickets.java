package commentOnTicket.interfaces;

public interface ICommentOnTickets
{
	public boolean postCommentOnticket(String ticketId, String UserName, String comment);
}
