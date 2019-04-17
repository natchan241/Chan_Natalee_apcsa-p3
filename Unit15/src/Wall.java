//(c) A+ Computer Science
//www.apluscompsci.com
//Name: Natalee Chan

public class Wall extends Block
{
	private int width, height;
	
	public Wall()
	{
		setPos(0, 0);
		width = 800;
		height = 600;
	}
	
	public Wall(int wid, int ht)
	{
		setPos(0, 0);
		setWidHt(wid, ht);
	}
	
	public void setWidHt(int wid, int ht)
	{
		width = wid;
		height = ht;
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public int getHeight()
	{
		return height;
	}
}
