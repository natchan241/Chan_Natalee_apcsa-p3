//(c) A+ Computer Science
//www.apluscompsci.com
//Name: Natalee Chan

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.List;

public class AlienHorde
{
	private List<Alien> aliens;

	public AlienHorde(int size)
	{
		aliens = new ArrayList<Alien>();
		for (int i = 0; i < size; i++)
		{
			add(new Alien(0, 0));
		}
	}

	public void add(Alien al)
	{
		aliens.add(al);
	}

	public void drawEmAll( Graphics window )
	{
		for (int i = 0; i < aliens.size(); i++)
		{
			aliens.get(i).draw(window);
		}
	}

	public void moveEmAll()
	{
		for (int i=0; i < aliens.size(); i++)
		{
			Alien being = aliens.get(i);
			if (i == 0 || aliens.get(i - 1).getY() != being.getY() || being.getX() + aliens.get(i-1).getWidth() + 50 < aliens.get(i - 1).getX() || being.getX()>aliens.get(i - 1).getX()+aliens.get(i - 1).getWidth() + 50)
			{
				if (being.getSpeed() > 0 && being.getX() >= 800 -being.getWidth() - being.getSpeed() || being.getSpeed()<0 && being.getX() <= -being.getSpeed())
				{
					being.setSpeed(-being.getSpeed());
					being.setY(being.getY() + being.getHeight());
				}
				else being.setX(being.getX() + being.getSpeed());
			}
		}
	}

	public void removeDeadOnes(List<Ammo> shots)
	{
		for (int i = 0; i < shots.size(); i++)
		{
			Ammo shot = shots.get(i);
			for (int j = 0; j < aliens.size(); j++)
			{
				Alien being = aliens.get(j);
				if(shot.getX() < (being.getX() + being.getWidth() + Math.abs(shot.getSpeed())) && shot.getX() >= (being.getX() - shot.getWidth() - Math.abs(shot.getSpeed())) && shot.getX() <= being.getX() + being.getWidth() && shot.getY() < (being.getY() + being.getHeight()) && (shot.getY() + shot.getHeight()) > being.getY())
				{
					aliens.remove(j);
					shots.remove(i);
					j--;
					i--;
				}
			}
		}
	}
	
	public void stopHorde()
	{
		for (Alien being : aliens) being.setSpeed(0);
	}
	
	public List<Alien> getList()
	{
		return aliens;
	}

	public String toString()
	{
		return "";
	}
}
