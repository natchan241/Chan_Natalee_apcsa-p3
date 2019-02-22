//(c) A+ Computer Science
//www.apluscompsci.com
//Name: Natalee Chan
//Date: February 21, 2019

public class RayOddToEven
{
	public static int go(int[] ray)
	{
		int counter = 0;
		for (int i = 0; i < ray.length; i++)
		{
			if (ray[i] % 2 != 0)
			{
				for (int j = i+1; j < ray.length; j++)
				{
					counter++;
					
					if (ray[j] % 2 == 0)
					{
						return counter;
					}
				}
			}
		}
		return -1;
	}
}