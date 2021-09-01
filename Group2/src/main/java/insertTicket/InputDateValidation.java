package insertTicket;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import insertTicket.Interfaces.IInputDateValidation;
import userinterface.IInputOutputHandler;

public class InputDateValidation implements IInputDateValidation
{
	
	IInputOutputHandler inputOutputHandler; 
	public InputDateValidation (IInputOutputHandler inputOutputHandler)
	{
		this.inputOutputHandler = inputOutputHandler;
	}
	public boolean isDurationValid (String startDate, String endDate) throws ParseException
	{		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
	    Date firstDate = format.parse(startDate);
	    Date secondDate = format.parse(endDate);

	    if(secondDate.before(firstDate)) 
	    {
			return false;
	    }
	    
		return true;
	}
 
	public boolean isDateFormatValid (String validationString) throws ParseException {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
		
		Date date = null;
		
		if(validationString.equals("") || validationString.equals(null)) 
		{	
			inputOutputHandler.displayMethod("Null value inserted");
			return true;
		}
		else 
		{
			date = format.parse(validationString);
		}
	    
		if (validationString.equals(format.format(date))) 
		{
			return true;
		}
		inputOutputHandler.displayMethod("Wrong date format for input string");

		return false;
	}
}
