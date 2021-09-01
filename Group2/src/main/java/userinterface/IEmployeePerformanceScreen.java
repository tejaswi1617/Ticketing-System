package userinterface;

import java.sql.SQLException;

import login.Interfaces.IParameterizedUser;

public interface IEmployeePerformanceScreen {

    public void displayTicketGenerationScreen(IParameterizedUser user) throws SQLException;

}
