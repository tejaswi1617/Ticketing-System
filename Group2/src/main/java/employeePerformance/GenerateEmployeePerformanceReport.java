package employeePerformance;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import employeePerformance.Interfaces.IGenerateEmployeePerformanceReport;
import employeePerformance.Interfaces.IInputEmployeeDetails;

public class GenerateEmployeePerformanceReport implements IGenerateEmployeePerformanceReport
{	
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		
		public ArrayList<String> displayEmployeeDetailsAndTicketCount( IInputEmployeeDetails employeeDetails, ResultSet resultset) throws SQLException, ParseException
		{ 
			ArrayList<String> employeeDetailsString = new ArrayList<String>();
			TableGenerator tableEmployeeInformation = new TableGenerator();
	        List<String> headersList = new ArrayList<>(); 
	        List<List<String>> rowsList = new ArrayList<>();
            List<String> row = new ArrayList<>(); 
            
	        headersList.add("Employee ID");
	        headersList.add("Date");
            row.add(employeeDetails.getEmployeeId());
            row.add(employeeDetails.getDate());
            rowsList.add(row);
	        
	        employeeDetailsString.add(tableEmployeeInformation.generateTable(headersList, rowsList));
	       
	        headersList.clear();
	        headersList.add("Ticket Level");
	        headersList.add("Count");
	        rowsList.clear();

	        while(resultset.next()) 
	    	{
	            List<String> ticketDetailRow = new ArrayList<>(); 
	            ticketDetailRow.add(resultset.getString("ticketLevel"));
	            ticketDetailRow.add(resultset.getString("count"));
	            rowsList.add(ticketDetailRow);
	    	}
	        
	        employeeDetailsString.add(tableEmployeeInformation.generateTable(headersList, rowsList));

			return employeeDetailsString;
		}
		
		
		public ArrayList<String> displayEmployeeEfficiency(HashMap <Integer, Integer> calculatedEmployeeEfficiency) 
		{
			ArrayList<String> employeeDetailsString = new ArrayList<String>();
	        String[] monthString = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
			TableGenerator tableGeneratorEmployeeEfficiency = new TableGenerator();
	        List<String> headersList = new ArrayList<>();
	        List<List<String>> rowsList = new ArrayList<>();

			employeeDetailsString.add("################ Month Wise Efficiency ################");
			headersList.clear();
	        headersList.add("Month");
	        headersList.add("Efficiency");
	        
	        for(int i=0;i<12;i++)
	        {
	            if(calculatedEmployeeEfficiency.containsKey(i))
				{	
		            List<String> ticketDetailRow = new ArrayList<>(); 
		            ticketDetailRow.add(monthString[i]);
		            ticketDetailRow.add(calculatedEmployeeEfficiency.get(i).toString());
		            rowsList.add(ticketDetailRow);
				}
	        }

	        employeeDetailsString.add(tableGeneratorEmployeeEfficiency.generateTable(headersList, rowsList));

			return employeeDetailsString;
		}
		
		public ArrayList<String> displayEmployeeProductivity(HashMap <Integer, Integer> calculatedEmployeeProductivity)  
		{
			ArrayList<String> employeeDetailsString = new ArrayList<String>();
			TableGenerator tableGeneratorEmployeeProductivity = new TableGenerator();
	        List<String> headersList = new ArrayList<>();
	        List<List<String>> rowsList = new ArrayList<>();
	        String[] monthString = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

			employeeDetailsString.add("################ Month Wise Productivity ################");
			headersList.clear();
	        headersList.add("Month");
	        headersList.add("Productivity");
	        
	        for(int i=0;i<12;i++)
	        {
	            if(calculatedEmployeeProductivity.containsKey(i))
				{	
		            List<String> ticketDetailRow = new ArrayList<>(); 
		            ticketDetailRow.add(monthString[i]);
		            ticketDetailRow.add(calculatedEmployeeProductivity.get(i).toString());
		            rowsList.add(ticketDetailRow);
				}
	        }
	    	
	        employeeDetailsString.add(tableGeneratorEmployeeProductivity.generateTable(headersList, rowsList));
			
			return employeeDetailsString;
		}
}