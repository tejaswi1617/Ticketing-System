package employeePerformance.abstractFactory;

import java.sql.ResultSet;
import employeePerformance.Interfaces.IEmployeeEfficiencyCalculator;
import employeePerformance.Interfaces.IEmployeePerformanceDB;
import employeePerformance.Interfaces.IEmployeeProductivityCalculator;
import employeePerformance.Interfaces.IGenerateEmployeePerformanceReport;
import employeePerformance.Interfaces.IInputEmployeeDetails;

public interface IEmployeePerformanceFactory 
{
	public IInputEmployeeDetails userInput(String date, String employeeId);
	public IGenerateEmployeePerformanceReport getPerformanceReport (); 
	public IEmployeePerformanceDB employeedetailsDB ( IInputEmployeeDetails inputEmployeeDetails);
	public IEmployeeEfficiencyCalculator getEmployeeEfficiencyCalculator(ResultSet resultset);
	public IEmployeeProductivityCalculator getEmployeeProductivityCalculator(ResultSet resultset);
}
