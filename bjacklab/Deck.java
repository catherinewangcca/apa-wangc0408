//Name -
//Date -
//Class -
//Lab  - 

import java.util.ArrayList;
import java.util.Collections;

public class Deck
{
  public static final int NUMFACES = 13;
  public static final int NUMSUITS = 4;
  public static final int NUMCARDS = 52;

  public static final String SUITS[] = {"CLUBS","SPADES","DIAMONDS","HEARTS"};

  private int topCardIndex;
  private ArrayList<Card> stackOfCards;

  public Deck ()
  {
    BlackJackCard temp;
    stackOfCards = new ArrayList<Card>();
    topCardIndex = NUMCARDS - 1;
    //initialize data - stackOfCards - topCardIndex
                
                
    //loop through suits
    //loop through faces
    //add in a new card
    for (int face = 0; face < 13; face++){
      for (int suit = 0; suit < 4; suit++){
        temp = new BlackJackCard(face, SUITS[suit]);
        stackOfCards.add(temp);
      }
    }
  }

  //modifiers
  public void shuffle ()
  {
    //shuffle the deck
    //reset variables as needed
    Collections.shuffle(stackOfCards);
    topCardIndex = stackOfCards.size() -1;
  }

  //accessors
  public int size ()
  {
    return stackOfCards.size();
  }

  public int numCardsLeft()
  {
    return topCardIndex + 1;
  }

  public Card nextCard()
  {
    if (topCardIndex >= 0){
    return stackOfCards.get(topCardIndex--);
    }
    return null;
  }

  public String toString()
  {
    return stackOfCards + "   topCardIndex = " + topCardIndex;
  } 
}