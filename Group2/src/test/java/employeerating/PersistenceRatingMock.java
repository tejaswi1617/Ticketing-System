//Author : Vamsi Krishna Utla

package employeerating;

import employeerating.interfaces.IRatingDao;

public class PersistenceRatingMock implements IRatingDao
{
    public String getPersistenceCreatorID(String ticketID)
    {
        String creatorID = "USER123";
        return creatorID;
    }

    public boolean insertRating(String ticketID, int rating)
    {
        return true;
    }
}
