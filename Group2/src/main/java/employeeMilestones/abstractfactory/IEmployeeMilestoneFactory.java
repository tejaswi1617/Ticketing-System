//Author : Vamsi Krishna Utla

package employeeMilestones.abstractfactory;

import employeeMilestones.interfaces.*;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

public interface IEmployeeMilestoneFactory
{
    ICalculateMilestone getCalculateMilestone(List<IParameterizedEmployeeTicket> employeeTicketList);
    IEmployeeMilestone getEmployeeMilestone() throws IOException;
    IParameterizedEmployeeTicket getParameterizedEmployeeTicket(String ticketID, String employeeID, String customerID, Date startDate, Date endDate, int rating, int priority, int impact, int urgency, String ticketType);
    IEmployeeTicketsDao getPersistenceEmployeeTickets() throws IOException;
}
