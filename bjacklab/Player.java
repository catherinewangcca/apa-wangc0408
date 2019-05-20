//Name -
//Date -
//Class -
//Lab  - 

import static java.lang.System.*;
import java.util.Scanner;
import java.util.ArrayList;



//define Player class here 

public class Player extends AbstractPlayer{

public Player(){
	super();
}

public Player(ArrayList<Card> cards){
    super(cards);
  }

  public Player(int wins){
    super(wins);
  }

  public Player(ArrayList<Card> cards, int wins){
    super(cards, wins);
  }




//constructors





//hit method goes here

  public boolean hit(){
		addCardToHand(new BlackJackCard());
		return getHandValue() < 21;
	}

}