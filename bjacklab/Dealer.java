//Name -
//Date -
//Class -
//Lab  - 

import java.util.ArrayList;

public class Dealer extends AbstractPlayer{
//define Dealer class here
        
        
        
        
//instance variable - Deck 

Deck deck;

//constructors

public Dealer(){
	super();
	deck = new Deck();
}


//method to shuffle

public void shuffle(){
	deck.shuffle();
}


//method to deal a card


public Card deal(){
	return deck.nextCard();
}


//hit method goes here

public boolean hit() {
	addCardToHand(new BlackJackCard());
	return getHandValue() < 17;
}

}	
