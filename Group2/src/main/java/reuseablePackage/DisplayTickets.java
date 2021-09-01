package reuseablePackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import reuseablePackage.interfaces.IDisplayTickets;
import reuseablePackage.interfaces.ITableGenerator;


public class DisplayTickets implements IDisplayTickets
{
	List<String> tableHeader;
	List<List<String>> rowOfTable;
	
	private ITableGenerator tableFormate;
	
	public DisplayTickets() 
	{
		tableFormate = new TableGenerator();
	}
	
	public String printTicketsDetails(Map<String,ArrayList<String>> ticketData,List<String> columnsOfTable)
	{ 
			
		tableHeader = new ArrayList<String>();
		rowOfTable = new  ArrayList<>();
		tableHeader.add(columnsOfTable.get(0));
		tableHeader.add(columnsOfTable.get(1));
		for(String key : ticketData.keySet())
		{
			ArrayList<String> rowData = new ArrayList<>();
			rowData.add(key);
			String element = ticketData.get(key).get(0);
			rowData.add(element);
			rowOfTable.add(rowData);
			
			
		}
		String table = tableFormate.generateTable(tableHeader, rowOfTable);
		return table;
	}
	
		
	public String printSignleTicketDetails(List<String> singleTicketData,List<String> columnsOfTable, List<String> comments)
	{
		rowOfTable = new  ArrayList<>();
		tableHeader = columnsOfTable;
		for(int i=0;i<singleTicketData.size();i++)
		{
			if(singleTicketData.get(i) == null)
			{
				singleTicketData.set(i, "");
			}
		}
		rowOfTable.add(singleTicketData);
		String table = tableFormate.generateTable(tableHeader, rowOfTable);
		table = table + "\n  Comments...";
		String commentsData="";
		for(int i = 0; i < comments.size() ; i++)
		{
			commentsData = commentsData +" "+comments.get(i)+"\n";
		}
		table = table + "\n"+commentsData;
		return table;
	}
}
    
