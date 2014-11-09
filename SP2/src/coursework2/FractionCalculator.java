package coursework2;

import java.util.ArrayList;
import java.util.Scanner;

public class FractionCalculator
{	
	public static Fraction evaluate(Fraction frac, String inputString)
	{
		ArrayList<String> userInput = Helper.tokenizeInput(inputString,"/");
		int tokens = userInput.size();
		String operator = "";
		String modifier = "";
		Fraction tempFrac = null; 
		
		for (int i = 0; i < tokens; i++)
		{
			String temp = userInput.get(i);
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
					String[] tempFraction = temp.split("/");
					int num = Integer.parseInt(tempFraction[0]);
					int denom = Integer.parseInt(tempFraction[1]);
					tempFrac = new Fraction (num, denom);
				}
				else
				{
					int num = Integer.parseInt(temp);
					tempFrac = new Fraction(num);
				}
				
				if(operator == "")
				{
					frac = tempFrac;
					tempFrac = null;
				}
				else if (operator != "" && modifier == "")
				{									
					switch (operator)
					{
						case "*":	frac = frac.multiply(tempFrac);
									tempFrac = null;
									operator = "";
									break;
						case "/":	frac = frac.divide(tempFrac);
									tempFrac = null;
									operator = "";
									break;				          		  
						case "+":	frac = frac.add(tempFrac);
									tempFrac = null;
									operator = "";
									break;
						case "-":	frac = frac.subtract(tempFrac);
									tempFrac = null;
									operator = "";
									break;
					 }					
				}
				else if (modifier != "")
				{
					switch (modifier)
					{
						case "A":	frac = tempFrac.absValue();
									tempFrac = null;
									break;
						case "Abs": frac = tempFrac.absValue();
									tempFrac = null;
									break;
						case "a":	frac = tempFrac.absValue();
									tempFrac = null;
									break;
									
						case "C":	frac = new Fraction (0,1);
									tempFrac = null;
									break;
						case "Clear": frac = tempFrac.absValue();
									tempFrac = null;
									break;
						case "c":	frac = tempFrac.absValue();
									tempFrac = null;
									break;
									
						case "N":	frac = tempFrac.negate();
									tempFrac = null;
									break;
						case "Neg": frac = tempFrac.negate();
									tempFrac = null;
									break;
						case "n":	frac = tempFrac.negate();
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
				}
			}
		}
		
		return frac;
	}
	
	public static void main (String []args)
	{
		Scanner in = new Scanner(System.in);
		String userInput = "";
		boolean exit = false;
		boolean validInput = false;
		Fraction lastFraction = new Fraction (0,1);		
		
		do
		{
			System.out.println("Welcome to Renan Salviato's Fraction Calculator.");
			System.out.println();
			
			System.out.println("Current value in calculator: "+lastFraction.toString());
			System.out.println();
			
			while (!validInput)
			{
				System.out.println("Please input your calculation or type \"Q\" to quit: ");
		
				userInput = in.nextLine();
							
				userInput = Helper.removeDuplicateSpaces(userInput);
					
				if (!(Helper.isInputValid(userInput)))
				{
					System.out.println("Your input contains double operator, please try again.");
					System.out.println();
				}
				else
				{
					validInput = true;				
				}					
			}
							
			lastFraction = evaluate(lastFraction,userInput);
			
			if (lastFraction == null)
			{
				exit = true;
				System.out.println("Thank you for using my calculator.");
			}
			
			System.out.println(lastFraction.toString());
		} while (exit);
		
		in.close();
	}
}