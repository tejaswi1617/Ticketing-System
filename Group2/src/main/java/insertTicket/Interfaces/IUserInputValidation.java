package insertTicket.Interfaces;

import java.text.ParseException;

import insertTicket.EnumValidation;

public interface IUserInputValidation {

	public boolean validation(String validationString, EnumValidation input) throws ParseException; 

}
