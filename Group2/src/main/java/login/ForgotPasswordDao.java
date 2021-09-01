//Author : Vamsi Krishna Utla

package login;

import database.abstractfactory.*;
import database.intefaces.IConnectionManager;
import database.intefaces.IDatabaseOperations;
import login.Interfaces.IForgotPasswordDao;
import mailservice.ReadPropertiesFile;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;


public class ForgotPasswordDao implements IForgotPasswordDao {
	private String projectConfigurationFile = "ProjectConfiguration.properties";
	private String dbConfigurationKey = "DBConfiguration";
	private final IDatabaseFactory databaseFactory = DatabaseFactory.instance();
	private final IConnectionManager connection;
	IDatabaseOperations databaseOperations = databaseFactory.getDatabaseOperations();

	public ForgotPasswordDao() throws IOException {
		Properties properties = ReadPropertiesFile.readConfigPropertyFile(projectConfigurationFile);
		String configurationFile = (String) properties.get(dbConfigurationKey);
		connection = databaseFactory.getConnectionManager(configurationFile);
	}

	public String getEmail(String employeeID) {
		Connection dummyConnection = null;
		CallableStatement procedureCall;
		String email = "";

		if (connection == null) {
			return null;
		}

		try {
			String procedureName = "getEmail";
			dummyConnection = connection.establishConnection();
			procedureCall = dummyConnection.prepareCall("{call " + procedureName + "(?)}");
			procedureCall.setString(1, employeeID);
			ResultSet resultSet = procedureCall.executeQuery();
			while (resultSet.next()) {
				email = resultSet.getString("email");
			}
			return email;
		} catch (SQLException throwables) {
			return null;
		} finally {
			connection.closeConnection();
		}
	}

	public boolean updatePassword(String employeeID, String newPassword) {
		Connection dummyConnection = null;
		CallableStatement procedureCall;

		if (connection == null) {
			return false;
		}

		try {
			String procedureName = "updatePassword";
			dummyConnection = connection.establishConnection();
			procedureCall = dummyConnection.prepareCall("{call " + procedureName + "(?,?)}");
			procedureCall.setString(1, employeeID);
			procedureCall.setString(2, newPassword);
			return databaseOperations.executeUpdateCommand(procedureCall);
		} catch (Exception throwables) {
			return false;
		} finally {
			connection.closeConnection();
		}
	}
}
