//Author : Vamsi Krishna Utla

package employeerating.abstractfactory;

import employeerating.PersistenceRatingMock;
import employeerating.RatingAssigneeFacade;
import employeerating.RatingQuestionnaire;
import employeerating.interfaces.*;

public class RatingFactoryTest implements IRatingFactoryTest
{
    private static IRatingFactoryTest uniqueInstance = null;

    private RatingFactoryTest()
    {

    }

    public static IRatingFactoryTest instance()
    {
        if(null == uniqueInstance)
        {
            uniqueInstance = new RatingFactoryTest();
        }
        return uniqueInstance;
    }

    public IRatingAssignee getRatingAssignee(IRatingQuestionnaire questionnaire)
    {
        IRatingDao persistenceRatingMock = getPersistenceRatingMock();
        return new RatingAssigneeFacade(questionnaire, persistenceRatingMock);
    }

    public IRatingDao getPersistenceRatingMock()
    {
        return new PersistenceRatingMock();
    }

    public IRatingQuestionnaire getRatingQuestionnaire(int userSatisfactionRating, int userFeedbackRating, int userExperienceRating, int userRecommendationRating)
    {
        return new RatingQuestionnaire(userSatisfactionRating, userFeedbackRating, userExperienceRating, userRecommendationRating);
    }
}