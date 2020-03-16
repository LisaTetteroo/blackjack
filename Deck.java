package nl.workingtalent.weekopdracht;

import java.util.Arrays;
import java.util.ArrayList;

public class Deck {
/*
Doelstelling 1: Het deck zijn de kaarten waarmee gepeeld wordt. Er wordt in eerste instantie met 52 kaarten gespeeld.
--> plan: Deck is een arraylist van 52 kaarten. Dus als deck geinitialiseerd wordt wordt een variabele deck gemaakt van type Card[], waarin kaarten ongeschuffeld worden toegevoegd.
--> Deze kaarten moeten geschud kunnen worden --> shuffle()
--> De karten moeten gedeeld kunnen worden --> deal()
// optie voor als tijd: er kan met meerdere decks gespeeld worden.
    --> via contructor aantal decks als argument/parameter en dan dat als loop gebruiken.
    ==> Done
*/

    static public Card[] deck;
    static private int cardsInDeck;



    public Deck() {
        deck = new Card[52];
        cardsInDeck = 0;
            for (int suit = 0; suit <= 3; suit++) {
                for (int value = 1; value <= 13; value++) {
                    this.deck[cardsInDeck] = new Card(value, suit);
                    cardsInDeck++;
                }
            }
        cardsInDeck = deck.length;
    }

    public Deck(int aantalDecks) {
        deck = new Card[(52*aantalDecks)];
        cardsInDeck = 0;
        for(int i = 1; i <= aantalDecks; i++) {
            int cardsInSingleDeck = 0;
            for (int suit = 0; suit <= 3; suit++) {
                for (int value = 1; value <= 13; value++) {
                    this.deck[cardsInDeck] = new Card(value, suit);
                    cardsInSingleDeck++;
                    cardsInDeck++;
                }
            }
        }
        //cardsInDeck = deck.length;
    }

    public void shuffle() {
        for (int n = 0; n <= 2; n++) {
            for (int i = 0; i < deck.length; i++) {
                int random = (int) (Math.random() * (deck.length));
                Card temp = deck[i];
                deck[i] = deck[random];
                deck[random] = temp;
            }
        }
    }

    /*
    public void printCard() {
        System.out.println(deck[cardsInDeck-1]);
    }
    */

    public void printDeck() {
        for (int i = 0; i < cardsInDeck; i++) {
            String suitAsString = Card.suitAsString(deck[i].getSuit());
            String valueAsString = Card.valueAsString(deck[i].getValue());
            System.out.print(suitAsString + " " + valueAsString + " - ");
        }
        System.out.println();
        System.out.println();
    }

    public void firstDeal() {
        for (int i = 1; i <= 2; i++) {
            dealCard(Hand.player);
        }
        // System.out.println("player hand" + Hand.player);
        dealCard(Hand.dealer);
        // System.out.println("dealer hand" + Hand.dealer);
    }

    public static void dealCard(ArrayList<Card> recipient) {
        Card cardDrawn = deck[cardsInDeck - 1];
        recipient.add(cardDrawn);
        cardsInDeck--;
    }



    @Override
    public String toString() {
        return "deck=" + Arrays.toString(deck);
    }
}

