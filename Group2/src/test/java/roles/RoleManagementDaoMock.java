//Author : Akshay Garg

package roles;

import java.util.ArrayList;
import java.util.List;
import roles.interfaces.IRoleManagementDao;
import validations.StringValidations;

public class RoleManagementDaoMock implements IRoleManagementDao {

	private final String USER_TYPE = "End_User";
	private final String EMP_ID = "E101";
	private final String CREATE_TICKET = "Create ticket";
	private final String UPDATE_TICKET = "Update ticket";
	private final String REOPEN = "Reopen the closed ticket";
	private final String SEARCH_TICKETS = "Search tickets";
	private final String RATING_FEATURE = "Rating feature";

	@Override
	public List<String> accessMenuItemsByRole(String role) {

		List<String> menuItemsList = null;
		if (StringValidations.isStringValid(role) && role.trim().equalsIgnoreCase(USER_TYPE)) {
			menuItemsList = new ArrayList<String>();
			menuItemsList.add(CREATE_TICKET);
			menuItemsList.add(UPDATE_TICKET);
			menuItemsList.add(REOPEN);
			menuItemsList.add(SEARCH_TICKETS);
			menuItemsList.add(RATING_FEATURE);
			return menuItemsList;
		}
		return menuItemsList;
	}

	@Override
	public boolean updateUserRole(String empId, String role) {
		boolean isUserUpadted = false;

		if (StringValidations.isStringValid(empId) && StringValidations.isStringValid(role)) {
			if (empId.trim().equalsIgnoreCase(EMP_ID) && role.trim().equalsIgnoreCase(USER_TYPE)) {
				isUserUpadted = true;
				return isUserUpadted;
			}
		}

		return isUserUpadted;
	}

}
