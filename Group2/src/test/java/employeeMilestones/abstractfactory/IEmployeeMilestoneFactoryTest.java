//Author : Vamsi Krishna Utla

package employeeMilestones.abstractfactory;

import employeeMilestones.interfaces.IEmployeeMilestone;
import employeeMilestones.interfaces.IEmployeeTicketsDao;

public interface IEmployeeMilestoneFactoryTest
{
    IEmployeeTicketsDao getPersistenceEmployeeTicketsMock();
    IEmployeeMilestone getEmployeeMilestone();
}
