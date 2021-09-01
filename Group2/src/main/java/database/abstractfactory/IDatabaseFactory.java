//Author : Akshay Garg

package database.abstractfactory;

import insertTicket.Interfaces.ICreateTicket;
import insertTicket.Interfaces.ITicketOperationsDB;
import database.intefaces.IConnectionManager;
import database.intefaces.IDatabaseOperations;

public interface IDatabaseFactory {
    IConnectionManager getConnectionManager(String configurationFile);

    IDatabaseOperations getDatabaseOperations();

    ITicketOperationsDB getTicketOperationsDB(ICreateTicket createTicket);
}
