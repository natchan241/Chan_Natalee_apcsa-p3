//(c) A+ Computer Science
//www.apluscompsci.com

//Name: Natalee Chan
//Date: February 5, 2019
//Class: APCSA
//Lab: Discount

import static java.lang.System.*;
import java.util.Scanner;

public class DiscountRunner
{
	public static void main( String args[] )
	{
		Scanner keyboard = new Scanner(System.in);
		
		out.print("Enter the original bill amount :: ");
		double amt = keyboard.nextDouble();
		
		out.printf("Bill after discount :: " + "%.2f \n", Discount.getDiscountedBill(amt));

	}
}