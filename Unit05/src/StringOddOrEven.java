//(c) A+ Computer Science
//www.apluscompsci.com

//Name: Natalee Chan
//Date: February 6, 2019
//Class: APCSA
//Lab: Odd or Even String

import static java.lang.System.*;
import java.util.Scanner;

public class StringOddOrEven
{
	private String word;

	public StringOddOrEven()
	{
		word = "";
	}

	public StringOddOrEven(String s)
	{
		setString(s);
	}

	public void setString(String s)
	{
		word = s;
	}

 	public boolean isEven()
 	{
 		int i = word.length();
 		if (i % 2 == 0)
 		{
 			return true;
 		}
 		return false;
	}

 	public String toString()
 	{
 		if (isEven() == true)
 		{
 			String output = (word + " is even.");
 			return output;
 		}
 		else
 		{
 			String output = (word + " is odd.");
 			return output;
 		}
	}
}