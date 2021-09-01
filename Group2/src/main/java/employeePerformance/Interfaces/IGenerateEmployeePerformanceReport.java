package employeePerformance.Interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;

public interface IGenerateEmployeePerformanceReport 
{
	public ArrayList<String> displayEmployeeDetailsAndTicketCount( IInputEmployeeDetails employeeDetails, ResultSet resultset) throws SQLException, ParseException;
	public ArrayList<String> displayEmployeeEfficiency(HashMap <Integer, Integer> calculatedEmployeeEfficiency); 
	public ArrayList<String> displayEmployeeProductivity(HashMap <Integer, Integer> calculatedEmployeeProductivity);
}
