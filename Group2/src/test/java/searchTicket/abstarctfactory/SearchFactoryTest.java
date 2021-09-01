package searchTicket.abstarctfactory;


import searchTicket.SearchTicketMock;
import searchTicket.interfaces.ISearchTicket;

public class SearchFactoryTest implements ISearchFactoryTest
{
	private static ISearchFactoryTest uniqueInstance = null;

    private SearchFactoryTest()
    {

    }

    public static ISearchFactoryTest instance()
    {
        if(null == uniqueInstance)
        {
            uniqueInstance = new SearchFactoryTest();
        }
        return uniqueInstance;
    }


	public ISearchTicket searchticketMock() 
	{
		
		return new SearchTicketMock();
	}


   
	
}
