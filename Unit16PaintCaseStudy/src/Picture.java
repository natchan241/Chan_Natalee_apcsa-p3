import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  private int[][] totalRedDigSum;
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  /*
  public void scale(Picture image, String output)
  {
	  Picture small = image.scale(0.25, 0.25);
	  small.write("src/images/" + output);
	  small.explore();
  }
  */
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }
  
  public void keepOnlyBlue()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  for (Pixel[] rowArray : pixels)
	  {
		  for (Pixel pixelObj : rowArray)
		  {
			  pixelObj.setRed(0);
			  pixelObj.setGreen(0);
		  }
	  }
  }
  
  public void keepOnlyRed()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  for (Pixel[] rowArray : pixels)
	  {
		  for (Pixel pixelObj : rowArray)
		  {
			  pixelObj.setBlue(0);
			  pixelObj.setGreen(0);
		  }
	  }
  }
  
  public void keepOnlyGreen()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  for (Pixel[] rowArray : pixels)
	  {
		  for (Pixel pixelObj : rowArray)
		  {
			  pixelObj.setRed(0);
			  pixelObj.setBlue(0);
		  }
	  }
  }
  
  public void negate()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  for (Pixel[] rowArray : pixels)
	  {
		  for (Pixel pixelObj : rowArray)
		  {
			  pixelObj.setRed(255 - pixelObj.getRed());
			  pixelObj.setGreen(255 - pixelObj.getGreen());
			  pixelObj.setBlue(255 - pixelObj.getBlue());
		  }
	  }
  }
  
  public void grayscale()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  for (Pixel[] rowArray : pixels)
	  {
		  for (Pixel pixelObj : rowArray)
		  {
			  int avg = (pixelObj.getBlue() + pixelObj.getRed() + pixelObj.getGreen()) / 3;
			  pixelObj.setRed(avg);
			  pixelObj.setBlue(avg);
			  pixelObj.setGreen(avg);
		  }
	  }  
  }
  
  public void fixUnderwater()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  int totalRed = 0;
	  int totalBlue = 0;
	  int totalGreen = 0;
	  int pixelCount = pixels.length * pixels[0].length;
	  
	  for (Pixel[] row : pixels)
	  {
		  for (Pixel pixelObj : row)
		  {
			  totalRed += pixelObj.getRed();
			  totalBlue += pixelObj.getBlue();
			  totalGreen += pixelObj.getGreen();
		  }
	  }
	  int avgRed = totalRed / pixelCount;
	  int avgBlue = totalBlue / pixelCount;
	  int avgGreen = totalGreen / pixelCount;
	  double factor = 3;
	  for (Pixel[] r : pixels)
	  {
		  for (Pixel pixel : r)
		  {
			  pixel.setGreen(pixel.getGreen() + (115 - avgGreen));
			  pixel.setBlue(pixel.getBlue() + (128 - avgBlue));
			  pixel.setRed(pixel.getRed() + (115 - avgRed));
			  pixel.setRed( (int) (pixel.getRed() - factor * (128 - pixel.getRed())));
			  pixel.setBlue( (int) (pixel.getBlue() - factor * (128 - pixel.getBlue())));
			  pixel.setGreen( (int) (pixel.getGreen() - factor * (128 - pixel.getGreen())));
		  }
	  }
  }
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }
  
  public void mirrorVerticalRightToLeft()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel leftPixel = null;
	  Pixel rightPixel = null;
	  int width = pixels[0].length;
	  for (int row = 0; row < pixels.length; row++)
	  {
	    for (int col = 0; col < width / 2; col++)
	    {
	      leftPixel = pixels[row][col];
	      rightPixel = pixels[row][width - 1 - col];
	      leftPixel.setColor(rightPixel.getColor());
	    }
	  } 
  }
  
  public void mirrorHorizontal()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel botPixel = null;
	  Pixel topPixel = null;
	  int height = pixels.length;
	  for (int row = 0; row < height / 2; row++)
	  {
	    for (int col = 0; col < pixels[row].length; col++)
	    {
	      topPixel = pixels[row][col];
	      botPixel = pixels[height - row - 1][col];
	      botPixel.setColor(topPixel.getColor());
	    }
	  }
  }
  
  public void mirrorHorizontalBotToTop()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel botPixel = null;
	  Pixel topPixel = null;
	  int height = pixels.length;
	  for (int row = 0; row < height / 2; row++)
	  {
	    for (int col = 0; col < pixels[row].length; col++)
	    {
	      topPixel = pixels[row][col];
	      botPixel = pixels[height - row - 1][col];
	      topPixel.setColor(botPixel.getColor());
	    }
	  }
  }
  
  public void mirrorDiagonal()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel lowerPixel = null;
	  Pixel upperPixel = null;
	  int square = Math.min(pixels.length, pixels[0].length);
	  
	  for (int i = 0; i < square; i++)
	  {
		  for (int j = 0; j < i; j++)
		  {
			  lowerPixel = pixels[i][j];
			  upperPixel = pixels[j][i];
			  upperPixel.setColor(lowerPixel.getColor());
		  }
	  }
  }
  
  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        count++;
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
    System.out.print(count);
  }
  
  public void mirrorArms()
  {
	  int mirrorPoint = 191;
	    Pixel botPixel = null;
	    Pixel topPixel = null;
	    Pixel[][] pixels = this.getPixels2D();
	    
	    for (int row = 160; row < mirrorPoint; row++)
	    {
	      for (int col = 103; col < 170; col++)
	      {
	        topPixel = pixels[row][col];      
	        botPixel = pixels[mirrorPoint - row + mirrorPoint][col];
	        botPixel.setColor(topPixel.getColor());
	      }
	    }
	    
	    mirrorPoint = 192;
	    for (int row = 172; row < mirrorPoint; row++)
	    {
	    	for (int col = 239; col < 295; col++)
	    	{
	    		topPixel = pixels[row][col];
	    		botPixel = pixels[mirrorPoint - row + mirrorPoint][col];
	    		botPixel.setColor(topPixel.getColor());
	    	}
	    }
  }
  
  public void mirrorGull()
  {
	  int mirrorPoint = 345;
	  Pixel leftPixel = null;
	  Pixel rightPixel = null;
	  Pixel[][] pixels = this.getPixels2D();
	  
	  for (int row = 235; row < 320; row++)
	  {
		  for (int col = 235; col < mirrorPoint; col++)
		  {
			  leftPixel = pixels[row][col];
			  rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
			  rightPixel.setColor(leftPixel.getColor());
		  }
	  }
  }
  
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }
  
  public void copy(Picture fromPic, 
                 int startRow, int startCol, int endRow, int endCol, int row, int col)
  {
	  Pixel fromPixel = null;
	  Pixel toPixel = null;
	  Pixel[][] toPixels = this.getPixels2D();
	  Pixel[][] fromPixels = fromPic.getPixels2D();
		
	  for (int fromRow = Math.min(fromPixels.length,  startRow), toRow = row; 
		  fromRow < Math.min(fromPixels.length, endRow) &&
		  toRow < toPixels.length; 
		  fromRow++, toRow++)
	  {
		  for (int fromCol = Math.min(fromPixels.length, startCol), toCol = col; 
				  fromCol < Math.min(fromPixels[0].length, endCol) &&
				  toCol < toPixels[0].length;  
				  fromCol++, toCol++)
		  {
			  fromPixel = fromPixels[fromRow][fromCol];
			  toPixel = toPixels[toRow][toCol];
			  toPixel.setColor(fromPixel.getColor());
		  }
	  }   
  }

  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("/Users/nataleechan/eclipse-workspace/Unit16PaintCaseStudy/src/images/flower1.jpg");
    Picture flower2 = new Picture("/Users/nataleechan/eclipse-workspace/Unit16PaintCaseStudy/src/images/flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write("/Users/nataleechan/eclipse-workspace/Unit16PaintCaseStudy/src/images/collage.jpg");
  }
  
  public void createMyCollage()
  {
	  Picture flower1 = new Picture("/Users/nataleechan/eclipse-workspace/Unit16PaintCaseStudy/src/images/flower1.jpg");
	  this.copy(flower1, 100, 100, 150, 150, 0, 0);
	  this.copy(flower1, 150, 0);
	  Picture invertflower = new Picture(flower1);
	  invertflower.negate();
	  this.copy(invertflower, 200, 0);
	  Picture greenFlower = new Picture(flower1);
	  greenFlower.keepOnlyGreen();
	  this.copy(greenFlower, 250, 0);
	  Picture mirrorFlower = new Picture(flower1);
	  mirrorFlower.mirrorVertical();
	  this.copy(mirrorFlower, 300, 0);
	  this.write("/Users/nataleechan/eclipse-workspace/Unit16PaintCaseStudy/src/images/collage.jpg");
  }
  
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
  }
  
  public void edgeDetection2(int edgeDist)
  {
	  Pixel leftPixel = null;
	  Pixel rightPixel = null;
	  Pixel[][] pixels = this.getPixels2D();
	  Color rightColor = null;
	  
	  for (int row = 0; row < pixels.length; row++)
	  {
	    for (int col = 0; col < pixels[0].length; col++)
	    {
	    	if (col < pixels[0].length - 1)
	    	{
	    		leftPixel = pixels[row][col];
	    		rightPixel = pixels[row][col + 1];
	    		rightColor = rightPixel.getColor();
	    		if (leftPixel.colorDistance(rightColor) > edgeDist)
	    		{
	    			leftPixel.setColor(Color.BLACK);
	    			continue;
	    		}
	    	}
	    	if (row < pixels.length - 1)
	    	{
	    		rightPixel = pixels[row + 1][col];;
	    		rightColor = rightPixel.getColor();
	    		if (leftPixel.colorDistance(rightColor) > edgeDist)
	    		{
	    			leftPixel.setColor(Color.BLACK);
	    			continue;
	    		}
	    	}
	    	leftPixel.setColor(Color.WHITE);
	    }
	  }
  }
  
  /** Hide a black and white message in the current
  * picture by changing the red to even and then
  * setting it to odd if the message pixel is black
  * @param messagePict the picture with a message
  */
  public void encode(Picture messagePict)
  	{
	  Pixel[][] messagePixels = messagePict.getPixels2D();
	  Pixel[][] currPixels = this.getPixels2D();
	  Pixel currPixel = null;
	  Pixel messagePixel = null;
	  int count = 0;
	  for (int row = 0; row < this.getHeight(); row++)
	  {
		  for (int col = 0; col < this.getWidth(); col++)
		  {
			  // if the current pixel red is odd make it even
			  currPixel = currPixels[row][col];
			  if (currPixel.getRed() % 2 == 1)
				  currPixel.setRed(currPixel.getRed() - 1);
			  messagePixel = messagePixels[row][col];
			  if (messagePixel.colorDistance(Color.BLACK) < 50)
			  {
				  currPixel.setRed(currPixel.getRed() + 1);
				  count++;
			  }
		  }
	  }
	  System.out.println(count);
  	}
  /**
  * Method to decode a message hidden in the
  * red value of the current picture
  * @return the picture with the hidden message
  */
  public Picture decode()
  	{
	  Pixel[][] pixels = this.getPixels2D();
	  int height = this.getHeight();
	  int width = this.getWidth();
	  Pixel currPixel = null;

	  Pixel messagePixel = null;
	  Picture messagePicture = new Picture(height,width);
	  Pixel[][] messagePixels = messagePicture.getPixels2D();
	  int count = 0;
	  for (int row = 0; row < this.getHeight(); row++)
	  {
		  for (int col = 0; col < this.getWidth(); col++)
		  {
			  currPixel = pixels[row][col];
			  messagePixel = messagePixels[row][col];
			  if (currPixel.getRed() % 2 == 1)
			  {
				  messagePixel.setColor(Color.BLACK);
				  count++;
			  }
		  }
	  }
	  System.out.println(count);
	  return messagePicture;
  	}
  
  public void redSumEncoder(Picture messPict)
  {
	  Pixel[][] messPixels = messPict.getPixels2D();
	  Pixel[][] picPixels = this.getPixels2D();
	  totalRedDigSum = new int[this.getHeight()][this.getWidth()];
	
	  Pixel picPixel = null;
	  Pixel messPixel = null;
	  int total = 0;
	  
	  int num = 0;
	  
	  for (int row = 0; row < this.getHeight(); row++)
	  {
		  for (int col = 0; col < this.getWidth(); col++)
		  {
			  picPixel = picPixels[row][col];
			  num = picPixel.getRed();
			  total = totalRedDigSum[row][col];
			  
			  while (num != 0)
			  {
				  total = total + num % 10;
				  num = num / 10;
			  }
			  
			  //System.out.println(totalRedDigSum);
			  
			  if (total % 2 == 0)
			  {
				  total += 1;
			  }
			  
			  //System.out.println("After: " + totalRedDigSum);
			  
			  messPixel = messPixels[row][col];
			  
			  //System.out.println(messPixel);
			  if (messPixel.colorDistance(Color.BLACK) < 50)
			  {
				  total = total - 1;
			  }
			  //System.out.println("Then: " + totalRedDigSum);
			  totalRedDigSum[row][col] = total;
		  }
	  }
  }
  
  public Picture RedSumDecoder()
  {
	  Pixel[][]pixels = this.getPixels2D();
	  
	  int height = this.getHeight();
	  int width = this.getWidth();
	  
	  Pixel picPixel = null;
	  Pixel messPixel = null;
	  
	  Picture messPic = new Picture(height, width);
	  Pixel[][]messPixels = messPic.getPixels2D();
	  
	  for (int row = 0; row < this.getHeight(); row++)
	  {
		  for (int col = 0; col < this.getWidth(); col++)
		  {
			  picPixel = pixels[row][col];
			  messPixel = messPixels[row][col];
			  
			  if (totalRedDigSum[row][col] % 2 == 0)
			  {
				  messPixel.setColor(Color.BLACK);
			  }
		  }
	  }
	  return messPic;
  }
  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture beach = new Picture("/Users/nataleechan/eclipse-workspace/Unit16PaintCaseStudy/src/images/beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
} // this } is the end of class Picture, put all new methods before this
