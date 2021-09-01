//Author : Vamsi Krishna Utla

package employeeMilestones;

import employeeMilestones.abstractfactory.*;
import employeeMilestones.interfaces.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EmployeeMilestoneFacade implements IEmployeeMilestone
{
    private final IEmployeeMilestoneFactory employeeMilestoneFactory = EmployeeMilestoneFactory.instance();
    private final IEmployeeTicketsDao persistenceEmployeeTickets;

    public EmployeeMilestoneFacade(IEmployeeTicketsDao persistenceEmployeeTickets)
    {
        this.persistenceEmployeeTickets = persistenceEmployeeTickets;
    }

    public Map<String, String> getEmployeeMilestone(String employeeID)
    {
        Map<String, String> result = new HashMap<>();
        Set<String> differentCustomersWorkedOn;
        String ticketType;
        String customersList = "";
        String rating;
        float averageResolutionTime;
        int totalTicketsWorkedOn;
        int highestAttentionTicketsWorkedOn;
        List<IParameterizedEmployeeTicket> employeeTicketList = persistenceEmployeeTickets.getEmployeeTickets(employeeID);
        ICalculateMilestone calculateMilestone = employeeMilestoneFactory.getCalculateMilestone(employeeTicketList);

        totalTicketsWorkedOn = calculateMilestone.getTotalTicketsWorkedOn();
        result.put("Total tickets worked on : ", Integer.toString(totalTicketsWorkedOn));

        highestAttentionTicketsWorkedOn = calculateMilestone.getHighestAttentionTicketsWorkedOn();
        result.put("Highest attention tickets worked on : ", Integer.toString(highestAttentionTicketsWorkedOn));

        differentCustomersWorkedOn = calculateMilestone.getDifferentCustomersWorkedOn();
        for(String customer : differentCustomersWorkedOn)
        {
            customersList = customersList.concat(customer + "\n");
        }
        result.put("Different customers worked with : \n", customersList);

        averageResolutionTime = calculateMilestone.calculateAverageResolutionTime();
        result.put("Average resolution time (in hours) : ", Float.toString(averageResolutionTime));

        rating = calculateMilestone.getOverallRating();
        result.put("Overall tickets rating : ", rating);

        ticketType = calculateMilestone.getModeTicketType();
        result.put("Most ticket types worked on : ", ticketType);

        return result;
    }
}
