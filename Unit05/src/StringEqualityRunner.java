//(c) A+ Computer Science
//www.apluscompsci.com

//Name: Natalee Chan
//Date: February 7, 2019
//Class: APCSA
//Lab: String Equality

import static java.lang.System.*;

import java.util.Scanner;

public class StringEqualityRunner
{
	public static void main( String args[] )
	{
		Scanner keyboard = new Scanner(in);
		
		out.print("Enter a word :: ");
		String one = keyboard.nextLine();

		out.print("Enter the next word :: ");
		String two = keyboard.nextLine();
		
		StringEquality test = new StringEquality(one, two);
		test.checkEquality();
		out.println(test.toString());
	}
}