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



    public static void playerOptions() {
        Scanner input = new Scanner(System.in);

        System.out.println("Choose your action / Kies een actie: \n" +
                "- stand/pas (S or P)\n" +
                "- Hit/Kaart (H or K)\n" +
                "- Quit (Q)");
        String option = (input.nextLine()).toUpperCase();
        if (option.equals("S") || option.equals("P")) {
            System.out.println("stand");
            playerOptions();
        } else if (option.equals("H") || option.equals("K")) {
            System.out.println("hit");
        }  else if (option.equals("Q")) {
            System.exit(0);
        }

    }

}
