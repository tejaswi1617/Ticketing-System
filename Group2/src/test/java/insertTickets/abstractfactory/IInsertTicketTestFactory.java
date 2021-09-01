package insertTickets.abstractfactory;

import insertTicket.Interfaces.ICreateTicket;
import insertTicket.Interfaces.IInputDateValidation;
import insertTicket.Interfaces.IInputRangeValidation;
import insertTicket.Interfaces.IInputStringValidation;
import insertTicket.Interfaces.IInsertTicket;
import insertTicket.Interfaces.ITicketOperationsDB;
import insertTicket.Interfaces.IUserInputValidation;
import userinterface.IInputOutputHandler;

public interface IInsertTicketTestFactory
{
	public IInputStringValidation ticketStringValidation(IInputOutputHandler inputOutputHandler);
	public 	IInputDateValidation dateValidation( IInputOutputHandler inputOutputHandler);
	public 	IInputRangeValidation rangeValidation( IInputOutputHandler inputOutputHandler);   
    public ITicketOperationsDB insertTicketDB(ICreateTicket createTicket);
    public 	ICreateTicket getcreateTicket(String ticketID, String description,  String expectedEndDate, String reporterID,
			String employeeID,  String assigneeName, String ticketType, String ticketStatus, int priority, int urgency, int impact,
			String ticketLevel, String customerID, String customerName, String creatorID, String creatorName, String attachmentID);
    public IInsertTicket insertTicket(ICreateTicket createTicket); 
    public IUserInputValidation userInputValidation();

}

