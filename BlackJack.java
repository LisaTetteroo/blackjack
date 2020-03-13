package nl.workingtalent.weekopdracht;

public class BlackJack {
    public static void main(String[] args) {
        System.out.println("let's make blackjack");

        Deck gameDeck = new Deck();
        System.out.println(gameDeck);
        gameDeck.shuffle();
        System.out.println(gameDeck);

    }


}
