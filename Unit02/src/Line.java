//(c) A+ Computer Science
//www.apluscompsci.com
//Name: Natalee Chan
//Date: February 1, 2019

public class Line
{
	public static double getSlope( int x1, int y1, int x2, int y2 )
	{
		Double temp;
		Double temp2;
		temp = (double) (y2-y1);
		temp2 = (double) (x2-x1);
		Double getSlope = temp/temp2;
		return getSlope;
	}

}