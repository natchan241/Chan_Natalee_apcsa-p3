//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Scanner;
import static java.lang.System.*;

public class MonsterRunner
{
	public static void main( String args[] )
	{
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Enter 1st monster's name : ");
		String name1 = keyboard.next();
		
		System.out.println("Enter 1st monster's size : ");
		int size1 = keyboard.nextInt();
		
		Skeleton monster1 = new Skeleton(name1, size1);
		
		System.out.println("Enter 2nd monster's name : ");
		String name2 = keyboard.next();
		
		System.out.println("Enter 2nd monster's size : ");
		int size2 = keyboard.nextInt();
		
		Creeper monster2 = new Creeper(name2, size2);
		
		System.out.println("\nMonster 1 - " + monster1);
		System.out.println("Monster 2 - " + monster2 + "\n");
		
		if (monster1.isBigger(monster2))
		{
			System.out.println("Monster one is bigger than Monster two.");
		}
		
		if (monster1.isSmaller(monster2))
		{
			System.out.println("Monster one is smaller than Monster two.");
		}
		
		if (monster1.namesTheSame(monster2))
		{
			System.out.println("Monster one has the same name as Monster two.");
		}
		else
		{
			System.out.println("Monster one does not have the same name as Monster two.");
		}
	}
}