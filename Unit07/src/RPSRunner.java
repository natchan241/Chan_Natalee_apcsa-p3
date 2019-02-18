//(c) A+ Computer Science
// www.apluscompsci.com
//Name: Natalee Chan

import java.util.Scanner;
import static java.lang.System.*;

public class RPSRunner
{
	public static void main(String args[])
	{
		Scanner keyboard = new Scanner(System.in);
		char response = ' ';
		
		do {
			String player = "";
			out.println("Rock-Paper-Sissors - pick your weapon[R,P,S]:: ");
			RockPaperScissors game = new RockPaperScissors(keyboard.next());
			out.println(game);
			out.println(game.determineWinner() + "\n" + "Do you want to play again? Please type y or Y (for yes) and n or N (for no). ");
			response = keyboard.next().charAt(0);
		
		}
		while(response == 'y' || response == 'Y');		
		
		out.println("End of game! Thanks for playing!");
	}
}



