//Author : Vamsi Krishna Utla

package sncustomeranalysis;

import sncustomeranalysis.Interfaces.ICustomerAnalysis;
import sncustomeranalysis.abstractfactory.CustomerAnalysisFactoryTest;
import sncustomeranalysis.abstractfactory.ICustomerAnalysisFactoryTest;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.*;

public class CustomerAnalysisFacadeTest
{
    @Test
    public void getCustomerAnalysisTest()
    {
        ICustomerAnalysisFactoryTest customerAnalysisFactoryTest = CustomerAnalysisFactoryTest.instance();
        ICustomerAnalysis customerAnalysis = customerAnalysisFactoryTest.getCustomerAnalysis();
        Map<String, String> actual = new HashMap<>();
        Map<String, String> expected = new HashMap<>();

        expected.put("Average tickets priority : ", "2.0");
        expected.put("Average tickets urgency : ", "2.0");
        expected.put("Average tickets impact : ", "2.3333333");
        expected.put("Most tickets of type : ", "Bug");
        expected.put("Most tickets created by : ", "USER_123");
        expected.put("Most tickets of level : ", "Easy, Moderate, Hard");
        expected.put("Average response time (in days) : ", "10.666667");
        expected.put("Tickets assignee statistics : ", "\tEMP_124 : 1\n\tEMP_125 : 1\n\tEMP_123 : 1\n");
        expected.put("Overall user rating : ", "Bad");

        actual = customerAnalysis.getCustomerAnalysis("CUST_DAL");
        System.out.print(actual);
        System.out.println(expected);
        assertTrue("Customer analysis test failed.", expected.equals(actual));
    }
}