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
    private final int value;
    private final int suit;

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

    public int getPointValue(int cardValue) {
        int pointValue = 0;
        if (cardValue >= 2 && cardValue <= 10) {
            pointValue = cardValue;
        } else if (cardValue >= 11 && cardValue <= 13) {
            pointValue = 10;
        } else if (cardValue == 1){
            if (!(Hand.player.contains(getValue() >= 11) || Hand.player.contains(getValue() == 1))) {
                pointValue = 11;
            } else {
                if (Hand.player.size() == 2 && Hand.player.contains(getValue() >= 11)){
                    pointValue = 11;
                } else {
                    pointValue = 1;
                }
            }
        }
        return pointValue;
    }

    public static String suitAsString(int suitAsInt) {
        switch (suitAsInt) {
            case 0: return"SCHOPPEN";
            case 1: return "HARTEN";
            case 2: return "RUITEN";
            case 3: return "KLAVER";
        }
        return "error";
    }


    public static String valueAsString (int valueAsInt) {
        switch (valueAsInt) {
            case 1: return "aas";
            case 2: return "2";
            case 3: return "3";
            case 4: return "4";
            case 5: return "5";
            case 6: return "6";
            case 7: return "7";
            case 8: return "8";
            case 9: return "9";
            case 10: return "10";
            case 11: return "boer";
            case 12: return "vrouw";
            case 13: return "heer";
        }
        return "error";
    }


    @Override
    public String toString() {
        return "Card{" +
                "value=" + value +
                ", suit=" + suit +
                '}';
    }

/*

    @Override
    public String toString() {
        return suitAsString() + " " + valueAsString();
    }

*/
}
