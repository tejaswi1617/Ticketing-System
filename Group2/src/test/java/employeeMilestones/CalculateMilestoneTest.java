//Author : Vamsi Krishna Utla

package employeeMilestones;

import employeeMilestones.abstractfactory.*;
import employeeMilestones.interfaces.*;
import org.junit.Before;
import org.junit.Test;
import java.util.Set;
import static org.junit.Assert.*;

public class CalculateMilestoneTest
{
    ICalculateMilestone calculateMilestone;
    @Before public void initialize()
    {
        IEmployeeMilestoneFactory employeeMilestoneFactory = EmployeeMilestoneFactory.instance();
        IEmployeeMilestoneFactoryTest employeeMilestoneFactoryTest = EmployeeMilestoneFactoryTest.instance();
        IEmployeeTicketsDao persistenceEmployeeTickets = employeeMilestoneFactoryTest.getPersistenceEmployeeTicketsMock();
        calculateMilestone = employeeMilestoneFactory.getCalculateMilestone(persistenceEmployeeTickets.getEmployeeTickets("EMP_123"));
    }

    @Test
    public void getTotalTicketsWorkedOnTest()
    {
        assertEquals("Number of tickets test failed.", 3, calculateMilestone.getTotalTicketsWorkedOn());
    }

    @Test
    public void getDifferentCustomersWorkedOnTest()
    {
        Set<String> actual;
        actual = calculateMilestone.getDifferentCustomersWorkedOn();
        assertEquals("Number of customers failed.", 2, actual.size());
    }

    @Test
    public void getHighestAttentionTicketsWorkedOnTest()
    {
        assertEquals("Highest attention tickets worked on failed.", 1, calculateMilestone.getHighestAttentionTicketsWorkedOn());
    }

    @Test
    public void calculateAverageResolutionTimeTest()
    {
        assertEquals("Average resolution time failed.", 101.0, Math.round(calculateMilestone.calculateAverageResolutionTime()), 0.0);
    }

    @Test
    public void getOverallRatingTest()
    {
        calculateMilestone.getOverallRating();
        assertEquals("Overall rating failed.", "Good", calculateMilestone.getOverallRating());
    }

    @Test
    public void getModeTicketTypeTest()
    {
        calculateMilestone.getModeTicketType();
        assertEquals("Ticket type failed.", "Bug", calculateMilestone.getModeTicketType());
    }
}