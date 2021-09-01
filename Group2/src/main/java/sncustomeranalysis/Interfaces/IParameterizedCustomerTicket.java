//Author : Vamsi Krishna Utla

package sncustomeranalysis.Interfaces;

import java.sql.Date;

public interface IParameterizedCustomerTicket
{
    String getTicketID();
    String getCustomerID();
    Date getStartDate();
    Date getEndDate();
    String getTicketType();
    int getPriority();
    int getUrgency();
    int getImpact();
    String getTicketLevel();
    String getCreatorID();
    String getEmployeeID();
    int getRating();
}
