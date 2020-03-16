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
        System.out.println();


        System.out.println("How many deck do you want to play with? Enter a number between 1 and 6");
        int numberOfDecks = Integer.parseInt(input.nextLine());
        System.out.println();

        if (inputYN.toUpperCase().equals("Y")) {
            Deck gameDeck = new Deck(numberOfDecks);
            Hand hand = new Hand();
            System.out.println("This is the deck we will be playing with:");
            gameDeck.printDeck();
            gameDeck.shuffle();
            System.out.println("Deck is shuffled, here is the first deal:");
            gameDeck.firstDeal();
            hand.printHand(Hand.player);
            hand.printHand(Hand.dealer);

            boolean playerBlackJack = hand.checkBlackJackPlayer();
            boolean dealerBlackJackPossible = hand.checkBlackJackDealerPossible();
            if (playerBlackJack == true && dealerBlackJackPossible == true) {
                System.out.println("Player has blackjack, lets see if the dealer gets blackjack too");
                Deck.dealCard(Hand.dealer);
                hand.printHand(Hand.dealer);
                if (hand.checkBlackJackDealer() == true) {
                    System.out.println("standoff with two blackjacks");
                    System.out.println();
                    System.out.println("===========================================================================");
                    playBlackJack();
                } else {
                    System.out.println("dealer didn't get blackjack, player wins");
                    System.out.println();
                    System.out.println("===========================================================================");
                    playBlackJack();
                }
            } else if (playerBlackJack == true && dealerBlackJackPossible == false) {
                System.out.println("player wins with a blackjack");
                System.out.println();
                System.out.println("===========================================================================");
                playBlackJack();
            } else {
                hand.playerOptions();
                System.out.println();
                System.out.println("===========================================================================");
                playBlackJack();
            }

        } else if (inputYN.equals("N")) {
            System.exit(0);
        } else {
            playBlackJack();
        }
    }
}
