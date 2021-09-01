package validations;

public interface IInputStringValidation {
		
	public boolean isStringNull(String validationString);
	public boolean isStringContainsSpecialCharacters(String validationString);
	public boolean isStringEmployeeAndReporterID (String validationString);
	public boolean isStringLengthValid (String validationString, int length);

}
