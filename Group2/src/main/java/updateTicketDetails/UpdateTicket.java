package updateTicketDetails;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import database.intefaces.IConnectionManager;
import updateTicketDetails.interfaces.ITicketStatusOperationsDB;
import updateTicketDetails.interfaces.IUpdateTicket;

public class UpdateTicket implements IUpdateTicket
{
	private Connection connect=null;
	private CallableStatement SPstatement=null;
	private ResultSet resultSet=null;

	private IConnectionManager connectionManager;
	private ITicketStatusOperationsDB ticketStatusOperationsDB = new TicketStatusOperationsDB();
	
	public UpdateTicket(IConnectionManager connectionManager)
	{
		this.connectionManager = connectionManager;
	}
	
	public boolean updateValueOfTicketForManager(String ticketID, int choice , String valueToUpdate)
	{
		boolean result = false;
		try 
		{
			if(choice == 7) 
			{
				return result=changeTicketSatatus(ticketID,valueToUpdate);
			}
			else
			{
				connect = connectionManager.establishConnection();
				SPstatement = connect.prepareCall("{call updateTicketForManager(?,?,?)}");
				SPstatement.setLong(1,choice);
				SPstatement.setString(2,ticketID);
				SPstatement.setString(3,valueToUpdate);
				boolean hasResult=SPstatement.execute();
				if(hasResult == false) {
					int count = SPstatement.getUpdateCount();
					if(count > 0)
					{
					   result = true;
					}
			
				}
				connectionManager.closeConnection();
			} 
		}
		catch (SQLException e)
		{
			connectionManager.closeConnection();
		}
	
		return result;
	}
	
	private boolean changeTicketSatatus(String ticketID, String valueToUpdate) {
		valueToUpdate = valueToUpdate.toLowerCase();
		double hours = 0;
		boolean result = false;
		int choice = 0;
		try 
		{
			connect = connectionManager.establishConnection();
			SPstatement = connect.prepareCall("{call searchTicket(?,?)}");
			SPstatement.setLong(1,1);
			SPstatement.setString(2,ticketID);
			SPstatement.execute();
			resultSet = SPstatement.getResultSet();
			if(resultSet.next())
			{
				String status = resultSet.getString("ticketStatus");
				if(status.equals("null"))
				{
					hours=0;
					ticketStatusOperationsDB.openTicket(ticketID);
				}
				else if(status.equals("done"))
				{
					return false;
				}else if(status.equalsIgnoreCase("on hold"))
				{
					if(status.equalsIgnoreCase(valueToUpdate)) {
						return false;
					}
					else
					{
						hours = ticketStatusOperationsDB.ticketonHoldHours(ticketID);
						choice = 1;
					}
					
				}
				else if(status.equalsIgnoreCase("in progress"))
				{
					if(status.equals(valueToUpdate))
					{
						return false;
					}
					else 
					{
						hours = ticketStatusOperationsDB.ticketInProgressHours(ticketID);
						choice = 2;
					}
					
				}
				
				double previoushours =0;
				int count=0;
				if(choice==1)
				{
					 previoushours = resultSet.getDouble("ticketOnHoldHours");
				}
				else if(choice==2)
				{
					previoushours = resultSet.getDouble("ticketInProgressHours");
				}
				
				if(previoushours > 0 ) 
				{
					hours = hours + previoushours;
				}
				
				if(valueToUpdate.equals("done"))
				{
					SPstatement = connect.prepareCall("{call calculating_resolutionHours(?,?,?,?)}");
					SPstatement.setString(1,status);
					SPstatement.setString(2,ticketID);
					SPstatement.setDouble(3,hours);
					SPstatement.setString(4,valueToUpdate);
					SPstatement.execute();
					count = SPstatement.getUpdateCount();
					
				}
				else if(hours>-1)
				{
					
					SPstatement = connect.prepareCall("{call updateTicketStatusDetails(?,?,?,?)}");
					SPstatement.setInt(1,choice);
					SPstatement.setString(2,ticketID);
					SPstatement.setDouble(3,hours);
					SPstatement.setString(4,valueToUpdate);
					SPstatement.execute();
					count = SPstatement.getUpdateCount();
					
				}
				if(count > 0)
				{
					   result = true;
				}
			}
			
			connectionManager.closeConnection();
		} 
		catch (SQLException e)
		{
			connectionManager.closeConnection();
		}

		return result;
		
	}
	public boolean updateValueOfTicketForNotManager(String ticketID, String valueToUpdate) throws ParseException
	{
		boolean result = changeTicketSatatus(ticketID,valueToUpdate);
		return result;
	}
	
}
