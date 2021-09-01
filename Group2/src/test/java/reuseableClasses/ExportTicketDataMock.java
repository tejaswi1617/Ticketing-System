package reuseableClasses;

import reuseablePackage.interfaces.IExportTicket;

public class ExportTicketDataMock implements IExportTicket
{

	public boolean exportTicket(String FileName) 
	{
		String fileNameExists = "t2.txt";
		if(fileNameExists.equals(FileName))
		{
			return false;
		}
		return true;
	}

}
