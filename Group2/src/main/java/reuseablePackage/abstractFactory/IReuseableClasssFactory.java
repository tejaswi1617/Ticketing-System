package reuseablePackage.abstractFactory;

import database.intefaces.IConnectionManager;
import reuseablePackage.interfaces.ICheckTicketsExists;
import reuseablePackage.interfaces.IDisplayTickets;
import reuseablePackage.interfaces.IExportTicket;
import reuseablePackage.interfaces.IGetListOfTickets;
import reuseablePackage.interfaces.IOpenTicket;
import reuseablePackage.interfaces.IStoreTicketData;
import reuseablePackage.interfaces.ITableGenerator;

public interface IReuseableClasssFactory
{
	IStoreTicketData storeTicketData();
	ITableGenerator tableFormate();
	IDisplayTickets displayUser();
	IOpenTicket openticket(IStoreTicketData storeTicketData,IConnectionManager connectionManager);
	ICheckTicketsExists checkticketexists(IConnectionManager connectionManager);
	IGetListOfTickets getalltickets(IConnectionManager connectionManager);
	IExportTicket exportTicketData(IStoreTicketData storeTicketData);	
}
