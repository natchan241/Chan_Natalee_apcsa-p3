//(c) A+ Computer Science
//www.apluscompsci.com
//Name: Natalee Chan

import static java.lang.System.*;

public class Perfect
{
   private int number;

	public Perfect()
	{
		number = 0;
	}
	
	public Perfect(int n)
	{
		SetNums(n);
	}

	public void SetNums(int n)
	{
		number = n;
	}

	public boolean isPerfect()
	{
		int sum = 0;
		
		for (int i = 1; i <= number/2; i++)
		{
			if(number % i == 0)
			{
				sum += i;
			}
		}
		
		if(sum == number)
		{
			return true;
		}
		return false;
	}

	public String toString()
	{
		if(isPerfect() == true)
		{
			return number + " is perfect.";
		}
		else
		{
			return number + " is not perfect.";
		}
	}
	
}