//Author : Vamsi Krishna Utla

package employeeMilestones.abstractfactory;

import employeeMilestones.*;
import employeeMilestones.interfaces.*;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

public class EmployeeMilestoneFactory implements IEmployeeMilestoneFactory {

    private static IEmployeeMilestoneFactory uniqueInstance = null;

    private EmployeeMilestoneFactory()
    {

    }

    public static IEmployeeMilestoneFactory instance()
    {
        if(null == uniqueInstance)
        {
            uniqueInstance = new EmployeeMilestoneFactory();
        }
        return uniqueInstance;
    }

    public ICalculateMilestone getCalculateMilestone(List<IParameterizedEmployeeTicket> employeeTicketList)
    {
        return new CalculateMilestone(employeeTicketList);
    }

    public IEmployeeMilestone getEmployeeMilestone() throws IOException
    {
        IEmployeeTicketsDao persistenceEmployeeTickets = getPersistenceEmployeeTickets();
        return new EmployeeMilestoneFacade(persistenceEmployeeTickets);
    }

    public IParameterizedEmployeeTicket getParameterizedEmployeeTicket(String ticketID, String employeeID, String customerID, Date startDate, Date endDate, int rating, int priority, int impact, int urgency, String ticketType)
    {
        return new ParameterizedEmployeeTicket(ticketID, employeeID, customerID, startDate, endDate, rating, priority, impact, urgency, ticketType);
    }

    public IEmployeeTicketsDao getPersistenceEmployeeTickets() throws IOException
    {
        return new EmployeeTicketsDao();
    }
}
