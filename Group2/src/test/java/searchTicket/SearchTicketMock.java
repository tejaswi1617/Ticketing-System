package searchTicket;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import reuseablePackage.abstractFactory.IReuseableClasssFactory;
import reuseablePackage.abstractFactory.ReuseableClasssFactory;
import reuseablePackage.interfaces.IDisplayTickets;
import reuseablePackage.interfaces.ITableGenerator;
import searchTicket.interfaces.ISearchTicket;

public class SearchTicketMock implements ISearchTicket
{
	
	Map<String, ArrayList<String>> ticketsData ;
	List<String> columnOfTable;
	
	private IReuseableClasssFactory reuseableclassfactory = ReuseableClasssFactory.instance();
	private ITableGenerator generateTable;
	private IDisplayTickets displayticket;

	
	public SearchTicketMock()
	{
		generateTable = reuseableclassfactory.tableFormate();
		displayticket = reuseableclassfactory.displayUser();
		ticketsData = new LinkedHashMap<String, ArrayList<String>>();
		columnOfTable = new ArrayList<String>();
	}
	
	public String searchbyTicket(int choice, String searchInput) 
	{
		addColumnsOfTable();
		if(choice==1)
		{
			if(searchInput.equals("111")) 
			{
				ticketsData.put(searchInput, new ArrayList<String>());
				ticketsData.get(searchInput).add("description: develope bugd free login functionality");
				ticketsData.get(searchInput).add("startDate:2021-03-15");
				ticketsData.get(searchInput).add("endDate:2021-03-30");
				ticketsData.get(searchInput).add("reporterId:EMP12");
				ticketsData.get(searchInput).add("employeeId:EMP123");
				ticketsData.get(searchInput).add("assigneeName:Tejasw");
				ticketsData.get(searchInput).add("ticketType: bug");
				ticketsData.get(searchInput).add("priority:1");
				ticketsData.get(searchInput).add("urgency:3");
			}
		}
		
		else if (choice == 2)
		{
			if(searchInput.equals("Tejasw"))
			{
				ticketsData.put("111", new ArrayList<String>());
				ticketsData.get("111").add("description: develope bugd free login functionality");
				ticketsData.get("111").add("startDate:2021-03-15");
				ticketsData.get("111").add("endDate:2021-03-30");
				ticketsData.get("111").add("reporterId:EMP12");
				ticketsData.get("111").add("employeeId:EMP123");
				ticketsData.get("111").add("assigneeName:"+searchInput);
				ticketsData.get("111").add("ticketType: bug");
				ticketsData.get("111").add("priority:1");
				ticketsData.get("111").add("urgency:3");
			}
			
		}
		else if (choice == 3)
		{
			if(searchInput.equals("bug"))
			{
				ticketsData.put("111", new ArrayList<String>());
				ticketsData.get("111").add("description: develope bugd free login functionality");
				ticketsData.get("111").add("startDate:2021-03-15");
				ticketsData.get("111").add("endDate:2021-03-30");
				ticketsData.get("111").add("reporterId:EMP12");
				ticketsData.get("111").add("employeeId:EMP123");
				ticketsData.get("111").add("assigneeName:"+searchInput);
				ticketsData.get("111").add("ticketType:"+searchInput);
				ticketsData.get("111").add("priority:1");
				ticketsData.get("111").add("urgency:3");
			}
		}
		else if (choice == 4)
		{
			ticketsData.put("111", new ArrayList<String>());
			ticketsData.get("111").add("description: develope bugd free login functionality");
			ticketsData.get("111").add("startDate:2021-03-15");
			ticketsData.get("111").add("endDate:2021-03-30");
			ticketsData.get("111").add("reporterId:EMP12");
			ticketsData.get("111").add("employeeId:EMP123");
			ticketsData.get("111").add("assigneeName:bug");
			ticketsData.get("111").add("ticketType: bug");
			ticketsData.get("111").add("priority:1");
			ticketsData.get("111").add("urgency:3");
		}
		else if (choice == 5)
				
		{
			if(searchInput.equals("EMP123"))
			{
				ticketsData.put("111", new ArrayList<String>());
				ticketsData.get("111").add("description: develope bugd free login functionality");
				ticketsData.get("111").add("startDate:2021-03-15");
				ticketsData.get("111").add("endDate:2021-03-30");
				ticketsData.get("111").add("reporterId:EMP12");
				ticketsData.get("111").add("employeeId:"+searchInput);
				ticketsData.get("111").add("assigneeName:"+searchInput);
				ticketsData.get("111").add("ticketType: bug");
				ticketsData.get("111").add("priority:1");
				ticketsData.get("111").add("urgency:3");
			}
		}
		else if (choice == 6)
		{
			if(searchInput.contains("login"))
			{
				ticketsData.put("111", new ArrayList<String>());
				ticketsData.get("111").add("develope bugd free"+ searchInput +"functionality");
				ticketsData.get("111").add("2021-03-15");
				ticketsData.get("111").add("2021-03-30");
				ticketsData.get("111").add("EMP12");
				ticketsData.get("111").add("EMP123");
				ticketsData.get("111").add(searchInput);
				ticketsData.get("111").add("bug");
				ticketsData.get("111").add("1");
				ticketsData.get("111").add("");
			}
		}
		String output = displayticket.printTicketsDetails(ticketsData,columnOfTable);
		return output;
	}

	private void addColumnsOfTable() {
		columnOfTable.add("ticketId");
		columnOfTable.add("description");
		columnOfTable.add("startDate");
		columnOfTable.add("endDate");
		columnOfTable.add("reporterId");
		columnOfTable.add("employeeId");
		columnOfTable.add("assigneeName");
		columnOfTable.add("ticketType");
		columnOfTable.add("priority");
		columnOfTable.add("urgency");
		
	}	
}
