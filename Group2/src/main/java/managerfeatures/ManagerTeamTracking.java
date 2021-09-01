package managerfeatures;

import java.util.List;
import org.apache.commons.lang3.StringUtils;
import insertTicket.Interfaces.ICreateTicket;
import managerfeatures.interfaces.IManagerFeaturesDao;
import managerfeatures.interfaces.IManagerTeamTracking;

public class ManagerTeamTracking implements IManagerTeamTracking {

	private IManagerFeaturesDao managerFeaturesDao;

	public ManagerTeamTracking(IManagerFeaturesDao managerFeaturesDao) {
		this.managerFeaturesDao = managerFeaturesDao;
	}

	public List<ICreateTicket> fetchTeamsTicketDetails(String managerId) throws Exception {
		List<ICreateTicket> dbTeamsTickets = null;
		if (StringUtils.isNotBlank(managerId)) {
			dbTeamsTickets = managerFeaturesDao.managersTeamTickets(managerId);
		}
		return dbTeamsTickets;
	}
}
