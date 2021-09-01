package reuseablePackage;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.intefaces.IConnectionManager;
import reuseablePackage.interfaces.IDisplayTickets;
import reuseablePackage.interfaces.IOpenTicket;
import reuseablePackage.interfaces.IStoreTicketData;


public class OpenTickets implements IOpenTicket
{	
	private IConnectionManager ConnectionManager;
	private IStoreTicketData storeTicketData;
	private IDisplayTickets displayUser;
	
	public OpenTickets(IStoreTicketData storeTicketData,IConnectionManager ConnectionManager)
	{
		this.ConnectionManager = ConnectionManager;
		this.storeTicketData = storeTicketData; 
		displayUser = new DisplayTickets();	
	}

	public String openticket(String ticketId)
	{
		List<String> comments;
		String tableofticket = "";
		ArrayList<String> singleTicketData = storeTicketData.getSingleTicketData(ticketId);
		List<String> columnOfTable = storeTicketData.getTicketColumns();
		if(singleTicketData.size() > 0) {
			comments = commentOnTicket(ticketId);
			tableofticket = displayUser.printSignleTicketDetails(singleTicketData,columnOfTable,comments);
		}
		
		ConnectionManager.closeConnection();
		return tableofticket;

		
	}
	
	private List<String> commentOnTicket(String ticketId) 
	{
		try 
		{
			Connection connect = ConnectionManager.establishConnection();
			CallableStatement SPstatement;
			String procedureCall = "fetchComments";
			SPstatement = connect.prepareCall("{call "+procedureCall+"(?)}");
			SPstatement.setString(1,ticketId);
			
			boolean hasResult=SPstatement.execute();
			
			if(hasResult) 
			{
				ResultSet resultSet = SPstatement.getResultSet();
				storeTicketData.addFetchedComments(resultSet);
				
				ConnectionManager.closeConnection();
				return(storeTicketData.getcommentsOnTicket());
			}
			else
			{
				ConnectionManager.closeConnection();
				return null;
			}
			
		} 
		catch (SQLException e)
		{
			ConnectionManager.closeConnection();
			return null;
		}
	}


}
