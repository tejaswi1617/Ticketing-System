//Author : Vamsi Krishna Utla

package sncustomeranalysis;

import sncustomeranalysis.Interfaces.*;
import sncustomeranalysis.abstractfactory.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerAnalysisFacade implements ICustomerAnalysis
{
    private final ICustomerAnalysisFactory customerAnalysisFactory = CustomerAnalysisFactory.instance();
    private final ICustomerAnalysisDao persistenceCustomer;
    private List<IParameterizedCustomerTicket> tickets;
    private IComputeCustomerProperties computeCustomerProperties;

    public CustomerAnalysisFacade(ICustomerAnalysisDao persistenceCustomer)
    {
        this.persistenceCustomer = persistenceCustomer;
    }

    public Map<String, String> getCustomerAnalysis(String customerID)
    {
        Map<String, String> customerAnalysis = new HashMap<>();
        tickets = persistenceCustomer.getTicketsOfCustomer(customerID);
        computeCustomerProperties = customerAnalysisFactory.getComputeCustomerProperties(tickets);
        Map<String, Integer> assigneeStatistics;
        String[] ticketRating = {"Good", "Bad"};
        String modeTicketType;
        String modeCreatedBy;
        String modeTicketLevel;
        String assigneeStatisticsRecords = "";
        float averageResponseTime;
        float ratingThreshold = 3.5f;
        float priority;
        float impact;
        float urgency;

        if(tickets.size() == 0 || tickets == null)
        {
            return null;
        }

        priority = computeCustomerProperties.getMeanPriority();
        customerAnalysis.put("Average tickets priority : ", Float.toString(priority));

        urgency = computeCustomerProperties.getMeanUrgency();
        customerAnalysis.put("Average tickets urgency : ", Float.toString(urgency));

        impact = computeCustomerProperties.getMeanImpact();
        customerAnalysis.put("Average tickets impact : ", Float.toString(impact));

        modeTicketType = computeCustomerProperties.getModeTicketType();
        customerAnalysis.put("Most tickets of type : ", modeTicketType);

        modeCreatedBy = computeCustomerProperties.getModeCreator();
        customerAnalysis.put("Most tickets created by : ", modeCreatedBy);

        modeTicketLevel = computeCustomerProperties.getModeTicketLevel();
        customerAnalysis.put("Most tickets of level : ", modeTicketLevel);

        averageResponseTime = computeCustomerProperties.getAverageResolutionDays();
        customerAnalysis.put("Average response time (in days) : ", Float.toString(averageResponseTime));

        assigneeStatistics = computeCustomerProperties.getCustomerTicketAssigneeStatistics();
        if(assigneeStatistics.isEmpty())
        {
            customerAnalysis.put("Tickets assignee statistics : \n", "No assignee details found.\n");
        }
        else
        {
            for(Map.Entry<String, Integer> assigneeStats : assigneeStatistics.entrySet())
            {
                int value = assigneeStats.getValue();
                String valueString = Integer.toString(value);
                assigneeStatisticsRecords = assigneeStatisticsRecords.concat("\t"+assigneeStats.getKey()+" : "+valueString+"\n");
            }
            customerAnalysis.put("Tickets assignee statistics : ", assigneeStatisticsRecords);
        }

        if(computeCustomerProperties.getMeanRating() >= ratingThreshold)
        {
            customerAnalysis.put("Overall user rating : ", ticketRating[0]);
        }
        else
        {
            customerAnalysis.put("Overall user rating : ", ticketRating[1]);
        }

        return customerAnalysis;
    }
}
