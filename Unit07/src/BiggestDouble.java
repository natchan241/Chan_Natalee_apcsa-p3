//(c) A+ Computer Science
// www.apluscompsci.com
//Name: Natalee Chan

import static java.lang.System.*;

public class BiggestDouble
{
	private double one, two, three, four;

	public BiggestDouble()
	{
		this(0,0,0,0);
	}

	public BiggestDouble(double a, double b, double c, double d)
	{
		setDoubles(a, b, c, d);
	}

	public void setDoubles(double a, double b, double c, double d)
	{
		one = a;
		two = b;
		three = c;
		four = d;
	}

	public double getBiggest()
	{
		double a = Math.max(one, two);
		double b = Math.max(three, four);
		
		if (a > b)
		{
			return a;
		}
		else
		{
			return b;
		}
	}

	public String toString()
	{
	   return one + ", " + two + ", " + three + ", " + four + "\n" + "biggest = " + getBiggest();
	}
}