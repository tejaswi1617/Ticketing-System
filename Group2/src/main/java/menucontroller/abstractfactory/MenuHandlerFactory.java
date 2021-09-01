package menucontroller.abstractfactory;

import menucontroller.MenuHandler;
import menucontroller.interfaces.IMenuHandler;

public class MenuHandlerFactory implements IMenuHandlerFactory {

	public final String FILE_ATTACHMENT = "File";

	private static IMenuHandlerFactory uniqueInstance = null;

	private MenuHandlerFactory() {
	}

	public static IMenuHandlerFactory instance() {
		if (null == uniqueInstance) {
			uniqueInstance = new MenuHandlerFactory();
		}
		return uniqueInstance;
	}

	@Override
	public IMenuHandler makeMenuHandlerObject() {
		return new MenuHandler();
	}
}
