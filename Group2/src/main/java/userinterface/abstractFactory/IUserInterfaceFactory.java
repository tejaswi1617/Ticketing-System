package userinterface.abstractFactory;

import userinterface.IBackToHomePageScreen;
import userinterface.ICommentOnTicketScreen;
import userinterface.ICustomerAnalysisScreen;
import userinterface.IDeleteTicketScreen;
import userinterface.IEmployeeMilestoneScreen;
import userinterface.IEmployeePerformanceScreen;
import userinterface.IExportEmployeePerformanceReport;
import userinterface.IForgotPasswordScreen;
import userinterface.IGenerateTicketScreen;
import userinterface.IHomePageScreen;
import userinterface.IInputOutputHandler;
import userinterface.ILoginScreen;
import userinterface.IManagerTeamTrackingScreen;
import userinterface.IModifyUserRoleScreen;
import userinterface.IRatingScreen;
import userinterface.IRegistrationScreen;
import userinterface.ISearchTicketScreen;
import userinterface.IServiceNowWelcomeScreen;
import userinterface.ISortTciketScreen;
import userinterface.ITwitterPostScreen;
import userinterface.IUpdateTicketScreen;

public interface IUserInterfaceFactory
{
    public IServiceNowWelcomeScreen getServiceNowWelcomeScreen(IInputOutputHandler inputOutputHandler);
    public IInputOutputHandler getInputOutputHandler();
    public ILoginScreen getLoginScreen(IInputOutputHandler inputOutputHandler);
    public IRegistrationScreen getRegistrationScreen(IInputOutputHandler inputOutputHandler);
    public IForgotPasswordScreen getForgotPasswordScreen(IInputOutputHandler inputOutputHandler);
    public IBackToHomePageScreen getBackToHomePageScreen(IInputOutputHandler inputOutputHandler);
    public IModifyUserRoleScreen getModifyUserRoleScreen(IInputOutputHandler inputOutputHandler);
    public IManagerTeamTrackingScreen getmangerTeamTrackingScreen(IInputOutputHandler inputOutputHandler);
    public IHomePageScreen getHomePageScreen(IInputOutputHandler inputOutputHandler);
    public IRatingScreen getRatingScreen(IInputOutputHandler inputOutputHandler);
    public ICustomerAnalysisScreen getCustomerAnalysisScreen(IInputOutputHandler inputOutputHandler);
    public IEmployeeMilestoneScreen getEmployeeMilestoneScreen(IInputOutputHandler inputOutputHandler);
    public IGenerateTicketScreen getGenerateTicketScreen(IInputOutputHandler inputOutputHandler);
    public IEmployeePerformanceScreen getEmployeePerformanceScreen(IInputOutputHandler inputOutputHandler);
    public ISortTciketScreen getsortTicketScreen(IInputOutputHandler inputOutputHandler);
    public ISearchTicketScreen getsearchTicketScreen(IInputOutputHandler inputOutputHandler);
    public IDeleteTicketScreen getdeleteTicketScreen(IInputOutputHandler inputOutputHandler);
    public ITwitterPostScreen getTwitterPostScreen(IInputOutputHandler inputOutputHandler);
    public IUpdateTicketScreen getUpdateTicketScreen(IInputOutputHandler inputOutputHandler);
    public ICommentOnTicketScreen getCommentOnTicketScreen(IInputOutputHandler inputOutputHandler);
	public IExportEmployeePerformanceReport getExportEmployeePerformanceReport(IInputOutputHandler inputOutputHandler); 

}
