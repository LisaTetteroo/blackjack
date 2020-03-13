package nl.workingtalent.weekopdracht;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Deck {
/*
Doelstelling 1: Het deck zijn de kaarten waarmee gepeeld wordt. Er wordt in eerste instantie met 52 kaarten gespeeld.
--> plan: Deck is een arraylist van 52 kaarten. Dus als deck geinitialiseerd wordt wordt een variabele deck gemaakt van type Card[], waarin kaarten ongeschuffeld worden toegevoegd.
--> Deze kaarten moeten geschud kunnen worden --> shuffle()
// optie voor als tijd: er kan met meerdere decks gespeeld worden.
*/

    private Card[] deck;

    public Deck() {
        this.deck = new Card[52];
        int cardNumber = 0;
        while (cardNumber < deck.length) {
            for (int suit = 0; suit <= 3; suit++) {
                for (int value = 1; suit < 13; value++) {
                    this.deck[cardNumber] =new Card(value, suit);
                }
            }
            cardNumber++;
        }
    }

/*
    @Override
    public String toString() {
        return "Deck{" +
                "deck=" + Arrays.toString(deck) +
                '}';
    }

 */
}

