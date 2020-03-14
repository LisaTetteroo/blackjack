package nl.workingtalent.weekopdracht;

import java.util.Scanner;

public class BlackJack {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Do you want to play blackjack? Enter Y for yes, N for No.");
        String inputYN = input.nextLine();
        if (inputYN.toUpperCase().equals("Y")) {
            Deck gameDeck = new Deck();
            System.out.println(gameDeck);
            gameDeck.shuffle();
            System.out.println(gameDeck);
            gameDeck.printCard();
            gameDeck.firstDeal();
        } else if (inputYN.equals("N")) {
            System.exit(0);
        }



    }
}
