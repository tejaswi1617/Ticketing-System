package employeePerformance.Interfaces;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

public interface IEmployeePerformanceDB 
{
	public ArrayList<String> getticketCountsDB() throws ParseException, SQLException;
	public ArrayList<String> getemployeeEfficiencyDB() throws ParseException, SQLException;
	public ArrayList<String> getemployeeProductivityDB() throws ParseException, SQLException;
}
