//(c) A+ Computer Science
//www.apluscompsci.com
//Name: Natalee Chan
//Date: February 5, 2019

import java.util.Scanner; 
import static java.lang.System.*;
import static java.lang.Math.*;

public class FirstLastVowel
{
   public static String go( String a )
	{
	   final String vowels = "aeiouAEIOU";
	   for (int i = 1; i <= vowels.length(); i++)
	   {
		   if (a.substring(0,1).equals(vowels.substring(i-1,i)))
			{
			   return "yes";
			}
		   else if (a.substring(a.length()-1, a.length()).equals(vowels.substring(i-1,i)))
		   {
			   return "yes";
		   }
	   }
		   return "no";
	}
}