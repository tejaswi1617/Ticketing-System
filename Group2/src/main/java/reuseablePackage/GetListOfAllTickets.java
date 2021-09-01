package reuseablePackage;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import database.intefaces.IConnectionManager;
import reuseablePackage.interfaces.IDisplayTickets;
import reuseablePackage.interfaces.IGetListOfTickets;
import reuseablePackage.interfaces.IStoreTicketData;

public class GetListOfAllTickets implements IGetListOfTickets
{
	private final int choice=4;
	private List<String> listOfTicketsId = new ArrayList<String>();
	
	private IConnectionManager connectionManager;
	private IDisplayTickets displayTickets = new DisplayTickets();
	private IStoreTicketData storeTicketData = new StoreTicketData();
	
	public GetListOfAllTickets(IConnectionManager connectionManager)
	{
		this.connectionManager = connectionManager;
		
	}
	
	public String listOfTickets()
	{
		String tableofticket="";
		try 
		{
			Connection connect = connectionManager.establishConnection();
			String procedureCall="searchTicket";
			CallableStatement SPstatement;
			SPstatement = connect.prepareCall("{call "+procedureCall+"(?,?)}");
			SPstatement.setLong(1,choice);
			SPstatement.setString(2, null);
			boolean hasResult = SPstatement.execute();
			if(hasResult)
			{
				ResultSet resultSet = SPstatement.getResultSet();
			    ResultSetMetaData tableMetaData = resultSet.getMetaData(); 
			    
			    storeTicketData.addFetchedTickets(resultSet,tableMetaData);
			    
			    Map<String, ArrayList <String>> ticketsData = storeTicketData.getTableData();
			    List<String> columnOfTable = storeTicketData.getTicketColumns();
			    
			    tableofticket = displayTickets.printTicketsDetails(ticketsData,columnOfTable);
			}
			connectionManager.closeConnection();
			
		}
		catch (SQLException e)
		{
			connectionManager.closeConnection();
		}
		return tableofticket;
	}
}
