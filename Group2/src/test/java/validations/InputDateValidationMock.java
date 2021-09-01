package validations;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Date;
import java.util.Locale;

public class InputDateValidationMock implements IInputDateValidation{
	
	public boolean isDurationValid (String startDate, String endDate) throws ParseException 
	{	
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	    Date firstDate = format.parse(startDate);
	    Date secondDate = format.parse(endDate);

	    long diffInMillies = secondDate.getTime() - firstDate.getTime();
	    System.out.print("Difference:" +diffInMillies);
		if(diffInMillies<0)
		{
			System.out.print("Wrong endDate found");
			return false;
		}
		return true;
	}
	
    @Override
    public boolean isDateFormatValid(String dateStr) throws ParseException {
    	DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("uuuu-MM-dd", Locale.US)
    		    .withResolverStyle(ResolverStyle.STRICT);

        try {
        	System.out.print("Here");
        	dateFormatter.parse(dateStr);
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }
}
