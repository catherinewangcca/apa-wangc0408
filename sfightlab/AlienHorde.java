//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.List;

public class AlienHorde
{
  private List<Alien> aliens;
  private String direction;

  public AlienHorde(int size)
  {
    aliens = new ArrayList<Alien>();
    for (int i = 0; i<size; i++){
      aliens.add(new Alien(100 + 70*i, 100, 50, 50, 3)); 
    }
    direction = "LEFT";
  }

  public void add(Alien al)
  {
    aliens.add(al);
  }

  public void drawEmAll( Graphics window )
  {
    for(Alien alien : aliens) {
     alien.draw(window);
    }
  }

  
  public void wallBounce() {
        int minX = 999;
        int maxX = 0;
        for (Alien al : aliens) {
            if (al.getX() < minX) {
                minX = al.getX();
                System.out.print("testone");
            }
            if (al.getX() > maxX) {
                maxX = al.getX();
                System.out.print("testtwo");
            }
        }
        if (maxX > 800) {
            direction = "LEFT";
            System.out.print("lefttest");
        } else if (minX < 50) {
            direction = "RIGHT";
            System.out.print("righttest");
        }
        moveEmAll(direction);
    }

    public void moveEmAll(String direction) {
        for (Alien al : aliens) {
            al.move(direction);
        }
    }


  public void removeDeadOnes(List<Ammo> shots)
  {

    for (int i = aliens.size()-1; i >= 0; i--) {
      for(int a = 0; i<shots.size(); a++){
        if (shots.get(a).hit(aliens.get(i))) {
            aliens.remove(i);
          break;
        }
      }
    }
  }

  public String toString()
  {
    return "";
  }
}
