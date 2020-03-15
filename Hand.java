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

    public static ArrayList<Card> player;
    public static ArrayList<Card> dealer;

    Scanner input = new Scanner(System.in);

    public Hand() {
        this.player = new ArrayList<Card>();
        this.dealer = new ArrayList<Card>();
    }

    public void playerOptions() {
        System.out.println("Choose your action / Kies een actie: \n" +
                "- stand/pas (S or P)\n" +
                "- Hit/Kaart (H or K)\n" +
                "- Quit (Q)");
        String option = (input.nextLine()).toUpperCase();
        if (option.equals("S") || option.equals("P")) {
            dealerOptions ();
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
        System.out.println(handValue(id) + " points");
    }

    public int handValue(ArrayList<Card> id) {
        // getPointValue voor de value van elke card in de hand
        int handValuePlayer = 0;
        for (int i=0; i < id.size(); i++) {
            handValuePlayer = handValuePlayer + id.get(i).getPointValue(id.get(i).getValue());
        }
        return handValuePlayer;
    }

    public void dealerOptions () {
        if (handValue(dealer) < 17) {
            Deck.dealCard(dealer);
            printHand(dealer);
            dealerOptions();
        } else {
            System.out.println("dealer stands at 17");
            checkWinner();
        }
    }

    public void checkWinner() {
        int pointsPlayer = handValue(player);
        int pointsDealer = handValue(dealer);
        System.out.println("player points: " +pointsPlayer);
        System.out.println("Dealer points: " + pointsDealer);
        if (pointsDealer > 21 && pointsPlayer > 21) {
            System.out.println("standoff");
        } else if (pointsDealer > 21 && pointsPlayer <= 21) {
            System.out.println("player wins");
        } else if ( pointsPlayer > 21 && pointsDealer <=21) {
            System.out.println("dealer wins");
        } else if (pointsDealer > pointsPlayer) {
            System.out.println("dealer wins");
        } else if (pointsPlayer > pointsDealer) {
            System.out.println("player wins");
        } else if (pointsDealer == pointsPlayer && checkBlackJackDealer() == true) {
            System.out.println("Dealer wins");
        } else if (pointsDealer == pointsPlayer) {
            System.out.println("standoff");
        }
    }

    public boolean checkBlackJackPlayer() {
        boolean playerBlackJack = false;
        if (handValue(player) == 21) {
            //System.out.println("player has blackjack");
            playerBlackJack = true;
        }
        return playerBlackJack;
    }

    public boolean checkBlackJackDealerPossible() {
        boolean dealerBlackJack = false;
        if (handValue(dealer) == 11) {
            //System.out.println("dealer can still get blackjack");
             dealerBlackJack = true;
        }
        return dealerBlackJack;
    }

    public boolean checkBlackJackDealer() {
        boolean dealerBlackJack = false;
        if (handValue(dealer) == 21 && dealer.size() == 2) {
            //System.out.println("dealer has blackjack");
            dealerBlackJack = true;
        }
        return dealerBlackJack;
    }
}
