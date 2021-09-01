package reuseableClasses;

import java.util.ArrayList;
import java.util.List;

import reuseablePackage.abstractFactory.IReuseableClasssFactory;
import reuseablePackage.abstractFactory.ReuseableClasssFactory;
import reuseablePackage.interfaces.IDisplayTickets;
import reuseablePackage.interfaces.IOpenTicket;
import reuseablePackage.interfaces.ITableGenerator;

public class OpenTicketMock implements IOpenTicket
{

	ArrayList<String> singleTicketData;
	ArrayList<String> comments;
	
	List<String> columnOfTable;
		
	private IReuseableClasssFactory reuseableclassfactory = ReuseableClasssFactory.instance();
	private ITableGenerator generateTable;
	private IDisplayTickets displayticket;
	
	public OpenTicketMock()
	{
		generateTable = reuseableclassfactory.tableFormate();
		displayticket = reuseableclassfactory.displayUser();
		singleTicketData = new 	ArrayList<String>();
		comments = new 	ArrayList<String>();
		columnOfTable = new ArrayList<String>();
	}

	public String openticket(String ticketId)
	{
		String ticketID = "111";
		if(ticketId.equals(ticketID))
		{
			singleTicketData.add("111");
			singleTicketData.add("description: develope bugd free login functionality");
			singleTicketData.add("startDate:2021-03-15");
			singleTicketData.add("endDate:2021-03-30");
			singleTicketData.add("reporterId:EMP12");
			singleTicketData.add("employeeId:EMP123");
			singleTicketData.add("assigneeName:Tejasw");
			singleTicketData.add("ticketType: bug");
			singleTicketData.add("priority:1");
			singleTicketData.add("urgency:3");
		}
		addColumnsOfTable();
		comments = commentOnTicket(ticketId);
		String output= displayticket.printSignleTicketDetails(singleTicketData,columnOfTable,comments);
		return output;
			
	}
	
	private ArrayList<String> commentOnTicket(String ticketId) 
	{
		ArrayList<String> comment = new ArrayList<String>();
		String ticketID = "111";
		String commentData;
		if(ticketId.equals(ticketID))
		{
			commentData = "Tejaswi" + " "+"Chaudhary"+"\t\t"+"2021-03-14"+"\n"+"ITs good enough";
			comment.add(commentData);
			return comment;
		}
		else
		{
			return comment;
		}
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
