package validations;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InputDateValidation implements IInputDateValidation
{
	
	public boolean isDurationValid (String startDate, String endDate) throws ParseException {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	    Date firstDate = format.parse(startDate);
	    Date secondDate = format.parse(endDate);

	    long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
		System.out.print("diff" +diffInMillies);

		if(diffInMillies<0)
		{
			System.out.print("Wrong endDate found");
			return false;
		}

		return true;
	}
	public boolean isDateFormatValid (String validationString) throws ParseException {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;

		if(validationString.equals("") || validationString.equals(null)) 
		{
			System.out.print("Here");
			
			return true;
		}
		else {
			date = format.parse(validationString);
		}
	    if (validationString.equals(format.format(date))) {
			return true;
		}
		System.out.print("Wrong date format for input string");

		return false;
	}
}
