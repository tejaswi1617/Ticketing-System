//Author : Vamsi Krishna Utla

package employeerating;

import employeerating.abstractfactory.*;
import employeerating.interfaces.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class RatingAssigneeFacadeTest {

    IRatingFactory ratingFactory;
    IRatingFactoryTest ratingFactoryTest;

    @Before
    public void intialize()
    {
        ratingFactory =  RatingFactory.instance();
        ratingFactoryTest = RatingFactoryTest.instance();
    }
    @Test
    public void provideRatingTest()
    {
        IRatingQuestionnaire questionnaire = ratingFactory.getRatingQuestionnaire(20, 20, 20, 20);
        IRatingAssignee ratingAssignee = ratingFactoryTest.getRatingAssignee(questionnaire);
        assertTrue("Rating assignee test failed.", ratingAssignee.provideRating("USER123", "DEMO123"));
    }
}