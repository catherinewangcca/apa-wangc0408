//Name -
//Date -
//Class -
//Lab  - 

import java.util.ArrayList;

public abstract class AbstractPlayer implements Playerable
{
  private ArrayList<Card> hand;
  private int winCount;

  //constructors

  public AbstractPlayer(){
    hand = new ArrayList<Card>();
    winCount = 0;
  }

  public AbstractPlayer(ArrayList<Card> cards){
    hand = cards;
    winCount = 0;
  }

  public AbstractPlayer(int wins){
    hand = new ArrayList<Card>();
    winCount = wins;
  }

  public AbstractPlayer(ArrayList<Card> cards, int wins){
    hand = cards;
    winCount = wins;
  }

  public  void addCardToHand( Card temp )
  {
    hand.add(temp);
  }

  public  void resetHand( )
  {
    hand = new ArrayList<Card>();
  }

  public  void setWinCount( int numWins )
  {
    winCount = numWins;
  }

  public int getWinCount() { return winCount; }

  public int getHandSize() { return hand.size(); }

  public int getHandValue()
  {
    //great example of polymorphism
    int total=0;

    for (int i = 0; i<hand.size(); i++){
      total += hand.get(i).getValue();
    }

    return total;
  }

  public String toString()
  {
    return "hand = " + hand.toString() + "\n - hand value = " + getHandValue() + " \n-  # wins " + winCount;
  }
}