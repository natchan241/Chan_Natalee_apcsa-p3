//(c) A+ Computer Science
//www.apluscompsci.com
//Name: Natalee Chan

import static java.lang.System.*;

import java.util.Scanner;

public class LetterRemoverRunner
{
	public static void main( String args[] )
	{
		Scanner keyboard = new Scanner(in);
		
		out.print("Enter the sentence :: ");
		String s = keyboard.nextLine();
		
		out.print("Enter the letter to remove :: ");
		char rem = keyboard.next().charAt(0);
		
		LetterRemover run = new LetterRemover(s, rem);
		
		out.println(run.toString());
											
	}
}