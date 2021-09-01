//Author : Vamsi Krishna Utla

package sncustomeranalysis;

import java.sql.Date;
import sncustomeranalysis.Interfaces.*;

public class ParameterizedCustomerTicket implements IParameterizedCustomerTicket
{
    private final String ticketID;
    private final String customerID;
    private final Date startDate;
    private final Date endDate;
    private final String ticketType;
    private final int priority;
    private final int urgency;
    private final int impact;
    private final String ticketLevel;
    private final String creatorID;
    private final String employeeID;
    private final int rating;

    public ParameterizedCustomerTicket(String ticketID, String customerID, Date startDate, Date endDate, String ticketType, int priority, int urgency, int impact, String ticketLevel, String creatorID, String employeeID, int rating)
    {
        this.ticketID = ticketID;
        this.customerID = customerID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.ticketType = ticketType;
        this.priority = priority;
        this.urgency = urgency;
        this.impact = impact;
        this.ticketLevel = ticketLevel;
        this.creatorID = creatorID;
        this.employeeID = employeeID;
        this.rating = rating;
    }

    public String getTicketID()
    {
        return ticketID;
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

    public String getTicketType()
    {
        return ticketType;
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

    public String getCreatorID()
    {
        return creatorID;
    }

    public String getEmployeeID()
    {
        return employeeID;
    }

    public int getRating()
    {
        return rating;
    }
}
