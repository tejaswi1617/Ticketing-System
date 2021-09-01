//Author : Vamsi Krishna Utla

package employeeMilestones;

import employeeMilestones.abstractfactory.*;
import employeeMilestones.interfaces.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class PersistenceEmployeeTicketsMock implements IEmployeeTicketsDao
{
    IEmployeeMilestoneFactory employeeMilestoneFactory = EmployeeMilestoneFactory.instance();

    public List<IParameterizedEmployeeTicket> getEmployeeTickets(String employeeID)
    {
        List<IParameterizedEmployeeTicket> employeeTicketList = new ArrayList<>();
        IParameterizedEmployeeTicket ticketOne = employeeMilestoneFactory.getParameterizedEmployeeTicket("ticket_001", employeeID, "CUST_DAL", Date.valueOf("2020-01-01"), Date.valueOf("2020-01-12"), 5, 1, 1, 1, "Bug");
        IParameterizedEmployeeTicket ticketTwo = employeeMilestoneFactory.getParameterizedEmployeeTicket("ticket_002", employeeID, "CUST_DAL", Date.valueOf("2020-02-01"), Date.valueOf("2020-02-04"), 2, 3, 3, 4, "User education");
        IParameterizedEmployeeTicket ticketThree = employeeMilestoneFactory.getParameterizedEmployeeTicket("ticket_003", employeeID, "CUST_Westin", Date.valueOf("2020-03-01"), Date.valueOf("2020-03-25"), 2, 2, 2, 2, "Bug");
        employeeTicketList.add(ticketOne);
        employeeTicketList.add(ticketTwo);
        employeeTicketList.add(ticketThree);

        return employeeTicketList;
    }
}
