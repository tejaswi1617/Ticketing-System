//Author : Vamsi Krishna Utla

package sncustomeranalysis.Interfaces;

import java.util.Map;

public interface IComputeCustomerProperties
{
    float getMeanPriority();
    float getMeanUrgency();
    float getMeanImpact();
    String getModeTicketType();
    String getModeCreator();
    String getModeTicketLevel();
    float getAverageResolutionDays();
    Map<String, Integer> getCustomerTicketAssigneeStatistics();
    float getMeanRating();

}