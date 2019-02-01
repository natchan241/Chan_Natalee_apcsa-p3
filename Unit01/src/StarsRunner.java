//� A+ Computer Science
//www.apluscompsci.com

//Name: Natalee Chan
//Date: January 31, 2019
//Class: APCSA
//Lab: StarsRunner

import static java.lang.System.*;

public class StarsRunner
{
   public static void main(String args[])
   {
	 //instantiate a StarsAndStripes object
	  StarsAndStripes natRunner = new StarsAndStripes();
      
      //call the methods needed to make the patterns on the word document
      out.println("Pattern given to us by the document:");
      
      natRunner.printTwentyDashes();
      natRunner.printTwentyStars();
      natRunner.printTwentyDashes();
      natRunner.printTwentyStars();
      natRunner.printTwentyDashes();
      natRunner.printTwentyStars();
      natRunner.printASmallBox();
      natRunner.printTwentyStars();
      natRunner.printTwentyDashes();
      natRunner.printTwentyStars();
      natRunner.printTwentyDashes();
      natRunner.printTwentyStars();
      natRunner.printTwentyDashes();
      natRunner.printTwentyDashes();
      natRunner.printTwentyStars();
      natRunner.printTwentyDashes();
      natRunner.printTwentyStars();
      natRunner.printTwentyDashes();
      natRunner.printTwentyStars();
      natRunner.printABigBox();
      natRunner.printTwoBlankLines();
      
      out.println("My Pattern:");
      
      natRunner.printSquig();
      natRunner.printASmallBox();
      natRunner.printABigBox();
      natRunner.printTwentyStars();
      natRunner.printTwoBlankLines();
      natRunner.printTwentyDashes();
   }
}