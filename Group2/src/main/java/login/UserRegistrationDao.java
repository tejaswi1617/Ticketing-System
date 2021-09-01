//Author : Vamsi Krishna Utla

package login;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Properties;
import database.abstractfactory.DatabaseFactory;
import database.abstractfactory.IDatabaseFactory;
import database.intefaces.IConnectionManager;
import login.Interfaces.IParameterizedUser;
import login.Interfaces.IUserRegistrationDao;
import mailservice.ReadPropertiesFile;

public class UserRegistrationDao implements IUserRegistrationDao {
	private boolean result = false;
	private String projectConfigurationFile = "ProjectConfiguration.properties";
	private String dbConfigurationKey = "DBConfiguration";
	private final IDatabaseFactory databaseFactory = DatabaseFactory.instance();
	private final IConnectionManager connection;

	public UserRegistrationDao() throws IOException {
		Properties properties = ReadPropertiesFile.readConfigPropertyFile(projectConfigurationFile);
		String configurationFile = (String) properties.get(dbConfigurationKey);
		connection = databaseFactory.getConnectionManager(configurationFile);
	}

	public boolean registerUserDatabase(IParameterizedUser user, String user_password) {
		Connection dummyConnection = null;
		CallableStatement procedureCall;

		if (connection == null) {
			return false;
		}

		try {
			String procedureName = "registerUser";
			dummyConnection = connection.establishConnection();
			procedureCall = dummyConnection.prepareCall("{call " + procedureName + "(?,?,?,?,?,?,?)}");
			procedureCall.setString(1, user.getEmployeeID());
			procedureCall.setString(2, user.getfirstName());
			procedureCall.setString(3, user.getLastName());
			procedureCall.setString(4, user.getEmail());
			procedureCall.setString(5, user_password);
			procedureCall.setString(6, user.getUserType());
			procedureCall.setString(7, user.getManager());
			return executeUpdateCommand(procedureCall);
		} catch (Exception throwables) {
			result = false;
			return result;
		} finally {
			connection.closeConnection();
		}
	}

	public boolean checkDuplicateEmployeeID(String employeeID) {
		if (connection == null) {
			return false;
		}

		CallableStatement procedureCall;
		try {
			procedureCall = connection.establishConnection().prepareCall("{call getEmployeeDetails(?)}");
			procedureCall.setString(1, employeeID);
			if (executeCommand(procedureCall)) {
				ResultSet resultSet = procedureCall.getResultSet();
				if (resultSet.next()) {
					return result = true;
				} else {
					return result = false;
				}
			}
		} catch (Exception throwables) {
			result = false;
			return result;
		} finally {
			connection.closeConnection();
		}
		return result = false;
	}

	boolean executeCommand(CallableStatement procedureCall) {
		boolean result;
		try {
			result = procedureCall.execute();
			return result;
		} catch (Exception throwables) {
			result = false;
			return result;
		}
	}

	boolean executeUpdateCommand(CallableStatement procedureCall) {
		boolean result;
		int updateResult;
		try {
			updateResult = procedureCall.executeUpdate();
			if (updateResult == 1) {
				result = true;
				return result;
			}
			result = false;
			return result;
		} catch (Exception throwables) {
			result = false;
			return result;
		}
	}
}
