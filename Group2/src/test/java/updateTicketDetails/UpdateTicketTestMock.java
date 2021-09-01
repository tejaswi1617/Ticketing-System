package updateTicketDetails;

import java.text.ParseException;

import updateTicketDetails.abstractfactory.IUpdateTicketDetailsfactoryTest;
import updateTicketDetails.abstractfactory.UpdateTicketDetailsfactoryTest;
import updateTicketDetails.interfaces.IUpdateTicket;

public class UpdateTicketTestMock  implements IUpdateTicket
{

	public boolean updateValueOfTicketForManager(String ticketID, int choice, String valueToUpdate)
	{
		boolean result = false;
		if(choice == 7) 
		{
			result =changeTicketSatatus(ticketID,valueToUpdate);
		}
		else
		{
			result =ticketExist(ticketID);
		}
		return result;
	}
	
	public boolean updateValueOfTicketForNotManager(String ticketID, String valueToUpdate) throws ParseException
	{
		boolean result;
		result =changeTicketSatatus(ticketID,valueToUpdate);
		return result;
	}
	
	private boolean ticketExist(String ticketID)
	{
		String ticketId = "111";
		if(ticketId.equals(ticketID))
		{
			return true;
		}
		else 
		{
			return false;
		}
	}

    private boolean changeTicketSatatus(String ticketID, String valueToUpdate) 
	{
		IUpdateTicketDetailsfactoryTest updateticketsdetailsfactore = UpdateTicketDetailsfactoryTest.instance();
		boolean result=false;
		double hour=0;
		String previousInProgressTicket = "in progress";
		String previousOnHoldTicket = "on hold";
		 result = ticketExist(ticketID);
		 if(result == true && previousInProgressTicket.equals(valueToUpdate))
		 {
			 hour = 1;
		 }
		 else if(result == true && previousOnHoldTicket.equals(valueToUpdate))
		 {
			 hour = 1;
		 }
		 else
		 {
			result = false; 
		 }
		if(hour == 1)
		{
			result = true;
		}
		return  result;
	}
}
