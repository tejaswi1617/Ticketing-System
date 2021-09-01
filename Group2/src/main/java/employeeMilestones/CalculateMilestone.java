//Author : Vamsi Krishna Utla

package employeeMilestones;

import employeeMilestones.interfaces.*;
import java.sql.Date;
import java.util.*;

public class CalculateMilestone implements ICalculateMilestone
{
    private final List<IParameterizedEmployeeTicket> employeeTicketList;

    public CalculateMilestone(List<IParameterizedEmployeeTicket> employeeTicketList)
    {
        this.employeeTicketList = employeeTicketList;
    }

    public int getTotalTicketsWorkedOn()
    {
        if(employeeTicketList == null)
        {
            return -1;
        }
        else
        {
            return employeeTicketList.size();
        }
    }

    public int getHighestAttentionTicketsWorkedOn()
    {
        int priority;
        int impact;
        int urgency;
        float average;
        int divisor = 3;
        float minimumThreshold = 1.5f;
        int counter = 0;
        for(IParameterizedEmployeeTicket employeeTicket: employeeTicketList)
        {
            priority = employeeTicket.getPriority();
            impact = employeeTicket. getImpact();
            urgency = employeeTicket.getUrgency();

            average = (float)(priority + impact + urgency)/divisor;

            if(average <= minimumThreshold)
            {
                counter = counter + 1;
            }
        }

        return counter;
    }

    public Set<String> getDifferentCustomersWorkedOn()
    {
        Set<String> customers = new HashSet<>();

        for(IParameterizedEmployeeTicket employeeTicket: employeeTicketList)
        {
            String customerID = employeeTicket.getCustomerID();
            customers.add(customerID);
        }

        return customers;
    }

    public float calculateAverageResolutionTime()
    {
        float divisor = 0.0f;
        float dividend = 0.0f;
        float averageResolutionTime = 0.0f;
        Date startDate;
        Date endDate;
        long differenceInSeconds;
        float differenceInTime;
        float toSeconds = 1000.0f;
        float toMinutes = 60.0f;
        float toHours = 60.0f;
        int hoursNotIncludedInWorkOnADay = 16;
        int hoursInADay = 24;
        float remainingHours;

        for(IParameterizedEmployeeTicket tempTicket : employeeTicketList)
        {
            divisor++;
            startDate = tempTicket.getStartDate();
            endDate = tempTicket.getEndDate();
            if(endDate == null)
            {
                endDate = new java.sql.Date(System.currentTimeMillis());
            }
            differenceInSeconds = endDate.getTime() - startDate.getTime();
            differenceInTime = differenceInSeconds/(toSeconds * toMinutes * toHours);
            remainingHours = Math.round(hoursNotIncludedInWorkOnADay*(differenceInTime/hoursInADay));
            differenceInTime = differenceInTime - remainingHours;
            dividend = dividend + differenceInTime;
        }

        averageResolutionTime = dividend/divisor;
        return averageResolutionTime;
    }

    public String getOverallRating()
    {
        int total = 0;
        float averageRating;

        for (IParameterizedEmployeeTicket tempTicket : employeeTicketList)
        {
            total = total + tempTicket.getRating();
        }

        averageRating = (float)total/employeeTicketList.size();

        if(averageRating >= 4.0f)
        {
            return "Excellent";
        }
        else if(averageRating >=2.5f)
        {
            return "Good";
        }
        else
        {
            return "Bad";
        }
    }

    public String getModeTicketType()
    {
        Map<String,Integer> ticketTypeCounter = new HashMap<>();
        int maximum = 0;
        String result = "";

        for(IParameterizedEmployeeTicket employeeTicket : employeeTicketList)
        {
            String keyTicketType = employeeTicket.getTicketType();
            if(ticketTypeCounter.containsKey(keyTicketType))
            {
                int existingValue = ticketTypeCounter.get(keyTicketType);
                ticketTypeCounter.put(keyTicketType, existingValue+1);
            }
            else
            {
                ticketTypeCounter.put(keyTicketType, 1);
            }
        }

        for(Map.Entry<String, Integer> ticketTypeItem : ticketTypeCounter.entrySet())
        {
            if(ticketTypeItem.getValue() > maximum)
            {
                maximum = ticketTypeItem.getValue();
                result = ticketTypeItem.getKey();
            }
            else if(ticketTypeItem.getValue() == maximum)
            {
                result = result.concat(", "+ticketTypeItem.getKey());
            }
        }

        return result;
    }
}
