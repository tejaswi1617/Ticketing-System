package managerfeatures;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import database.abstractfactory.DatabaseFactory;
import database.abstractfactory.IDatabaseFactory;
import database.intefaces.IConnectionManager;
import database.intefaces.IDatabaseOperations;
import insertTicket.Interfaces.ICreateTicket;
import insertTicket.abstractFactory.IInsertTicketFactory;
import insertTicket.abstractFactory.InsertTicketFactory;
import mailservice.ReadPropertiesFile;
import managerfeatures.interfaces.IManagerFeaturesDao;

public class ManagerFeaturesDao implements IManagerFeaturesDao {

	private final String MANAGER_TEAM_TICKETS = "managers_team_tickets";
	private IConnectionManager connectionManager;
	private String projectConfigurationFile = "ProjectConfiguration.properties";
	private String dbConfigurationKey = "DBConfiguration";
	private final IDatabaseFactory databaseFactory = DatabaseFactory.instance();
	private final IDatabaseOperations databaseOperations = databaseFactory.getDatabaseOperations();

	public ManagerFeaturesDao() throws IOException {
		Properties properties = ReadPropertiesFile.readConfigPropertyFile(projectConfigurationFile);
		String configurationFile = (String) properties.get(dbConfigurationKey);
		connectionManager = databaseFactory.getConnectionManager(configurationFile);
	}

	@Override
	public List<ICreateTicket> managersTeamTickets(String managerId) throws Exception {

		IInsertTicketFactory insertTicketFactory = InsertTicketFactory.instance();

		List<ICreateTicket> createTickets = new ArrayList<ICreateTicket>();

		if (connectionManager == null) {
			throw new Exception("Error while creating connection to DB. Please contact admin.");
		}

		Connection connection = connectionManager.establishConnection();
		CallableStatement procedureCall;
		procedureCall = connection.prepareCall("call " + MANAGER_TEAM_TICKETS + "(?)");
		procedureCall.setString(1, managerId);

		ResultSet resultSet = databaseOperations.executeQuery(procedureCall);

		if (resultSet == null) {
			return null;
		}

		while (resultSet.next()) {
			String employeeId = resultSet.getString(1);
			String ticketId = resultSet.getString(2);
			String description = resultSet.getString(3);
			ICreateTicket createTicket = insertTicketFactory.getcreateTicket(ticketId, description, null, null,
					employeeId, null, null, null, 0, 0, 0, null, null, null, null, null,null);
			createTickets.add(createTicket);
		}
		connectionManager.closeConnection();
		return createTickets;
	}

}
