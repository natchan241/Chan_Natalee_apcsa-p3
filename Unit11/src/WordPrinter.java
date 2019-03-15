//(c) A+ Computer Science
//www.apluscompsci.com
//Name: Natalee Chan

import static java.lang.System.*;

public class WordPrinter
{
			
	public static String printWord(String word, int times)
	{
		String output = "";
		
		for (int i = 0; i < times; i++)
		{
			output += word + "\n";
		}
		return output;
		
	}
}