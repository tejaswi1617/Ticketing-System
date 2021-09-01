package employeePerformance.Interfaces;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.HashMap;

public interface IEmployeeProductivityCalculator 
{
	public HashMap<Integer,Integer> calculateEmployeeProductivity() throws SQLException, ParseException;
}
