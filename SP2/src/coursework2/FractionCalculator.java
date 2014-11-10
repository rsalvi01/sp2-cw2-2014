package coursework2;

import java.util.Scanner;

public class FractionCalculator
{	
	public static Fraction evaluate(Fraction frac, String inputString)
	{
		String[] userInput = inputString.split(" ");
		int tokens = userInput.length;
		String operator = "";
		String modifier = "";
		Fraction tempFrac = null;		
		
		for (int i = 0; i < tokens; i++)
		{
			String temp = userInput[i];
			
			//
			//First IF block to analyse current token
			//
			
			if (Helper.isOperator(temp))
			{
				if (operator == "")
				{
					operator = temp;
				}
				else
				{
					System.out.println("Consecutive operators (*, /, + and -) are not accepted.");
					frac = new Fraction (0,1);
					i = tokens;
				}
			}
			else if (Helper.isModifier(temp))
			{
				modifier = temp;
			}
			else if (Helper.isFraction(temp))
			{
				if(temp.contains("/"))
				{
					String[] tempString = temp.split("/");
					int num = Integer.parseInt(tempString[0]);
					int denom = Integer.parseInt(tempString[1]);
					tempFrac = new Fraction (num, denom);
				}
				else
				{
					int num = Integer.parseInt(temp);
					tempFrac = new Fraction(num);
				}
			}
			else
			{				
				System.out.println("I am sorry but there was an error in your input. Please try again.");
				return tempFrac;
			}
			//End of first IF block
			
			
			//
			//Second IF Block
			//
							
			//if current token is a modifier, it needs to be applied to the last known fraction, ignoring any operator remembered.
			if (modifier != "")
			{
				switch (modifier)
				{
					case "A":	frac = frac.absValue();
								tempFrac = null;
								break;
					case "Abs": frac = frac.absValue();
								tempFrac = null;
								break;
					case "a":	frac = frac.absValue();
								tempFrac = null;
								break;
								
					case "C":	frac = new Fraction (0,1);
								tempFrac = null;
								break;
					case "Clear": frac = new Fraction (0,1);
								tempFrac = null;
								break;
					case "c":	frac = new Fraction (0,1);
								tempFrac = null;
								break;
								
					case "N":	frac = frac.negate();
								tempFrac = null;
								break;
					case "Neg": frac = frac.negate();
								tempFrac = null;
								break;
					case "n":	frac = frac.negate();
								tempFrac = null;
								break;
					case "Q":	frac = null;
								tempFrac = null;
								break;
					case "Quit": frac = null;
								tempFrac = null;
								break;
					case "q":	frac = null;
								tempFrac = null;
								break;
				}
				modifier = ""; //clearing modifier for next iteration
			}			
			//if current token is a fraction
			else if (operator == "") //and operator is blank, then current fraction replaces the previous known fraction
			{
				frac = tempFrac;				
			}
			else //if operator is not blank
			{									
				switch (operator)
				{
					case "*":	frac = frac.multiply(tempFrac);
								tempFrac = null;
								break;
					case "/":	frac = frac.divide(tempFrac);
								tempFrac = null;
								break;				          		  
					case "+":	frac = frac.add(tempFrac);
								tempFrac = null;
								break;
					case "-":	frac = frac.subtract(tempFrac);
								tempFrac = null;
								break;
				}				
			}			
		}//End of For loop
		return frac;
	}//End of Class
		
		
	
	
	//
	//MAIN METHOD
	//
	public static void main (String []args)
	{
		Scanner in = new Scanner(System.in);
		String userInput = "";		
		Fraction lastFraction = new Fraction (0,1);		
		
		System.out.println("Welcome to Renan Salviato's Fraction Calculator.");
		System.out.println();
		
		System.out.println("Current value in calculator: "+lastFraction.toString());
		System.out.println();
		
		System.out.println("Please input your calculation or type \"Q\" to quit: ");

		userInput = in.nextLine();
					
		userInput = Helper.removeDuplicateSpaces(userInput);
		
		lastFraction = evaluate(lastFraction,userInput);
		
		
		
		in.close();
	}
}