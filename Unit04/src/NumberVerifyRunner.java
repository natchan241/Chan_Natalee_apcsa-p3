//(c) A+ Computer Science
//www.apluscompsci.com

//Name: Natalee Chan
//Date: February 4, 2019
//Class: APCSA
//Lab: Odd or Even

import static java.lang.System.*;
import java.util.Scanner;

public class NumberVerifyRunner
{
	public static void main ( String[] args )
	{
		Scanner keyboard = new Scanner(in);
		
		out.print("Enter a whole number :: ");
		int num = keyboard.nextInt();
		
		System.out.println(num + " is odd :: " + NumberVerify.isOdd(num));
		System.out.println(num + " is even :: " + NumberVerify.isEven(num));
		
	}
}