package validations;

import java.text.ParseException;

public interface IInputDateValidation 
{
		public boolean isDurationValid (String startDate, String endDate) throws ParseException;
		public boolean isDateFormatValid (String validationString) throws ParseException;
}
