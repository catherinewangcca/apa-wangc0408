//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

public class Alien extends MovingThing
{
  private int speed;
  private Image image;
  private String direction;
  private int yCount;
  private int i = 0;
  private int a = 0;


  public Alien()
  {
    this(0,0,30,30,3);
    direction = "LEFT";
  }

  public Alien(int x, int y)
  {
    this(x,y,30,30,3);
    direction = "LEFT";
  }

  public Alien(int x, int y, int s)
  {
    this(x,y,30,30,s);
    direction = "LEFT";
   } 

  public Alien(int x, int y, int w, int h, int s)
  {
    super(x, y, w,h);
    speed=s;
    direction = "LEFT";
    try
    {
      URL url = getClass().getResource("alien.jpg");
      image = ImageIO.read(url);
    }
    catch(Exception e)
    {
      //feel free to do something here
    }
  }

  public void setSpeed(int s)
  {
    speed = s;
  }

  public int getSpeed()
  {
    return speed;
  }

  public void move(String direction) {
    switch (direction) {
      case "LEFT":
        setX(getX() - speed);
        break;
      case "RIGHT":
        setX(getX() + speed);
        break;
      case "UP":
        setY(getY() - speed);
        break;
      case "DOWN":
        setY(getY() + speed);
        break;
    }
  }

  public void move(){
      if (i >= 0 && i < 300){
        move("LEFT");
        i++;
      }
      else if (i >= 300 && i < 350){
        move("DOWN");
        i++;
      }
      else if (i >= 350 && i < 650){
        move("RIGHT");
        i++;
      }
      else if (i >= 650 && i < 700){
        move("DOWN");
        i++;
      }
      if (i == 700){
        i = 0;
        a++;
      }
    }
  
  public int getA(){
    return a;
  }

  public boolean didCollideLeft(){
    return true;
  }

  public void draw( Graphics window )
  {
    window.drawImage(image,getX(),getY(),getWidth(),getHeight(),null);
  }

  public String toString()
  {
    return "";
  }
}
