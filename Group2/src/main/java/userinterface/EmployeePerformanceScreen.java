package userinterface;

import userinterface.abstractFactory.*;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import employeePerformance.Interfaces.IEmployeePerformanceDB;
import employeePerformance.Interfaces.IInputEmployeeDetails;
import employeePerformance.abstractFactory.EmployeePerformanceFactory;
import employeePerformance.abstractFactory.IEmployeePerformanceFactory;
import login.Interfaces.IParameterizedUser;

public class EmployeePerformanceScreen implements IEmployeePerformanceScreen
{
    private final IUserInterfaceFactory userInterfaceFactory =  UserInterfaceFactory.instance();;
    private IEmployeePerformanceFactory employeePerformanceFactory = EmployeePerformanceFactory.instance();
    private IInputEmployeeDetails inputEmployeeDetails;
    private IEmployeePerformanceDB employeedetailsDB;
    private IExportEmployeePerformanceReport employeePerformanceReport;
    private IBackToHomePageScreen backToHomePageScreen;
    private IInputOutputHandler inputOutputHandler = userInterfaceFactory.getInputOutputHandler();
    
    public EmployeePerformanceScreen(IInputOutputHandler inputOutputHandler)
    { 
        this.inputOutputHandler = inputOutputHandler;
    }
    
    public void displayTicketGenerationScreen(IParameterizedUser user) throws SQLException
    {
	   
	   	String date = null;
	    String employeeID = null;
	 	ArrayList <String> efficiencyReport = new ArrayList<String>();
	    inputOutputHandler.displayMethod("Enter employeeID:");
		employeeID = inputOutputHandler.input();
		Scanner sc = new Scanner(System.in);
		inputOutputHandler.displayMethod("Enter Date from which you want to see analysis report:");
		date = sc.nextLine();
			
		inputEmployeeDetails = employeePerformanceFactory.userInput(date, employeeID);
		
		employeedetailsDB = employeePerformanceFactory.employeedetailsDB(inputEmployeeDetails);
		
		try
		{
			efficiencyReport.add(employeedetailsDB.getticketCountsDB().toString());

			if(employeedetailsDB.getticketCountsDB()!=null) 
			{
			    inputOutputHandler.displayMethod("Successfully performed fetching of ticket count based on ticket level:");
			}
			else 
			{
			    inputOutputHandler.displayMethod("Ticket count fetching failed");
			}
		} 
		catch (ParseException e1) 
		{
			// TODO Auto-generated catch block
		    inputOutputHandler.displayMethod(e1.toString());
			e1.printStackTrace();
		}
		
		try {
			efficiencyReport.add(employeedetailsDB.getemployeeEfficiencyDB().toString());

			if(employeedetailsDB.getemployeeEfficiencyDB()!=null) 
			{
			    inputOutputHandler.displayMethod("Successfully performed data fetching for generating employee efficiency:");
			}
			else 
			{
			    inputOutputHandler.displayMethod("data fetching failed for calculating employee efficiency");
			}
		} 
		catch (ParseException e1) 
		{
			// TODO Auto-generated catch block
		    inputOutputHandler.displayMethod(e1.toString());
			e1.printStackTrace();
		}
		
		try 
		{
			efficiencyReport.add(employeedetailsDB.getemployeeProductivityDB().toString());

			if(employeedetailsDB.getemployeeProductivityDB() != null) 
			{
				
			    inputOutputHandler.displayMethod("Successfully performed data fetching for generating employee productivity:");
			}
			else 
			{
			    inputOutputHandler.displayMethod("data fetching failed for calculating employee productivity");
			}
		} 
		catch (ParseException e1) 
		{
			// TODO Auto-generated catch block
		    inputOutputHandler.displayMethod(e1.toString());
			e1.printStackTrace();
		}

		sc.close();
		employeePerformanceReport = userInterfaceFactory.getExportEmployeePerformanceReport(inputOutputHandler);
		employeePerformanceReport.exportTicket(efficiencyReport);
		
	    backToHomePageScreen = userInterfaceFactory.getBackToHomePageScreen(inputOutputHandler);
        backToHomePageScreen.displayGoBackToHomePageOption(user);
    }	
}