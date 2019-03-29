//(c) A+ Computer Science
//www.apluscompsci.com
//Name: Natalee Chan

import static java.lang.System.*;

public class RecursionFunOne
{
	public static int countEvenDigits(int num)
	{
		if (num < 10)
		{
			if (num % 2 == 0) return 1;
			else return 0;
		}
		if (num % 2 == 0)
		{
			return countEvenDigits(num / 10) + 1;
		}
		else return countEvenDigits(num / 10);
	}
}