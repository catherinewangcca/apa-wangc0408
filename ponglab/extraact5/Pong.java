//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.util.*;

public class Pong extends Canvas implements KeyListener, Runnable
{
  private Ball ball;
  private Paddle leftPaddle;
  private Paddle rightPaddle;
  private boolean[] keys;
  private BufferedImage back;
  private Score leftCount;
  private Score rightCount;
  private Wall leftWall;
  private Wall rightWall;
  private Wall topWall;
  private Wall bottomWall;
  private boolean[] invisibleGrid;

  public Pong()
  {
    //set up all variables related to the game

    // new walls
    	leftWall = new Wall(1, 1, 1, 600, Color.RED);
    	rightWall = new Wall(779, 0, 1, 600, Color.PINK);
    	topWall = new Wall(0, 0, 800, 1, Color.PINK);
    	bottomWall = new Wall(599, 0, 600, 1, Color.PINK);

  	 //instantiate a Ball
		ball = new Ball(200, 200, 10, 10, Color.BLUE, 3, 1);
		
    //instantiate a left Paddle
		leftPaddle = new Paddle(30, 250, 10, 100, Color.BLACK, 5);
		
    //instantiate a right Paddle
		rightPaddle = new Paddle(770, 250, 10, 100, Color.BLACK, 5);

	// instantiate new Player counts
		leftCount = new Score("leftPlayer");
		rightCount = new Score("rightPlayer");




    keys = new boolean[4];
    invisibleGrid = new boolean[2];

    
    setBackground(Color.WHITE);
    setVisible(true);
		
    new Thread(this).start();
    addKeyListener(this);		//starts the key thread to log key strokes
  }
	
  public void update(Graphics window){
    paint(window);
  }

  public void paint(Graphics window)
  {
    //set up the double buffering to make the game animation nice and smooth
    Graphics2D twoDGraph = (Graphics2D)window;

    //take a snap shop of the current screen and same it as an image
    //that is the exact same width and height as the current screen
    if(back==null)
      back = (BufferedImage)(createImage(getWidth(),getHeight()));

    //create a graphics reference to the back ground image
    //we will draw all changes on the background image
    Graphics graphToBack = back.createGraphics();


    ball.moveAndDraw(graphToBack);
    leftPaddle.draw(graphToBack);
    rightPaddle.draw(graphToBack);
    leftWall.draw(graphToBack);
    rightWall.draw(graphToBack);
    topWall.draw(graphToBack);
    bottomWall.draw(graphToBack);

    // collide left wall
    if (ball.didCollideLeft(leftWall)){
      rightCount.addPoints();
      ball.setXSpeed(0); // if this is buggy, change the params here and following to 0
      ball.setYSpeed(0);
    }

    if (ball.didCollideRight(rightWall)){
      leftCount.addPoints();
      ball.setXSpeed(0); // if this is buggy, change the params here and following to 0
      ball.setYSpeed(0);
    }

    if (ball.didCollideTop(topWall)){
    	ball.setYSpeed(-ball.getYSpeed());
    }

    if (ball.didCollideBottom(bottomWall)){
    	ball.setYSpeed(-ball.getYSpeed());
    }


    /*see if ball hits left wall or right wall
    if(!(ball.getX()>=1 && ball.getX()<=780))
    {
      ball.setXSpeed(0); // if this is buggy, change the params here and following to 0
      ball.setYSpeed(0);
      //ball.setXSpeed(-ball.getXSpeed());
    }
	*/
		
    //see if the ball hits the top or bottom wall 

     if(!(ball.getY()>=10 && ball.getY()<=572))
    {
      //ball.setXSpeed(-ball.getXSpeed()); // if this is buggy, change the params here and following to 0
      ball.setYSpeed(-ball.getYSpeed());
    }

    


  	ifHitLeftPaddle();
  	ifHitRightPaddle();

  	graphToBack.setColor(Color.WHITE);
  	graphToBack.fillRect(200,400,300,300);
  	graphToBack.setColor(Color.BLACK);

  	graphToBack.drawString(leftCount.toString(), 350, 550);
  	graphToBack.drawString(rightCount.toString(), 350, 560);
			
  

	
		

    //see if the paddles need to be moved


	if (keys[0])
    {
      //move left paddle up and draw it on the window
      if (leftPaddle.getY() >=10)
        leftPaddle.moveUpAndDraw(graphToBack);
    }
    if (keys[1])
    {
      //move left paddle down and draw it on the window
      if (leftPaddle.getY() <=472)
        leftPaddle.moveDownAndDraw(graphToBack);
    }
    if (keys[2])
    {
      //move right paddle up and draw it on the window
      if (rightPaddle.getY() >=10)
        rightPaddle.moveUpAndDraw(graphToBack);

    }
    if (keys[3])
    {
      //move right paddle up and draw it on the window
      if (rightPaddle.getY() <= 472)
        rightPaddle.moveDownAndDraw(graphToBack);
    }


    twoDGraph.drawImage(back, null, 0, 0);
  }

  public void ifHitLeftPaddle(){

  //see if the ball hits the left paddle
	if ((ball.getX() <= leftPaddle.getX() + leftPaddle.getWidth() + Math.abs(ball.getXSpeed())) && (ball.getY() >= leftPaddle.getY() && ball.getY() <= leftPaddle.getY() + leftPaddle.getHeight() || ball.getY() + ball.getHeight()
>= leftPaddle.getY() && ball.getY() + ball.getHeight() < leftPaddle.getY() + leftPaddle.getHeight()))
	{
		if (ball.getX() <= leftPaddle.getX() + leftPaddle.getWidth() - Math.abs(ball.getXSpeed())){
				ball.setYSpeed(-ball.getYSpeed());
				//leftCount.addPoints();
			}	
		else	
			ball.setXSpeed(-ball.getXSpeed());
	}

  }

  public void ifHitRightPaddle(){
  	//see if the ball hits the right paddle

	
	if ((ball.getX() >= rightPaddle.getX() /* took out the next phrase*/  - rightPaddle.getWidth() - Math.abs(ball.getXSpeed())) && (ball.getY() >= rightPaddle.getY() && ball.getY() <= rightPaddle.getY() + rightPaddle.getHeight() || ball.getY() + ball.getHeight()
>= rightPaddle.getY() && ball.getY() + ball.getHeight() < rightPaddle.getY() + rightPaddle.getHeight()))
	{
		if (ball.getX() <= rightPaddle.getX() /*took out the next phrase*/ - rightPaddle.getWidth() + Math.abs(ball.getXSpeed())){
				ball.setYSpeed(-ball.getYSpeed());
				//rightCount.addPoints();
			}
		else	
			ball.setXSpeed(-ball.getXSpeed());
	}	
  }

  public void keyPressed(KeyEvent e)
  {
    switch(toUpperCase(e.getKeyChar()))
    {
    case 'W' : keys[0]=true; break;
    case 'Z' : keys[1]=true; break;
    case 'I' : keys[2]=true; break;
    case 'M' : keys[3]=true; break;
    }
  }

  public void keyReleased(KeyEvent e)
  {
    switch(toUpperCase(e.getKeyChar()))
    {
    case 'W' : keys[0]=false; break;
    case 'Z' : keys[1]=false; break;
    case 'I' : keys[2]=false; break;
    case 'M' : keys[3]=false; break;
    }
  }

  public void keyTyped(KeyEvent e){}
	
  public void run()
  {
    try
    {
      while(true)
      {
	Thread.currentThread().sleep(8);
	repaint();
      }
    }catch(Exception e)
    {
    }
  }	
}