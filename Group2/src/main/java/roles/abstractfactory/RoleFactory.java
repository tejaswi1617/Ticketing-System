//Author : Akshay Garg

package roles.abstractfactory;

import java.io.IOException;
import roles.MenuItemsByRole;
import roles.ModifyUserRole;
import roles.RoleManagementDao;
import roles.interfaces.IMenuItemsByRole;
import roles.interfaces.IModifyUserRole;

public class RoleFactory implements IRoleFactory {

	private static IRoleFactory uniqueInstance = null;

	private RoleFactory() {
	}

	public static IRoleFactory instance() {
		if (null == uniqueInstance) {
			uniqueInstance = new RoleFactory();
		}
		return uniqueInstance;
	}

	@Override
	public IModifyUserRole makeModifyUserRoleObject() throws IOException {
		RoleManagementDao roleManagementDao = new RoleManagementDao();
		return new ModifyUserRole(roleManagementDao);
	}

	@Override
	public IMenuItemsByRole makeMenuItemsByRoleObject() throws IOException {
		RoleManagementDao roleManagementDao = new RoleManagementDao();
		return new MenuItemsByRole(roleManagementDao);
	}
}
