package comments;

import java.sql.Date;
import java.text.SimpleDateFormat;

import commentOnTicket.interfaces.ICommentOnTickets;
import userinterface.IInputOutputHandler;
import userinterface.InputOutputHandler;

public class CommentOnTicketMock implements ICommentOnTickets 
{
	IInputOutputHandler inputoutputhandler = new InputOutputHandler();

	private SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
	private Date date = new Date(System.currentTimeMillis());
	
	
	public boolean postCommentOnticket(String ticketId, String UserName, String comment) {
		String dateInfo = formatter.format(date);
		inputoutputhandler.displayMethod(ticketId + "\n"+UserName + "\t" + dateInfo+"\n"+comment);
		return true;
	}

}
