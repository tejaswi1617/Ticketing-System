//Author : Vamsi Krishna Utla

package employeerating.interfaces;

public interface IRatingDao
{
    public String getPersistenceCreatorID(String ticketID);
    public boolean insertRating(String ticketID, int rating);
}
