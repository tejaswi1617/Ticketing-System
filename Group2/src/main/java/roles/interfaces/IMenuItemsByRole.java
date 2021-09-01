//Author : Akshay Garg

package roles.interfaces;

import java.util.List;

public interface IMenuItemsByRole {

	public List<String> fetchMenuItemsByRole(String userType) throws Exception;

}
