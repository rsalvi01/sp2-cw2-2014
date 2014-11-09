package coursework2;

import java.util.ArrayList;
import java.util.Scanner;
public class FractionCalculator
{
	/*public Fraction evaluate (Fraction input, String inputString)
	{
	}*/
	public static void main (String []args)
	{
		Scanner in = new Scanner(System.in);
		String lastOperator = ""; // operators can be *, /, +, -
		String lastModifier = "0"; // modifiers can be (A, a, Abs), (Q, q, quit), (C, c, Clear) and (N, n, neg) 
		Fraction lastFraction = new Fraction (0,1);
		String newFraction = "";
		String userInput = ""; 
		boolean exit = false;
		boolean error = false;
		ArrayList<String> tokenizedInput = new ArrayList<String>( );
		
		while (!exit)
		System.out.println("Please input your calculation: ");
		userInput = in.nextLine();
		
		userInput = Helper.removeDuplicateSpaces(userInput);
		
		if (!(Helper.isInputValid(userInput)))
		{
			System.out.println("Your input contains double operator, please start again.");
		}
		else
		{		
			tokenizedInput = Helper.tokenizeInput(userInput," ");
			int tokenLength = tokenizedInput.size();
			
			for (int i = 0; i < tokenLength; i++)
			{
				if (Helper.isOperator(tokenizedInput.get(0)))
				{
					lastOperator = tokenizedInput.get(0);
				}
				else if (Helper.isModifier(tokenizedInput.get(0)))
				{
					lastModifier = tokenizedInput.get(0);
				}
				else if (Helper.isFraction(tokenizedInput.get(0)))
				{
					newFraction = tokenizedInput.get(0);
				}
				else
				{
					error = true;
				}				
				
			}
			
			
						
		
		/*while (!(exit.equals("q")) && !(exit.equals("Q")))
		{
			System.out.println("Welcome to Renan Salviato's Fraction Calculator");
			System.out.println("The last remembered value is: "+lastValue);
			System.out.println("Please enter your expression to be evaluated: ");
			userInput = in.nextLine();
		}*/
		
		
		
	}
}
}