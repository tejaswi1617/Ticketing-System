//Author : Vamsi Krishna Utla

package sncustomeranalysis;

import database.abstractfactory.*;
import database.intefaces.*;
import mailservice.ReadPropertiesFile;
import sncustomeranalysis.Interfaces.*;
import sncustomeranalysis.abstractfactory.*;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class CustomerAnalysisDao implements ICustomerAnalysisDao
{
    private final IDatabaseFactory databaseFactory = DatabaseFactory.instance();
    private final ICustomerAnalysisFactory customerAnalysisFactory = CustomerAnalysisFactory.instance();
    private final String projectConfigurationFile = "ProjectConfiguration.properties";
    private final String dbConfigurationKey = "DBConfiguration";
    private final IDatabaseOperations databaseOperations = databaseFactory.getDatabaseOperations();
    private final IConnectionManager connection;

    public CustomerAnalysisDao() throws IOException
    {
        Properties properties = ReadPropertiesFile.readConfigPropertyFile(projectConfigurationFile);
        String configurationFile = (String)properties.get(dbConfigurationKey);
        connection = databaseFactory.getConnectionManager(configurationFile);
    }

    public List<IParameterizedCustomerTicket> getTicketsOfCustomer(String customerID)
    {
        List<IParameterizedCustomerTicket> tickets = new ArrayList<>();
        String ticketID;
        Date startDate;
        Date endDate;
        String ticketType;
        int priority;
        int urgency;
        int impact;
        String ticketLevel;
        String creatorID;
        String employeeID;
        int rating;
        Connection dummyConnection;
        CallableStatement procedureCall;

        if(connection == null)
        {
            return null;
        }

        try
        {
            String procedureName = "getCustomerTickets";
            dummyConnection = connection.establishConnection();
            procedureCall = dummyConnection.prepareCall("{call "+procedureName+"(?)}");
            procedureCall.setString(1, customerID);
            ResultSet resultSet = databaseOperations.executeQuery(procedureCall);

            if(resultSet == null)
            {
                return null;
            }

            while(resultSet.next())
            {
                ticketID = resultSet.getString("ticketId");
                startDate = resultSet.getDate("startDate");
                endDate = resultSet.getDate("endDate");
                ticketType = resultSet.getString("ticketType");
                priority = resultSet.getInt("priority");
                urgency = resultSet.getInt("urgency");
                impact = resultSet.getInt("impact");
                ticketLevel = resultSet.getString("ticketLevel");
                creatorID = resultSet.getString("creatorID");
                employeeID = resultSet.getString("employeeId");
                rating = resultSet.getInt("rating");
                IParameterizedCustomerTicket ticket = customerAnalysisFactory.getParameterizedCustomerTicket(ticketID, customerID, startDate, endDate, ticketType, priority, urgency, impact, ticketLevel, creatorID, employeeID, rating);
                tickets.add(ticket);
            }
            return tickets;
        }
        catch (Exception throwable)
        {
            return null;
        }
        finally
        {
            connection.closeConnection();
        }
    }
}