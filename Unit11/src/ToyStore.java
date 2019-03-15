//(c) A+ Computer Science
//www.apluscompsci.com
//Name: Natalee Chan

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import static java.lang.System.*;

public class ToyStore
{
	private ArrayList<Toy> toyList;

	public ToyStore()
	{
		loadToys("");
	}
	
	public ToyStore(String toys)
	{
		loadToys(toys);
	}

	public void loadToys(String toys)
	{
		toyList = new ArrayList<Toy>();
		for (String newToy : toys.split(" "))
		{
			boolean ToyInList = false;
			for (Toy toy: toyList)
			{
				if (newToy.equals(toy.getName()))
				{
					toy.setCount(toy.getCount() + 1);
					ToyInList = true;
					
				}
			}
			
			if (ToyInList == false)
			{
				toyList.add(new Toy(newToy));
			}
		}
	}
  
  	public Toy getThatToy(String nm)
  	{
  		for (Toy fetchToy: toyList)
  		{
  			if (fetchToy.getName().equals(nm))
  			{
  				return fetchToy;
  			}
  		}
  		return null;
  	}
  
  	public String getMostFrequentToy()
  	{
  		Toy mostFrequent = toyList.get(0);
  		
  		for (int index = 0; index < toyList.size(); index++)
  		{
  			if (toyList.get(index).getCount() > mostFrequent.getCount())
  			{
  				mostFrequent = toyList.get(index);
  			}
  		}
  		return mostFrequent.getName();
  	}  
  
  	public void sortToysByCount()
  	{
  		boolean sorted = false;
  		while (sorted == false)
  		{
  			sorted = true;
  			for (int i = 0; i < toyList.size() - 1; i++)
  			{
  				if (toyList.get(i).getCount() < toyList.get(i + 1).getCount())
  				{
  					toyList.add(i, toyList.get(i + 1));
  					toyList.remove(i + 2);
  					sorted = false;
  				}
  			}
  		}
  	}  
  	  
	public String toString()
	{
	   return Arrays.toString(toyList.toArray());
	}
}