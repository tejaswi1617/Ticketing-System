package menucontroller;

import java.sql.SQLException;

import login.Interfaces.IParameterizedUser;
import menucontroller.interfaces.IMenuTask;
import userinterface.IEmployeePerformanceScreen;
import userinterface.IInputOutputHandler;
import userinterface.abstractFactory.IUserInterfaceFactory;
import userinterface.abstractFactory.UserInterfaceFactory;

public class EmployeePerformanceReportTask implements IMenuTask {

	public void runMenuTask(IParameterizedUser user, IInputOutputHandler inputOutputHandler) {
		IUserInterfaceFactory userInterfaceFactory = UserInterfaceFactory.instance();
		IEmployeePerformanceScreen employeePerformanceScreen = userInterfaceFactory
				.getEmployeePerformanceScreen(inputOutputHandler);
		try {
			employeePerformanceScreen.displayTicketGenerationScreen(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
