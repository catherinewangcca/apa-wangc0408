//Name -
//Date -
//Class -
//Lab  - 


public abstract class Card
{
  public static final String FACES[] = {"ZERO","ACE","TWO","THREE","FOUR",
                                        "FIVE","SIX","SEVEN","EIGHT","NINE","TEN","JACK","QUEEN","KING"};

  private String suit;
  private int face;

  //constructors

  public Card(){
  	suit = "Diamonds";
  	face = 1;
  }

  public Card(String s){
  	suit = s;
  	face = 1;
  }

  public Card(int f, String s){
  	suit = s;
  	face = f;
  }


  // modifiers

  public void setSuit(String s){
  	suit = s;
  }

  public void setFace(int f){
  	face = f;
  }
 

  //accessors

  public String getSuit(){
  	return suit;
  }

  public int getFace(){
  	return face;
  }

  public abstract int getValue();

  public boolean equals(Object obj)
  {
  	Card other = (Card)obj;
  	
  		if (suit.equals(other.getSuit()) && face == other.getFace())
  		{
  			return true;
  		}

    return false;
  }

  //toString

  public String toString(){
  	return FACES[face] + " of " + getSuit() + " | value = " + getValue();
  }
        
}