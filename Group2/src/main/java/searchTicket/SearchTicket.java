package searchTicket;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import database.intefaces.IConnectionManager;
import reuseablePackage.abstractFactory.IReuseableClasssFactory;
import reuseablePackage.abstractFactory.ReuseableClasssFactory;
import reuseablePackage.interfaces.IDisplayTickets;
import reuseablePackage.interfaces.IStoreTicketData;
import searchTicket.interfaces.ISearchTicket;

public class SearchTicket implements ISearchTicket
{
	static IReuseableClasssFactory reuseablefactory=ReuseableClasssFactory.instance();
	private IStoreTicketData storeTicketData;
	private IDisplayTickets displayUser;
	private IConnectionManager connectionManager;
	
	public SearchTicket(IStoreTicketData storeTicketData,IConnectionManager connectionManager)
	{
		this.storeTicketData = storeTicketData; 
		this.connectionManager = connectionManager;
		displayUser = reuseablefactory.displayUser();
	}
	public String searchbyTicket(int choice, String searchInput) 
	{
		String output="";
		try 
		{
			Connection connect = connectionManager.establishConnection();
			CallableStatement SPstatement;
			String procedureCall = "searchTicket";
			SPstatement = connect.prepareCall("{call "+procedureCall+"(?,?)}");
			SPstatement.setLong(1,choice);
			SPstatement.setString(2,searchInput);
			boolean hasResult=SPstatement.execute();
			if(hasResult)
			{
				ResultSet resultSet = SPstatement.getResultSet();
			    ResultSetMetaData tableMetaData = resultSet.getMetaData();
			    storeTicketData.addFetchedTickets(resultSet,tableMetaData);
			    LinkedHashMap<String,ArrayList<String>> ticketData = storeTicketData.getTableData();
			    List<String> columnOfTable = storeTicketData.getTicketColumns();
			    if(ticketData.size()>0)
			    {
			    	 output = displayUser.printTicketsDetails(ticketData,columnOfTable);
			    }
			}
	
			connectionManager.closeConnection();
		} 
		catch (SQLException e)
		{
			connectionManager.closeConnection();
		}
		return output;
	}	
}
