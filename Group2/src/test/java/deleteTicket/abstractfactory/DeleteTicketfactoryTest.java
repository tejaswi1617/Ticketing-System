package deleteTicket.abstractfactory;

import deleteTicket.DeleteTicketMock;
import deleteTicket.interfaces.IDeleteTickets;

public class DeleteTicketfactoryTest implements IDeleteTicketfactoryTest {
	private static IDeleteTicketfactoryTest uniqueInstance = null;

    private DeleteTicketfactoryTest()
    {

    }

    public static IDeleteTicketfactoryTest instance()
    {
        if(null == uniqueInstance)
        {
            uniqueInstance = new DeleteTicketfactoryTest();
        }
        return uniqueInstance;
    }

	public IDeleteTickets deleteTicketMock() {
		return new DeleteTicketMock();
	}
	
}
