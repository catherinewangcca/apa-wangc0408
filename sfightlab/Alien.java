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
  private int temp = 0;
  private int temp2 = 0;


  public Alien()
  {
    this(0,0,30,30,3);
  }

  public Alien(int x, int y)
  {
    this(x,y,30,30,3);
  }

  public Alien(int x, int y, int s)
  {
    this(x,y,30,30,s);
  }

  public Alien(int x, int y, int w, int h, int s)
  {
    super(x, y, w,h);
    speed=s;
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

  public void move(String direction)
  {
    if (rightCount < 50 )

    if (temp2 == 0 && getX() <= 750 - getWidth() - speed){
      setX(getX() + speed);
      temp = getY();
    }

    else if (getY() <= 100 + temp){
      temp2 = 1;
      setY(getY() + speed);
    }

    else if (getX() >= 0 && getY() >= 100 + temp){
      setX(getX() - speed);
      temp = getY();
    }

    else if (getX() <= 10 && getY() <= 100 + temp){
      setY(getY() + speed);
      temp2 = 0;
    }

/* locks it in place
    if (getX() <= 750 - getWidth() - speed){
      setX(getX() + speed);
      temp = getY();
    }

    else if (getX() >= 680 && getY() <= 100 + temp){
      setY(getY() + speed);
    }

    else if (getX() >= 680 && getY() >= 100 + temp){
      setX(getX() - speed);
      temp = getY();
    }

    else if (getX() <= 10 && getY() <= 100 + temp){
      setY(getY() + speed);
    }
*/

    if (direction.equals("LEFT") && getX() >=  speed){
      setX(getX() - speed);
    }
    else if (direction.equals("RIGHT") && getX() <= 750 - getWidth() - speed){
      setX(getX() + speed);
    }
    else if (direction.equals("UP") && getY() >= speed){
      setY(getY() - speed);
    }
    else if (direction.equals("DOWN") && getY() <= 550 - speed - getHeight()){
      setY(getY() + speed);
    }
    
    
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
