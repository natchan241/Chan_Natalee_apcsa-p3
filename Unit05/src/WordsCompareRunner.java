//(c) A+ Computer Science
//www.apluscompsci.com

//Name: Natalee Chan
//Date: February 7, 2019
//Class: APCSA
//Lab: Dictionary

import static java.lang.System.*;

import java.util.Scanner;

public class WordsCompareRunner
{
   public static void main( String args[] )
   {
	   Scanner keyboard = new Scanner(in);
	   
	   out.print("Enter one word :: ");
	   String one = keyboard.nextLine();

		out.print("Enter the next word :: ");
		String two = keyboard.nextLine();
	   
	   WordsCompare run = new WordsCompare(one, two);
	
	   run.compare();
	   out.println(run.toString());

	}
}