package commentOnTicket;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import commentOnTicket.interfaces.ICommentOnTickets;
import database.intefaces.IConnectionManager;

public class CommentOnTickets implements ICommentOnTickets
{

	private SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
	private Date date = new Date(System.currentTimeMillis());
	
	private IConnectionManager connectionManager;
	
	public CommentOnTickets(IConnectionManager connectionManager) 
	{
		this.connectionManager=connectionManager;
		
	}

	public boolean postCommentOnticket(String ticketId, String employeeID, String comment)
	{
		String dateInfo = formatter.format(date);
		boolean result;
		
		try 
		{
			Connection connect = connectionManager.establishConnection();
			CallableStatement SPstatement;
			String procedureCall = "postCommentOnTicket";
			SPstatement = connect.prepareCall("{call "+procedureCall+"(?,?,?,?)}");
			SPstatement.setString(1,ticketId);
			SPstatement.setString(2,employeeID);
			SPstatement.setString(3,dateInfo);
			SPstatement.setString(4,comment);
			
			SPstatement.execute();
			
			connectionManager.closeConnection();
			
			result = true;
		} 
		catch (SQLException e)
		{
			result = false;
		}

		return result;
	}
}
