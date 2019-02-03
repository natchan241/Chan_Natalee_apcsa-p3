//(c) A+ Computer Science 
//www.apluscompsci.com

//Name: Natalee Chan
//Date: February 1, 2019
//Class: APCSA
//Lab: Distance Formula

import java.util.Scanner; 
import static java.lang.System.*;
import static java.lang.Math.*;

public class Distance
{
	private int xOne,yOne,xTwo,yTwo;
	private double distance, y;

	public Distance(int x1, int y1, int x2, int y2)
	{
		setCoordinates(x1, y1, x2, y2);
	}

	public void setCoordinates(int x1, int y1, int x2, int y2)
	{
		xOne = x1;
		yOne = y1;
		xTwo = x2;
		yTwo = y2;
	}

	public void calcDistance()
	{
		double x = xTwo-xOne;
		double y = yTwo-yOne;
		double xx = x*x;
		double yy = y*y;
		double sum = xx+yy;
		distance = sqrt(sum);
		
	}
	
	public void print()
	{
		out.printf("distance == %.3f\n", distance);
	}
	
	//complete print or the toString

	public String toString()
	{
		return (String.format("distance == %.3f", distance));
	}
}