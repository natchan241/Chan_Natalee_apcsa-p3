//(c) A+ Computer Science
//www.apluscompsci.com
//Name: Natalee Chan

import static java.lang.System.*;

public class TriangleFive
{
   private char letter;
   private int amount;

	public TriangleFive()
	{
		letter = ' ';
		amount = 0;
		setLetter(' ');
		setAmount(0);
	}

	public TriangleFive(char c, int amt)
	{
		setLetter(c);
		setAmount(amt);
	}

	public void setLetter(char c)
	{
		letter = c;
	}

	public void setAmount(int amt)
	{
		amount = amt;
	}

	public String toString()
	{
		String output = "";
		for (int i = amount; i > 0; i--)
		{
			for(int j = amount; j > amount - i; j--)
			{
				for(int k = amount; k > amount - j; k--)
				{
					if (letter + amount - j <= 90)
					{
						output += (char) (letter + amount - j);
					}
					else
					{
						output += (char) (letter + amount - j - 26);
					}
				}
				output += " ";
			}
			output += "\n";
		}
		return output;
	}
}