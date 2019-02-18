//(c) A+ Computer Science
// www.apluscompsci.com
//Name: Natalee Chan

import static java.lang.System.*;

import java.util.Scanner;

public class TriplesRunner
{
   public static void main(String args[])
   {
	   Scanner keyboard = new Scanner(in);
	   
	   out.println("Enter a number :: ");
	   int num = keyboard.nextInt();
	   
	   Triples run = new Triples(num);
	   
	   out.println(run);
   }
}