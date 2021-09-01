package insertTickets.abstractfactory;

import insertTicket.CreateTicket;
import insertTicket.InputDateValidation;
import insertTicket.InputRangeValidation;
import insertTicket.InputStringValidation;
import insertTicket.InsertTicket;
import insertTicket.TicketOperationsDB;
import insertTicket.UserInputValidation;
import insertTicket.Interfaces.ICreateTicket;
import insertTicket.Interfaces.IInputDateValidation;
import insertTicket.Interfaces.IInputRangeValidation;
import insertTicket.Interfaces.IInputStringValidation;
import insertTicket.Interfaces.IInsertTicket;
import insertTicket.Interfaces.ITicketOperationsDB;
import insertTicket.Interfaces.IUserInputValidation;
import insertTicket.abstractFactory.IInsertTicketFactory;
import insertTicket.abstractFactory.InsertTicketFactory;
import insertTickets.InsertTicketsDBMock;
import userinterface.IInputOutputHandler;

public class InsertTicketTestFactory implements IInsertTicketTestFactory
{
	private static IInsertTicketTestFactory uniqueInstance = null;

	private InsertTicketTestFactory()
    {
    	
    }

    public static IInsertTicketTestFactory instance()
    {
        if(null == uniqueInstance)
        {
            uniqueInstance = new InsertTicketTestFactory();
        }
        return uniqueInstance;
    }

    public IInputStringValidation ticketStringValidation(IInputOutputHandler inputOutputHandler)
    {
    	return new InputStringValidation(inputOutputHandler);
    }
    
    public 	IInputDateValidation dateValidation( IInputOutputHandler inputOutputHandler)
    {
    	return new InputDateValidation(  inputOutputHandler);
    }
    
    public 	IInputRangeValidation rangeValidation( IInputOutputHandler inputOutputHandler) 
    {
    	return new InputRangeValidation( inputOutputHandler);
    }    
    
    public 	ICreateTicket getcreateTicket(String ticketID, String description,  String expectedEndDate, String reporterID,
			String employeeID,  String assigneeName, String ticketType, String ticketStatus, int priority, int urgency, int impact,
			String ticketLevel, String customerID, String customerName, String creatorID, String creatorName, String attachmentID) {
    	return new CreateTicket(  ticketID,  description,   expectedEndDate,  reporterID,
				 employeeID,   assigneeName,  ticketType,  ticketStatus,  priority,  urgency,  impact,
				 ticketLevel,  customerID,  customerName,  creatorID, creatorName, attachmentID);
    }
    public IInsertTicket insertTicket(ICreateTicket createTicket) {
    	
    	return new InsertTicket(createTicket);
    }
    
    public ITicketOperationsDB insertTicketDB(ICreateTicket createTicket) 
    {
    	return new InsertTicketsDBMock(createTicket);
    }
    
    public IUserInputValidation userInputValidation() 
    {
    	return new UserInputValidation();
    }
    
}
