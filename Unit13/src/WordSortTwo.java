//(c) A+ Computer Science
//www.apluscompsci.com
//Name: Natalee Chan

import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;

public class WordSortTwo
{
	private String[] wordRay;

	public WordSortTwo(String sentence)
	{
		wordRay = sentence.split(" ");
	}

	public void sort()
	{
		for (int i = 1; i < wordRay.length; i++)
		{
			String temp = wordRay[i];
			int compare = i;
			while (compare > 0 && wordRay[compare - 1].compareTo(temp) > 0)
			{
				wordRay[compare] = wordRay[compare - 1];
				compare--;
			}
			wordRay[compare] = temp;
		}
	}

	public String toString()
	{
		String output = "";
		
		for (String word: wordRay)
		{
			output = output + word + "\n";
		}
		return output + "\n\n";
	}
}