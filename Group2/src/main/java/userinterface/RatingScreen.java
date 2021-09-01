//Author : Vamsi Krishna Utla

package userinterface;

import employeerating.abstractfactory.*;
import employeerating.interfaces.*;
import login.Interfaces.IParameterizedUser;
import userinterface.abstractFactory.*;
import java.io.IOException;

public class RatingScreen implements IRatingScreen
{
    private final IInputOutputHandler inputOutputHandler;
    private final IRatingFactory ratingFactory;
    private IUserInterfaceFactory userInterfaceFactory;
    private IBackToHomePageScreen backToHomePageScreen;

    public RatingScreen(IInputOutputHandler inputOutputHandler)
    {
        this.inputOutputHandler = inputOutputHandler;
        ratingFactory = RatingFactory.instance();
        userInterfaceFactory = UserInterfaceFactory.instance();
    }

    public void displayRatingScreen(IParameterizedUser user)
    {
        String ticketID;
        String employeeID;
        int userSatisfactionRating;
        int userFeedbackRating;
        int userExperienceRating;
        int userRecommendationRating;
        IRatingDao persistenceRating;
        IRatingQuestionnaire ratingQuestionnaire;
        IRatingAssignee ratingAssignee = null;

        inputOutputHandler.displayMethod("Enter ticket ID to provide rating:\n");
        ticketID = inputOutputHandler.input();

        inputOutputHandler.displayMethod("Enter user satisfaction rating (Hint: values allowed -> 0-25)\n");
        userSatisfactionRating = inputOutputHandler.inputInt();

        inputOutputHandler.displayMethod("Enter user feedback rating (Hint: values allowed -> 0-25)\n");
        userFeedbackRating = inputOutputHandler.inputInt();

        inputOutputHandler.displayMethod("Enter user experience rating (Hint: values allowed -> 0-25)\n");
        userExperienceRating = inputOutputHandler.inputInt();

        inputOutputHandler.displayMethod("Enter user recommendation rating (Hint: values allowed -> 0-25)\n");
        userRecommendationRating = inputOutputHandler.inputInt();

        ratingQuestionnaire = ratingFactory.getRatingQuestionnaire(userSatisfactionRating, userFeedbackRating, userExperienceRating, userRecommendationRating);
        try
        {
            ratingAssignee = ratingFactory.getRatingAssignee(ratingQuestionnaire);
        }
        catch (IOException e)
        {
            inputOutputHandler.displayMethod("Rating process encountered an issue. Please contact system administrator.");
        }

        if(ratingAssignee == null)
        {
            backToHomePageScreen = userInterfaceFactory.getBackToHomePageScreen(inputOutputHandler);
            backToHomePageScreen.displayGoBackToHomePageOption(user);
            return;
        }

        employeeID = user.getEmployeeID();
        if(ratingAssignee.provideRating(employeeID, ticketID))
        {
            inputOutputHandler.displayMethod("Rating has been provided successfully.\n");
        }
        else
        {
            inputOutputHandler.displayMethod("Rating was not provided to the given ticket. Please check the information and try again.\n");
        }

        backToHomePageScreen = userInterfaceFactory.getBackToHomePageScreen(inputOutputHandler);
        backToHomePageScreen.displayGoBackToHomePageOption(user);
    }
}
