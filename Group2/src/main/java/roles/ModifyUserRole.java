//Author : Akshay Garg

package roles;

import org.apache.commons.lang3.StringUtils;
import roles.interfaces.IModifyUserRole;
import roles.interfaces.IRoleManagementDao;

public class ModifyUserRole implements IModifyUserRole {

	private IRoleManagementDao roleManagementDao;

	public ModifyUserRole(IRoleManagementDao roleManagementDao) {
		this.roleManagementDao = roleManagementDao;
	}

	@Override
	public boolean modifyUserRole(String empId, String userType) throws Exception {

		boolean isUserModified = false;

		if (StringUtils.isNotBlank(empId) && StringUtils.isNotBlank(userType)) {
			isUserModified = roleManagementDao.updateUserRole(empId, userType);
		}

		return isUserModified;
	}

}
