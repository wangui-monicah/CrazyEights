/** Game.java
 *   Author: your name here
 *
 *
 *   Game class for playing crazy eights in commandline
 *   To be used with Player, Card, Deck classes
 *
 */

import java.util.Scanner;
import java.util.ArrayList;

class Game{

    private Deck deck;
    private Player p1;
    private ArrayList<Card> compHand;

    private Card faceup;

    private char currentSuit; // need in case an 8 is played
    private Scanner input;
    

    // sets up the Game object for play
    public Game(){
        // your code here
        p1= new Player();
        compHand = new ArrayList<>();
        deck = new Deck();
        deck.shuffle();
        input = new Scanner(System.in);
    }


    // Plays a game of crazy eights. 
    // Returns true to continue playing and false to stop playing
    public boolean play(){
        // your code here

        //Description
        System.out.println("Type play to start playing");

        for (int i = 0; i < 7; i++){
            compHand.add(deck.deal());
            p1.getHand().add(deck.deal());
        }
        
        faceup = deck.deal();
        System.out.println( "Faceup card: "+ faceup.toString());

        
       while (deck.canDeal() && compHand.size() > 0 && p1.getHand().size() > 0){
            faceup = p1.playsTurn(deck, faceup);
            if(faceup.getRank() != 8)
                System.out.println( "   \n\nYou played: "+ faceup.toString()+" \n   New face up card: "+faceup.toString());
            if(faceup == null){
                break;
            }else if(faceup.getRank() == 8){
                System.out.print("Enter suit c, h, d, s to play next ");
                String userInput = input.nextLine();

                while(!userInput.equals("c") && !userInput.equals("h") && !userInput.equals("d") && !userInput.equals("s")){
                    System.out.print("Incorrect input! Enter suit c h d s ");
                    userInput = input.nextLine();
                }

                if(userInput.equals("c")){
                    faceup = new Card('c', 0);
                }else if(userInput.equals("h")){
                    faceup = new Card('h', 0);
                }if(userInput.equals("d")){
                    faceup = new Card('d', 0);
                }if(userInput.equals("s")) {
                    faceup = new Card('s', 0);
                }

                System.out.println( "faceup card suit will now be: "+ faceup.getSuit());
            }


            faceup = computerTurn();
            if(faceup.getRank() != 8)
                System.out.println( "   \n\nComputer played: "+ faceup.toString()+" \n   New face up card: "+faceup.toString());

           if(faceup == null){
               break;
            }else if(faceup.getRank() == 8){
               System.out.println( "   \n\nComputer played: "+ faceup.toString());
               faceup = new Card('c', 0);
               System.out.println( "faceup card suit will now be: "+ faceup.getSuit());
            }
           System.out.println("\n");
       }


        if(p1.getHand().size() < compHand.size()){
            System.out.println("Won");
        }else{
            System.out.println("Lost");
        }
        System.out.println("Do you want to keep playing? true/false");
        String userInput = input.nextLine();
        if (userInput.equals("true"))
            return true;
        else
            return false;
    }

    /* Naive computer player AI that does one of two actions:
        1) Plays the first card in their hand that is a valid play
        2) If no valid cards, draws until they can play

        You may choose to use a different approach if you wish but
        this one is fine and will earn maximum marks
     */
    private Card computerTurn(){
        for(int i = 0; i < compHand.size(); i++){
            if(compHand.get(i).getSuit() == faceup.getSuit() || compHand.get(i).getRank() == faceup.getRank() || compHand.get(i).getRank() == 8){
                return compHand.remove(i);
            }
        }
        while(deck.canDeal()){
            Card newCard = deck.deal();
            if(newCard.getSuit() == faceup.getSuit() || newCard.getRank() == faceup.getRank()  || newCard.getRank() == 8){
                return newCard;
            }
            compHand.add(newCard);
        }
        return null;
    }

// you will likely wish to have several more helper methods to simplify
// and shorten the methods above.


}