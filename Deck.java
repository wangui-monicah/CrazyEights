import java.util.Random;

/** Deck.java
 *   Author: Wangui Monicah Wambugu
 *
 *   Models a typical deck of playing cards
 *   To be used with Card class
 *
 */
class Deck{

    private Card[] deck; // contains the cards to play with

    private int top; // controls the "top" of the deck to deal from

    public static final char[] suit = {'c', 'd', 'h', 's'};
    public static final String[] rank = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
    public final int sizeOfDeck = 52;

    // constructs a default Deck
    public Deck(){
        // your code here
        deck = new Card[sizeOfDeck];
        int j = 0;
        for (int s = 0; s<4; s++){
            for(int i = 1; i<=13; i++){
                deck[j]=new Card(suit[s],i);
                j++;
            }
        }

    }

    // Deals the top card off the deck
    public Card deal(){
        if(top <= 51){
            return deck[top++];
        }
        else{
            return null;
        }
    }


    // returns true provided there is a card left in the deck to deal
    public boolean canDeal(){
        // your code here
        if(top<52){
            return true;
        }return false;
    }

    // Shuffles the deck
    public void shuffle(){
        // your code here
        Random rand = new Random();
        int j;
        for (int i = 0; i < sizeOfDeck; i++) {
            j = rand.nextInt(sizeOfDeck);
            Card temp = deck[i];
            deck[i] = deck[j];
            deck[j] = temp;
        }
    }

    // Returns a string representation of the whole deck
    public String toString(){
        // your code here
        String stringOfDeck = "";

         // This is printing out numbers only. How to find a way to print out full description

        for (int i = 0; i<sizeOfDeck; i++){
            stringOfDeck += deck[i].toString() + "\n";
        }
        return stringOfDeck;
    }
    







    // you may wish to have more helper methods to simplify
    // and shorten the methods above.
}

