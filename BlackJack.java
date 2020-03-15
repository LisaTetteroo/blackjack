package nl.workingtalent.weekopdracht;

import java.util.ArrayList;
import java.util.Scanner;

public class BlackJack {

    Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        new BlackJack().playBlackJack();
    }

    public void playBlackJack() {
        System.out.println("Do you want to play blackjack? Enter Y for yes, N for No.");
        String inputYN = input.nextLine();
        if (inputYN.toUpperCase().equals("Y")) {
            Deck gameDeck = new Deck();
            Hand hand = new Hand();
            gameDeck.printDeck();
            //System.out.println(gameDeck);
            gameDeck.shuffle();
            //System.out.println(gameDeck);
            gameDeck.firstDeal();
            hand.printHand(Hand.player);
            hand.printHand(Hand.dealer);
            boolean playerBlackJack = hand.checkBlackJackPlayer();
            boolean dealerBlackJackPossible = hand.checkBlackJackDealerPossible();
            if (playerBlackJack == true && dealerBlackJackPossible == true) {
                System.out.println("Dealer has blackjack, lets see if the dealer gets blackjack too");
                Deck.dealCard(Hand.dealer);
                if (hand.checkBlackJackDealer() == true) {
                    System.out.println("standoff with two blackjacks");
                    playBlackJack();
                } else {
                    System.out.println("dealer didn't get blackjack, player wins");
                    playBlackJack();
                }
            } else if (playerBlackJack == true && dealerBlackJackPossible == false) {
                System.out.println("player wins with a blackjack");
                playBlackJack();
            } else {
                hand.playerOptions();
                playBlackJack();
            }
        } else if (inputYN.equals("N")) {
            System.exit(0);
        }
    }
}
