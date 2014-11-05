package coursework2;

import java.util.Scanner;

public class FractionCalculator
{		
	/*public Fraction evaluate (Fraction input, String inputString)
	{
		
	}*/
	
	public static void main (String []args)
	{
		Scanner in = new Scanner(System.in);
		String exit = "";
		String lastValue = "0";
		String userInput = "";
		
		Fraction c = new Fraction(9,3);
				
		while (!(exit.equals("q")) && !(exit.equals("Q")))
			{
				System.out.println("Welcome to Renan Salviato's Fraction Calculator");
				System.out.println("The last remembered value is: "+lastValue);
				System.out.println("Please enter your expression to be evaluated: ");
				userInput = in.nextLine();
			}		
	}
}
