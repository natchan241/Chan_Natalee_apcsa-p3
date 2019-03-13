//(c) A+ Computer Science
//www.apluscompsci.com
//Name: Natalee Chan
//Date: March 12, 2019

import java.util.ArrayList;
import java.util.List;

public class ListOddToEven
{
	public static int go( List<Integer> ray )
	{
		
		for (int i = 0; i < ray.size(); i++)
		{
			if (ray.get(i) % 2 == 1)
			{
				int result = 0;
				for (int j = i; j < ray.size(); j++)
				{
					if (ray.get(j) % 2 == 0)
					{
						result = j;
					}
				}
				if (result > 0)
				{
					return result - i;
				}
			}
		}
		return -1;
	}
}