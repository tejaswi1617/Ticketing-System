package reuseablePackage.abstractFactory;

import database.intefaces.IConnectionManager;
import reuseablePackage.CheckTicketsExists;
import reuseablePackage.DisplayTickets;
import reuseablePackage.ExportTickets;
import reuseablePackage.GetListOfAllTickets;
import reuseablePackage.OpenTickets;
import reuseablePackage.StoreTicketData;
import reuseablePackage.TableGenerator;
import reuseablePackage.interfaces.ICheckTicketsExists;
import reuseablePackage.interfaces.IDisplayTickets;
import reuseablePackage.interfaces.IExportTicket;
import reuseablePackage.interfaces.IGetListOfTickets;
import reuseablePackage.interfaces.IOpenTicket;
import reuseablePackage.interfaces.IStoreTicketData;
import reuseablePackage.interfaces.ITableGenerator;

public class ReuseableClasssFactory implements IReuseableClasssFactory {

	private static ReuseableClasssFactory uniqueInstance = null;

    private ReuseableClasssFactory()
    {

    }

    public static IReuseableClasssFactory instance()
    {
        if(null == uniqueInstance)
        {
            uniqueInstance = new ReuseableClasssFactory();
        }
        return uniqueInstance;
    }


	public IStoreTicketData storeTicketData()
	{
		return new StoreTicketData();
	}
		
	public IDisplayTickets displayUser()
	{
		return new DisplayTickets();
	}
	

	public ITableGenerator tableFormate()
	{
		return new TableGenerator();

	}

	public IOpenTicket openticket(IStoreTicketData storeTicketData,IConnectionManager connectionManager)
	{
		return new OpenTickets(storeTicketData,connectionManager);
	}


	public ICheckTicketsExists checkticketexists(IConnectionManager connectionManager)
	{
		return new CheckTicketsExists(connectionManager);
	}
	

	public IGetListOfTickets getalltickets(IConnectionManager connectionManager)
	{
		return new GetListOfAllTickets(connectionManager);
	}
	

	public IExportTicket exportTicketData(IStoreTicketData storeTicketData) 
	{
		return new ExportTickets(storeTicketData);
	}
	
}
