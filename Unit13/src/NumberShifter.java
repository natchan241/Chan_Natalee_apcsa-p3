//(c) A+ Computer Science
//www.apluscompsci.com
//Name: Natalee Chan

import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import static java.lang.System.*;

public class NumberShifter
{
	public static int[] makeLucky7Array( int size)
	{
		int[] lucky7 = new int[size];
		
		for (int i = 0; i < size; i++)
		{
			int random = (int) (Math.random() * 10) + 1;
			lucky7[i] = random;
		}
		return lucky7;
	}
	public static void shiftEm(int[] array)
	{
		int change = 0;
		
		while (array[change] == 7)
		{
			change++;
		}
		
		for (int index = 0; index < array.length; index++)
		{
			if (array[index] == 7)
			{
				int temp = array[index];
				array[index] = array[change];
				array[change] = temp;
				change++;
			}
		}
	}
}