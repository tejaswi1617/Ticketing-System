package userinterface;

import insertTicket.EnumValidation;
import login.Interfaces.IParameterizedUser;

public interface IGenerateTicketScreen 
{
    public void displayTicketGenerationScreen(IParameterizedUser user);
    public String displayGenerateTicketScreenController(int validInput, String inputType, EnumValidation validationString, IParameterizedUser user);
}
