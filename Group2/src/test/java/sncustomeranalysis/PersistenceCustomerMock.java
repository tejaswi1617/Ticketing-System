//Author : Vamsi Krishna Utla

package sncustomeranalysis;


import sncustomeranalysis.Interfaces.*;
import sncustomeranalysis.abstractfactory.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class PersistenceCustomerMock implements ICustomerAnalysisDao
{
    ICustomerAnalysisFactory customerAnalysisFactory = CustomerAnalysisFactory.instance();
    public List<IParameterizedCustomerTicket> getTicketsOfCustomer(String customerID)
    {
        List<IParameterizedCustomerTicket> customerTickets = new ArrayList<>();

        IParameterizedCustomerTicket customerTicketOne = customerAnalysisFactory.getParameterizedCustomerTicket("TIC_001", "CUST_DAL", Date.valueOf("2021-01-10"), Date.valueOf("2021-01-15"), "Bug", 1, 1, 1, "Easy", "USER_123", "EMP_123", 5);
        IParameterizedCustomerTicket customerTicketTwo = customerAnalysisFactory.getParameterizedCustomerTicket("TIC_002", "CUST_DAL", Date.valueOf("2021-02-01"), Date.valueOf("2021-02-20"), "User education", 3, 3, 3, "Hard", "USER_123", "EMP_125", 3);
        IParameterizedCustomerTicket customerTicketThree = customerAnalysisFactory.getParameterizedCustomerTicket("TIC_003", "CUST_DAL", Date.valueOf("2021-03-23"), Date.valueOf("2021-03-31"), "Bug", 2, 2, 3, "Moderate", "USER_456", "EMP_124", 2);

        customerTickets.add(customerTicketOne);
        customerTickets.add(customerTicketTwo);
        customerTickets.add(customerTicketThree);

        return customerTickets;
    }

}
