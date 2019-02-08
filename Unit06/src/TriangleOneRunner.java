//(c) A+ Computer Science
//www.apluscompsci.com
//Name: Natalee Chan

import static java.lang.System.*;

import java.util.Scanner;

public class TriangleOneRunner
{
	public static void main ( String[] args )
	{
		Scanner keyboard = new Scanner(in);
		
		out.println("Enter in a word :: ");
		String s = keyboard.nextLine();
		
		TriangleOne run = new TriangleOne(s);
		
		run.print();
	}
}