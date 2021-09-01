package insertTicket;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import insertTicket.Interfaces.ICreateTicket;
 
public class CreateTicket implements ICreateTicket
{ 
	private String ticketID = null;
    private String description = null;
    private Date startDate = null;
    private String endDate = null;
    private String reporterID = null;
    private String employeeID = null;
    private String assigneeName = null;
    private String ticketType = null;
    private String ticketStatus = null;
    private int priority = 0;
    private int urgency = 0;
    private int impact = 0;
    private String ticketLevel = null;
    private String customerID = null;
    private String customerName = null;
    private String creatorID = null;
    private String creatorName = null;
	private String expectedEndDateString;
	private Date expectedEndDate;
	private String attachmentId = null;
	
	public CreateTicket(String ticketID, String description,  String expectedEndDate, String reporterID,
			String employeeID,  String assigneeName, String ticketType, String ticketStatus, int priority, int urgency, int impact,
			String ticketLevel, String customerID, String customerName, String creatorID, String creatorName, String attachmentId)
	{
		this.ticketID = ticketID;
	    this.description = description;
	    this.expectedEndDateString = expectedEndDate;
	    this.reporterID = reporterID;
	    this.employeeID = employeeID;
	    this.assigneeName = assigneeName;
	    this.ticketType = ticketType;
	    this.ticketStatus = ticketStatus;
	    this.priority = priority;
	    this.urgency = urgency;
	    this.impact = impact;
	    this.ticketLevel = ticketLevel;
	    this.customerID = customerID;
	    this.customerName = customerName;
	    this.creatorID = creatorID;
	    this.creatorName = creatorName;  
	}
	   
    public String getTicketID() 
    {
        return ticketID;
    }
    
    public String getDescription()
    {
        return description;
    }
    
    public Date generateStartDate() throws ParseException 
    {
    	startDate = new java.util.Date();
        return startDate;
    }
    
    public Date getExpectedEndDate() throws ParseException 
    {
    	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
    	expectedEndDateString =formatter.format(formatter.parse(expectedEndDateString));
    	expectedEndDate = (Date)formatter.parseObject(expectedEndDateString);
    	
    	return expectedEndDate;
    }
    
    public String getEndDate() 
    {
        return endDate;
    }
    
    public String getReporterID() 
    {
        return reporterID;
    }

    public String getEmployeeID() 
    {
        return employeeID;
    }

    public String getAssigneeName() 
    {
        return assigneeName;
    }
    
    public String getTicketType()
    {
        return ticketType;
    }
    
    public String getTicketStatus()
    {
        return ticketStatus;
    }
    
    public int getPriority() 
    {
    	return priority;
    }

    public int getUrgency() 
    {
    	return urgency;
    }
    
    public int getImpact() 
    {
    	return impact;
    }
    
    public String getTicketLevel() 
    {
    	return ticketLevel;
    }
  
    public String getCustomerID() 
    { 
    	return customerID;
    }
  
    public String getCustomerName() 
    {
    	return customerName;
    }
    
    public String getCreatorID() 
    {
    	return creatorID;
    }
    
    public String getCreatorName() 
    {
    	return creatorName;
    }
    
    public String getAttachmentID() 
    {
    	return attachmentId;
    }

	
}