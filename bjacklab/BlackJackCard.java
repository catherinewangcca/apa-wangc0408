//Name -
//Date -
//Class -
//Lab  - 

public class BlackJackCard extends Card
{
  //constructors

	public BlackJackCard(){
		super();
	}

	public BlackJackCard(String s){
		super(s);
	}

	public BlackJackCard(int f, String s){
		super(f, s);
	}



  public int getValue()
  {
  	if (getFace() <= 10 && getFace() >= 2){
  		return getFace();
  	}

  	else if (getFace() == 1){
  		return 11;
  	}

  	else if (getFace() > 10){
  		return 10;
  	}
    //enables you to build the value for the game into the card
    //this makes writing the whole program a little easier


    return 0;
  }
        
}