//Author : Vamsi Krishna Utla

package sncustomeranalysis.abstractfactory;

import sncustomeranalysis.CustomerAnalysisFacade;
import sncustomeranalysis.PersistenceCustomerMock;
import sncustomeranalysis.Interfaces.ICustomerAnalysis;
import sncustomeranalysis.Interfaces.ICustomerAnalysisDao;

public class CustomerAnalysisFactoryTest implements ICustomerAnalysisFactoryTest
{
    private static ICustomerAnalysisFactoryTest uniqueInstance = null;

    private CustomerAnalysisFactoryTest()
    {

    }

    public static ICustomerAnalysisFactoryTest instance()
    {
        if(null == uniqueInstance)
        {
            uniqueInstance = new CustomerAnalysisFactoryTest();
        }
        return uniqueInstance;
    }

    public ICustomerAnalysis getCustomerAnalysis()
    {
        ICustomerAnalysisDao persistenceCustomerMock = getPersistenceCustomerMock();
        return new CustomerAnalysisFacade(persistenceCustomerMock);
    }

    public ICustomerAnalysisDao getPersistenceCustomerMock()
    {
        return new PersistenceCustomerMock();
    }
}
