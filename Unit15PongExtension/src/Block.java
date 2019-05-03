//(c) A+ Computer Science
//www.apluscompsci.com
//Name: Natalee Chan

import java.awt.Color;
import java.awt.Graphics;

public class Block implements Locatable
{
	private int xPos;
	private int yPos;
	private int width;
	private int height;

	private Color color;

	public Block()
	{
		this(10, 10, 10, 10, Color.BLACK);
	}
	
	public Block(int x, int y)
	{
		this(x, y, 10, 10, Color.BLACK);
	}
	
	public Block(int x, int y, int wid, int ht)
	{
		this(x, y, wid, ht, Color.BLACK);
	}
	
	public Block (int x, int y, int wid, int ht, Color col)
	{
		setPos(x, y);
		setWidth(wid);
		setHeight(ht);
		setColor(col);
	}
	
	public void setX(int x)
	{
		xPos = x;
	}
	
	public void setY(int y)
	{
		yPos = y;
	}
	
	public void setPos(int x, int y)
	{
		setX(x);
		setY(y);
	}
	
	public void setWidth(int wid)
	{
		width = wid;
	}
	
	public void setHeight(int ht)
	{
		height = ht;
	}

   public void setColor(Color col)
   {
	   color = col;
   }

   public void draw(Graphics window)
   {
      window.setColor(color);
      window.fillRect(getX(), getY(), getWidth(), getHeight());
   }

   public void draw(Graphics window, Color col)
   {
	   window.setColor(col);
	   window.fillRect(getX(), getY(), getWidth(), getHeight());
   }
   
	public boolean equals(Object obj)
	{
		Block other = (Block) obj;
		return other.getX() == xPos && other.getY() == yPos && other.getWidth() == width &&other.getHeight() == height && other.getColor().equals(color);
	}   
	
	//get methods
	public int getX()
	{
		return xPos;
	}
	
	public int getY()
	{
		return yPos;
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public int getHeight()
	{
		return height;
	}
	
	public Color getColor()
	{
		return color;
	}
	
	public String toString()
	{
		return xPos + " " + yPos + " " + width + " " + height + " " + color;
	}
}