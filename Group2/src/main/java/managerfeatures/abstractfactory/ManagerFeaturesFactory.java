package managerfeatures.abstractfactory;

import java.io.IOException;
import managerfeatures.ManagerFeaturesDao;
import managerfeatures.ManagerTeamTracking;
import managerfeatures.interfaces.IManagerFeaturesDao;
import managerfeatures.interfaces.IManagerTeamTracking;

public class ManagerFeaturesFactory implements IManagerFeaturesFactory {

	private static IManagerFeaturesFactory uniqueInstance = null;

	private ManagerFeaturesFactory() {
	}

	public static IManagerFeaturesFactory instance() {
		if (null == uniqueInstance) {
			uniqueInstance = new ManagerFeaturesFactory();
		}
		return uniqueInstance;
	}

	@Override
	public IManagerTeamTracking makeManagerFeaturesFactoryObject() throws IOException {
		IManagerFeaturesDao managerFeaturesDao = new ManagerFeaturesDao();
		return new ManagerTeamTracking(managerFeaturesDao);
	}
}
