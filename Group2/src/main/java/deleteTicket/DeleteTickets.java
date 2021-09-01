package deleteTicket;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import database.intefaces.IConnectionManager;
import deleteTicket.interfaces.IDeleteTickets;

public class DeleteTickets implements IDeleteTickets
{
	private Connection connect=null;
	private CallableStatement SPstatement=null;
	private String ConfigurationFile = "ConfigurationFile";
	
	private IConnectionManager IConnectionMng;
	
	public DeleteTickets(IConnectionManager IConnectionMng)
	{
		this.IConnectionMng =IConnectionMng ;
	}

	public boolean deleteticket(String ticketId)
	{
		try 
		{
			connect = IConnectionMng.establishConnection();
			SPstatement = connect.prepareCall("{call deleteticket(?)}");
			SPstatement.setString(1,ticketId);
			SPstatement.execute();
			IConnectionMng.closeConnection();
			return true;
		} 
		catch (SQLException e)
		{
				e.printStackTrace();
				return false;
		}
	}			
}
