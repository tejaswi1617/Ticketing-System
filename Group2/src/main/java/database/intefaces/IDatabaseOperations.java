//Author : Vamsi Krishna Utla

package database.intefaces;
import java.sql.CallableStatement;
import java.sql.ResultSet;
public interface IDatabaseOperations
{
    boolean executeCommand(CallableStatement procedureCall) throws Exception;
    boolean executeUpdateCommand(CallableStatement procedureCall) throws Exception;
    ResultSet executeQuery(CallableStatement procedureCall) throws Exception;
}
