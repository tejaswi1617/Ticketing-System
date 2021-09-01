//Author : Vamsi Krishna Utla

package employeerating.abstractfactory;

import employeerating.*;
import employeerating.interfaces.*;
import java.io.IOException;

public class RatingFactory implements IRatingFactory
{
    private static IRatingFactory uniqueInstance = null;

    private RatingFactory()
    {

    }

    public static IRatingFactory instance()
    {
        if(null == uniqueInstance)
        {
            uniqueInstance = new RatingFactory();
        }
        return uniqueInstance;
    }

    public IRatingAssignee getRatingAssignee(IRatingQuestionnaire questionnaire) throws IOException
    {
        IRatingDao persistenceRating = getPersistenceRating();
        return new RatingAssigneeFacade(questionnaire, persistenceRating);
    }

    public IRatingDao getPersistenceRating() throws IOException
    {
        return new RatingDao();
    }

    public IRatingQuestionnaire getRatingQuestionnaire(int userSatisfactionRating, int userFeedbackRating, int userExperienceRating, int userRecommendationRating)
    {
        return new RatingQuestionnaire(userSatisfactionRating, userFeedbackRating, userExperienceRating, userRecommendationRating);
    }
}