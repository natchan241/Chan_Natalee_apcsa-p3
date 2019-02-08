//(c) A+ Computer Science
//www.apluscompsci.com
//Name: Natalee Chan

import static java.lang.System.*;

public class LetterRemover
{
   private String sentence;
   private char lookFor;

	public LetterRemover()
	{
		sentence = "";
		lookFor = ' ';
	}

	public LetterRemover(String s, char rem)
	{
		setRemover(s, rem);
	}
	
	public void setRemover(String s, char rem)
	{
		sentence = s;
		lookFor = rem;
	}

	public String removeLetters()
	{
		String cleaned = sentence;
		String letter = Character.toString(lookFor);
		
		while (cleaned.indexOf(lookFor) >= 0)
		{
			cleaned = cleaned.replace(letter, "");
			
		}
		
		return cleaned;
	}

	public String toString()
	{
		return sentence + " - letter to remove " + lookFor + "\n" + removeLetters();
	}
}