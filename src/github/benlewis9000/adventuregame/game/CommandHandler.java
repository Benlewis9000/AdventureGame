package github.benlewis9000.adventuregame.game;

import github.benlewis9000.adventuregame.mapping.Direction;
import github.benlewis9000.adventuregame.player.Player;

public class CommandHandler {

    public CommandHandler(String command) { }

    // Todo: Multiple constructors needed?

    // Static method that will handle no arg commands
   /* public static void onCommand(Player player, String args){

        switch (args) {

            case "inventory":
                System.out.println("What would you like do? (Type the desired command as showed)\n" +
                        "\"inventory view\"\n" +
                        "- View items in your inventory");
                break;

            case "help":
                System.out.println("Todo...");
                break;

            default:
                System.out.println("Sorry, that command doesn't exist! Type \"help\" for a list of commands");
                break;

        }

    }*/

    // ...handles 1 arg commands
    public static void onCommand(Player player, String[] args){


        // Take first arg
        switch (args[0]) {

            case "w":
                player.walk(Direction.NORTH);
                break;
            case "a":
                player.walk(Direction.WEST);
                break;
            case "s":
                player.walk(Direction.SOUTH);
                break;
            case "d":
                player.walk(Direction.EAST);
                break;

            case "map":
                player.getMap().printMap();
                break;

            case "inventory":

                if (args.length >= 2) {
                    switch (args[1]) {

                        case "view":
                            printInventory(player.getInventory().viewInventory());
                            break;

                        default:
                            System.out.println("Sorry, that command doesn't exist! Type \"help\" for a list of commands");
                            break;

                    }
                }

                else System.out.println("What would you like do? (Type the desired command as showed)\n" +
                        "\"inventory view\"\n" +
                        "- View items in your inventory");

                break;

            case "help":
                System.out.println("Todo...");
                break;

            default:
                System.out.println("Sorry, that command doesn't exist! Type \"help\" for a list of commands");
                break;


        }

    }

    private static void printInventory(String[][] contents) {

        System.out.println("Inventory:");

        for (int i = 0; i < contents.length; i++){

            // [0] name
            // [1] desc]
            // [2] quantity


            System.out.println("   " + contents[i][0] + "(" + contents[i][2] + "):\n   " +
                                contents[i][1]);

        }

    }

}
