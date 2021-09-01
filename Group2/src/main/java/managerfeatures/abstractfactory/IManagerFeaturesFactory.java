package managerfeatures.abstractfactory;

import java.io.IOException;
import managerfeatures.interfaces.IManagerTeamTracking;

public interface IManagerFeaturesFactory {

	IManagerTeamTracking makeManagerFeaturesFactoryObject() throws IOException;

}