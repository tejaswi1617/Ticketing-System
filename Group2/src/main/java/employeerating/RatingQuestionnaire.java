//Author : Vamsi Krishna Utla

package employeerating;

import static java.lang.Math.floor;
import employeerating.interfaces.*;

public class RatingQuestionnaire implements IRatingQuestionnaire
{
    protected int userSatisfactionRating;
    protected int userFeedbackRating;
    protected int userExperienceRating;
    protected int userRecommendationRating;

    public RatingQuestionnaire(int userSatisfactionRating, int userFeedbackRating, int userExperienceRating, int userRecommendationRating)
    {
        this.userSatisfactionRating = userSatisfactionRating;
        this.userFeedbackRating = userFeedbackRating;
        this.userExperienceRating = userExperienceRating;
        this.userRecommendationRating = userRecommendationRating;
    }

    public boolean checkRatingQuestionnaire()
    {
        int highestRating = 25;
        int lowestRating = 0;

        if(userExperienceRating <= highestRating && userExperienceRating >= lowestRating &&
           userFeedbackRating <= highestRating && userFeedbackRating >= lowestRating &&
           userRecommendationRating <= highestRating && userRecommendationRating >= lowestRating &&
           userSatisfactionRating <= highestRating && userSatisfactionRating >= lowestRating)
        {
            return true;
        }

        return false;
    }

    public int calculateRating()
    {
        int totalRating;

        totalRating = userExperienceRating + userFeedbackRating + userSatisfactionRating + userRecommendationRating;
        totalRating = (int)floor(totalRating/4);

        return totalRating;
    }
}
