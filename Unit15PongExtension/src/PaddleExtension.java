//(c) A+ Computer Science
//www.apluscompsci.com
//Name: Natalee Chan

import java.awt.Color;
import java.awt.Graphics;

public class PaddleExtension extends Paddle
{
	   public PaddleExtension()
	   {
			super();
	   }

	   public PaddleExtension(int x, int y)
	   {
		   super(x, y);
	   }
	   
	   public PaddleExtension(int x, int y, int s)
	   {
		   super(x, y, s);
	   }
	   
	   public PaddleExtension(int x, int y, int wid, int ht, int s)
	   {
		   super(x, y, wid, ht, s);
	   }
	   
	   public PaddleExtension(int x, int y, int wid, int ht, Color col, int s)
	   {
		   super(x, y, wid, ht, col, s);
	   }

	   public void moveLeftAndDraw(Graphics window)
	   {
		   draw(window, Color.WHITE);
		   setX(getX() - getSpeed());
		   draw(window);
	   }

	   public void moveRightAndDraw(Graphics window)
	   {
		   draw(window, Color.WHITE);
		   setX(getX() + getSpeed());
		   draw(window);
	   }

}