package coursework2;
import java.util.Arrays;

public class Helper
{

	//removing any consecutive white spaces from user input
	//the tip on using \s+ came from StackOverflow at
	//http://stackoverflow.com/questions/3958955/how-to-remove-duplicate-white-spaces-in-string-using-java
	public static String removeDuplicateSpaces(String userInput)
	{
		return userInput = userInput.replaceAll("\\s+", " ");
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
		if (token.contains("/"))
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
		else if (isInteger(token)) 
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
