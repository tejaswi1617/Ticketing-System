package menucontroller.interfaces;

import login.Interfaces.IParameterizedUser;
import menucontroller.MenuHandler.Menu;
import userinterface.IInputOutputHandler;

public interface IMenuHandler {

	void runMenuTask(Menu menuTaskName, IParameterizedUser user, IInputOutputHandler inputOutputHandler);

}