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


  public Alien()
  {
    this(0,0,30,30,3);
    direction = "RIGHT";
  }

  public Alien(int x, int y)
  {
    this(x,y,30,30,3);
    direction = "RIGHT";
  }

  public Alien(int x, int y, int s)
  {
    this(x,y,30,30,s);
    direction = "RIGHT";
   } 

  public Alien(int x, int y, int w, int h, int s)
  {
    super(x, y, w,h);
    speed=s;
    direction = "RIGHT";
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
    if (getX() >= 700){
      for (int i = 0; i<30; i++){
      move("DOWN");
      }
      move("LEFT");
      if (getX() <= 10){
        for (int i = 0; i<30; i++){
      move("DOWN");
      }
      move("RIGHT");
      }
    }
  }


  /*public void move(String direction)
  {
    if (direction.equals("LEFT") && getX() >=  speed){
      setX(getX() - speed);
    }
    else if (direction.equals("RIGHT") && getX() <= 720 - getWidth() - speed){
      setX(getX() + speed);
      System.out.println("right triggered");
    }
    else if (direction.equals("DOWN") && getY() <= 520 - speed - getHeight()){
      setY(getY() + speed);
    }
  }

  public void setDirection(String dir)
  {
    direction = dir;
  }

  public void move()
  {
    if((getX() < 15 && direction.equals("LEFT")) || (getX() > 670 && direction.equals("RIGHT")))
    {
      move("DOWN"); /*
      for (int i = 0; i<15; i++){
        move("DOWN");
      }

      if(getY() >= yCount*getHeight()) {
        if("LEFT".equals(direction)){
          //direction = "RIGHT";
          move("RIGHT");

        }
        else {
          move("LEFT");
          //direction = "LEFT";
        }
        yCount += 2;
      }
    } else
      move(direction);
  }
  */

  public void draw( Graphics window )
  {
    window.drawImage(image,getX(),getY(),getWidth(),getHeight(),null);
  }

  public String toString()
  {
    return "";
  }
}
