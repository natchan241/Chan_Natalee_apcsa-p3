//� A+ Computer Science
//www.apluscompsci.com

//Name: Natalee Chan
//Date: January 31, 2019
//Class: APCSA
//Lab: Stars and Stripes

import static java.lang.System.*;

public class StarsAndStripes
{
   public StarsAndStripes()
   {
      out.println("StarsAndStripes");
      printTwoBlankLines();
   }

   public void printTwentyStars()
   {
	   out.println("********************");
   }

   public void printTwentyDashes()
   {
	   out.println("--------------------");
   }

   public void printTwoBlankLines()
   {
	   out.println("\n" + "\n");
   }
   
   public void printASmallBox()
   {	
	   	printTwentyDashes();
		printTwoBlankLines();
		printTwentyDashes();
   }
 
   public void printABigBox()
   { 	
	   printTwentyDashes();
	   printTwoBlankLines();
	   printTwoBlankLines();
	   printTwentyDashes();
   }   
   
   public void printSquig()
   {
	   out.println("~~~~~~~~~~~~~~~~~~~~");
   }
}