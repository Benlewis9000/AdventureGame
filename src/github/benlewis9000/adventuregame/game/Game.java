package github.benlewis9000.adventuregame.game;

import github.benlewis9000.adventuregame.mapping.Direction;
import github.benlewis9000.adventuregame.mapping.Map;
import github.benlewis9000.adventuregame.player.Player;

import java.util.Scanner;

import static github.benlewis9000.adventuregame.game.Utilities.delay;

public class Game {

    private Map map;
    private Player player;
    public static boolean gameLive;



    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }



    public Game(Player player){

        this.setPlayer(player);
        this.setMap(player.getMap());

        this.runGame();

    }



    public void runGame(){

        if (Main.TITLE_SEQUENCE) title();

        Scanner scanner = new Scanner(System.in);

        System.out.println("\n(Press ENTER to begin...)");
        scanner.nextLine();

        if (Main.TITLE_SEQUENCE) introStory();

        //testText();

        gameLive = true;

        // Todo: block input during title sequences - (or whenever not ready)

        while (gameLive){

            String input = scanner.nextLine();

            CommandHandler.onCommand(getPlayer(), Utilities.stringToArgs(input));

        }

    }

    public static void testText(){

        System.out.println("Begin");
        delay(1000);
        System.out.println("1");
        delay(1000);
        System.out.println("2");
        delay(1000);
        System.out.println("3 - End");


    }

    public static void introStory(){

        delay(2000);

        System.out.println("\nYou stir.");
        delay(2000);
        System.out.print("\nIt's bright - ");
        delay(2000);
        System.out.println("you're blinded by the light.");

        delay(3000);

        System.out.println("\nYou don't know where you are.");
        delay(2000);
        System.out.println("You don't know how you got here.");
        delay(2000);
        System.out.println("You don't even know who you are.");

        delay(3000);

        System.out.println("\nYou lay motionless, feeling the hot sun bear down on you.");

        delay(3000);

        System.out.print("\nYou try to move... ");
        delay(2000);
        System.out.println("but to little success.");

        delay (3000);

        System.out.println("\nYou hear a murmuring - someone is busy circling about you.");
        delay(2000);
        System.out.println("They're mumbling away, you can barely make out what they're saying.");

        delay(2000);

        System.out.print("\n\"hmm... ");
        delay(2000);
        System.out.print("now what could... ");
        delay(2000);
        System.out.print("what in heavens... ");
        delay(1000);
        System.out.println("what has happened here.\"");

        delay (3000);

        System.out.println("\n\"Surely not... \"");

        delay(2000);

        System.out.println("\nIt looks like a fellow mortal soul.");
        delay(2000);
        System.out.print("But in these lands!? ");
        delay(1000);
        System.out.println("Impossible!");
        delay(2000);
        System.out.println("This dimension is only for the wretched creatures unfit to roam the mortal world.");
        delay(3000);
        System.out.println("");

    }

    public static void title(){

        System.out.println(" _______  ______            _______  _       _________          _______  _______ \n" +
                "(  ___  )(  __  \\ |\\     /|(  ____ \\( (    /|\\__   __/|\\     /|(  ____ )(  ____ \\\n" +
                "| (   ) || (  \\  )| )   ( || (    \\/|  \\  ( |   ) (   | )   ( || (    )|| (    \\/\n" +
                "| (___) || |   ) || |   | || (__    |   \\ | |   | |   | |   | || (____)|| (__    \n" +
                "|  ___  || |   | |( (   ) )|  __)   | (\\ \\) |   | |   | |   | ||     __)|  __)   \n" +
                "| (   ) || |   ) | \\ \\_/ / | (      | | \\   |   | |   | |   | || (\\ (   | (      \n" +
                "| )   ( || (__/  )  \\   /  | (____/\\| )  \\  |   | |   | (___) || ) \\ \\__| (____/\\\n" +
                "|/     \\|(______/    \\_/   (_______/|/    )_)   )_(   (_______)|/   \\__/(_______/\n" +
                "                                                                                 \n" +
                " _______  _______  _______  _______                                              \n" +
                "(  ____ \\(  ___  )(       )(  ____ \\                                             \n" +
                "| (    \\/| (   ) || () () || (    \\/                                             \n" +
                "| |      | (___) || || || || (__                                                 \n" +
                "| | ____ |  ___  || |(_)| ||  __)                                                \n" +
                "| | \\_  )| (   ) || |   | || (                                                   \n" +
                "| (___) || )   ( || )   ( || (____/\\                                             \n" +
                "(_______)|/     \\||/     \\|(_______/");

        delay(2000);
        System.out.print("        by Benlewis9000  \n");

        delay (2000);

    }

}
