//Author : Vamsi Krishna Utla

package employeeMilestones;

import database.intefaces.IConnectionManager;
import database.abstractfactory.*;
import database.intefaces.IDatabaseOperations;
import employeeMilestones.abstractfactory.*;
import employeeMilestones.interfaces.*;
import mailservice.ReadPropertiesFile;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class EmployeeTicketsDao implements IEmployeeTicketsDao
{
    private final IEmployeeMilestoneFactory employeeMilestoneFactory = EmployeeMilestoneFactory.instance();
    private final String projectConfigurationFile = "ProjectConfiguration.properties";
    private final String dbConfigurationKey = "DBConfiguration";
    private final IDatabaseFactory databaseFactory = DatabaseFactory.instance();
    private final IDatabaseOperations databaseOperations = databaseFactory.getDatabaseOperations();
    private final IConnectionManager connection;

    public EmployeeTicketsDao() throws IOException
    {
        Properties properties = ReadPropertiesFile.readConfigPropertyFile(projectConfigurationFile);
        String configurationFile = (String)properties.get(dbConfigurationKey);
        connection = databaseFactory.getConnectionManager(configurationFile);
    }

    public List<IParameterizedEmployeeTicket> getEmployeeTickets(String employeeID)
    {
        String ticketID;
        String customerID;
        String ticketType;
        Date startDate;
        Date endDate;
        int rating;
        int priority;
        int impact;
        int urgency;
        List<IParameterizedEmployeeTicket> employeeTicketList = new ArrayList<>();

        if(connection == null)
        {
            return null;
        }

        Connection dummyConnection;
        CallableStatement procedureCall;
        try {
            String procedureName = "ticketsByEmployee";
            dummyConnection = connection.establishConnection();
            procedureCall = dummyConnection.prepareCall("{call "+procedureName+"(?)}");
            procedureCall.setString(1, employeeID);
            ResultSet resultSet = databaseOperations.executeQuery(procedureCall);

            if(resultSet == null)
            {
                return null;
            }

            while(resultSet.next())
            {
                ticketID = resultSet.getString("tiketId");
                customerID = resultSet.getString("customerID");
                startDate = resultSet.getDate("startDate");
                endDate = resultSet.getDate("endDate");
                rating = resultSet.getInt("rating");
                priority = resultSet.getInt("priority");
                impact = resultSet.getInt("impact");
                urgency = resultSet.getInt("urgency");
                ticketType = resultSet.getString("ticketType");
                IParameterizedEmployeeTicket employeeTicket = employeeMilestoneFactory.getParameterizedEmployeeTicket(ticketID, employeeID, customerID, startDate, endDate, rating, priority, impact, urgency, ticketType);
                employeeTicketList.add(employeeTicket);
            }

            return employeeTicketList;
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