//Author : Vamsi Krishna Utla

package employeeMilestones.interfaces;

import java.sql.Date;

public interface IParameterizedEmployeeTicket
{
    String getTicketID();
    String getEmployeeID();
    String getCustomerID();
    Date getStartDate();
    Date getEndDate();
    int getRating();
    int getPriority();
    int getImpact();
    int getUrgency();
    String getTicketType();
}
