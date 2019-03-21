//(c) A+ Computer Science
//www.apluscompsci.com
//Name: Natalee Chan

import static java.lang.System.*;

public class Word implements Comparable<Word>
{
	private String word;
	
	public Word()
	{
		setWord("");
	}

	public Word(String s)
	{
		setWord(s);
	}
	
	public void setWord(String s)
	{
		word = s;
	}
	
	public String getWord()
	{
		return word;
	}

	public int compareTo( Word rhs )
	{		
		if (word.length() - rhs.getWord().length() == 0)
		{
			return word.compareTo(rhs.getWord());
		}
		else
		{
			return word.length() - rhs.getWord().length();
		}
	}

	public String toString()
	{
		return word;
	}
}