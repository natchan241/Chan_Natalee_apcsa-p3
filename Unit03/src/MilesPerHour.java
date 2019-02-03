//(c) A+ Computer Science
//www.apluscompsci.com

//Name: Natalee Chan
//Date: February 1, 2019
//Class: APCSA
//Lab: Miles Per Hour

import java.util.Scanner; 
import static java.lang.System.*;
import static java.lang.Math.*;

public class MilesPerHour
{
	private int distance, hours;
	private double minutes;
	private double mph;

	public MilesPerHour(int dist, int hrs, int mins)
	{
		setNums(dist, hrs, mins);
	}

	public void setNums(int dist, int hrs, int mins)
	{
		distance = dist;
		hours = hrs;
		minutes = mins;
		
	}

	public void calcMPH()
	{
		double minhrs = minutes/60;
		double hrs = hours + minhrs;
		mph = distance/hrs;
		mph = Math.round(mph);
		
	}

	public void print()
	{
		out.println(distance + " miles in " + hours + " hour and " + minutes + " minutes = " + mph + " MPH.");
	}
	
	//create a print or toString or both
	
	public String toString()
	{
		
		return (distance + " miles in " + hours + " hour and " + minutes + " minutes = " + mph + " MPH.");
	}
	
}