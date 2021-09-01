package managerfeatures.abstractfactory;

import managerfeatures.ManagerFeaturesDaoMock;
import managerfeatures.ManagerTeamTracking;
import managerfeatures.interfaces.IManagerFeaturesDao;
import managerfeatures.interfaces.IManagerTeamTracking;

public class ManagerFeaturesMockFactory implements IManagerFeaturesFactory {

	private static IManagerFeaturesFactory uniqueInstance = null;

	private ManagerFeaturesMockFactory() {
	}

	public static IManagerFeaturesFactory instance() {
		if (null == uniqueInstance) {
			uniqueInstance = new ManagerFeaturesMockFactory();
		}
		return uniqueInstance;
	}

	@Override
	public IManagerTeamTracking makeManagerFeaturesFactoryObject() {
		IManagerFeaturesDao managerFeaturesDao = new ManagerFeaturesDaoMock();
		return new ManagerTeamTracking(managerFeaturesDao);
	}
}
