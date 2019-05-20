//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block, implements Collidable
{
  private int xSpeed;
  private int ySpeed;

  public Ball()
  {
    super(200,200);
    xSpeed = 3;
    ySpeed = 1;
  }

  //add the other Ball constructors
	
	
  public Ball(int xS)
  {
    super(200,200);
    xSpeed = xS;
    ySpeed = 1;
  }

  public Ball(int xS, int yS)
  {
    super(200,200);
    xSpeed = xS;
    ySpeed = yS;
  }

  public Ball(int x, int y, int w, int h)
  {
    super(x, y, w, h);
    xSpeed = 3;
    ySpeed = 1;
  }

  public Ball(int x, int y, int w, int h, Color c)
  {
    super(x, y, w, h, c);
    xSpeed = 3;
    ySpeed = 1;
  }

  public Ball(int x, int y, int w, int h, Color c, int xS, int yS)
  {
    super(x, y, w, h, c);
    xSpeed = xS;
    ySpeed = yS;
  }

  // set methods 
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
    //draw a white ball at old ball location
    //draw(window, Color.WHITE);
    draw(window, Color.WHITE);

    setX(getX()+xSpeed);
    setY(getY()+ySpeed);    

    //draw the ball at its new location
    draw(window, getColor()); 
 }
   
  public boolean equals(Object obj)
  {
    Ball other = (Ball)obj;
    if (super.equals(other) && xSpeed == other.getXSpeed() &&  ySpeed == other.getYSpeed())
    {
	return true;
    }
    return false;
  }   

  //add the get methods
  
  public int getXSpeed()
  {
    return xSpeed;
  }

  public int getYSpeed()
  {
    return ySpeed;
  }

  public boolean didCollideLeft(Block obj){
    
  }

   boolean didCollideRight(Block obj);  
   boolean didCollideTop(Block obj);  
   boolean didCollideBottom(Block obj);  

  //add a toString() method
  public String toString()
  {
    return super.toString() + " " + xSpeed + " " + ySpeed;
  }

}
