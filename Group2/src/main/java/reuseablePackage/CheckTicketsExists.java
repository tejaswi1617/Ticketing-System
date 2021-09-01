package reuseablePackage;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.intefaces.IConnectionManager;
import reuseablePackage.interfaces.ICheckTicketsExists;

public class CheckTicketsExists  implements ICheckTicketsExists
{
	private final int choice=1;
	private Connection connect=null;
	private CallableStatement SPstatement=null;
	private ResultSet resultSet=null;

	private IConnectionManager connectionManager;
	
	public CheckTicketsExists(IConnectionManager connectionManager)
	{
		this.connectionManager = connectionManager;
	}
	public boolean ticketExists(String ticketID)
	{
		boolean result=false;
		try {
			fetchTicketForTicketID(ticketID);
			if(resultSet.next())
			{
				result=true;	
			}
			connectionManager.closeConnection();
		} catch (Exception e) {
			connectionManager.closeConnection();
		}
		return result;
	}
	
	private void fetchTicketForTicketID(String ticketID)
	{
		try 
		{
			connect = connectionManager.establishConnection();
			SPstatement = connect.prepareCall("{call searchTicket(?,?)}");
			SPstatement.setLong(1,choice);
			SPstatement.setString(2,ticketID);
			SPstatement.execute();
			resultSet = SPstatement.getResultSet();
		}
		catch (SQLException e)
		{
			connectionManager.closeConnection();
		}
		
	}
	
	public boolean ticketExistForNotManager(String ticketID,String employeeID)
	{
		boolean result=false;
		try
		{
			fetchTicketForTicketID(ticketID);
			if(resultSet.next())
			{
				String employeeid = resultSet.getString("employeeID");
				if(employeeid.equals(employeeID))
				{
					
					result=true;
				}
				connectionManager.closeConnection();
			}
		} 
		catch (Exception e)
		{
			connectionManager.closeConnection();
		}
		return result;
	}

}
