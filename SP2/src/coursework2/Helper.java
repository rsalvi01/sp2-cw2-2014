package coursework2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Helper {

	public static String removeDuplicateSpaces(String userInput)
	{
		//replacing any sequential white spaces from user input
		//the tip on using \s+ came from StackOverflow at
		//http://stackoverflow.com/questions/3958955/how-to-remove-duplicate-white-spaces-in-string-using-java
		return userInput = userInput.replaceAll("\\s+", " ");
	}

	public static boolean isInputValid(String userInput)
	{
		//checking that input doesn't contain double operator
		final String[] BAD_OPERATORS = {"* /","* -","* +","* *","/ *","/ -","/ +","/ /","- *","- /","- +","- -","+ *","+ /","+ -","+ +","*/","*-","*+","**","/*","/-","/+","//","-*","-/","-+","--","+*","+/","+-","++"};
		for (int i = 0; i < BAD_OPERATORS.length; i++)
		{
			if (userInput.contains(BAD_OPERATORS[i]))
			{
				return false;
			}
		}
		return true;
	}

	public static ArrayList<String> tokenizeInput(String userInput, String delimiter)
	{
		ArrayList<String> listTest = new ArrayList<String>( );
		StringTokenizer st = new StringTokenizer(userInput, delimiter);

		while (st.hasMoreTokens())
		{
			listTest.add(st.nextToken());
		}

		return listTest;		
	}

	public static boolean isOperator(String token)
	{
		String[] operators = {"*","/","+","-"};
		return Arrays.asList(operators).contains(token);		
	}

	public static boolean isModifier(String token)
	{
		String[] modifiers = {"A","a","Abs","Q","q","quit","C","c","Clear","N","n","neg"};
		return Arrays.asList(modifiers).contains(token);		
	}

	public static boolean isFraction(String token)
	{
		String[] check = token.split("/");

		if (isInteger(check[0]) && isInteger(check[1]))
		{
			return true;
		}
		else
		{
			return false;
		}		
	}

	public static boolean isInteger(String input)  
	{  
		try  
		{  
			Integer.parseInt( input );  
			return true;  
		}  
		catch (Exception e)  
		{  
			return false;  
		}  
	}
}
