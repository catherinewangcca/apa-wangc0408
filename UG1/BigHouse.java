//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Canvas;

public class BigHouse extends Canvas
{
   public BigHouse()  //constructor - sets up the class
   {
      setSize(800,600);
      setBackground(Color.WHITE);
      setVisible(true);
   }

   public void paint( Graphics window )
   {
      //call bigHouse
   }

   public void bigHouse( Graphics window )
   {
      window.setColor(Color.BLUE);

      window.drawString( "BIG HOUSE ", 50, 50 );
	window.fillRect(100, 100, 800, 200);

      window.setColor(Color.RED);
	window.fillRect(200,300,600,600);

	window.setColor(Color.YELLOW);
	window.fillRect(300,400,100,100);
	window.fillRect(500,400,100,100);


	window.setColor(Color.WHITE);
      window.fillRect(400, 600, 200, 300 );

   }
}
