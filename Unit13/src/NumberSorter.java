//(c) A+ Computer Science
//www.apluscompsci.com
//Name: Natalee Chan

import java.util.Arrays; 
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import static java.lang.System.*;

public class NumberSorter
{
	
	private static int getNumDigits(int number)
	{
		int count = 0;
		while (Math.pow(10, count) < number)
		{
			count++;
		}
		return (int) count;
	}

	public static int[] getSortedDigitArray(int number)
	{
		int length = getNumDigits(number);
		int[] sorted = new int[length];
		
		for (int i = 0; i < length; i++)
		{
			sorted[i] = (number / (int) Math.pow(10, i) % 10);
		}
		for (int i = 1; i < length; i++)
		{
			int temp = sorted[i];
			int check = i;
			
			while (check > 0 && sorted[check - 1] > temp)
			{
				sorted[check] = sorted[check - 1];
				check--;
			}
			sorted[check] = temp;
		}
		return sorted;
	}
}