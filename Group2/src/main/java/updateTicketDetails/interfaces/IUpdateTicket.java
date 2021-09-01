package updateTicketDetails.interfaces;

import java.text.ParseException;

public interface IUpdateTicket {
	public boolean updateValueOfTicketForManager(String ticketID, int choice , String valueToUpdate);
	public boolean updateValueOfTicketForNotManager(String ticketID, String valueToUpdate) throws ParseException;
}
