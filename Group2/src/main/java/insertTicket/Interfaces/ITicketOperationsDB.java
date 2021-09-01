package insertTicket.Interfaces;

import java.text.ParseException;

public interface ITicketOperationsDB {

	public boolean insertTicket() throws ParseException;
	public boolean duplicateTicket() throws ParseException;
}
