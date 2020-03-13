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

    /*
    public static final int SCHOPPEN = 0, HARTEN = 1, RUITEN = 2, KLAVER = 3;
    public static final int AAS = 1, BOER = 11, VROUW = 12, HEER = 13;
     */

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
    public String suitAsString() {
        String stringSuit = "";
        switch (suit) {
            case 0: stringSuit = "S";
            case 1: stringSuit = "H";
            case 2: stringSuit = "R";
            case 3: stringSuit = "K";
        }
        return stringSuit;
    }


    public String valueAsString () {
        String stringValue = "";
        switch (value) {
            case 1: stringValue = "aas";
            case 2: stringValue = "2";
            case 3: stringValue = "3";
            case 4: stringValue = "4";
            case 5: stringValue = "5";
            case 6: stringValue = "6";
            case 7: stringValue = "7";
            case 8: stringValue = "8";
            case 9: stringValue = "9";
            case 10: stringValue = "10";
            case 11: stringValue = "boer";
            case 12: stringValue = "vrouw";
            case 13: stringValue = "heer";
        }
        return stringValue;
    }
    */

    @Override
    public String toString() {
        return "Card{" +
                "value=" + value +
                ", suit=" + suit +
                ", pointValue=" + pointValue +
                '}';
    }
}
