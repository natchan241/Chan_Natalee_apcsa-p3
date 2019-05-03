//(c) A+ Computer Science
//www.apluscompsci.com
//Name: Natalee Chan

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.ArrayList;
import java.awt.event.ActionListener;

public class PongExtension extends Canvas implements KeyListener, Runnable 
{
	private Ball ball;
	private PaddleExtension Paddle;
	private boolean[] keys;
	private BufferedImage back;
	private Block erase;
	private Wall wall;
	private int Pts;
	private List<Block> Blocks;

	public PongExtension()
	{
		ball = new Ball(250, 250, 10, 10, Color.BLUE, 3, 2);
		Paddle = new PaddleExtension(380, 280, 40, 40, Color.ORANGE, 2);
		
		keys = new boolean[4];

		erase = new Block(300, 430, 200, 60, Color.BLACK);
		wall = new Wall(805, 585);
		
		setBlocks();
    
    	setBackground(Color.WHITE);
		setVisible(true);
		
		new Thread(this).start();
		addKeyListener(this);		//starts the key thread to log key strokes
	}
	
	public void setBlocks()
	{
		Blocks = new ArrayList<Block>();
		
		for (int xPos = 85; xPos < 700; xPos += 80)
		{
			Blocks.add(new Block(xPos, 5, 75, 35, Color.GREEN));
			Blocks.add(new Block(xPos, 45, 75, 35, Color.GREEN));
			Blocks.add(new Block(xPos, 485, 75, 35, Color.GREEN));
			Blocks.add(new Block(xPos, 525, 75, 35, Color.GREEN));
		}
		
		for (int yPos = 5; yPos < 550; yPos += 80)
		{
			Blocks.add(new Block(5, yPos, 35, 75, Color.GREEN));
			Blocks.add(new Block(45, yPos, 35, 75, Color.GREEN));
			Blocks.add(new Block(725, yPos, 35, 75, Color.GREEN));
			Blocks.add(new Block(765, yPos, 35, 75, Color.GREEN));
		}
	}
	
	public void printScore(Graphics window)
	{
		window.clearRect(0, 0, 1000, 1000);
		erase.draw(window, Color.WHITE);
		window.setColor(Color.BLACK);
		window.drawString("Score: " + Pts, 300, 300);
		
	}
	
	public boolean inRange(int test, int smol, int large)
	{
		return (test < large && test > smol);
	}
	
   public void update(Graphics window){
	   paint(window);
   }

   public void paint(Graphics window)
   {
		//set up the double buffering to make the game animation nice and smooth
		Graphics2D twoDGraph = (Graphics2D)window;

		//take a snap shop of the current screen and same it as an image
		//that is the exact same width and height as the current screen
		if(back == null)
		   back = (BufferedImage)(createImage(getWidth(),getHeight()));

		//create a graphics reference to the back ground image
		//we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();

		printScore(graphToBack);
		ball.moveAndDraw(graphToBack);
		Paddle.draw(graphToBack);
		Boolean PaddleHitsWall = false;
		
		for (Block block : Blocks)
		{
			block.draw(graphToBack);
		}

		if(Blocks.size() == 0 || Pts == 60)
		{
			ball.setXSpeed(0);
			ball.setYSpeed(0);
			Paddle.setSpeed(0);
			
			window.setColor(Color.BLACK);
			window.drawString("Level 2", 300, 250);
			
			ball = new Ball(250, 250, 10, 10, Color.BLUE, (int) (Math.pow(-1, (int) (Math.random() * 2))), (int) (Math.random() * 2) * (int) (Math.pow(-1,  (int) (Math.random() * 2))));
			Paddle = new PaddleExtension(380, 280, 40, 40, Color.ORANGE, 2);
			setBlocks();
			
			ball.moveAndDraw(graphToBack);
			Paddle.draw(graphToBack);
			Pts += 10;
			
			if (!(ball.getY() >= wall.getY() && ball.getY() <= wall.getHeight() - ball.getHeight() - ball.getYSpeed() - 20))
			{
				ball.setYSpeed(ball.getYSpeed() * -1);
			}
			
			//see if the ball hits the side walls
			else if(!(ball.getX() >= wall.getX() && ball.getX() <= wall.getWidth() - ball.getWidth() - ball.getXSpeed()))
			{
				ball.setXSpeed(ball.getXSpeed() * -1);
			}
			
			else if(Paddle.getX() <= 0)
			{
				PaddleHitsWall = true;
				if (!PaddleHitsWall) Paddle.moveLeftAndDraw(graphToBack);
			}
			
			//see if the ball hits the paddle
			if(ball.didCollideLeft(Paddle) && !(ball.didCollideTop(Paddle)))
			{
				if (ball.getX() <= (Paddle.getX() + Paddle.getWidth() - Math.abs(ball.getXSpeed())))
				{
					ball.setYSpeed(Math.abs(ball.getYSpeed()));
				}
				else
				{
					ball.setXSpeed(Math.abs(ball.getXSpeed()));
				}
			}
			
			if(ball.didCollideRight(Paddle) && !(ball.didCollideTop(Paddle) && !(ball.didCollideBottom(Paddle))))
			{
				if (ball.getX() >= (Paddle.getX() + Paddle.getWidth() + Math.abs(ball.getXSpeed())))
				{
					ball.setYSpeed(-1 * Math.abs(ball.getYSpeed()));
				}
				else
				{
					ball.setXSpeed(-1 * Math.abs(ball.getYSpeed()));
				}
			}
			
			if(ball.didCollideTop(Paddle) && !(ball.didCollideLeft(Paddle) && !(ball.didCollideRight(Paddle))))
			{
				if (ball.getY() >= (Paddle.getY() + Paddle.getHeight() + Math.abs(ball.getYSpeed())))
				{
					ball.setXSpeed(-1 * Math.abs(ball.getXSpeed()));
				}
				else
				{
					ball.setYSpeed(-1 * Math.abs(ball.getYSpeed()));
				}
			}
			
			if(ball.didCollideBottom(Paddle) && !(ball.didCollideLeft(Paddle) && !(ball.didCollideRight(Paddle)) && !(ball.didCollideTop(Paddle))))
			{
				if (ball.getY() <= (Paddle.getY() + Paddle.getHeight() - Math.abs(ball.getYSpeed())))
				{
					ball.setXSpeed(Math.abs(ball.getXSpeed()));
				}
				else
				{
					ball.setYSpeed(Math.abs(ball.getYSpeed()));
				}
			}
			
			//see if the ball hits the side blocks
			for (int i = 0; i < Blocks.size(); i++)
			{
				Block side = Blocks.get(i);
				if (ball.didCollideTop(side) || ball.didCollideLeft(side) || ball.didCollideRight(side) || ball.didCollideBottom(side))
				{
					if (ball.didCollideBottom(side) || ball.didCollideTop(side))
					{
						ball.setYSpeed(-1 * ball.getYSpeed());
					}
					else 
					{
						ball.setXSpeed(-1 * ball.getXSpeed());
					}
					side.draw(graphToBack, Color.WHITE);
					Blocks.remove(i);
					Pts += 1;
				}
			}

			//see if the paddles need to be moved
			if (keys[0] == true && Paddle.getY() > Paddle.getSpeed())
			{
				boolean paddleHitBlock = false;
				for (Block block: Blocks)
				{
					if (block.getY() + block.getHeight() < Paddle.getY() && Paddle.getY() < Paddle.getSpeed() + block.getY() + block.getHeight() && (inRange(Paddle.getX(), block.getX(), block.getX() + block.getWidth()) || inRange(Paddle.getX() + Paddle.getWidth(), block.getX(), block.getX() + block.getWidth()) || inRange(block.getX(), Paddle.getX(), Paddle.getX() + Paddle.getWidth()) || inRange(block.getX() + block.getWidth(), Paddle.getX(), Paddle.getX() + Paddle.getWidth())))
					{
						paddleHitBlock = true;
					}
				}
				if (!paddleHitBlock) Paddle.moveUpAndDraw(graphToBack);
			}
			
			if (keys[1] == true && Paddle.getY() < (600 - Paddle.getHeight() - 20))
			{
				boolean paddleHitBlock = false;
				for (Block block: Blocks)
				{
					if (block.getX() + block.getWidth() < Paddle.getX() && Paddle.getX() < Paddle.getSpeed() + block.getX() + block.getWidth() && (inRange(Paddle.getY(), block.getY(), block.getY() + block.getHeight()) || inRange(Paddle.getY() + Paddle.getHeight(), block.getY(), block.getY() + block.getHeight()) || inRange(block.getY(), Paddle.getY(), Paddle.getY() + Paddle.getHeight()) || inRange(block.getY() + block.getHeight(), Paddle.getY(), Paddle.getY() + Paddle.getHeight())))
					{
						paddleHitBlock = true;
					}
				}
				if (!paddleHitBlock) Paddle.moveLeftAndDraw(graphToBack);
			}
			
			if (keys[2] == true && Paddle.getY() > Paddle.getSpeed())
			{
				boolean paddleHitsBlock = false;
				for (Block block: Blocks)
				{
					if (block.getY() > Paddle.getY() && Paddle.getY() > block.getY() - Paddle.getHeight() - Paddle.getSpeed() - 1 && (inRange(Paddle.getX(), block.getX(), block.getX() + block.getWidth()) || inRange(Paddle.getX() + Paddle.getWidth(), block.getX(), block.getX() + block.getWidth()) || inRange(block.getX(), Paddle.getX(), Paddle.getX() + Paddle.getWidth()) || inRange(block.getX() + block.getWidth(), Paddle.getX(), Paddle.getX() + Paddle.getWidth())))
					{
						paddleHitsBlock = true;
					}
				}
				if (!paddleHitsBlock) Paddle.moveDownAndDraw(graphToBack);
			}
			
			if (keys[3] == true && Paddle.getX() < (800 - Paddle.getWidth()))
			{
				boolean paddleHitsBlock = false;
				for (Block block: Blocks)
				{
					if (block.getX() > Paddle.getX() && Paddle.getX() > block.getX() - Paddle.getWidth() - Paddle.getSpeed() - 1 && (inRange(Paddle.getY(), block.getY(), block.getY() + block.getHeight()) || inRange(Paddle.getY() + Paddle.getHeight(), block.getY(), block.getY() + block.getHeight()) || inRange(block.getY(), Paddle.getY(), Paddle.getY() + Paddle.getHeight()) || inRange(block.getY() + block.getHeight(), Paddle.getY(), Paddle.getY() + Paddle.getHeight())))
					{
						paddleHitsBlock = true;
					}
				}
				if (!paddleHitsBlock) Paddle.moveRightAndDraw(graphToBack);
			}
			
			twoDGraph.drawImage(back, null, 0, 0);
		}

		//see if the ball hits the top or bottom wall 
		if (!(ball.getY() >= wall.getY() && ball.getY() <= wall.getHeight() - ball.getHeight() - ball.getYSpeed() - 20))
		{
			ball.setYSpeed(ball.getYSpeed() * -1);
		}
		
		//see if the ball hits the side walls
		else if(!(ball.getX() >= wall.getX() && ball.getX() <= wall.getWidth() - ball.getWidth() - ball.getXSpeed()))
		{
			ball.setXSpeed(ball.getXSpeed() * -1);
		}
		
		else if(Paddle.getX() <= 0)
		{
			PaddleHitsWall = true;
			if (!PaddleHitsWall) Paddle.moveLeftAndDraw(graphToBack);
		}
		
		//see if the ball hits the paddle
		if(ball.didCollideLeft(Paddle) && !(ball.didCollideTop(Paddle)))
		{
			if (ball.getX() <= (Paddle.getX() + Paddle.getWidth() - Math.abs(ball.getXSpeed())))
			{
				ball.setYSpeed(Math.abs(ball.getYSpeed()));
			}
			else
			{
				ball.setXSpeed(Math.abs(ball.getXSpeed()));
			}
		}
		
		if(ball.didCollideRight(Paddle) && !(ball.didCollideTop(Paddle) && !(ball.didCollideBottom(Paddle))))
		{
			if (ball.getX() >= (Paddle.getX() + Paddle.getWidth() + Math.abs(ball.getXSpeed())))
			{
				ball.setYSpeed(-1 * Math.abs(ball.getYSpeed()));
			}
			else
			{
				ball.setXSpeed(-1 * Math.abs(ball.getYSpeed()));
			}
		}
		
		if(ball.didCollideTop(Paddle) && !(ball.didCollideLeft(Paddle) && !(ball.didCollideRight(Paddle))))
		{
			if (ball.getY() >= (Paddle.getY() + Paddle.getHeight() + Math.abs(ball.getYSpeed())))
			{
				ball.setXSpeed(-1 * Math.abs(ball.getXSpeed()));
			}
			else
			{
				ball.setYSpeed(-1 * Math.abs(ball.getYSpeed()));
			}
		}
		
		if(ball.didCollideBottom(Paddle) && !(ball.didCollideLeft(Paddle) && !(ball.didCollideRight(Paddle)) && !(ball.didCollideTop(Paddle))))
		{
			if (ball.getY() <= (Paddle.getY() + Paddle.getHeight() - Math.abs(ball.getYSpeed())))
			{
				ball.setXSpeed(Math.abs(ball.getXSpeed()));
			}
			else
			{
				ball.setYSpeed(Math.abs(ball.getYSpeed()));
			}
		}
		
		//see if the ball hits the side blocks
		for (int i = 0; i < Blocks.size(); i++)
		{
			Block side = Blocks.get(i);
			if (ball.didCollideTop(side) || ball.didCollideLeft(side) || ball.didCollideRight(side) || ball.didCollideBottom(side))
			{
				if (ball.didCollideBottom(side) || ball.didCollideTop(side))
				{
					ball.setYSpeed(-1 * ball.getYSpeed());
				}
				else 
				{
					ball.setXSpeed(-1 * ball.getXSpeed());
				}
				side.draw(graphToBack, Color.WHITE);
				Blocks.remove(i);
				Pts += 1;
			}
		}

		//see if the paddles need to be moved
		if (keys[0] == true && Paddle.getY() > Paddle.getSpeed())
		{
			boolean paddleHitBlock = false;
			for (Block block: Blocks)
			{
				if (block.getY() + block.getHeight() < Paddle.getY() && Paddle.getY() < Paddle.getSpeed() + block.getY() + block.getHeight() && (inRange(Paddle.getX(), block.getX(), block.getX() + block.getWidth()) || inRange(Paddle.getX() + Paddle.getWidth(), block.getX(), block.getX() + block.getWidth()) || inRange(block.getX(), Paddle.getX(), Paddle.getX() + Paddle.getWidth()) || inRange(block.getX() + block.getWidth(), Paddle.getX(), Paddle.getX() + Paddle.getWidth())))
				{
					paddleHitBlock = true;
				}
			}
			if (!paddleHitBlock) Paddle.moveUpAndDraw(graphToBack);
		}
		
		if (keys[1] == true && Paddle.getY() < (600 - Paddle.getHeight() - 20))
		{
			boolean paddleHitBlock = false;
			for (Block block: Blocks)
			{
				if (block.getX() + block.getWidth() < Paddle.getX() && Paddle.getX() < Paddle.getSpeed() + block.getX() + block.getWidth() && (inRange(Paddle.getY(), block.getY(), block.getY() + block.getHeight()) || inRange(Paddle.getY() + Paddle.getHeight(), block.getY(), block.getY() + block.getHeight()) || inRange(block.getY(), Paddle.getY(), Paddle.getY() + Paddle.getHeight()) || inRange(block.getY() + block.getHeight(), Paddle.getY(), Paddle.getY() + Paddle.getHeight())))
				{
					paddleHitBlock = true;
				}
			}
			if (!paddleHitBlock) Paddle.moveLeftAndDraw(graphToBack);
		}
		
		if (keys[2] == true && Paddle.getY() > Paddle.getSpeed())
		{
			boolean paddleHitsBlock = false;
			for (Block block: Blocks)
			{
				if (block.getY() > Paddle.getY() && Paddle.getY() > block.getY() - Paddle.getHeight() - Paddle.getSpeed() - 1 && (inRange(Paddle.getX(), block.getX(), block.getX() + block.getWidth()) || inRange(Paddle.getX() + Paddle.getWidth(), block.getX(), block.getX() + block.getWidth()) || inRange(block.getX(), Paddle.getX(), Paddle.getX() + Paddle.getWidth()) || inRange(block.getX() + block.getWidth(), Paddle.getX(), Paddle.getX() + Paddle.getWidth())))
				{
					paddleHitsBlock = true;
				}
			}
			if (!paddleHitsBlock) Paddle.moveDownAndDraw(graphToBack);
		}
		
		if (keys[3] == true && Paddle.getX() < (800 - Paddle.getWidth()))
		{
			boolean paddleHitsBlock = false;
			for (Block block: Blocks)
			{
				if (block.getX() > Paddle.getX() && Paddle.getX() > block.getX() - Paddle.getWidth() - Paddle.getSpeed() - 1 && (inRange(Paddle.getY(), block.getY(), block.getY() + block.getHeight()) || inRange(Paddle.getY() + Paddle.getHeight(), block.getY(), block.getY() + block.getHeight()) || inRange(block.getY(), Paddle.getY(), Paddle.getY() + Paddle.getHeight()) || inRange(block.getY() + block.getHeight(), Paddle.getY(), Paddle.getY() + Paddle.getHeight())))
				{
					paddleHitsBlock = true;
				}
			}
			if (!paddleHitsBlock) Paddle.moveRightAndDraw(graphToBack);
		}
		
		twoDGraph.drawImage(back, null, 0, 0);
	}

	public void keyPressed(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0] = true; break;
			case 'A' : keys[1] = true; break;
			case 'S' : keys[2] = true; break;
			case 'D' : keys[3] = true; break;
		}
	}

	public void keyReleased(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0] = false; break;
			case 'A' : keys[1] = false; break;
			case 'S' : keys[2] = false; break;
			case 'D' : keys[3] = false; break;
		}
	}

	public void keyTyped(KeyEvent e){}
	
   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(8);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}	
}
