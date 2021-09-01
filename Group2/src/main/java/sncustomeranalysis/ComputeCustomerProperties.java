//Author : Vamsi Krishna Utla

package sncustomeranalysis;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import sncustomeranalysis.Interfaces.*;

public class ComputeCustomerProperties implements IComputeCustomerProperties
{
    private List<IParameterizedCustomerTicket> tickets;

    public ComputeCustomerProperties(List<IParameterizedCustomerTicket> tickets)
    {
        this.tickets = tickets;
    }

    public float getMeanPriority()
    {
        int total = 0;
        float meanPriority;

        for (IParameterizedCustomerTicket tempTicket : tickets)
        {
            total = total + tempTicket.getPriority();
        }

        meanPriority = (float)total/tickets.size();
        return meanPriority;
    }

    public float getMeanUrgency()
    {
        int total = 0;
        float meanUrgency;

        for (IParameterizedCustomerTicket tempTicket : tickets)
        {
            total = total + tempTicket.getUrgency();
        }

        meanUrgency = (float)total/tickets.size();
        return meanUrgency;
    }

    public float getMeanImpact()
    {
        int total = 0;
        float meanImpact = 0.0f;

        for (IParameterizedCustomerTicket tempTicket : tickets)
        {
            total = total + tempTicket.getImpact();
        }

        meanImpact = (float)total/tickets.size();
        return meanImpact;
    }

    public String getModeTicketType()
    {
        Map<String,Integer> ticketTypeCounter = new HashMap<>();

        for (IParameterizedCustomerTicket tempTicket : tickets)
        {
            if (ticketTypeCounter.containsKey(tempTicket.getTicketType())) {
                int incrementer = ticketTypeCounter.get(tempTicket.getTicketType());
                ticketTypeCounter.put(tempTicket.getTicketType(), incrementer + 1);
            }
            else
            {
                ticketTypeCounter.put(tempTicket.getTicketType(), 1);
            }
        }

        return calculateModeTicket(ticketTypeCounter);
    }

    public String getModeCreator()
    {
        Map<String,Integer> ticketCreatorCounter = new HashMap<>();

        for (IParameterizedCustomerTicket tempTicket : tickets)
        {
            if (ticketCreatorCounter.containsKey(tempTicket.getCreatorID())) {
                int incrementer = ticketCreatorCounter.get(tempTicket.getCreatorID());
                ticketCreatorCounter.put(tempTicket.getCreatorID(), incrementer + 1);
            }
            else
            {
                ticketCreatorCounter.put(tempTicket.getCreatorID(), 1);
            }
        }

        return calculateModeTicket(ticketCreatorCounter);
    }

    public String getModeTicketLevel()
    {
        Map<String,Integer> ticketLevelCounter = new HashMap<>();

        for (IParameterizedCustomerTicket tempTicket : tickets)
        {
            if (ticketLevelCounter.containsKey(tempTicket.getTicketLevel())) {
                int incrementer = ticketLevelCounter.get(tempTicket.getTicketLevel());
                ticketLevelCounter.put(tempTicket.getTicketLevel(), incrementer + 1);
            }
            else
            {
                ticketLevelCounter.put(tempTicket.getTicketLevel(), 1);
            }
        }

        return calculateModeTicket(ticketLevelCounter);
    }

    public float getAverageResolutionDays()
    {
        float divisor = 0.0f;
        float dividend = 0.0f;
        float averageResolutionDays = 0.0f;
        Date startDate;
        Date endDate;
        long differenceInSeconds;
        float differenceInDays;
        float toSeconds = 1000.0f;
        float toMinutes = 60.0f;
        float toHours = 60.0f;
        float toDays = 24.0f;

        for(IParameterizedCustomerTicket tempTicket : tickets)
        {
            divisor++;
            startDate = tempTicket.getStartDate();
            endDate = tempTicket.getEndDate();
            if(endDate == null)
            {
                endDate = new java.sql.Date(System.currentTimeMillis());
            }
            differenceInSeconds = endDate.getTime() - startDate.getTime();
            differenceInDays = differenceInSeconds/(toSeconds * toMinutes * toHours * toDays);
            dividend = dividend + differenceInDays;
        }

        averageResolutionDays = dividend/divisor;
        return averageResolutionDays;
    }

    public Map<String, Integer> getCustomerTicketAssigneeStatistics()
    {
        Map<String,Integer> customerTicketAssigneeStatistics = new HashMap<>();

        for (IParameterizedCustomerTicket tempTicket : tickets)
        {
            if (customerTicketAssigneeStatistics.containsKey(tempTicket.getEmployeeID()))
            {
                int incrementer = customerTicketAssigneeStatistics.get(tempTicket.getEmployeeID());
                customerTicketAssigneeStatistics.put(tempTicket.getEmployeeID(), incrementer + 1);
            }
            else
            {
                customerTicketAssigneeStatistics.put(tempTicket.getEmployeeID(), 1);
            }
        }
        return customerTicketAssigneeStatistics;
    }

    public float getMeanRating()
    {
        int total = 0;
        float averageRating;

        for (IParameterizedCustomerTicket tempTicket : tickets)
        {
            total = total + tempTicket.getRating();
        }

        averageRating = (float)total/tickets.size();
        return averageRating;
    }

    private String calculateModeTicket(Map<String, Integer> ticketTypeCounter)
    {
        int maximum = 0;
        String mode = "";

        for(Map.Entry<String,Integer> individualTicketType : ticketTypeCounter.entrySet())
        {
            if(individualTicketType.getValue() > maximum)
            {
                maximum = individualTicketType.getValue();
                mode = individualTicketType.getKey();
            }
            else if(individualTicketType.getValue() == maximum)
            {
                mode = mode.concat(", "+individualTicketType.getKey());
            }
        }
        return mode;
    }
}