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


  /** Method to set the red and green to 0 */
  public void onlyBlue()
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

  /** Method to negate all of the colors */
  public void negate()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setRed(255-pixelObj.getRed());
        pixelObj.setGreen(255-pixelObj.getGreen());
        pixelObj.setBlue(255-pixelObj.getBlue());
      }
    }
  }

  /** Method to gray all of the colors */
  public void grayscale()
  {
    Pixel[][] pixels = this.getPixels2D();
    //int temp = 0;
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        int temp;

        // AVERAGE ALGORITHM
        //temp = (int)pixelObj.getAverage();


        //LUMOSITY ALGORITHM
        temp = (int)pixelObj.lumosity();

        //LIGHTNESS ALGORITHM
        //temp = (int)pixelObj.lightness();

        pixelObj.setRed(temp);
        pixelObj.setGreen(temp);
        pixelObj.setBlue(temp);

      }
    }
  }


  /** Method to brighten fish */
  public void underwater()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {


        
        if (pixelObj.getRed() >= 190){
          pixelObj.setRed(255);
        }
        else{
          pixelObj.setRed(pixelObj.getRed() + 65);
        }
        if (pixelObj.getGreen() <= 60){
          pixelObj.setGreen(0);
        }
        else
        {
          pixelObj.setGreen(pixelObj.getGreen() - 60);
        }

        if (pixelObj.getBlue() <= 30){
          pixelObj.setBlue(0);
        }
        else{
        pixelObj.setBlue(pixelObj.getBlue() - 30);
        }
      }
    }
  }

  public void blur(int x, int y, int w, int h, int n)
  {
    Pixel[][] pixels = this.getPixels2D();
    int average = 0;
    Pixel left = null;
    Pixel right = null;
    Pixel top = null;
    Pixel bottom = null;
    

    while(n>=0){
    for (int row = y; row < y+h; row++)
    {
      for (int col = x; col < x+w; col++)
      {
        //if (col -1 >= 0 && row -1 >= 0 && x-1 >= 0 && y-1 >= 0 && x+1<=x+h && y+1<=y+h){
        if (col -1 >= 0 && row -1 >= 0 && col+1<=x+h && row+1<=y+h){
        left = pixels[row][col-1];
        right = pixels[row][col+1];
        top = pixels[row-1][col];
        bottom = pixels[row + 1][col];
        pixels[row][col].setBlue((int)((top.getBlue() + bottom.getBlue() + left.getBlue() + right.getBlue())*.25));
        pixels[row][col].setGreen((int)((top.getGreen() + bottom.getGreen() + left.getGreen() + right.getGreen())*.25));
        pixels[row][col].setRed((int)((top.getRed() + bottom.getRed() + left.getRed() + right.getRed())*.25));
      }
      }
    } 
    n--;
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
      for (int col = 0; col < width/2; col++)
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
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    int height = pixels.length;
    for (int row = 0; row < pixels.length/2; row++)
    {
      for (int col = 0; col < pixels[0].length; col++)
      {
        topPixel = pixels[row][col];
        bottomPixel = pixels[height - 1 - row][col];
        bottomPixel.setColor(topPixel.getColor());
      }
    } 
  }

  public void mirrorHorizontalBottomToTop()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    int height = pixels.length;
    for (int row = 0; row < pixels.length/2; row++)
    {
      for (int col = 0; col < pixels[0].length; col++)
      {
        topPixel = pixels[row][col];
        bottomPixel = pixels[height - 1 - row][col];
        topPixel.setColor(bottomPixel.getColor());
      }
    } 
  }
  
  public void mirrorDiagonal()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel sourcePixel = null;
    Pixel receivePixel = null;
    int height = pixels.length;
    int width = pixels[0].length;

    if (height < width)
    {
      for (int row = height-1; row>=0; row--)
      {
        for (int col = 0; col<height; col++){
          sourcePixel = pixels[row][col];
          receivePixel = pixels[col][row];
          receivePixel.setColor(sourcePixel.getColor());
        }
      }
    }
    else
    {
      for (int row = height -1; row>= height - 1 - width; row--)
      {
        for (int col = 0; col<width; col++){
          sourcePixel = pixels[row][col];
          receivePixel = pixels[col][row];
          receivePixel.setColor(sourcePixel.getColor());
        }
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
        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
        count++;
      }
    }
    System.out.println(count);
  }

  public void mirrorArms()
  {
    int mirrorPoint = 190; //mirror at row 199
    Pixel sourcePixel = null;
    Pixel receivePixel = null;
    Pixel[][] pixels = this.getPixels2D();

    //loop thru rows for first arm
    for (int row = 158; row < mirrorPoint; row++){
      //loop columns 100 to 169 - left arm
      for (int col = 100; col < 169; col++){
        sourcePixel = pixels[row][col];
        receivePixel = pixels[mirrorPoint + mirrorPoint - row][col];
        receivePixel.setColor(sourcePixel.getColor());
      }
    }

    //loop thru rows for second arm
    mirrorPoint = 195;
    for (int row = 169; row < mirrorPoint; row++){
      //loop cols 239 to 300 - right arm
      for (int col = 239; col<300; col++){
        sourcePixel = pixels[row][col];
        receivePixel = pixels[mirrorPoint + mirrorPoint - row][col];
        receivePixel.setColor(sourcePixel.getColor());
      }
    }
  }

  public void mirrorGull()
  {
    int mirrorPoint = 230; //mirror col 240
    Pixel sourcePixel = null;
    Pixel receivePixel = null;
    Pixel[][] pixels = this.getPixels2D();

    for (int row = 230; row < 326; row++){
      for (int col = mirrorPoint; col < 347; col++){
        sourcePixel = pixels[row][col];
        receivePixel = pixels[row][mirrorPoint+mirrorPoint-col];
        receivePixel.setColor(sourcePixel.getColor());
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
                 int startRowTo, int startColTo, int startRowFrom, int startColFrom, int endRowFrom, int endColFrom)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = startRowFrom, toRow = startRowTo; 
         fromRow < endRowFrom &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = startColFrom, toCol = startColTo; 
           fromCol < endColFrom &&
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
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write("collage.jpg");
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
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color bottomColor = null;
    for (int row = 0; row < pixels.length-1; row++)
    {
      for (int col = 0; col < pixels[0].length; col++)
      {
        topPixel = pixels[row][col];
        bottomPixel = pixels[row+1][col];
        bottomColor = bottomPixel.getColor();
        if (topPixel.colorDistance(bottomColor) > 
            edgeDist)
          topPixel.setColor(Color.BLACK);
        else
          topPixel.setColor(Color.WHITE);
      }
    }
  }

  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
} // this } is the end of class Picture, put all new methods before this
