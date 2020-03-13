package nl.workingtalent.weekopdracht;

/*
Doel: Het aanmaken van de 52 kaarten. elke kaart heeft een puntenwaarde, kleur, getal.

getal en puntenwaarde.
aas = 1 of 11 (in de doelstelling 2 10)
boer, vrouw, heer = 10
2 t/m 10 = waarde kaart

kleuren(suit): H, S, K, R voor harten, schoppen, klaver, ruiten.
 */

public class Card {
    String value;
    String suit;
    int pointValue;


    public Card (int i) {
        this.value = Integer.toString(i);
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardnr='" + value + '\'' +
                '}';
    }
}
