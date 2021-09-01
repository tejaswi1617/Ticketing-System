//Author : Vamsi Krishna Utla

package employeerating.abstractfactory;

import java.io.IOException;

import employeerating.interfaces.*;

public interface IRatingFactory
{
    IRatingAssignee getRatingAssignee(IRatingQuestionnaire questionnaire) throws IOException;
    IRatingDao getPersistenceRating() throws IOException;
    IRatingQuestionnaire getRatingQuestionnaire(int userSatisfactionRating, int userFeedbackRating, int userExperienceRating, int userRecommendationRating);
}
