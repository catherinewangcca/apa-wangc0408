//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Canvas;

class Robot extends Canvas
{
  public Robot()    //constructor method - sets up the class
  {
    setSize(800,600);
    setBackground(Color.WHITE);   	
    setVisible(true);
  }
  
  public void paint( Graphics window )
  {
    window.setColor(Color.BLUE);
    
    window.drawString("Robot LAB ", 35, 35 );
    
    head(window);
	upperBody(window);
	lowerBody(window);
    
  }
  
  public void head( Graphics window )
  {
    window.setColor(Color.YELLOW);
    
    window.fillOval(190, 125, 30, 30);
window.fillOval(250, 125, 30, 30);
    

    //add more code here
    
  }

  public void upperBody( Graphics window )
  {
	
    window.setColor(Color.RED);
	window.fillRect(150, 50, 150, 150);
  }

  public void lowerBody( Graphics window )
  {
	window.fillRect(150, 400, 50, 150);
	window.fillRect(250, 400, 50, 150);
	window.setColor(Color.YELLOW);
	window.fillRect(150, 250, 150, 150);
	window.setColor(Color.BLUE);
	window.fillRect(200, 250, 50, 50);

    //add more code here
    
  }
}
