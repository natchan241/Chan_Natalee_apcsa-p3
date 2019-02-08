//(c) A+ Computer Science
//www.apluscompsci.com
//Name: Natalee Chan

import static java.lang.System.*;

import java.util.Scanner;

public class WordRunner
{
	public static void main ( String[] args )
	{
		Scanner keyboard = new Scanner(in);
		
		out.println("Enter in a word :: ");
		String s = keyboard.nextLine();
		
		Word run = new Word(s);
		out.println(run.toString());
	}
}