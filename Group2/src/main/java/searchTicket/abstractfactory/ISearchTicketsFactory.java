package searchTicket.abstractfactory;


import database.intefaces.IConnectionManager;
import reuseablePackage.interfaces.IExportTicket;
import reuseablePackage.interfaces.IStoreTicketData;
import searchTicket.interfaces.ISearchTicket;

public interface ISearchTicketsFactory {

	ISearchTicket searchticket(IStoreTicketData storeTicketData,IConnectionManager ConnectionMng);
	IExportTicket exportTicketData(IStoreTicketData storeTicketData);
}

