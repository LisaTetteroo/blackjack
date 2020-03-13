package nl.workingtalent.weekopdracht;

import java.util.Arrays;

public class Deck {
/*
Doelstelling 1: Het deck zijn de kaarten waarmee gepeeld wordt. Er wordt in eerste instantie met 52 kaarten gespeeld.
--> plan: Deck is een arraylist van 52 kaarten. Dus als deck geinitialiseerd wordt wordt een variabele deck gemaakt van type String[], waarin kaarten worden toegevoegd.
--> Deze kaarten moeten geschud kunnen worden --> shuffle()
// optie voor als tijd: er kan met meerdere decks gespeeld worden.
*/

    private Card[] deck;

    public Deck() {
        this.deck = new Card[52];
        for (int i = 1; i < deck.length; i++) {
            this.deck[i] = new Card(i);
        }
    }



    @Override
    public String toString() {
        return "Deck{" +
                "deck=" + Arrays.toString(deck) +
                '}';
    }

}

