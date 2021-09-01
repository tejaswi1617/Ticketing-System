package searchTicket;

import org.junit.Test;

import reuseableClasses.abstractfactory.IReuseableClassesFactoryTest;
import reuseableClasses.abstractfactory.ReuseableClassFactoryTest;
import reuseablePackage.interfaces.IOpenTicket;
import userinterface.IInputOutputHandler;
import userinterface.InputOutputHandler;


public class OpenTicketTest
{
	private IReuseableClassesFactoryTest reuseableclassfactory = ReuseableClassFactoryTest.instance();
	IOpenTicket openticket = reuseableclassfactory.openticketMock();
	IInputOutputHandler inputoutputhandler = new InputOutputHandler();
//	 
//	@Before
//    public void initialize()
//    {
//		openticket = searchfactorytest.openticketMock();
//    }
//
//	
	@Test
	public void openTicketTest()
	{
		String TicketId = "111";
		String output = openticket.openticket(TicketId);
		inputoutputhandler.displayMethod(output);
	}
}
