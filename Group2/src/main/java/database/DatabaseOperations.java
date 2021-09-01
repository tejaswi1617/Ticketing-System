//Author : Vamsi Krishna Utla

package database;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import database.intefaces.IDatabaseOperations;

public class DatabaseOperations implements IDatabaseOperations {

	public boolean executeCommand(CallableStatement procedureCall) throws Exception {
		boolean result;
		try {
			result = procedureCall.execute();
			return result;
		} catch (SQLException throwables) {
			throw new Exception("Failed during DB operations. Please contact admin.");
		}
	}

	public boolean executeUpdateCommand(CallableStatement procedureCall) throws Exception {
		boolean result;
		int updateResult;
		try {
			updateResult = procedureCall.executeUpdate();
			if (updateResult > 0) {
				result = true;
				return result;
			}
			result = false;
			return result;
		} catch (SQLException throwables) {
			throw new Exception("Failed during DB operations. Please contact admin.");
		}
	}

	public ResultSet executeQuery(CallableStatement procedureCall) throws Exception {
		try {
			return procedureCall.executeQuery();
		} catch (SQLException throwables) {
			throw new Exception("Failed during DB operations. Please contact admin.");
		}
	}
}
