package github.benlewis9000.adventuregame.game;

import github.benlewis9000.adventuregame.entity.Entity;
import github.benlewis9000.adventuregame.entity.Monster;
import github.benlewis9000.adventuregame.mapping.Map;
import github.benlewis9000.adventuregame.mapping.MapGenerator;
import github.benlewis9000.adventuregame.player.Player;

import java.io.*;
import java.util.Random;

public class Main {

    /*
        Todo:
            - Implement Battle system
            - Allow player to equip items
            - Improve monster generation
     */

    /*  Settings    */
    // Todo: Have settings saved and loaded from file
    public static final boolean debug = false;  // Prints debug messages
    public static final boolean seedEntities = true;  // Spawns entities in same place based on seed
    public static final boolean testing = false;

    public static void main(String[] args) {

        System.out.println("Program running...");

        /*   TESTING SITE!   */

        if (testing) {

            // TestSite.test();

            //TestSite.testFight();

        }


        /*   MAIN GAME      */
        else {

            // Generate map
            MapGenerator mapGenerator = new MapGenerator();
            Map map = mapGenerator.generateMap(40, 40, 8876222);
            System.out.println("Seed: " + map.getSeed() + "\n");

            // Create Player (assigned to Map, and placed on Map)
            Player player = new Player(map);

            System.out.println(
                    "Index: (" + player.getX_index() + ", " + player.getY_index() + ")\n"
                            + "Cords: (" + player.getX_cords() + ", " + player.getY_cords() + ")");

            //player.getMap().printMap();

            // CME cell:
            System.out.println("\nEntities:");
            for (Entity entity : player.getMap().getCells()[11][12].getEntities()){
                System.out.println(entity.getName());
            }

            Game game = new Game(player);
            game.runGame();

        }

    }

}

/*
        Movement:
            - boolean canMove(), check adjacent cell in direction of movement
            - ^if true, move(), deleting player Unit from previous cell and adding to new one(?),
                also check for current unit
                Should moving be done by fake coords and indexes? a player unit isn't needed?
 */