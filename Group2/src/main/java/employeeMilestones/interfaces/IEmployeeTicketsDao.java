//Author : Vamsi Krishna Utla

package employeeMilestones.interfaces;

import java.util.List;

public interface IEmployeeTicketsDao
{
    List<IParameterizedEmployeeTicket> getEmployeeTickets(String employeeID);
}
