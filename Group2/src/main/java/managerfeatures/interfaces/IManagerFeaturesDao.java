package managerfeatures.interfaces;

import java.util.List;
import insertTicket.Interfaces.ICreateTicket;

public interface IManagerFeaturesDao {

	public List<ICreateTicket> managersTeamTickets(String managerId) throws Exception;

}
