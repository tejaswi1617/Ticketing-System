package userinterface;
import login.Interfaces.*;
import mailservice.ReadPropertiesFile;
import userinterface.abstractFactory.*;
import java.io.IOException;
import java.text.ParseException;
import java.util.Properties;
import java.util.Scanner;

import attachment.abstractfactory.AttachmentFactory;
import attachment.abstractfactory.IAttachmentFactory;
import attachment.interfaces.IAttachment;
import insertTicket.EnumValidation;
import insertTicket.Interfaces.ICreateTicket;
import insertTicket.Interfaces.IInsertTicket;
import insertTicket.abstractFactory.IInsertTicketFactory;
import insertTicket.abstractFactory.InsertTicketFactory;

public class GenerateTicketScreen implements IGenerateTicketScreen
{
    private final IInputOutputHandler inputOutputHandler;
    private final IUserInterfaceFactory userInterfaceFactory;
    private IBackToHomePageScreen backToHomePageScreen;
    private IInsertTicketFactory insertTicketFactory = InsertTicketFactory.instance();
	private IInsertTicket insertTicket;
    private ICreateTicket createTicket;
     
    private IAttachmentFactory attachmentfactory= AttachmentFactory.instance();

    private IAttachment attachment;
    public GenerateTicketScreen(IInputOutputHandler inputOutputHandler)
    {
        this.inputOutputHandler = inputOutputHandler;
        this.userInterfaceFactory = UserInterfaceFactory.instance();
    }
    
    public void displayTicketGenerationScreen(IParameterizedUser user)
    {
		String ticketID = null;
	    String description = null;
	    String expectedEndDate = null;
	    String reporterID = null;
	    String employeeID = null;
	    String assigneeName = null;
	    String ticketType = null;    
	    String ticketStatus = null;		    
	    int priority = 0;
	    int urgency = 0;
	    int impact = 0;
	    String ticketLevel = null;		    
	    String customerID = null;
	    String customerName = null;
	    String creatorID = null;
	    String creatorName = null;
	    String attachmentID = null;
		String projectConfigurationFile = "ProjectConfiguration.properties";

	   	int validInput = -1;	 
	   	    
		
	   	ticketID = displayGenerateTicketScreenController(validInput,"ticketID",EnumValidation.VALIDATETICKETID,user);
	   	description = displayGenerateTicketScreenController(validInput,"description",EnumValidation.VALIDATEDESCRIPTION,user);
	   	expectedEndDate = displayGenerateTicketScreenController(validInput,"expectedEndDate",EnumValidation.VALIDATEEXPECTEDENDDATE,user);
	   	reporterID = displayGenerateTicketScreenController(validInput,"reporterID",EnumValidation.VALIDATEREPORTERID,user);
	   	employeeID = displayGenerateTicketScreenController(validInput,"employeeID",EnumValidation.VALIDATEEMPLOYEEID,user);
	   	assigneeName = displayGenerateTicketScreenController(validInput,"assigneeName",EnumValidation.VALIDATEASSIGNEENAME,user);
	   	ticketType = displayGenerateTicketScreenController(validInput,"ticketType",EnumValidation.VALIDATETICKETTYPE,user);
	   	ticketStatus = displayGenerateTicketScreenController(validInput,"ticketStatus",EnumValidation.VALIDATETICKETSTATUS,user);
	   	priority = Integer.parseInt(displayGenerateTicketScreenController(validInput,"priority",EnumValidation.VALIDATEPRIORITY,user));
	   	urgency = Integer.parseInt(displayGenerateTicketScreenController(validInput,"urgency",EnumValidation.VALIDATEURGENCY,user));
	   	impact = Integer.parseInt(displayGenerateTicketScreenController(validInput,"impact",EnumValidation.VALIDATEIMPACT,user));
	   	ticketLevel = displayGenerateTicketScreenController(validInput,"ticketLevel",EnumValidation.VALIDATETICKETLEVEL,user);
	   	customerID = displayGenerateTicketScreenController(validInput,"customerID",EnumValidation.VALIDATECUSTOMERID,user);
	   	customerName = displayGenerateTicketScreenController(validInput,"customerName",EnumValidation.VALIDATECUSTOMERNAME,user);
	   	creatorID = displayGenerateTicketScreenController(validInput,"creatorID",EnumValidation.VALIDATECREATORID,user);
	   	creatorName = displayGenerateTicketScreenController(validInput,"creatorName",EnumValidation.VALIDATECREATORNAME,user);
	   	
		String attchmentType = "ATTACHMENT_TYPE";

		Properties properties;
		String attachmentFileName = null;
		try {
			properties = ReadPropertiesFile.readConfigPropertyFile(projectConfigurationFile);
			attachmentFileName = (String) properties.get(attchmentType);
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
	     Scanner scanner = new Scanner(System.in);  // Create a Scanner object

	   	inputOutputHandler.displayMethod("Enter Attachment Path");
	   	attachmentID = scanner.nextLine();
	   	try {
			attachment = attachmentfactory.makeAttachmentObject(attachmentFileName);
			try {
				attachmentID = attachment.upload(attachmentID);
				System.out.print(attachmentID);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    

	    createTicket = insertTicketFactory.getcreateTicket(ticketID, description, expectedEndDate, reporterID,
	    		employeeID, assigneeName, ticketType, ticketStatus,priority, urgency, impact, ticketLevel, customerID, 
	    		customerName, creatorID, creatorName,attachmentID);
	   
        inputOutputHandler.displayMethod("\n");
	   	

	    insertTicket = insertTicketFactory.insertTicket(createTicket);
	    try 
	    {
			if(insertTicket.successfulInsertion()==true) 
			{
	            inputOutputHandler.displayMethod("Ticket generation successful.");
			}
			else 
			{
	            inputOutputHandler.displayMethod("Ticket generation failed");
			}
		}
	    catch (ParseException e) 
	    {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}      
	    scanner.close();
	    backToHomePageScreen = userInterfaceFactory.getBackToHomePageScreen(inputOutputHandler);
        backToHomePageScreen.displayGoBackToHomePageOption(user);
        
    }
    
    public String displayGenerateTicketScreenController(int validInput, String inputType, EnumValidation validationString, IParameterizedUser user)
    {
    	String inputString = null;
    	String inputMessage = null;
    	String errorMessage = null;
        inputMessage = "Enter " + inputType + ":\n";
        errorMessage = "Please enter valid " + inputType;
               
    	while(validInput != 0) 
    	{
    		if(inputType!="expectedEndDate") 
    		{
    			 inputOutputHandler.displayMethod(inputMessage);
    	    	 inputString = inputOutputHandler.input();
    		}
    		else 
    		{
    		     Scanner scanner = new Scanner(System.in);  // Create a Scanner object
    			 inputOutputHandler.displayMethod(inputMessage);
    	    	 inputString = scanner.nextLine();
    		}
    	   
    	    
		    try {
				if(insertTicketFactory.validation().validation(inputString,validationString) == false) 
				{
				    inputOutputHandler.displayMethod(errorMessage);
					validInput = 1;
				}
				else 
				{
					validInput = 0;
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    if(validInput == 1) 
		    {
	    	    inputOutputHandler.displayMethod("Exit? (Yes/No)");
	    	    inputString = inputOutputHandler.input();
	    	    if(inputString == "Yes") 
	    	    {
	    	    	backToHomePageScreen = userInterfaceFactory.getBackToHomePageScreen(inputOutputHandler);
	    	        backToHomePageScreen.displayGoBackToHomePageOption(user);
	    	    }
	    	    else 
	    	    {
	    	    	validInput = 0;
	    	    }
		    }
    	}
    	return inputString;
    }

	
}