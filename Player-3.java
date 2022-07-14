/** Player.java
 *   Author: your name here
 *
 *   Player class as part of Crazy Eights
 *   To be used with Game, Card, Deck classes
 *
 */

import java.util.ArrayList;
import java.util.Scanner;

class Player{

    private ArrayList<Card> hand; // the player's hand
    private Scanner input;

    public Player(){
        // your code here
        hand = new ArrayList<>();
        input = new Scanner(System.in);
    }

    // Adds a card to the player's hand
    public void addCard(Card c){
        // your code here
        hand.add(c);


    }

    // Covers all the logic regarding a human player's turn
    // public so it may be called by the Game class
    public Card playsTurn(Deck deck, Card faceup){
        // your code here
        
        printHand();
        System.out.print("Press 1. to play 2. to draw ");
        int userInput = input.nextInt();

        while(userInput < 1 || userInput > 2){
            System.out.print("Incorrect input! Press 1. to play 2. to draw ");
            userInput = input.nextInt();
        }

        if(userInput == 1){
            System.out.print("Which card would you like to play? ");
            userInput = input.nextInt();

            while(userInput < 0 || userInput > hand.size() ){
                System.out.print("Incorrect input! Which card would you like to play? ");
                userInput = input.nextInt();
            }

            while(hand.get(userInput).getSuit() != faceup.getSuit() && hand.get(userInput).getRank() != faceup.getRank()  && hand.get(userInput).getRank() != 8){
                System.out.print("Cannot play card! Which card would you like to play? Enter -1 to draw card ");
                userInput = input.nextInt();
                if(userInput == -1){
                    break;
                }
            }
            if(userInput == -1){
                userInput = 2;
            }else{
                    return hand.remove(userInput);
            }

        }
        if (userInput == 2){

            if(deck.canDeal()){
                hand.add(deck.deal());
                printHand();

                do {
                    System.out.print("Which card would you like to play? press -1 to draw card");
                    userInput = input.nextInt();
                    if(userInput == -1) {
                        hand.add(deck.deal());
                        printHand();
                    }
                } while (userInput == -1);


                while(hand.get(userInput).getSuit() != faceup.getSuit() && hand.get(userInput).getRank() != faceup.getRank()  && hand.get(userInput).getRank() != 8){
                    System.out.println("Invalid, try again: pick valid card or press -1 to draw card ");

                    userInput = input.nextInt();
                    if(userInput == -1){
                        do {
                            hand.add(deck.deal());
                            printHand();
                            System.out.print("Which card would you like to play? press -1 to draw card");
                            userInput = input.nextInt();
                        } while (userInput == -1 && deck.canDeal());
                        if(!deck.canDeal()) {
                            return null;
                        }
                        
                    }
                }
                return hand.remove(userInput);
            }
        }
        return null;
    }


    // Accessor for the players hand
    public ArrayList<Card> getHand(){
        // your code here
        return hand;
    }

    // Returns a printable string representing the player's hand
    public String handToString(){
        // your code here
        return hand.toString();

    }


    public void printHand(){
        for (int i = 0; i < hand.size(); i++){
            System.out.println((i) +". "+ hand.get(i).toString());
        }
    }

// you will likely wish to have several more helper methods to simplify
// and shorten the methods above.

} // end
