//Author : Vamsi Krishna Utla

package userinterface;

import employeeMilestones.abstractfactory.*;
import employeeMilestones.interfaces.IEmployeeMilestone;
import login.Interfaces.IParameterizedUser;
import userinterface.abstractFactory.IUserInterfaceFactory;
import userinterface.abstractFactory.UserInterfaceFactory;
import java.io.IOException;
import java.util.Map;

public class EmployeeMilestoneScreen implements IEmployeeMilestoneScreen
{
    private final IInputOutputHandler inputOutputHandler;
    private IUserInterfaceFactory userInterfaceFactory;
    private IBackToHomePageScreen backToHomePageScreen;
    private final IEmployeeMilestoneFactory employeeMilestoneFactory = EmployeeMilestoneFactory.instance();

    public  EmployeeMilestoneScreen(IInputOutputHandler inputOutputHandler)
    {
        this.inputOutputHandler = inputOutputHandler;
    }

    public void displayEmployeeMileStoneScreen(IParameterizedUser user)
    {
        String employeeID;
        Map<String, String> output;
        IEmployeeMilestone employeeMilestone = null;

        inputOutputHandler.displayMethod("Enter employee ID:\n");
        employeeID = inputOutputHandler.input();
        try
        {
            employeeMilestone = employeeMilestoneFactory.getEmployeeMilestone();
        }
        catch (IOException e)
        {
            inputOutputHandler.displayMethod("Employee milestone encountered an issue. Please contact system administrator.");
        }

        if(employeeMilestone == null)
        {
            userInterfaceFactory = UserInterfaceFactory.instance();
            backToHomePageScreen = userInterfaceFactory.getBackToHomePageScreen(inputOutputHandler);
            backToHomePageScreen.displayGoBackToHomePageOption(user);
            return;
        }

        output = employeeMilestone.getEmployeeMilestone(employeeID);

        if (output == null)
        {
            inputOutputHandler.displayMethod("No data found for " + employeeID+"\n");
        }
        else
        {
            for(Map.Entry<String, String> outputRecord : output.entrySet())
            {
                inputOutputHandler.displayMethod(outputRecord.getKey() +"\n"+outputRecord.getValue()+"\n");
            }
            inputOutputHandler.displayMethod("\n");
        }

        userInterfaceFactory = UserInterfaceFactory.instance();
        backToHomePageScreen = userInterfaceFactory.getBackToHomePageScreen(inputOutputHandler);
        backToHomePageScreen.displayGoBackToHomePageOption(user);
    }
}
