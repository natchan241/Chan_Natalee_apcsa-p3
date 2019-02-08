//(c) A+ Computer Science
//www.apluscompsci.com
//Name: Natalee Chan

import static java.lang.System.*;

import java.util.Scanner; 

public class PerfectRunner
{
	public static void main( String args[] )
	{
		Scanner keyboard = new Scanner(in);
		
		out.println("Enter in a number :: ");
		int n = keyboard.nextInt();
		
		Perfect run = new Perfect(n);
		
		out.println(run.toString());
																
	}
}