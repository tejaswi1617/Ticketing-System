//Author : Akshay Garg

package roles.abstractfactory;

import java.io.IOException;
import roles.interfaces.IMenuItemsByRole;
import roles.interfaces.IModifyUserRole;

public interface IRoleFactory {

	IMenuItemsByRole makeMenuItemsByRoleObject() throws IOException;

	IModifyUserRole makeModifyUserRoleObject() throws IOException;

}