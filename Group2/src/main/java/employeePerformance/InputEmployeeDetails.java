package employeePerformance;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import employeePerformance.Interfaces.IInputEmployeeDetails;

public class InputEmployeeDetails implements IInputEmployeeDetails
{
    private String employeeId = null;
    private String dateString = null;
    private Date date = null;
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
	
    public InputEmployeeDetails(String date, String employeeId)
    {
    	this.dateString = date;
    	this.employeeId = employeeId;
    }
    
    public String getEmployeeId() 
    { 
        return employeeId;
    }

    public String getDate()
    {
        return dateString;
    }
    
    public Date generateDateFormat() throws ParseException 
    {
    	dateString = formatter.format(formatter.parse(dateString));
    	date = (Date)formatter.parseObject(dateString);
        return date;
    }
}
