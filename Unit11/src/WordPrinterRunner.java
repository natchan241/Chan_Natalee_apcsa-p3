//(c) A+ Computer Science
//www.apluscompsci.com
//Name: Natalee Chan

import java.util.Scanner;
import static java.lang.System.*;

public class WordPrinterRunner
{
	public static void main( String args[] )
	{
   	Scanner keyboard = new Scanner(System.in);
   	WordPrinter test = new WordPrinter();
   	
   	String choice = "";
		do {
			out.print("Enter the word to display :: ");
			String word = keyboard.next();
	
			out.print("Enter the times to display :: ");
 			int times = keyboard.nextInt();			
			
			System.out.println(test.printWord(word, times));

			System.out.print("Do you want to enter more sample input? ");
			choice = keyboard.next();
			System.out.print("\n");
			
		} while(choice.equals("Y") || choice.equals("y"));		
	}
}