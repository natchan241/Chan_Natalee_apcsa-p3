//(c) A+ Computer Science
//www.apluscompsci.com
//Name: Natalee Chan

import java.awt.Color;
import java.awt.Graphics;

public class Paddle extends Block
{
   private int speed;

   public Paddle()
   {
		this(10,10);
   }

   public Paddle(int x, int y)
   {
	   super(x, y, 10, 10, Color.BLACK);
	   setSpeed(5);
   }
   
   public Paddle(int x, int y, int s)
   {
	   super(x, y, 10, 10, Color.BLACK);
	   setSpeed(s);
   }
   
   public Paddle(int x, int y, int wid, int ht, int s)
   {
	   super(x, y, wid, ht, Color.BLACK);
	   setSpeed(s);
   }
   
   public Paddle(int x, int y, int wid, int ht, Color col, int s)
   {
	   super(x, y, wid, ht, col);
	   setSpeed(s);
   }
   
   public void setSpeed(int s)
   {
	   speed = s;
   }

   public void moveUpAndDraw(Graphics window)
   {
	   draw(window, Color.WHITE);
	   setY(getY() - speed);
	   draw(window);
   }

   public void moveDownAndDraw(Graphics window)
   {
	   draw(window, Color.WHITE);
	   setY(getY() + speed);
	   draw(window);
   }

   public int getSpeed()
   {
	   return speed;
   }
   
   public String toString()
   {
	   return super.toString() + " " + speed;
   }
}