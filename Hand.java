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
        Hierbij moet rekening gehouden worden met azen.
    - er moet op blackjack gecontroleerd worden

    // extra plan: om met meerdere spelers te spelen:
    --> via contructor aantal spelers als argument/parameter en dan dat als loop gebruiken.
    --> dan moet ook puntentelling aangepast etcetera.
    ==> Krijg niet bedacht hoe, want hoe maak ik nieuwe players aan met verschillende naam. Tenzij ik meerdere constructoren maak met elk een ander aantal?
     */


    public static ArrayList<Card> dealer;
    public static ArrayList<Card> player;

    /*
    voorbereiding meerdere spelers
    public static ArrayList<Card> player1;
    public static ArrayList<Card> player2;
    public static ArrayList<Card> player3;
     */

    Scanner input = new Scanner(System.in);

    public Hand() {
        this.player = new ArrayList<Card>();
        this.dealer = new ArrayList<Card>();
    }

    public void playerOptions() {
        System.out.println();
        System.out.println("Choose your action: \n" +
                "- Stand (S or P)\n" +
                "- Hit (H or K)\n" +
                "- Quit (Q)");
        String option = (input.nextLine()).toUpperCase();
        if (option.equals("S") || option.equals("P")) {
            dealerOptions ();
        } else if (option.equals("H") || option.equals("K")) {
            Deck.dealCard(this.player);
            printHand(player);
            printHand(dealer);
            if (handValue(player) < 21) {
                playerOptions();
            } else if (handValue(player) == 21){
                System.out.println();
                System.out.println("Player has 21 points, dealer wil play now:");
                dealerOptions ();
            } else if (handValue(player) > 21) {
                System.out.println();
                System.out.println("Player has more than 21 points, player busts, dealer wins");
            }
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
        int handValuePlayer = 0;
        for (int i=0; i < id.size(); i++) {
            handValuePlayer = handValuePlayer + id.get(i).getPointValue(id.get(i).getValue());
        }
        handValuePlayer = handValuePlayer - aceSubstraction(id);
        return handValuePlayer;
    }

    public void dealerOptions () {
        System.out.println();
        if (handValue(dealer) < 17) {
            Deck.dealCard(dealer);
            printHand(dealer);
            dealerOptions();
        } else {
            System.out.println("Dealer stands at 17. Point totals are:");
            checkWinner();
        }
    }

    public void checkWinner() {
        int pointsPlayer = handValue(player);
        int pointsDealer = handValue(dealer);
        System.out.println("Player points: " +pointsPlayer);
        System.out.println("Dealer points: " + pointsDealer);
        System.out.println();
        if (pointsDealer > 21 && pointsPlayer > 21) {
            System.out.println("Push");
        } else if (pointsDealer > 21 && pointsPlayer <= 21) {
            System.out.println("Player wins");
        } else if ( pointsPlayer > 21 && pointsDealer <=21) {
            System.out.println("Dealer wins");
        } else if (pointsDealer > pointsPlayer) {
            System.out.println("Dealer wins");
        } else if (pointsPlayer > pointsDealer) {
            System.out.println("Player wins");
        } else if (pointsDealer == pointsPlayer && checkBlackJackDealer() == true) {
            System.out.println("Dealer wins");
        } else if (pointsDealer == pointsPlayer) {
            System.out.println("Push");
        }
    }

    public boolean checkBlackJackPlayer() {
        boolean playerBlackJack = false;
        if (handValue(player) == 21) {
            playerBlackJack = true;
        }
        return playerBlackJack;
    }

    public boolean checkBlackJackDealerPossible() {
        boolean dealerBlackJack = false;
        if (handValue(dealer) == 11 || handValue(dealer) == 10) {
             dealerBlackJack = true;
        }
        return dealerBlackJack;
    }

    public boolean checkBlackJackDealer() {
        boolean dealerBlackJack = false;
        if (handValue(dealer) == 21 && dealer.size() == 2) {
            dealerBlackJack = true;
        }
        return dealerBlackJack;
    }

    public int aceSubstraction(ArrayList<Card>  id){
        // als oplossing voor puntentelling met 2 azen in 1 hand, terwijl er geen split optie is.
        int aceCount = 0;
        int aceSubstraction = 0;
        for (int i=0; i < id.size(); i++) {
            if (id.get(i).getValue() == 1) {
                aceCount++;
            }
        }
        if (aceCount <= 1) {
            aceSubstraction = 0;
        } else {
            aceSubstraction = 10 * (aceCount - 1);
        }
        return aceSubstraction;
    }
}
