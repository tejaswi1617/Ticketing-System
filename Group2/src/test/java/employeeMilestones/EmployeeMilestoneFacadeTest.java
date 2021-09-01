//Author : Vamsi Krishna Utla

package employeeMilestones;

import employeeMilestones.abstractfactory.EmployeeMilestoneFactoryTest;
import employeeMilestones.abstractfactory.IEmployeeMilestoneFactoryTest;
import employeeMilestones.interfaces.IEmployeeMilestone;
import org.junit.Before;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.assertTrue;

public class EmployeeMilestoneFacadeTest
{
    IEmployeeMilestoneFactoryTest employeeMilestoneFactoryTest;

    @Before
    public void initialize()
    {
        employeeMilestoneFactoryTest = EmployeeMilestoneFactoryTest.instance();
    }

    @Test
    public void getEmployeeMilestoneTest()
    {
        int counter = 0;
        IEmployeeMilestone employeeMilestone = employeeMilestoneFactoryTest.getEmployeeMilestone();
        Map<String, String> expected = new HashMap<>();
        Map<String, String> actual = new HashMap<>();

        expected.put("Total tickets worked on : ", "3");
        expected.put("Highest attention tickets worked on : ", "1");
        expected.put("Different customers worked with : \n", "CUST_Westin\nCUST_DAL\n");
        expected.put("Average resolution time (in hours) : ", "101.333336");
        expected.put("Overall tickets rating : ", "Good");
        expected.put("Most ticket types worked on : ", "Bug");

        actual = employeeMilestone.getEmployeeMilestone("EMP_123");
        assertTrue("Employee milestone failed.", expected.equals(actual));
    }
}