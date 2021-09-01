package insertTicket.Interfaces;

public interface IInputStringValidation 
{		
	public boolean isStringNull(String validationString);
	public boolean isStringContainsSpecialCharacters(String validationString);
	public boolean isStringEmployeeAndReporterID (String validationString);
}
