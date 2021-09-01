//Author : Akshay Garg

package roles.abstractfactory;

import roles.MenuItemsByRole;
import roles.ModifyUserRole;
import roles.RoleManagementDaoMock;
import roles.interfaces.IMenuItemsByRole;
import roles.interfaces.IModifyUserRole;
import roles.interfaces.IRoleManagementDao;

public class RoleMockFactory implements IRoleFactory {

	private static IRoleFactory uniqueInstance = null;

	private RoleMockFactory() {
	}

	public static IRoleFactory instance() {
		if (null == uniqueInstance) {
			uniqueInstance = new RoleMockFactory();
		}
		return uniqueInstance;
	}

	@Override
	public IModifyUserRole makeModifyUserRoleObject() {
		IRoleManagementDao roleManagementDao = new RoleManagementDaoMock();
		return new ModifyUserRole(roleManagementDao);
	}

	@Override
	public IMenuItemsByRole makeMenuItemsByRoleObject() {
		IRoleManagementDao roleManagementDao = new RoleManagementDaoMock();
		return new MenuItemsByRole(roleManagementDao);
	}
}
