package coursework2;

public class FractionCalculator
{
	char bo; //basic operators to be remembered: (*) (/) (+) (-)
	char oo; //other operations: (A) or (a) absolute value, (N) or (n) negate and (Q) or (q) quit
	
	public String validateInput(String inputString)
	{
		final String[] BAD_OPERATORS = {"* /","* -","* +","* *","/ *","/ -","/ +","/ /","- *","- /","- +","- -","+ *","+ /","+ -","+ +"};
		boolean error = false;
		
		//replacing any double white spaces
		//tip on using \s+ came from
		//http://stackoverflow.com/questions/3958955/how-to-remove-duplicate-white-spaces-in-string-using-java
		inputString = inputString.replaceAll("\\s+", " ");
				
		//checking that input doesn't contain double operator
		for (int i = 0; i < BAD_OPERATORS.length; i++)
		{
			if (error == false)
			{
				if (inputString.contains(BAD_OPERATORS[i]))
				{
					error = true;
				}
			}
		}		
		
		if (error)
		{
			return "BadInput";
		}
		else
		{
			return inputString;		
		}
	}
	
	public Fraction evaluate (Fraction input, String inputString)
	{	
		String[] userInputs;
		
		boolean proceed = true;
		
		if (validateInput(inputString).equals("BadInput"))
		{
			proceed = false;			
		}
		
		if (!proceed)
		{
			System.out.print("The input your entered contains double operators (e.g.: the times symbol (*)");
			System.out.println("followed by the addition symbol (+). Please try again.");
			return null;
		}
		else
		{
			//splitting user input into an array				
			userInputs = inputString.split(" ");
		}		
		
		/*for (int i = 0; i < userInputs.length; i++)
		{
			if(userInputs[0])
		}*/
		
		return null;
	}
}