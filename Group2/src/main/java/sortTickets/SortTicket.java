package sortTickets;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import database.intefaces.IConnectionManager;
import reuseablePackage.abstractFactory.IReuseableClasssFactory;
import reuseablePackage.abstractFactory.ReuseableClasssFactory;
import reuseablePackage.interfaces.IDisplayTickets;
import reuseablePackage.interfaces.IStoreTicketData;
import sortTickets.interfaces.ISortTicket;

public class SortTicket implements ISortTicket 
{	
	private IConnectionManager connectionManager;
	private IReuseableClasssFactory reuseablefactory = ReuseableClasssFactory.instance();
	private IDisplayTickets displayUser;
	private IStoreTicketData storeTicketData ;
	
	public SortTicket(IStoreTicketData storeTicketData,IConnectionManager connectionManager)
	{
		this.storeTicketData = storeTicketData; 
		displayUser = reuseablefactory.displayUser();
		this.connectionManager = connectionManager;
	}
	
	public String sortTickets(int choice) 
	{
		String output="";
		try 
		{
			Connection connect = connectionManager.establishConnection();
			CallableStatement SPstatement;
			String procedureCall = "sortTickets";
			SPstatement = connect.prepareCall("{call "+procedureCall+"(?)}");
			 
			SPstatement.setLong(1,choice);
			SPstatement.execute();
			boolean hasResult=SPstatement.execute();
			
			if(hasResult)
			{
				ResultSet resultSet = SPstatement.getResultSet();
			    ResultSetMetaData tableMetaData = resultSet.getMetaData();
			    storeTicketData.addFetchedTickets(resultSet,tableMetaData);
			    Map<String, ArrayList <String>> ticketsData = storeTicketData.getTableData();
			    List<String> columnOfTable = storeTicketData.getTicketColumns();
			    output = displayUser.printTicketsDetails(ticketsData,columnOfTable);
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
