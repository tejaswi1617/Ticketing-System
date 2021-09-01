package menucontroller.interfaces;

import login.Interfaces.IParameterizedUser;
import userinterface.IInputOutputHandler;

public interface IMenuTask {
	
	public void runMenuTask(IParameterizedUser user, IInputOutputHandler inputOutputHandler);
	
}
