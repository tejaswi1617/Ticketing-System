//Author : Akshay Garg, Vamsi Krishna Utla, Janvi Patel, Tejaswi Chaudhary

package userinterface.abstractFactory;

import userinterface.BackToHomePageOption;
import userinterface.CommentOnTicketScreen;
import userinterface.CustomerAnalysisScreen;
import userinterface.DeleteTicketScreen;
import userinterface.EmployeeMilestoneScreen;
import userinterface.EmployeePerformanceScreen;
import userinterface.ExportEmployeePerformanceReport;
import userinterface.ForgotPasswordScreen;
import userinterface.GenerateTicketScreen;
import userinterface.HomePageScreen;
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
import userinterface.InputOutputHandler;
import userinterface.LoginScreen;
import userinterface.ManagerTeamTrackingScreen;
import userinterface.ModifyUserRoleScreen;
import userinterface.RatingScreen;
import userinterface.RegistrationScreen;
import userinterface.SearchTicketScreen;
import userinterface.ServiceNowWelcomeScreen;
import userinterface.SortTicketScreen;
import userinterface.TwitterPostScreen;
import userinterface.UpdateTicketScreen;

public class UserInterfaceFactory implements IUserInterfaceFactory
{
	private static IUserInterfaceFactory uniqueInstance = null;
	
	public UserInterfaceFactory() {
	}
	
	public static IUserInterfaceFactory instance() {
		if(null == uniqueInstance) {
			uniqueInstance = new UserInterfaceFactory();
		}
		return uniqueInstance;
	}
	
	public IServiceNowWelcomeScreen getServiceNowWelcomeScreen(IInputOutputHandler inputOutputHandler)
	{
	        return new ServiceNowWelcomeScreen(inputOutputHandler);
	}

    public IInputOutputHandler getInputOutputHandler()
    {
        return new InputOutputHandler();
    }

    public ILoginScreen getLoginScreen(IInputOutputHandler inputOutputHandler)
    {
        return new LoginScreen(inputOutputHandler);
    }

    public IRegistrationScreen getRegistrationScreen(IInputOutputHandler inputOutputHandler)
    {
        return new RegistrationScreen(inputOutputHandler);
    }

    public IForgotPasswordScreen getForgotPasswordScreen(IInputOutputHandler inputOutputHandler)
    {
        return new ForgotPasswordScreen(inputOutputHandler);
    }
    
    public IBackToHomePageScreen getBackToHomePageScreen(IInputOutputHandler inputOutputHandler)
    {
    	return new BackToHomePageOption(inputOutputHandler);
    }
    
    public IModifyUserRoleScreen getModifyUserRoleScreen(IInputOutputHandler inputOutputHandler)
    {
        return new ModifyUserRoleScreen(inputOutputHandler);
    }
    
    public IManagerTeamTrackingScreen getmangerTeamTrackingScreen(IInputOutputHandler inputOutputHandler)
    {
        return new ManagerTeamTrackingScreen(inputOutputHandler);
    }
    
    public IHomePageScreen getHomePageScreen(IInputOutputHandler inputOutputHandler)
    {
        return new HomePageScreen(inputOutputHandler);
    }

    public IRatingScreen getRatingScreen(IInputOutputHandler inputOutputHandler)
    {
        return new RatingScreen(inputOutputHandler);
    }

    public ICustomerAnalysisScreen getCustomerAnalysisScreen(IInputOutputHandler inputOutputHandler)
    {
        return new CustomerAnalysisScreen(inputOutputHandler);
    }

    public IEmployeeMilestoneScreen getEmployeeMilestoneScreen(IInputOutputHandler inputOutputHandler)
    {
        return new EmployeeMilestoneScreen(inputOutputHandler);
    }
    
    public IGenerateTicketScreen getGenerateTicketScreen(IInputOutputHandler inputOutputHandler)
    {
        return new GenerateTicketScreen(inputOutputHandler);
    }
    public IEmployeePerformanceScreen getEmployeePerformanceScreen(IInputOutputHandler inputOutputHandler)
    {
        return new EmployeePerformanceScreen(inputOutputHandler);
    }
    
    public ISearchTicketScreen getsearchTicketScreen(IInputOutputHandler inputOutputHandler)
    {
        return new SearchTicketScreen(inputOutputHandler);
    }
    
    public ISortTciketScreen getsortTicketScreen(IInputOutputHandler inputOutputHandler)
    {
        return new SortTicketScreen(inputOutputHandler);
    }

    public IDeleteTicketScreen getdeleteTicketScreen(IInputOutputHandler inputOutputHandler)
    {
        return new DeleteTicketScreen(inputOutputHandler);
    }
    
    public ITwitterPostScreen getTwitterPostScreen(IInputOutputHandler inputOutputHandler)
    {
        return new TwitterPostScreen(inputOutputHandler);
    }
    
    public IUpdateTicketScreen getUpdateTicketScreen(IInputOutputHandler inputOutputHandler) 
    {
        return new UpdateTicketScreen(inputOutputHandler);
    }

    public ICommentOnTicketScreen getCommentOnTicketScreen(IInputOutputHandler inputOutputHandler)
    {
        return new CommentOnTicketScreen(inputOutputHandler);
    }

	@Override
	public IExportEmployeePerformanceReport getExportEmployeePerformanceReport(IInputOutputHandler inputOutputHandler) {
		// TODO Auto-generated method stub
		return new ExportEmployeePerformanceReport(inputOutputHandler);
	}

}
