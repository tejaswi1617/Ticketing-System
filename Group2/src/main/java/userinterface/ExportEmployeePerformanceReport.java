package userinterface;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import employeePerformance.Interfaces.IGenerateEmployeePerformanceReport;

public class ExportEmployeePerformanceReport implements IExportEmployeePerformanceReport 
{	
	private String FileName = null;
	private Scanner sc = new Scanner(System.in);
	IGenerateEmployeePerformanceReport generateEmployeePerformanceReport;
	IInputOutputHandler inputOutputHandler;
	
	public ExportEmployeePerformanceReport(IInputOutputHandler inputOutputHandler) {
		this.inputOutputHandler = inputOutputHandler;
	}
	
	@Override
	public void exportTicket(ArrayList<String> employeeEfficiency) 
	{
		inputOutputHandler.displayMethod("Enter file name with Path:");
		FileName=sc.next();
	    
		File myObj = new File(FileName);
	    try 
	    {
			if (myObj.createNewFile()) 
			{
				  FileWriter myWriter = new FileWriter(FileName);
				  for(String employeedetails: employeeEfficiency) 
				  { 
					  myWriter.write(employeedetails);
					  myWriter.write("\n");
					  inputOutputHandler.displayMethod("Successfully Created");
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
