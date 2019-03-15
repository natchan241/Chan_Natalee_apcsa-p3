//(c) A+ Computer Science
//www.apluscompsci.com
//Name: Natalee Chan

import java.util.Scanner;
import static java.lang.System.*;

public class TriangleWordRunner
{
	public static void main( String args[] )
	{
		Scanner keyboard = new Scanner(System.in);
		String choice = "y";
		TriangleWord test = new TriangleWord();
		
		while (choice.equals("y") || choice.equals("Y"))
		{
			System.out.println("Enter a word :: ");
			String word = keyboard.next();
			test.printTriangle(word);
			System.out.print("Do you want to enter more sample input? ");
			choice = keyboard.next();
			System.out.println("\n");
			
		}
	}
}