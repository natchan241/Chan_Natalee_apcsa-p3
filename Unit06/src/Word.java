//(c) A+ Computer Science
//www.apluscompsci.com
//Name: Natalee Chan

import static java.lang.System.*;

public class Word
{
	private String word;

	public Word()
	{
		word = "";
	}

	public Word(String s)
	{
		setString(s);
	}

	public void setString(String s)
	{
		word = s;
	}

	public char getFirstChar()
	{
		return word.charAt(0);
	}

	public char getLastChar()
	{
		return word.charAt(word.length()-1);
	}

	public String getBackWards()
	{
		String back = "";
		char ch[] = word.toCharArray();
		
		for(int i = word.length() - 1; i >= 0; i--)
		{
			back += ch[i];
		}
		
		return back;
	}

 	public String toString()
 	{
 		return getFirstChar() + "\n" + getLastChar() + "\n" + getBackWards() + "\n" + word;
	}
}