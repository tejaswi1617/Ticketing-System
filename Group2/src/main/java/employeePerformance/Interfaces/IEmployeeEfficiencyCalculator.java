package employeePerformance.Interfaces;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.HashMap;

public interface IEmployeeEfficiencyCalculator 
{
	public HashMap<Integer,Integer> calculateEmployeeEfficiency() throws SQLException, ParseException;
}
