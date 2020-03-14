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
            Hand player = new Hand();
            Hand dealer = new Hand();
            System.out.println(gameDeck);
            gameDeck.shuffle();
            //System.out.println(gameDeck);
            //gameDeck.printCard();
            gameDeck.firstDeal();
            player.printHand(Hand.player);
            dealer.printHand(Hand.dealer);
            player.playerOptions();

        } else if (inputYN.equals("N")) {
            System.exit(0);
        }
    }
}
