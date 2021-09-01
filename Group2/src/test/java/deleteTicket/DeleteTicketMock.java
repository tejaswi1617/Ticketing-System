package deleteTicket;

import deleteTicket.interfaces.IDeleteTickets;

public class DeleteTicketMock implements IDeleteTickets
{

	
	public boolean deleteticket(String ticketId) {
		return true;
	}

}
