package managerfeatures;

import java.util.ArrayList;
import java.util.List;
import insertTicket.Interfaces.ICreateTicket;
import insertTicket.abstractFactory.IInsertTicketFactory;
import insertTicket.abstractFactory.InsertTicketFactory;
import managerfeatures.interfaces.IManagerFeaturesDao;
import validations.StringValidations;

public class ManagerFeaturesDaoMock implements IManagerFeaturesDao {

	private final String MANAGER_ID = "M101";
	private final String EMPLOYEE_ID = "E101";
	private final String TICKET_ID = "TICKET1";
	private final String DESCRIPTION = "Facing issues fetching data from DB";

	@Override
	public List<ICreateTicket> managersTeamTickets(String managerId) throws Exception {
		List<ICreateTicket> createTickets = null;
		IInsertTicketFactory insertTicketFactory = InsertTicketFactory.instance();
		if (StringValidations.isStringValid(managerId) && managerId.trim().equalsIgnoreCase(MANAGER_ID)) {
			createTickets = new ArrayList<ICreateTicket>();
			String employeeId = EMPLOYEE_ID;
			String ticketId = TICKET_ID;
			String description = DESCRIPTION;
			ICreateTicket createTicket = insertTicketFactory.getcreateTicket(ticketId, description, null, null,
					employeeId, null, null, null, 0, 0, 0, null, null, null, null, null,null);
			createTickets.add(createTicket);
		}
		return createTickets;
	}

}
