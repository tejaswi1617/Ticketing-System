package managerfeatures.interfaces;

import java.util.List;
import insertTicket.Interfaces.ICreateTicket;

public interface IManagerTeamTracking {

	public List<ICreateTicket> fetchTeamsTicketDetails(String managerId) throws Exception;

}
