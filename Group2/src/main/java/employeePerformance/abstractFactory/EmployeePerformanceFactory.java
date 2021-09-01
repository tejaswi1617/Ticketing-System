package employeePerformance.abstractFactory;

import java.sql.ResultSet;
import employeePerformance.EmployeeEfficiencyCalculator;
import employeePerformance.EmployeePerformanceDB;
import employeePerformance.EmployeeProductivityCalculator;
import employeePerformance.GenerateEmployeePerformanceReport;
import employeePerformance.InputEmployeeDetails;
import employeePerformance.Interfaces.IEmployeeEfficiencyCalculator;
import employeePerformance.Interfaces.IEmployeePerformanceDB;
import employeePerformance.Interfaces.IEmployeeProductivityCalculator;
import employeePerformance.Interfaces.IGenerateEmployeePerformanceReport;
import employeePerformance.Interfaces.IInputEmployeeDetails;

public class EmployeePerformanceFactory implements IEmployeePerformanceFactory
{ 
	private static IEmployeePerformanceFactory uniqueInstance = null;

    private EmployeePerformanceFactory()
    {
    	
    }
 
    public static IEmployeePerformanceFactory instance()
    {
        if(null == uniqueInstance)
        {
            uniqueInstance = new EmployeePerformanceFactory();
        }
        return uniqueInstance;
    }
    
	public IInputEmployeeDetails userInput(String date, String employeeId) 
	{
		return new InputEmployeeDetails(date, employeeId);
	}
	
	public IEmployeePerformanceDB employeedetailsDB ( IInputEmployeeDetails inputEmployeeDetails) 
	{	
		return new EmployeePerformanceDB(inputEmployeeDetails);
	}

	public IGenerateEmployeePerformanceReport getPerformanceReport () 
	{	
		return new GenerateEmployeePerformanceReport();
	}
	
	public IEmployeeEfficiencyCalculator getEmployeeEfficiencyCalculator(ResultSet resultset) 
	{
		return new EmployeeEfficiencyCalculator(resultset);
	}
	
	public IEmployeeProductivityCalculator getEmployeeProductivityCalculator(ResultSet resultset)
	{
		return new EmployeeProductivityCalculator(resultset);
	}
}
