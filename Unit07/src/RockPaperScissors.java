//(c) A+ Computer Science
// www.apluscompsci.com
//Name: Natalee Chan

import java.util.Scanner;
import static java.lang.System.*;

public class RockPaperScissors
{
	private String playChoice;
	private String compChoice;

	public RockPaperScissors()
	{
		setPlayers("");
	}

	public RockPaperScissors(String player)
	{
		setPlayers(player);
	}

	public void setPlayers(String player)
	{
		playChoice = player.toUpperCase();

		int choice = 0;
		choice = (int) (Math.random() * 3);
		
		switch (choice)
		{
		case 0:
			compChoice = "R";
			break;
		case 1:
			compChoice = "S";
			break;
		case 2:
			compChoice = "P";
			break;
		}
		
	}

	public String determineWinner()
	{
		String winner = "";
		
		if (playChoice.equals(compChoice))
		{
			winner = "!Draw Game!";
		}
		else if (playChoice.equals("R"))
		{
			if (compChoice.equals("P"))
			{
				winner = "!Computer wins <<Paper Covers Rock>>!";
			}
			else
			{
				winner = "!PLayer wins <<Rock Breaks Scissors>>!";
			}
		}
		else if (playChoice.equals("P"))
			{
				if (compChoice.equals("R"))
				{
					winner = "!Player wins <<Paper Covers Rock>>!";
				}
				else
				{
					winner = "!Computer wins <<Scissors Cuts Paper>>!";
				}
			}
		else if (playChoice.equals("S"))
		{
			if (compChoice.equals("R"))
			{
				winner = "!Computer wins <<Rock Breaks Scissors>>!";
			}
			else
			{
				winner = "!Player wins <<Sissors Cuts Paper>>!";
			}
		}
		
		return winner;
		
	}

	public String toString()
	{
		String output= "Player had " + playChoice + "\n" + "Computer had " + compChoice;
		
		return output;
	}
}