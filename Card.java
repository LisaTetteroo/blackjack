package nl.workingtalent.weekopdracht;

/*
Doel: Het aanmaken van de 52 kaarten. elke kaart heeft een puntenwaarde, kleur, getal.

getal en puntenwaarde.
aas = 1 of 11 punten  (in de doelstelling 2 10) (naam --> int = 1)
boer, vrouw, heer = 10 punten (naam --> int boer = 11, vrouw = 12, heer = 13)
2 t/m 10 = waarde kaart

kleuren(suit): S=0,H=1,R=2,K=3 (schoppen, harten, ruiten, klaveren)
 */

public class Card {
    private int value;
    private int suit;
    private int pointValue;

    public static final int SCHOPPEN = 0, HARTEN = 1, RUITEN = 2, KLAVER = 3;
    public static final int AAS = 1, BOER = 11, VROUW = 12, HEER = 13;



    public Card (int value, int suit) {
        this.value = value;
        this.suit = suit;
    }

    public int getValue() {
        return value;
    }

    public int getSuit() {
        return suit;
    }
/*
    @Override
    public String toString() {
        return "Card{" +
                "value=" + value +
                ", suit=" + suit +
                ", pointValue=" + pointValue +
                '}';
    }

 */
}
