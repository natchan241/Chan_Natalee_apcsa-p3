//(c) A+ Computer Science
//www.apluscompsci.com
//Name: Natalee Chan

import static java.lang.System.*; 

public class Skeleton implements Monster
{
	private String name;
	private int size;

	public Skeleton()
	{
		setSkelly("", 0);
	}
	
	public Skeleton(String word, int num)
	{
		setSkelly(word, num);
	}
	
	public void setSkelly(String word, int num)
	{
		name = word;
		size = num;
	}

	public String getName()
	{
		return name;
	}
	
	public int getHowBig()
	{
		return size;
	}
	
	public boolean isBigger(Monster other)
	{
		if (size > other.getHowBig())
		{
			return true;
		}
		return false;
	}
	
	public boolean isSmaller(Monster other)
	{
		if (size < other.getHowBig())
		{
			return true;
		}
		return false;
	}
	
	public boolean namesTheSame(Monster other)
	{
		if (name.equals(other.getName()))
		{
			return true;
		}
		return false;
	}

	public String toString()
	{
		return name + " " + size;
	}
}