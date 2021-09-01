package insertTicket;

import insertTicket.Interfaces.IInputRangeValidation;
import userinterface.IInputOutputHandler;

public class InputRangeValidation implements IInputRangeValidation 
{
	IInputOutputHandler inputOutputHandler;
	public InputRangeValidation (IInputOutputHandler inputOutputHandler)
	{
		this.inputOutputHandler = inputOutputHandler;
	}
	public boolean isRangeValid (int inputValue)  
	{
		if(inputValue>0 && inputValue<6)
		{
			return true;
		}
		inputOutputHandler.displayMethod("Range for inputted string priority, impact and urgency is 1-5");
		return false;
	}
}
