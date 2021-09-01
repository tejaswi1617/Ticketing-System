//Author : Vamsi Krishna Utla

package employeeMilestones.interfaces;

import java.util.Set;

public interface ICalculateMilestone
{
    int getTotalTicketsWorkedOn();
    int getHighestAttentionTicketsWorkedOn();
    Set<String> getDifferentCustomersWorkedOn();
    float calculateAverageResolutionTime();
    String getOverallRating();
    String getModeTicketType();
}
