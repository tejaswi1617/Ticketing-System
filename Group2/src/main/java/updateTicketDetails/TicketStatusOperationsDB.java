package updateTicketDetails;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import database.ConnectionManager;
import database.intefaces.IConnectionManager;
import insertTicket.Interfaces.ICreateTicket;
import updateTicketDetails.interfaces.ITicketStatusOperationsDB;
import updateTicketDetails.interfaces.IworkingHours;

public class TicketStatusOperationsDB implements ITicketStatusOperationsDB
{
	
		private Connection connection;
		private String ConfigurationFile = "ConfigurationFile.txt";
	 
		IConnectionManager IConnectionMng = new ConnectionManager(ConfigurationFile);
		ICreateTicket createTicket = null;
		IworkingHours hours;
	    HashMap<String, String> inputsHandler = new HashMap<String, String>();

	    
		public double ticketonHoldHours(String ticketID)
		{
				connection = IConnectionMng.establishConnection();
		        boolean hasResult = false;
		        double onHoldHours = 0;
		        ResultSet resultset;
				try {
				CallableStatement statement = (CallableStatement) connection.prepareCall("{call getTicketStatusDate(?)}");
				
				statement.setString(1, ticketID);
			
				hasResult = statement.execute();
		
		        if(hasResult)  
		        {  
		        	resultset = statement.getResultSet();
		        	hours = new workingHours(resultset);
		        	onHoldHours = hours.insertTicket(resultset);
		        }
			}
			catch (SQLException e)
			{
				onHoldHours=0;
			}
			return onHoldHours;	
		}
		

	    public double ticketInProgressHours(String ticketID)
		{
			String inProgressEnterdate = null;
			Date todayDate = null;
			Date formateGetDate = null;
			double inProgressHours = 0;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		    Calendar cal = Calendar.getInstance();
		    CallableStatement statement;
			ResultSet resultset;
			boolean hasResult = false;
			try
			{
				
				connection = IConnectionMng.establishConnection();
				statement = connection.prepareCall("{call getTicketStatusDate(?)}");
				statement.setString(1,ticketID);
				
				hasResult = statement.execute();
		
		        if(hasResult)  
		        {  
		        	resultset = statement.getResultSet();
		        	hours = new workingHours(resultset);
		        	inProgressHours = hours.insertTicket(resultset);
		        }
				
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    return inProgressHours;	
	    }
	    
	    public boolean openTicket(String ticketID) throws SQLException
		{
	    	
		    CallableStatement statement;
			ResultSet resultset;
			boolean hasResult = false;
			double inProgressHours = 0;
	    	ticketInProgressHours( ticketID);
	    	connection = IConnectionMng.establishConnection();
			statement = connection.prepareCall("{call check_openTicket(?)}");
			statement.setString(1,ticketID);
			
			hasResult = statement.execute();
	
	        if(hasResult)  
	        {  
	        	resultset = statement.getResultSet();
	        	hours = new workingHours(resultset);
	        	inProgressHours = hours.insertTicket(resultset);

	        	connection = IConnectionMng.establishConnection();
				statement = connection.prepareCall("{call calculating_responseHours(?,?)}");
				statement.setDouble(1,inProgressHours);
				statement.setString(2,ticketID);

				statement.execute();
	        }
			return true;
	    }
	}


