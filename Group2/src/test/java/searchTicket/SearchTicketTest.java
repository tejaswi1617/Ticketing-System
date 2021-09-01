package searchTicket;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import reuseableClasses.abstractfactory.IReuseableClassesFactoryTest;
import reuseableClasses.abstractfactory.ReuseableClassFactoryTest;
import reuseablePackage.interfaces.IExportTicket;
import searchTicket.abstarctfactory.ISearchFactoryTest;
import searchTicket.abstarctfactory.SearchFactoryTest;
import searchTicket.interfaces.ISearchTicket;
import userinterface.IInputOutputHandler;
import userinterface.InputOutputHandler;


public class SearchTicketTest 
{
	ISearchFactoryTest  searchfactorytest = SearchFactoryTest.instance();
	ISearchTicket searchticket;
	IInputOutputHandler inputoutputhandler = new InputOutputHandler();
	IReuseableClassesFactoryTest searchTicket = ReuseableClassFactoryTest.instance();
	IExportTicket exportTicket;
	
	@Before
    public void initialize()
    {
		searchticket = searchfactorytest.searchticketMock();
		exportTicket = searchTicket.exportticketdataMock();
    }

	
	@Test
	public void searchbyTicketIDTest()
	{
		String TicketId = "111";
		String output = searchticket.searchbyTicket(1, TicketId);
		inputoutputhandler.displayMethod(output);
	}
	
	@Test
	public void searchbyTicketAssigneeTest()
	{
		String AssigneeName = "Tejasw";
		String output = searchticket.searchbyTicket(2, AssigneeName);
		inputoutputhandler.displayMethod(output);
	}
	
	@Test
	public void searchbyTicketTypeTest()
	{
		String TicketType = "bug";
		String output = searchticket.searchbyTicket(3, TicketType);
		inputoutputhandler.displayMethod(output);
	}
	
	@Test
	public void searchAllTicketTest()
	{
		String TicketIAll = null;
		String output = searchticket.searchbyTicket(4, TicketIAll);
		inputoutputhandler.displayMethod(output);
	}
	
	@Test
	public void searchbyTicketCreatorTest()
	{
		String TicketCreatorId= "EMP123";
		String output = searchticket.searchbyTicket(5, TicketCreatorId);
		inputoutputhandler.displayMethod(output);
	}
	
	@Test
	public void searchTicketbyKeyWordTest()
	{
		String keyword = "login";
		String output = searchticket.searchbyTicket(6, keyword);
		inputoutputhandler.displayMethod(output);
	}
	
	@Test
	public void exportTicketSuccessfully()
	{
		assertTrue(exportTicket.exportTicket("t1.txt"));
	}
	
	@Test
	public void exportTicketUnSuccessfully()
	{
		assertFalse(exportTicket.exportTicket("t2.txt"));
	}
}
