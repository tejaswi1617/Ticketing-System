//Author : Akshay Garg

package roles;

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
import mailservice.ReadPropertiesFile;
import roles.interfaces.IRoleManagementDao;

public class RoleManagementDao implements IRoleManagementDao {

	private final String menuItemsByRoleProcedure = "menu_items_by_role";
	private final String updateUserRoleProcedure = "update_user_role";
	private IConnectionManager connectionManager;
	private String projectConfigurationFile = "ProjectConfiguration.properties";
	private String dbConfigurationKey = "DBConfiguration";
	private final IDatabaseFactory databaseFactory = DatabaseFactory.instance();
	private final IDatabaseOperations databaseOperations = databaseFactory.getDatabaseOperations();

	public RoleManagementDao() throws IOException {
		Properties properties = ReadPropertiesFile.readConfigPropertyFile(projectConfigurationFile);
		String configurationFile = (String) properties.get(dbConfigurationKey);
		connectionManager = databaseFactory.getConnectionManager(configurationFile);
	}

	@Override
	public List<String> accessMenuItemsByRole(String role) throws Exception {

		if (connectionManager == null) {
			throw new Exception("Error while creating connection to DB. Please contact admin.");
		}

		List<String> menuItemsList = null;
		Connection connection = connectionManager.establishConnection();
		CallableStatement procedureCall;
		procedureCall = connection.prepareCall("call " + menuItemsByRoleProcedure + "(?)");
		procedureCall.setString(1, role);

		ResultSet resultSet = databaseOperations.executeQuery(procedureCall);

		if (resultSet == null) {
			return null;
		}

		while (resultSet.next()) {
			if (menuItemsList == null) {
				menuItemsList = new ArrayList<String>();
			}
			menuItemsList.add(resultSet.getString(1));
		}

		connectionManager.closeConnection();
		return menuItemsList;
	}

	@Override
	public boolean updateUserRole(String empId, String role) throws Exception {

		if (connectionManager == null) {
			throw new Exception("Error while creating connection to DB. Please contact admin.");
		}

		Connection connection = connectionManager.establishConnection();
		CallableStatement procedureCall;
		procedureCall = connection.prepareCall("call " + updateUserRoleProcedure + "(?,?)");
		procedureCall.setString(1, empId);
		procedureCall.setString(2, role);

		boolean result = databaseOperations.executeUpdateCommand(procedureCall);
		connectionManager.closeConnection();
		return result;

	}

}
