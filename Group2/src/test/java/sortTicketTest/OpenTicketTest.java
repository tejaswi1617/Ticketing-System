package sortTicketTest;


import org.junit.Test;

import reuseableClasses.abstractfactory.IReuseableClassesFactoryTest;
import reuseableClasses.abstractfactory.ReuseableClassFactoryTest;
import reuseablePackage.interfaces.IOpenTicket;
import userinterface.IInputOutputHandler;
import userinterface.InputOutputHandler;

public class OpenTicketTest
{
	IReuseableClassesFactoryTest reuseableclassfactorytest = ReuseableClassFactoryTest.instance();
	IOpenTicket openticket = reuseableclassfactorytest.openticketMock();
	IInputOutputHandler inputoutputhandler = new InputOutputHandler();
	
	@Test
	public void openTicketTest()
	{
		String TicketId = "111";
		String output = openticket.openticket(TicketId);
		inputoutputhandler.displayMethod(output);
	}
}
