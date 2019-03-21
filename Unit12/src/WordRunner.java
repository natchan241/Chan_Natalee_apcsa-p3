//(c) A+ Computer Science
//www.apluscompsci.com
//Name: Natalee Chan

import java.io.File; 
import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;
import static java.lang.System.*;

public class WordRunner
{
	public static void main( String args[] ) throws IOException
	{
		Scanner file = new Scanner(new File("src//words.dat"));

		int size = file.nextInt();
		Word words[] = new Word[size];
		file.nextLine();
		
		int cnt = 0;
		for (int i = 0; i < size; i++)
		{
			words[cnt] = new Word(file.nextLine());
			cnt++;
		}
		file.close();
		
		Arrays.sort(words);
		
		for (Word item: words)
		{
			System.out.println(item);
		}
	}
}