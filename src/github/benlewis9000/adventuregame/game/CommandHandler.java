package github.benlewis9000.adventuregame.game;

import github.benlewis9000.adventuregame.entity.Weapon;
import github.benlewis9000.adventuregame.mapping.Direction;
import github.benlewis9000.adventuregame.player.Player;
import github.benlewis9000.adventuregame.player.PlayerState;

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

        PlayerState state = player.getState();

        // Take first arg
        switch (args[0]) {

            case "w":
                if (state != PlayerState.ROAMING) {
                    System.out.println("You may not do this!");
                    break;
                }
                player.walk(Direction.NORTH);
                break;
            case "a":
                if (state != PlayerState.ROAMING) {
                    System.out.println("You may not do this!");
                    break;
                }
                player.walk(Direction.WEST);
                break;
            case "s":
                if (state != PlayerState.ROAMING) {
                    System.out.println("You may not do this!");
                    break;
                }
                player.walk(Direction.SOUTH);
                break;
            case "d":
                if (state != PlayerState.ROAMING) {
                    System.out.println("You may not do this!");
                    break;
                }
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

                        case "equip":
                            if (args.length > 3){
                                System.out.println("Please state which weapon you would like to equip.");
                            }
                            else {

                                switch (args[2]){

                                    case "dagger":
                                        if (player.getInventory().containsItem(Weapon.DAGGER)){
                                            player.setWeapon(Weapon.DAGGER);
                                            System.out.println("You have equipped the dagger.");
                                        }
                                        else System.out.println("You do not have this weapon!");
                                        break;

                                    case "sword":
                                        if (player.getInventory().containsItem(Weapon.SWORD)){
                                            player.setWeapon(Weapon.SWORD);
                                            System.out.println("You have equipped the sword.");
                                        }
                                        else System.out.println("You do not have this weapon!");
                                        break;

                                    case "battle":
                                        if (player.getInventory().containsItem(Weapon.BATTLE_AXE)){
                                            player.setWeapon(Weapon.BATTLE_AXE);
                                            System.out.println("You have equipped the battle axe.");
                                        }
                                        else System.out.println("You do not have this weapon!");
                                        break;

                                    case "war":
                                        if (player.getInventory().containsItem(Weapon.WAR_HAMMER)){
                                            player.setWeapon(Weapon.WAR_HAMMER);
                                            System.out.println("You have equipped the war hammer.");
                                        }
                                        else System.out.println("You do not have this weapon!");
                                        break;

                                    default:
                                        System.out.println("Please enter a valid weapon!");

                                }

                            }
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
                System.out.println("Type the command and necessary args as stated below:" +
                        "\n    W/A/S/D:" +
                        "\n    - Move North/West/South/East" +
                        "\n    inventory view" +
                        "\n    - View available items in your inventory" +
                        "\n    inventory equip <weapon>" +
                        "\n    - Equip a weapon in your inventory for battle" +
                        "\n    map" +
                        "\n    - View the current map");
                break;

            default:
                System.out.println("Sorry, that command doesn't exist! Type \"help\" for a list of commands.");
                break;


        }

    }

    public static boolean onBattleCommand(Battle battle, Player player, String[] args){

        switch (args[0].toLowerCase()){

            case "fight":
                battle.playerAttack();
                return true;
            default:
                return false;

            // Todo...
            /*
                    inventory view
                    inventory equip (weapon)
                    inventory use (consumable e.g. food/potion)
                    run (exits)

             */

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
