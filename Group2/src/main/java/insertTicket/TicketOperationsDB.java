package insertTicket;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;

import database.ConnectionManager;
import database.intefaces.IConnectionManager;
import insertTicket.Interfaces.ICreateTicket;
import insertTicket.Interfaces.ITicketOperationsDB;
import userinterface.IInputOutputHandler;

public class TicketOperationsDB implements ITicketOperationsDB{

	private Connection connection;
	private String ConfigurationFile = "ConfigurationFile.txt";
 
    IInputOutputHandler inputOutputHandler;
	IConnectionManager IConnectionMng = new ConnectionManager(ConfigurationFile);
	ICreateTicket createTicket = null;
 
	public TicketOperationsDB(ICreateTicket createTicket)
	{
		this.createTicket = createTicket;
	}
	
	public boolean insertTicket() throws ParseException
	{
		connection = IConnectionMng.establishConnection();
        boolean success=false;
		try 
		{
			CallableStatement statement = (CallableStatement) connection.prepareCall("{call insertTicket(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
		
			statement.setString(1, createTicket.getTicketID());
            statement.setString(2, createTicket.getDescription());
            statement.setTimestamp(3, new java.sql.Timestamp(createTicket.generateStartDate().getTime()));
            statement.setTimestamp(4, new java.sql.Timestamp(createTicket.getExpectedEndDate().getTime()));
            statement.setString(5, createTicket.getReporterID());
            statement.setString(6, createTicket.getEmployeeID());
            statement.setString(7, createTicket.getAssigneeName());
            statement.setString(8, createTicket.getTicketType() );
            statement.setInt(9, createTicket.getPriority() );
            statement.setInt(10, createTicket.getUrgency());
            statement.setInt(11, createTicket.getImpact() );
            statement.setString(12, createTicket.getTicketLevel());
            statement.setString(13, createTicket.getCustomerID());
            statement.setString(14, createTicket.getCustomerName());
            statement.setString(15, createTicket.getCreatorID());
            statement.setString(16, createTicket.getCreatorName());
            statement.setString(17, createTicket.getAttachmentID());

	        statement.execute();
	        success = true;
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			inputOutputHandler.displayMethod("SQL Exception");
			e.printStackTrace();
		}
        return success;
	}	
	
	public boolean duplicateTicket() throws ParseException {
		
		connection = IConnectionMng.establishConnection();
		int duplicate_ticket = 0;
        boolean success=false;
		try 
		{
			CallableStatement statement = (CallableStatement) connection.prepareCall("{call duplicateTicket(?,?)}");

			statement.setString(1, createTicket.getTicketID());
            statement.execute();
            
            duplicate_ticket = statement.getInt(2);
             
			if(duplicate_ticket==0) 
			{
			    success = false;
			}
			else 
			{
				inputOutputHandler.displayMethod("Duplicate Entry Found!!!");
				success = true;
			}
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return success;
	}
}
