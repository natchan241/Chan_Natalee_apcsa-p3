//(c) A+ Computer Science
//www.apluscompsci.com
//Name: Natalee Chan

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block implements Collidable
{
	private int xSpeed;
	private int ySpeed;

	public Ball()
	{
		super(200, 200);
		setSpeed(3, 1);
	}

	public Ball(int x, int y)
	{
		super(x, y);
		setSpeed(3, 1);
	}
	
	public Ball(int x, int y, int wid, int ht)
	{
		this(x, y);
		super.setWidth(wid);
		super.setHeight(ht);
	}
	
	public Ball(int x, int y, int wid, int ht, Color col)
	{
		this(x, y, wid, ht);
		super.setColor(col);
	}
	
	public Ball(int x, int y, int wid, int ht, int xS, int yS)
	{
		this(x, y, wid, ht);
		setSpeed(xS, yS);
	}
	
	public Ball(int x, int y, int wid, int ht, Color col, int xS, int yS)
	{
		super(x, y, wid, ht, col);
		setSpeed(xS, yS);
	}
	
	public void setXSpeed(int xS)
	{
		xSpeed = xS;
	}
	
	public void setYSpeed(int yS)
	{
		ySpeed = yS;
	}
	
	public void setSpeed(int xS, int yS)
	{
		setXSpeed(xS);
		setYSpeed(yS);
	}
  
   public void moveAndDraw(Graphics window)
   {
	   draw(window, Color.WHITE);
	   setX(getX() + xSpeed);
	   setY(getY() + ySpeed);
	   draw(window);
   }
   
	public boolean equals(Object obj)
	{
		Ball other = (Ball) obj;
		return super.equals(other) && xSpeed == other.getXSpeed() && ySpeed == other.getYSpeed();
	}   

	//get methods
	public int getXSpeed()
	{
		return xSpeed;
	}
	
	public int getYSpeed()
	{
		return ySpeed;
	}
	
	public boolean didCollideLeft(Object obj)
	{
		Block other = (Block) obj;
		return (getX() <= (other.getX() + other.getWidth() + Math.abs(getXSpeed())) && getX() > (other.getX() - getWidth() - Math.abs(getXSpeed())) && getX() >= (other.getX()) && getY() < (other.getY() + other.getHeight()) && (getY() + getHeight()) > other.getY());
	}
	
	public boolean didCollideRight(Object obj)
	{
		Block other = (Block) obj;
		return (getX() < (other.getX() + other.getWidth() + Math.abs(getXSpeed())) && getX() >= (other.getX() - getWidth() - Math.abs(getXSpeed())) && getX() <= other.getX() + other.getWidth() && getY() < (other.getY() + other.getHeight()) && (getY() + getHeight()) > other.getY());
	}
	
	public boolean didCollideTop(Object obj)
	{
		Block other = (Block) obj;
		return (getY() <= (other.getY() + other.getHeight() + Math.abs(getYSpeed())) && getY() > (other.getY() - getHeight() - Math.abs(getYSpeed())) && getY() <= (other.getY()) && getX() < (other.getX() + other.getWidth()) && (getX() + getWidth()) > other.getX());
	}
	
	public boolean didCollideBottom(Object obj)
	{
		Block other = (Block) obj;
		return (getY() > (other.getY() - getHeight() - Math.abs(getYSpeed())) && getY() <= (other.getY() + other.getHeight() + Math.abs(getYSpeed()))  && (getY() >= other.getY() && getX() < (other.getX() + other.getWidth()) && (getX() + getWidth()) > other.getX() && (getX() + getWidth()) < other.getX() + other.getWidth()));
	}
	
	public String toString()
	{
		return super.toString() + " " + xSpeed + " " + ySpeed;
	}
}