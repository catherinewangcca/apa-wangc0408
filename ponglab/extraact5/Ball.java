//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.util.*;

public class Ball extends Block
{
  private int xSpeed;
  private int ySpeed;
  private Color tempColor;
  private double tempNumber;

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
    tempNumber = Math.random();
    if (tempNumber > 0.5){
      tempColor = getColor();
    }
    else{
      tempColor = Color.WHITE;
    }
    draw(window, tempColor); 
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
      if (obj instanceof Wall){
      return (getX() == obj.getX() && getY() >= obj.getY() && getY() <= obj.getY() + obj.getHeight());
    }
    return false;
   } 

  public boolean didCollideRight(Block obj){
      if (obj instanceof Wall){
      return (getX() + getWidth() == obj.getX() && getY() >= obj.getY() && getY() <= obj.getY() + obj.getHeight());
    }
    return false;
  } 

  public boolean didCollideTop(Block obj){
      if (obj instanceof Wall){
      return (getY() == obj.getY() && getX() >= obj.getX() && getX() <= obj.getX() + obj.getWidth());
    }
    return false;
  } 

  public boolean didCollideBottom(Block obj){
    if (obj instanceof Wall){
     return (getY() == obj.getY() && getX() >= obj.getX() && getX() <= obj.getX() + obj.getWidth());
    }
    return false;
  }  
      


  //add a toString() method
  public String toString()
  {
    return super.toString() + " " + xSpeed + " " + ySpeed;
  }

}
