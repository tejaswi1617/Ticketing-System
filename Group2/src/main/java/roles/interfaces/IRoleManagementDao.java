//Author : Akshay Garg

package roles.interfaces;

import java.util.List;

public interface IRoleManagementDao {

	List<String> accessMenuItemsByRole(String role) throws Exception;

	boolean updateUserRole(String empId, String role) throws Exception;
}
