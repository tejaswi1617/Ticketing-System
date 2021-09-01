package insertTicket;

public class StringValidations {
	
	public static boolean isStringValid(String validationString) {
		
		if(validationString != null && validationString.trim().length() > 0) 
		{
			return true;
		} 
		return false;
	}

}
 