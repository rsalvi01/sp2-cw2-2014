package coursework2;

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
		if(token == "*" || token == "/" || token == "+" || token == "-")
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public static boolean isModifier(String token)
	{
		String[] modifiers = {"A","a","Abs","Q","q","Quit","C","c","Clear","N","n","Neg"};
		int count = modifiers.length;
		
		for (int i = 0; i < count; i++)
		{
			if (modifiers[i] == token)
			{
				return true;
			}						
		}
		return false;
		
	}

	public static boolean isFraction(String token)
	{
		if (token.contains("/") && token.length()>1)
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
