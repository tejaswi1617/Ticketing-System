package updateTicketDetails.abstractfactory;

import updateTicketDetails.UpdateTicketTestMock;
import updateTicketDetails.interfaces.IUpdateTicket;

public class UpdateTicketDetailsfactoryTest implements IUpdateTicketDetailsfactoryTest
{
	private static IUpdateTicketDetailsfactoryTest uniqueInstance = null;

    private UpdateTicketDetailsfactoryTest()
    {

    }

    public static IUpdateTicketDetailsfactoryTest instance()
    {
        if(null == uniqueInstance)
        {
            uniqueInstance = new UpdateTicketDetailsfactoryTest();
        }
        return uniqueInstance;
    }
    
    public IUpdateTicket updateticketMock()
    {
    	return new UpdateTicketTestMock();
    }


}
