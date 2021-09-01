package reuseablePackage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

import reuseablePackage.interfaces.IExportTicket;
import reuseablePackage.interfaces.IStoreTicketData;
import reuseablePackage.interfaces.ITableGenerator;

public class ExportTickets implements  IExportTicket{
	private Scanner sc=new Scanner(System.in);
	
	private IStoreTicketData storeTicketData;
	private ITableGenerator tableFormate;
	
	public ExportTickets(IStoreTicketData storeTicketData)
	{
		this.storeTicketData = storeTicketData;
		tableFormate = new TableGenerator();
	}
	
	public boolean exportTicket(String FileName) {
		File myObj = new File(FileName);
	      try{
			if (myObj.createNewFile()) 
			{
				FileWriter myWriter = new FileWriter(FileName);
				LinkedHashMap<String,ArrayList<String>> ticketData = storeTicketData.getTableData();
				List<String> columnOfTable = storeTicketData.getTicketColumns();
				  List<List<String>> allRowData = new ArrayList<>();
				  
				  int index=0;
				  for(String key : ticketData.keySet())
				  {
					  List<String> rowData = new ArrayList<>();
					  rowData.add(key);
					  for(int i=0;i<ticketData.get(key).size();i++)
					  {
						  String data =  ticketData.get(key).get(i);
						  if(data == null)
						  {
							  rowData.add(""); 
						  }
						  else {
							  rowData.add(data);  
						  }
						   
					  }
					  if(rowData.size()>columnOfTable.size())
					  {
						  rowData.remove(0);
					  }
					  allRowData.add(index,rowData);
					  index++;
				  }
				 
				  myWriter.write(tableFormate.generateTable(columnOfTable, allRowData));
				  myWriter.close();
			}
			return true;
	      }
	    catch (IOException e)
	    {
	    	return false;
		} 
	}
}
