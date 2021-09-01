//Author : Vamsi Krishna Utla

package employeeMilestones;
import employeeMilestones.interfaces.IParameterizedEmployeeTicket;
import java.sql.Date;

public class ParameterizedEmployeeTicket implements IParameterizedEmployeeTicket
{
    private final String ticketID;
    private final String employeeID;
    private final String ticketType;
    private final String customerID;
    private final Date startDate;
    private final Date endDate;
    private final int rating;
    private final int priority;
    private final int impact;
    private final int urgency;

    public ParameterizedEmployeeTicket(String ticketID, String employeeID, String customerID, Date startDate, Date endDate, int rating, int priority, int impact, int urgency, String ticketType)
    {
        this.ticketID = ticketID;
        this.employeeID = employeeID;
        this.customerID = customerID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.rating = rating;
        this.priority = priority;
        this.impact = impact;
        this.urgency = urgency;
        this.ticketType = ticketType;
    }

    public String getTicketID()
    {
        return ticketID;
    }

    public String getEmployeeID()
    {
        return  employeeID;
    }

    public String getCustomerID()
    {
        return customerID;
    }

    public Date getStartDate()
    {
        return startDate;
    }

    public Date getEndDate()
    {
        return endDate;
    }

    public int getRating()
    {
        return rating;
    }

    public int getPriority()
    {
        return priority;
    }

    public int getImpact()
    {
        return impact;
    }

    public int getUrgency()
    {
        return urgency;
    }

    public String getTicketType()
    {
        return ticketType;
    }
}
