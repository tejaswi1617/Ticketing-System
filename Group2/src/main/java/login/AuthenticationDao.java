//Author : Vamsi Krishna Utla

package login;

import database.intefaces.IConnectionManager;
import database.abstractfactory.DatabaseFactory;
import database.abstractfactory.IDatabaseFactory;
import login.Interfaces.*;
import login.abstractfactory.*;
import mailservice.ReadPropertiesFile;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class AuthenticationDao implements IAuthenticationDao
{
    ILoginFactory loginFactory = LoginFactory.instance();
    private final IDatabaseFactory databaseFactory = DatabaseFactory.instance();
    private String projectConfigurationFile = "ProjectConfiguration.properties";
    private String dbConfigurationKey = "DBConfiguration";
    private final IConnectionManager connection;

    public AuthenticationDao() throws IOException {
        Properties properties = ReadPropertiesFile.readConfigPropertyFile(projectConfigurationFile);
        String configurationFile = (String)properties.get(dbConfigurationKey);
        connection = databaseFactory.getConnectionManager(configurationFile);
    }

    public String getPassword(String employeeID)
    {
        String result = "";
        final Object nullObject = null;
        String procedureName = "getPassword";
        Connection dummyConnection=null;
        CallableStatement procedureCall;

        if(connection == null)
        {
            return null;
        }

        try {
            dummyConnection = connection.establishConnection();
            procedureCall =	dummyConnection.prepareCall("{call "+procedureName+"(?)}");
            procedureCall.setString(1,employeeID);
            ResultSet resultSet = procedureCall.executeQuery();
            while(resultSet.next())
            {
                result = resultSet.getString("user_password");
            }
            if(result == null)
            {
                return null;
            }
            else 
            {
            	return result;
            }
        }
        catch (SQLException throwables)
        {
            return null;
        }
        finally
        {
            connection.closeConnection();
        }
    }

    public IParameterizedUser getUserDetails(String employeeID)
    {
        IParameterizedUser parameterizedUser;
        String firstName;
        String lastName;
        String userType;
        String email;
        String manager;
        final Object nullObject = null;
        String procedureName = "getUserDetails";
        Connection dummyConnection=null;
        CallableStatement procedureCall;

        if(connection == null)
        {
            return null;
        }

        try {
            dummyConnection = connection.establishConnection();
            procedureCall =	dummyConnection.prepareCall("{call "+procedureName+"(?)}");
            procedureCall.setString(1,employeeID);
            ResultSet resultSet = procedureCall.executeQuery();
            if(resultSet.next())
            {
                firstName = resultSet.getString("firstName");
                lastName = resultSet.getString("lastName");
                email = resultSet.getString("email");
                userType = resultSet.getString("user_type");
                manager = resultSet.getString("manager");
                parameterizedUser = loginFactory.getParameterizedUser(employeeID, firstName, lastName, email, userType, manager);
                return parameterizedUser;
            }
            else
            {
                return null;
            }
        }
        catch (Exception throwables)
        {
            return null;
        }
        finally
        {
            connection.closeConnection();
        }
    }
}