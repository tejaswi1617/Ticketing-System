package employeePerformance.Interfaces;

import java.text.ParseException;
import java.util.Date;

public interface IInputEmployeeDetails 
{
	public String getEmployeeId();
    public Date generateDateFormat() throws ParseException;
    public String getDate() throws ParseException;
}
