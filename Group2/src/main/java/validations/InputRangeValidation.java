package validations;

public class InputRangeValidation implements IInputRangeValidation {

	public boolean isRangeValid (int inputValue)  {

		System.out.print("Input value" +inputValue);

		if(inputValue>0 && inputValue<6)
		{
			return true;
		}
		System.out.print("Range for inputted string priority, impact and urgency is 1-5");
		return false;
	}
}
