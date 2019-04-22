//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.util.*;

class BlinkyBall extends Ball
{

  //constructors
  public BlinkyBall()
  {
    super();
  }

  public BlinkyBall(int x, int y)
  {
    super(x,y, 50, 50);
  }

  public BlinkyBall(int x, int y, int wid, int ht)
  {
    super(x,y,wid,ht); 
  }

  public BlinkyBall(int x, int y, int wid, int ht, int xSpd, int ySpd)
  {
    super(x,y,wid,ht,Color.BLUE, xSpd, ySpd);
  }

  public BlinkyBall(int x, int y, int wid, int ht, Color col, int xSpd, int ySpd)
  {
    super(x,y,wid,ht,col,xSpd, ySpd);
  }

  public Color randomColor()
  {
    int r = (int)(Math.random()*255);		//use Math.random()
    int g = (int)(Math.random()*255);
    int b = (int)(Math.random()*255);
    return new Color(r,g,b);
  }

  public void moveAndDraw(Graphics window)
  {


    draw(window, Color.WHITE);

    setX(getX()+super.getXSpeed());
    setY(getY()+super.getYSpeed());    

    //draw the ball at its new location
    draw(window, randomColor()); 



  }
}