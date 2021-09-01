//Author : Vamsi Krishna Utla

package employeerating.abstractfactory;

import employeerating.interfaces.IRatingDao;
import employeerating.interfaces.IRatingAssignee;
import employeerating.interfaces.IRatingQuestionnaire;

public interface IRatingFactoryTest
{
    IRatingAssignee getRatingAssignee(IRatingQuestionnaire questionnaire);
    IRatingDao getPersistenceRatingMock();
    IRatingQuestionnaire getRatingQuestionnaire(int userSatisfactionRating, int userFeedbackRating, int userExperienceRating, int userRecommendationRating);
}
