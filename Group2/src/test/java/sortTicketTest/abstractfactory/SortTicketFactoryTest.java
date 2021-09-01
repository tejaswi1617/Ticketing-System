package sortTicketTest.abstractfactory;

import sortTicketTest.SortTicketMock;
import sortTickets.interfaces.ISortTicket;

public class SortTicketFactoryTest implements ISortTicketFactoryTest
{

	private static ISortTicketFactoryTest uniqueInstance = null;

    private SortTicketFactoryTest()
    {

    }

    public static ISortTicketFactoryTest instance()
    {
        if(null == uniqueInstance)
        {
            uniqueInstance = new SortTicketFactoryTest();
        }
        return uniqueInstance;
    }

	public ISortTicket sortTicketMock() 
	{
		return new SortTicketMock();
	}
	
}
