package reuseableClasses.abstractfactory;

import reuseablePackage.interfaces.ICheckTicketsExists;
import reuseablePackage.interfaces.IExportTicket;
import reuseablePackage.interfaces.IGetListOfTickets;
import reuseablePackage.interfaces.IOpenTicket;

public interface IReuseableClassesFactoryTest 
{
	ICheckTicketsExists checkticketexistMock();
	IGetListOfTickets getlistofticketsMock();

	IExportTicket exportticketdataMock();
	IOpenTicket openticketMock();
}
