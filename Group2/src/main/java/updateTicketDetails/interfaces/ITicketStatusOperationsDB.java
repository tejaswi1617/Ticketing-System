package updateTicketDetails.interfaces;

import java.sql.SQLException;

public interface ITicketStatusOperationsDB {

	public double ticketonHoldHours(String ticketID);
    public double ticketInProgressHours(String ticketID);
    public boolean openTicket(String ticketID)  throws SQLException;


}
