//Author : Vamsi Krishna Utla

package sncustomeranalysis.abstractfactory;

import sncustomeranalysis.*;
import sncustomeranalysis.Interfaces.*;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

public class CustomerAnalysisFactory implements ICustomerAnalysisFactory
{
    private static ICustomerAnalysisFactory uniqueInstance = null;

    private CustomerAnalysisFactory()
    {

    }

    public static ICustomerAnalysisFactory instance()
    {
        if(null == uniqueInstance)
        {
            uniqueInstance = new CustomerAnalysisFactory();
        }
        return uniqueInstance;
    }

    public IComputeCustomerProperties getComputeCustomerProperties(List<IParameterizedCustomerTicket> tickets)
    {
        return new ComputeCustomerProperties(tickets);
    }

    public ICustomerAnalysis getCustomerAnalysis() throws IOException
    {
        ICustomerAnalysisDao persistenceCustomer = getPersistenceCustomer();
        return new CustomerAnalysisFacade(persistenceCustomer);
    }

    public IParameterizedCustomerTicket getParameterizedCustomerTicket(String ticketID, String customerID, Date startDate, Date endDate, String ticketType, int priority, int urgency, int impact, String ticketLevel, String creatorID, String employeeID, int rating)
    {
        return new ParameterizedCustomerTicket(ticketID, customerID, startDate, endDate, ticketType, priority, urgency, impact, ticketLevel, creatorID, employeeID, rating);
    }

    public ICustomerAnalysisDao getPersistenceCustomer() throws IOException
    {
        return new CustomerAnalysisDao();
    }
}
