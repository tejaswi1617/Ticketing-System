package comments;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import reuseableClasses.abstractfactory.IReuseableClassesFactoryTest;
import reuseableClasses.abstractfactory.ReuseableClassFactoryTest;
import reuseablePackage.interfaces.ICheckTicketsExists;

public class CheckTicketExistsTest 
{
	IReuseableClassesFactoryTest reuseableclassfactorytest = ReuseableClassFactoryTest.instance();
	ICheckTicketsExists checkticketexists =reuseableclassfactorytest.checkticketexistMock();
	
	@Test
	public void ticketExistsTest()
	{
		assertTrue(checkticketexists.ticketExists("111"));
		assertFalse(checkticketexists.ticketExists("123"));
	}
}
