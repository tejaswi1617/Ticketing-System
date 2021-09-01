package employeePerformance;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import employeePerformance.Interfaces.IExportEmployeePerformanceReport;
import employeePerformance.Interfaces.IGenerateEmployeePerformanceReport;
import userinterface.IInputOutputHandler;

public class ExportEmployeePerformanceReport implements IExportEmployeePerformanceReport 
{	
	private String FileName = null;
	private Scanner sc = new Scanner(System.in);
	private ArrayList<String> employeeDetailsString = new ArrayList<String>();
	IGenerateEmployeePerformanceReport generateEmployeePerformanceReport;
	IInputOutputHandler inputOutputHandler; 
	
	public ExportEmployeePerformanceReport(IInputOutputHandler inputOutputHandler, ArrayList<String> employeeEfficiency) 
	{
		this.employeeDetailsString = employeeEfficiency;
		this.inputOutputHandler = inputOutputHandler;
	}
	
	@Override
	public void exportTicket() 
	{
		inputOutputHandler.displayMethod("Enter file name with Path:");
		FileName=sc.next();
		File myObj = new File(FileName);
	    try 
	    {
			if (myObj.createNewFile()) 
			{
				  FileWriter myWriter = new FileWriter(FileName);
				  for(String employeedetails: employeeDetailsString) 
				  {
					  inputOutputHandler.displayMethod(employeedetails);
					  myWriter.write(employeedetails);
					  myWriter.write("\n");
     			  }		  
			      myWriter.close();
			}
		} 
	    catch (IOException e) 
	    {
	    	inputOutputHandler.displayMethod(e.toString());
			e.printStackTrace();
		} 
	}
}
