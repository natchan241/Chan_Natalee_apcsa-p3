//(c) A+ Computer Science
//www.apluscompsci.com

//Name: Natalee Chan
//Date: February 6, 2019
//Class: APCSA
//Lab: Odd or Even String

import static java.lang.System.*;
import java.util.Scanner;

public class StringRunner
{
	public static void main ( String[] args )
	{
		Scanner keyboard = new Scanner(in);
		
		out.print("Enter a word :: ");
		String s = keyboard.nextLine();
		
		StringOddOrEven run = new StringOddOrEven(s);
		run.isEven();
		out.println(run.toString());
	}
}