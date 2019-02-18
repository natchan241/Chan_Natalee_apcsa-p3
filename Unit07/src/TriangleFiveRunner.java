//(c) A+ Computer Science
//www.apluscompsci.com
//Name: Natalee Chan

import static java.lang.System.*;

public class TriangleFiveRunner
{
   public static void main(String args[])
   {
	   TriangleFive run = new TriangleFive('C', 4);
	   
	   out.println(run);
	   
	   run.setLetter('A');
	   run.setAmount(5);
	   
	   out.println(run);
	   
	   run.setLetter('B');
	   run.setAmount(7);
	   
	   out.println(run);
	   
	   run.setLetter('X');
	   run.setAmount(6);
	   
	   out.println(run);
	   
	   run.setLetter('Z');
	   run.setAmount(8);
	   
	   out.println(run);
	   
   }
}