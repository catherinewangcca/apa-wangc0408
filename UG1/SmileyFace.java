 //(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Canvas;

public class SmileyFace extends Canvas
{
   public SmileyFace()    //constructor - sets up the class
   {
      setSize(800,600);
      setBackground(Color.WHITE);
      setVisible(true);
   }

   public void paint( Graphics window )
   {
      smileyFace(window);
   }

   public void smileyFace( Graphics window )
   {
	window.setColor(Color.YELLOW);
	window.fillOval(210, 100, 400, 400);
	
      window.setColor(Color.BLUE);
      window.drawString("SMILEY FACE LAB ", 35, 35);

      window.fillOval(350, 200, 80,80);
	window.fillOval(450, 200, 80, 80);
   window.fillOval(400, 290, 40, 40);

	window.setColor(Color.RED);
	window.drawArc(300, 380,200,15,250,120);
	
  			
   }
}
