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
*/

    public Card[] deck;
    private int cardsInDeck;

    public ArrayList<Card> player = new ArrayList<Card>();
    public ArrayList<Card> dealer = new ArrayList<Card>();

    public Deck() {
        this.deck = new Card[52];
        cardsInDeck = 0;
            for (int suit = 0; suit <= 3; suit++) {
                for (int value = 1; value <= 13; value++) {
                    this.deck[cardsInDeck] = new Card(value, suit);
                    cardsInDeck++;
                }
            }
        cardsInDeck = deck.length;
    }

    public void shuffle() {
        for (int i = 0; i < 52; i++) {
            int random = (int)(Math.random()*(deck.length));
            Card temp = deck[i];
            deck[i] = deck[random];
            deck[random] = temp;
        }
    }

    public void printCard() {
        System.out.println(deck[cardsInDeck-1]);
    }


    public void firstDeal() {
        for (int i = 1; i <= 2; i++) {
            dealCard(player);
        }
        System.out.println(player);
    }

    public void dealCard(ArrayList<Card> recipient) {
        Card cardDrawn = deck[cardsInDeck - 1];
        recipient.add(cardDrawn);
        cardsInDeck--;
    }



    @Override
    public String toString() {
        return "Deck{" +
                "deck=" + Arrays.toString(deck) +
                '}';
    }
}

