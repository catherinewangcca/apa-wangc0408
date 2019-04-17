//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Paddle extends Block
{
  //instance variables
  private int speed;

  public Paddle()
  {
    super(10,10);
    speed =5;
  }

  public Paddle(int x, int y)
  {
    super(x, y, 70, 200, Color.BLACK);
    setSpeed(5); // look at this if it isn't moving fast enough
  }

  public Paddle(int x, int y, int yPos) // I set this to yPos, if it doesn't work, change it to xPos
  {
    super(x, y, 70, yPos, Color.BLACK);
    setSpeed(5); // look at this if it isn't moving fast enough
  }

  public Paddle(int x, int y, int xPos, int yPos, int sp)
  {
    super(x, y, xPos, yPos, Color.BLACK);
    setSpeed(sp); 
  }

  public Paddle(int x, int y, int xPos, int yPos, Color c, int sp)
  {
    super(x, y, xPos, yPos, c);
    setSpeed(sp); 
  }

/*

  public Paddle(int x, int y, int sp)
  {
    super(10, 10, 70, 200, Color.BLACK);
    setSpeed(sp); 
  }

*/  

  //add the other Paddle constructors



  public void setSpeed(int sp){
    speed = sp;
  }

  public int getSpeed(){
    return speed;
  }


  public void moveUpAndDraw(Graphics window)
  {
    draw(window, Color.WHITE);


    setY(getY()-speed);    

    //draw the ball at its new location
    draw(window, getColor()); 

  }

  public void moveDownAndDraw(Graphics window)
  {


  } 
   
   
  //add a toString() method

  public String toString(){
    return super.toString() + " " + getSpeed();
  }
}