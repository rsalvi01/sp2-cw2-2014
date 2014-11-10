package coursework2;

import java.util.Scanner;

public class FractionCalculator
{	
	public static Fraction evaluate(Fraction frac, String inputString)
	{		
		String[] userInput = inputString.split(" ");		
		int tokens = userInput.length;
		String operator = "";
		Fraction currentFrac = new Fraction(frac.getNumerator(),frac.getDenominator());
		Fraction tempFrac = new Fraction (0,1);		
		
		for (int i = 0; i < tokens; i++)
		{
			String temp = userInput[i];
			
			if (Helper.isOperator(temp))
			{				
				if (operator == "")
				{
					operator = temp;
				}
				else
				{
					System.out.println("Consecutive operators (*, /, + and -) are not accepted.");
					return tempFrac;				
				}
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
				
				if (operator == "") //if current token is a fraction and operator is blank, then current fraction replaces the previous known fraction
				{
					currentFrac = tempFrac;				
				}
				else //if operator is not blank
				{									
					switch (operator)
					{
						case "*":	currentFrac = currentFrac.multiply(tempFrac);
									tempFrac = null;
									break;
						case "/":	currentFrac = currentFrac.divide(tempFrac);
									tempFrac = null;
									break;				          		  
						case "+":	currentFrac = currentFrac.add(tempFrac);
									tempFrac = null;
									break;
						case "-":	currentFrac = currentFrac.subtract(tempFrac);
									tempFrac = null;
									break;
					}
					operator = ""; //clearing operator for next iteration
				}
			}
			else if (Helper.isModifier(temp))
			{				
				switch (temp)
				{
					case "A":	currentFrac = currentFrac.absValue();
								tempFrac = null;
								break;
					case "Abs": currentFrac = currentFrac.absValue();
								tempFrac = null;
								break;
					case "a":	currentFrac = currentFrac.absValue();
								tempFrac = null;
								break;
								
					case "C":	return currentFrac = new Fraction (0,1);
								
					case "Clear": return currentFrac = new Fraction (0,1);
								
					case "c":	return currentFrac = new Fraction (0,1);
								
								
					case "N":	currentFrac = currentFrac.negate();
								tempFrac = null;
								break;
					case "Neg": currentFrac = currentFrac.negate();
								tempFrac = null;
								break;
					case "n":	currentFrac = currentFrac.negate();
								tempFrac = null;
								break;
															
					case "Q":	return null;
					
					case "Quit": return null;
								
					case "q":	return null;								
								
				}
				operator = ""; //clearing operator for next iteration				
			}
			else
			{				
				System.out.println("I am sorry but there was an error in your input. Please try again.");
				System.out.println();
				return tempFrac;
			
			}//End of IF block
									
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
		Fraction lastFraction = new Fraction (-3,2);
		System.out.println("Welcome to Renan Salviato's Fraction Calculator.");
		System.out.println();
		
		while (!(lastFraction == null))
		{		
			System.out.println("Current value in calculator: "+lastFraction.toString());
			System.out.println();
			
			System.out.println("Please input your calculation or type \"Q\" to quit: ");
	
			userInput = in.nextLine();
			System.out.println();
			userInput = Helper.removeDuplicateSpaces(userInput);
			
			lastFraction = evaluate(lastFraction,userInput);
									
			if (lastFraction == null)
			{
				System.out.println("Thank you for using my calculator.");				
			}
			else
			{
				System.out.println("Evaluation = " + lastFraction.toString());
			}
		}
		
		in.close();
	}
}