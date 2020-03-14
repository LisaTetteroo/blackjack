package nl.workingtalent.weekopdracht;

import java.util.ArrayList;
import java.util.Scanner;

public class Hand {
    /* alle basis mogelijkheden als kaart kopen en passen, plus array (?) van hand kaarten.
    Zowel deler als spelers valt hieronder.
    - om te beginnen wordt er standaard 1 speler en 1 dealer gemaakt.
    - de speler heeft kaarten in hand[]
    - Onderstaande opties moeten worden aangeboden --> playOptions()
    - Speler kan passen --> pass()
    - Speler kan kaart vragen --> hit()
    - Speler kan stoppen --> quit()
    - punten moeten geteld worden zodat vergelijking gedaan kan worden --> handPoints()
     */

    public static ArrayList<Card> player = new ArrayList<Card>();
    public static ArrayList<Card> dealer = new ArrayList<Card>();

    Scanner input = new Scanner(System.in);

    public void playerOptions() {
        System.out.println("Choose your action / Kies een actie: \n" +
                "- stand/pas (S or P)\n" +
                "- Hit/Kaart (H or K)\n" +
                "- Quit (Q)");
        String option = (input.nextLine()).toUpperCase();
        if (option.equals("S") || option.equals("P")) {
            System.out.println("stand");
        } else if (option.equals("H") || option.equals("K")) {
            Deck.dealCard(this.player);
            System.out.println(this.player);
            printHand(player);
            playerOptions();
        }  else if (option.equals("Q")) {
            System.exit(0);
        }
    }

    public void printHand(ArrayList<Card> id) {
        if (id == player) {
            System.out.print("Player hand: ");
        } else if (id == dealer) {
            System.out.print("Dealer hand: ");
        }

        for (int i=0; i < id.size(); i++) {
           String suitAsString = Card.suitAsString(id.get(i).getSuit());
           String valueAsString = Card.valueAsString(id.get(i).getValue());
           System.out.print(suitAsString + " " + valueAsString + " - ");
        }
        handValue(id);
    }

    public void handValue(ArrayList<Card> id) {
        // getPointValue voor de value van elke card in de hand
        int handValuePlayer = 0;
        for (int i=0; i < id.size(); i++) {
            handValuePlayer = handValuePlayer + id.get(i).getPointValue(id.get(i).getValue());
        }
        System.out.println(handValuePlayer + "points");
    }



    public void dealerOptions () {

    }

}
