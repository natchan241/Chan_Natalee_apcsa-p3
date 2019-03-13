//(c) A+ Computer Science
//www.apluscompsci.com
//Name: Natalee Chan
//Date: March 12, 2019

import java.util.List;
import java.util.ArrayList;

public class ListSumFirst
{
	public static int go(List<Integer> ray)
	{
		boolean hasLarger = false;
		int sum = 0;
		if (ray.size() == 0) return -1;
		else 
		{
			for (Integer i: ray) {
				if (i > ray.get(0))
				{
					hasLarger = true;
					sum += i;
				}
			}
		}
		if (hasLarger == false) return -1;
		else return sum;
	}
}