//Author : Vamsi Krishna Utla

package userinterface;

import login.Interfaces.IParameterizedUser;
import sncustomeranalysis.Interfaces.ICustomerAnalysis;
import sncustomeranalysis.abstractfactory.*;
import userinterface.abstractFactory.*;
import java.io.IOException;
import java.util.Map;

public class CustomerAnalysisScreen implements ICustomerAnalysisScreen
{
    private final ICustomerAnalysisFactory customerAnalysisFactory = CustomerAnalysisFactory.instance();
    private final IInputOutputHandler inputOutputHandler;
    private IUserInterfaceFactory userInterfaceFactory;
    private IBackToHomePageScreen backToHomePageScreen;

    public CustomerAnalysisScreen(IInputOutputHandler inputOutputHandler)
    {
        this.inputOutputHandler = inputOutputHandler;
    }

    public void displayCustomerAnalysisScreen(IParameterizedUser user)
    {
        String customerID;
        Map<String, String> outputResult;
        ICustomerAnalysis customerAnalysis = null;
        try
        {
            customerAnalysis = customerAnalysisFactory.getCustomerAnalysis();
        }
        catch (IOException e)
        {
            inputOutputHandler.displayMethod("Customer analysis process encountered an issue. Please contact system administrator.");
        }

        if(customerAnalysis == null)
        {
            userInterfaceFactory = UserInterfaceFactory.instance();
            backToHomePageScreen = userInterfaceFactory.getBackToHomePageScreen(inputOutputHandler);
            backToHomePageScreen.displayGoBackToHomePageOption(user);
            return;
        }

        inputOutputHandler.displayMethod("Enter customer ID:");
        customerID = inputOutputHandler.input();
        outputResult = customerAnalysis.getCustomerAnalysis(customerID);

        if(outputResult == null)
        {
            inputOutputHandler.displayMethod("No data found for "+customerID);
        }
        else
        {
            for(Map.Entry<String, String> outputRecord : outputResult.entrySet())
            {
                inputOutputHandler.displayMethod(outputRecord.getKey()+"\n"+outputRecord.getValue()+"\n");
            }
        }

        userInterfaceFactory = UserInterfaceFactory.instance();
        backToHomePageScreen = userInterfaceFactory.getBackToHomePageScreen(inputOutputHandler);
        backToHomePageScreen.displayGoBackToHomePageOption(user);
    }
}
