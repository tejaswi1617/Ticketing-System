package insertTicket;

import insertTicket.Interfaces.IInputStringValidation;
import userinterface.IInputOutputHandler;

public class InputStringValidation implements IInputStringValidation
{
	IInputOutputHandler inputOutputHandler;

	protected static String validationString = null;
	protected static int length = 0;
	
	public InputStringValidation(IInputOutputHandler inputOutputHandler) 
	{
		this.inputOutputHandler = inputOutputHandler;
	}

	public boolean isStringNull(String validationString) 
	{
		
		if(validationString == null || validationString.equals(" ")) 
		{
			inputOutputHandler.displayMethod("Null value found for input string");
			return true;
		}
		 
		return false;
	}
	
	public boolean isStringContainsSpecialCharacters (String validationString) 
	{
		
		if(validationString.contains("@") || validationString.contains("#") || validationString.contains("!") ||  validationString.contains("_") ||  validationString.contains("%") || validationString.contains("&"))
		{
			inputOutputHandler.displayMethod("SpecialCharacters found for input string");
			return true;
		}
		
		return false;
	}

	public boolean isStringEmployeeAndReporterID (String validationString) 
	{
		String prefix = "EMP";
		if(validationString.equals(null) || validationString.equals(" ") || validationString.equals("")) 
		{
			return true;
		}
		if(validationString.substring(0, 3).equalsIgnoreCase(prefix) ) {
			if(validationString.substring(3, validationString.length()).matches("[0-9]+"))
			{
				return true;
			}
		}
		
		inputOutputHandler.displayMethod("\nPrefix should be 'EMP' for input string");
		return false;
	}
}
