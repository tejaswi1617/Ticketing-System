package menucontroller;

import login.Interfaces.IParameterizedUser;
import menucontroller.interfaces.IMenuHandler;
import menucontroller.interfaces.IMenuTask;
import userinterface.IInputOutputHandler;

public class MenuHandler implements IMenuHandler {

	public enum Menu {
		LOGIN, REGISTRATION, FORGOT_PASSWORD, CREATE_TICKET, UPDATE_TICKET, COMMENT, SORT, SEARCH_TICKETS,
		RATING_FEATURE, EMPLOYEE_PERFORMANCE_REPORT, TWITTER_POSTING, EMPLOYEE_EFFICENCY, CUSTOMERS_ANALYSIS,
		OPEN_TICKETS_WITH_TEAM, MODIFY_USER_ROLE, HOME_PAGE, LOGOUT, EXIT, DELETE_TICKET
	}

	@Override
	public void runMenuTask(Menu menuTaskName, IParameterizedUser user, IInputOutputHandler inputOutputHandler) {
		IMenuTask menuTask = createMenuTaskObject(menuTaskName);
		menuTask.runMenuTask(user, inputOutputHandler);
	}

	private IMenuTask createMenuTaskObject(Menu menuTaskName) {
		IMenuTask menuTask = null;

		switch (menuTaskName) {
		case LOGIN:
			menuTask = new LoginMenuTask();
			break;
		case REGISTRATION:
			menuTask = new RegistrationMenuTask();
			break;
		case FORGOT_PASSWORD:
			menuTask = new ForgotPasswordMenuTask();
			break;
		case CREATE_TICKET:
			menuTask = new CreateTicketMenuTask();
			break;
		case UPDATE_TICKET:
			menuTask = new UpdateTicketMenuTask();
			break;
		case DELETE_TICKET:
			menuTask = new DeleteTicketMenuTask();
			break;
		case COMMENT:
			menuTask = new CommentOnTicketMenuTask();
			break;
		case SORT:
			menuTask = new SortTicketMenuTask();
			break;
		case SEARCH_TICKETS:
			menuTask = new SearchTicketMenuTask();
			break;
		case RATING_FEATURE:
			menuTask = new RatingMenuTask();
			break;
		case EMPLOYEE_PERFORMANCE_REPORT:
			menuTask = new EmployeePerformanceReportTask();
			break;
		case TWITTER_POSTING:
			menuTask = new TwitterPostingMenuTask();
			break;
		case EMPLOYEE_EFFICENCY:
			menuTask = new EmployeeEfficiencyMenuTask();
			break;
		case CUSTOMERS_ANALYSIS:
			menuTask = new CustomerAnalysisMenuTask();
			break;
		case OPEN_TICKETS_WITH_TEAM:
			menuTask = new OpenTicketsWithTeamMenuTask();
			break;
		case MODIFY_USER_ROLE:
			menuTask = new ModifyUserRoleMenuTask();
			break;
		case HOME_PAGE:
			menuTask = new HomePageMenuTask();
			break;
		case LOGOUT:
			menuTask = new LogoutMenuTask();
			break;
		case EXIT:
			menuTask = new ExitMenuTask();
			break;
		}
		return menuTask;
	}
}
