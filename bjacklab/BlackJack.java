//Name -
//Date -
//Class -
//Lab  - 

import java.util.ArrayList;
import static java.lang.System.*;
import java.util.Scanner;

public class BlackJack
{
  private ArrayList<Playerable> players;

  public BlackJack(int numPlayers)
  {
    players = new ArrayList<Playerable>();
    players.add(new Dealer());

    for (int i = 0; i<numPlayers; i++){
      players.add(new Player());
    }
  }

  public void playGame()
  {
    Scanner keyboard = new Scanner(System.in);
    char choice = 1;
    int hitResponse;
    int temp;

    do{
      ((Dealer)(players.get(0))).shuffle();

       for(int i = 1; i < players.size(); i++){
          //twice = two cards -- for all the players
          players.get(i).addCardToHand(((Dealer)(players.get(0))).deal());
          players.get(i).addCardToHand(((Dealer)(players.get(0))).deal());
      }

      players.get(0).addCardToHand(((Dealer)(players.get(0))).deal());
      players.get(0).addCardToHand(((Dealer)(players.get(0))).deal());

//each of the players plays
      for (int i = 1; i < players.size(); i++){
        System.out.println("\n\n\n Player " + i + ":: Hit? \n yes :: 1 \n no :: 2 \n\n Player \n" + players.get(i).getHandValue() + " " + players.get(i).toString());

        hitResponse = keyboard.nextInt();

        if (hitResponse == 1){
          do{
          players.get(i).addCardToHand(((Dealer)(players.get(0))).deal());
          System.out.println("\n\nPlayer " + i + ":: \n"+ i + " " + players.get(i).getHandValue() + " " + players.get(i).toString());
          if (players.get(i).getHandValue() < 21){
            System.out.println("\nPlayer " + i + ":: Hit? \n yes :: 1 \n no :: 2 \n");
            hitResponse = keyboard.nextInt();
          }
        }while(players.get(i).getHandValue() < 21 && hitResponse == 1);
      }
    }

   
   //the dealer plays
        do{

          System.out.println("\nDealer \n" + players.get(0).getHandValue() + " " + players.get(0).toString() +"\n");

        }while(players.get(0).hit());

        System.out.println("\nDealer \n" + players.get(0).getHandValue() + " " + players.get(0).toString() +"\n");

      //winner 

        for (int i = 1; i < players.size(); i++){

        if ((players.get(0).getHandValue() > 21 && players.get(i).getHandValue() > 21) || (players.get(i).getHandValue() > 21 && players.get(0).getHandValue() < 21)){
          players.get(0).setWinCount(players.get(0).getWinCount() + 1);
          System.out.println("Dealer wins since Player " + i +  " busts.");
        }
        else if (players.get(0).getHandValue() > 21){
          players.get(i).setWinCount(players.get(i).getWinCount() + 1);
          System.out.println("Player " + i +  "wins since dealer, but not Player " + i +  ", busts.");
        }
        else if (players.get(0).getHandValue() == players.get(i).getHandValue()){
          System.out.println("Tie since dealer and Player " + i + " have equal hand values.");
        }
        else if (players.get(0).getHandValue() > players.get(i).getHandValue()){
          System.out.println("Dealer wins against Player " + i +  "since dealer has a larger hand");
          players.get(0).setWinCount(players.get(0).getWinCount() + 1);
        }
        else if (players.get(0).getHandValue() < players.get(i).getHandValue()){
          players.get(i).setWinCount(players.get(i).getWinCount() + 1);
          System.out.println("Player " + i + " has a larger hand than the dealer!");
        }

        System.out.println("\n\nDealer wins " + players.get(0).getWinCount() + " game(s) and Player " + i + " wins " + players.get(i).getWinCount() + " game(s) \n\n");
        }


      System.out.println("PLAY AGAIN? \n yes:: 1 \n no:: 2 \n \n ");
        temp = keyboard.nextInt();

      //new game
        for (int i = 1; i < players.size(); i++){
          players.get(i).resetHand();
        }

        players.get(0).resetHand();
      } 
      while(temp == 1);

  }//end the method

        
  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);
    System.out.println("\n\n\nHow many players? ");
    int entry = keyboard.nextInt();
    BlackJack game = new BlackJack(entry);
    game.playGame();
  }
  }// end the class
