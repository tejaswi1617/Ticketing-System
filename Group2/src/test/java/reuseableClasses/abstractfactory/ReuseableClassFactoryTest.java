package reuseableClasses.abstractfactory;

import reuseableClasses.CheckTicketExistsMock;
import reuseableClasses.ExportTicketDataMock;
import reuseableClasses.GetListOfTicketsMock;
import reuseableClasses.OpenTicketMock;
import reuseablePackage.interfaces.ICheckTicketsExists;
import reuseablePackage.interfaces.IExportTicket;
import reuseablePackage.interfaces.IGetListOfTickets;
import reuseablePackage.interfaces.IOpenTicket;

public class ReuseableClassFactoryTest implements IReuseableClassesFactoryTest
{
	private static IReuseableClassesFactoryTest uniqueInstance = null;

    private ReuseableClassFactoryTest()
    {

    }

    public static IReuseableClassesFactoryTest instance()
    {
        if(null == uniqueInstance)
        {
            uniqueInstance = new ReuseableClassFactoryTest();
        }
        return uniqueInstance;
    }

	public ICheckTicketsExists checkticketexistMock()
	{
		return new CheckTicketExistsMock();
	}
	public IGetListOfTickets getlistofticketsMock()
	{
		return new GetListOfTicketsMock();
	}

	public IExportTicket exportticketdataMock()
	{
		return new ExportTicketDataMock();
	}

	public IOpenTicket openticketMock()
	{
		return new OpenTicketMock();
	}
}
