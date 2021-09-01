//Author : Vamsi Krishna Utla

package sncustomeranalysis.abstractfactory;

import sncustomeranalysis.Interfaces.*;

public interface ICustomerAnalysisFactoryTest
{
    ICustomerAnalysis getCustomerAnalysis();
    ICustomerAnalysisDao getPersistenceCustomerMock();
}
