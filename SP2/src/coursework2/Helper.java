package coursework2;

public class Helper
{
	public static void main(String[] args)
	{
		System.out.println("hi");
	}

	public String removeDuplicateSpaces(String userInput)
	{
		//replacing any sequential white spaces from user input
		//the tip on using \s+ came from StackOverflow at
		//http://stackoverflow.com/questions/3958955/how-to-remove-duplicate-white-spaces-in-string-using-java
		return userInput = userInput.replaceAll("\\s+", " ");
	}
	
	public String isInputValid(String userInput)
	{							
		//checking that input doesn't contain double operator
		final String[] BAD_OPERATORS = {"* /","* -","* +","* *","/ *","/ -","/ +","/ /","- *","- /","- +","- -","+ *","+ /","+ -","+ +","*/","*-","*+","**","/*","/-","/+","//","-*","-/","-+","--","+*","+/","+-","++"};
		for (int i = 0; i < BAD_OPERATORS.length; i++)
		{			
				if (userInput.contains(BAD_OPERATORS[i]))
				{
					return "badinput";
				}
		}
		return userInput;							
		
	}
	
}
