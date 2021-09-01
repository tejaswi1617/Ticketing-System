package managerfeatures;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.io.IOException;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import insertTicket.Interfaces.ICreateTicket;
import managerfeatures.abstractfactory.IManagerFeaturesFactory;
import managerfeatures.abstractfactory.ManagerFeaturesMockFactory;
import managerfeatures.interfaces.IManagerTeamTracking;

public class ManagerTeamTrackingTest {

	private final String MANAGER_ID = "M101";
	private final String NULL_OBJECT = null;
	private final String EMPTY = "";
	private final String INVALID_MANAGER_ID = "ABC";

	private IManagerTeamTracking managerTeamTracking;

	@Before
	public void init() throws IOException {
		IManagerFeaturesFactory managerFeaturesFactory = ManagerFeaturesMockFactory.instance();
		managerTeamTracking = managerFeaturesFactory.makeManagerFeaturesFactoryObject();
	}

	@Test
	public void fetchTeamsTicketDetailsTest() throws Exception {
		List<ICreateTicket> teamsTickets = managerTeamTracking.fetchTeamsTicketDetails(MANAGER_ID);
		boolean isMenuItemsListSizeGreaterThan0 = teamsTickets.size() > 0;
		assertTrue(isMenuItemsListSizeGreaterThan0);
	}

	@Test
	public void fetchTeamsTicketDetailsInvalidManagerIdTest() throws Exception {
		List<ICreateTicket> teamsTickets = managerTeamTracking.fetchTeamsTicketDetails(INVALID_MANAGER_ID);
		assertNull(teamsTickets);
	}

	@Test
	public void fetchTeamsTicketDetailsNullTest() throws Exception {
		List<ICreateTicket> teamsTickets = managerTeamTracking.fetchTeamsTicketDetails(NULL_OBJECT);
		assertNull(teamsTickets);
	}

	@Test
	public void fetchTeamsTicketDetailsEmptyTest() throws Exception {
		List<ICreateTicket> teamsTickets = managerTeamTracking.fetchTeamsTicketDetails(EMPTY);
		assertNull(teamsTickets);
	}
}
