/** Card.java
 *   Author: Wangui Monicah Wambugu
 *
 *
 *   Models a typical playing card
 *
 */

class Card{

    private char suit;
    private int rank;

    // Initializes a card instance
    public Card(char suit, int rank){
        // your code here
        this.rank = rank;
        this.suit = suit;
    }

    // Accessor for suit
    public char getSuit(){
        // your code here;
        return suit;
    }

    // Accessor for rank
    public int getRank(){
        // your code here;
        return rank;
    }

    // Returns a human readable form of the card (eg. King of Diamonds)
    public String toString(){
        // your code here
        return this.rank + " of " + this.suit;
    }
}