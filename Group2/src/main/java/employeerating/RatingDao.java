//Author : Vamsi Krishna Utla

package employeerating;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Properties;
import database.abstractfactory.*;
import database.intefaces.IConnectionManager;
import database.intefaces.IDatabaseOperations;
import employeerating.interfaces.*;
import mailservice.ReadPropertiesFile;

public class RatingDao implements IRatingDao
{
    private final IDatabaseFactory databaseFactory = DatabaseFactory.instance();
    private String projectConfigurationFile = "ProjectConfiguration.properties";
    private String dbConfigurationKey = "DBConfiguration";
    private IConnectionManager connection;
    IDatabaseOperations databaseOperations = databaseFactory.getDatabaseOperations();

    public RatingDao() throws IOException {
        Properties properties = ReadPropertiesFile.readConfigPropertyFile(projectConfigurationFile);
        String configurationFile = (String)properties.get(dbConfigurationKey);
        connection = databaseFactory.getConnectionManager(configurationFile);
    }

    public String getPersistenceCreatorID(String ticketID)
    {
        Connection dummyConnection=null;
        CallableStatement procedureCall;
        ResultSet resultSet;

        if(connection == null)
        {
            return null;
        }

        try
        {

            String procedureName = "checkCreator";
            dummyConnection = connection.establishConnection();
            procedureCall = dummyConnection.prepareCall("{call "+procedureName+"(?)}");
            procedureCall.setString(1, ticketID);
            resultSet = databaseOperations.executeQuery(procedureCall);
            
            if(resultSet == null)
            {
            	return null;
            }
            
            while(resultSet.next())
            {
            	return resultSet.getString("creatorID");
            }
            return null;
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

    public boolean insertRating(String ticketID, int rating)
    {
        Connection dummyConnection=null;
        CallableStatement procedureCall;
        try
        {
            String procedureName = "insertRating";
            dummyConnection = connection.establishConnection();
            procedureCall = dummyConnection.prepareCall("{call "+procedureName+"(?,?}");
            procedureCall.setString(1, ticketID);
            procedureCall.setInt(2, rating);
            return databaseOperations.executeUpdateCommand(procedureCall);
        }
        catch (Exception throwables)
        {
            return false;
        }
        finally
        {
            connection.closeConnection();
        }
    }
}
