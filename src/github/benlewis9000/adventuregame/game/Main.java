package github.benlewis9000.adventuregame.game;

import github.benlewis9000.adventuregame.entity.Entity;
import github.benlewis9000.adventuregame.entity.Monster;
import github.benlewis9000.adventuregame.entity.Weapon;
import github.benlewis9000.adventuregame.mapping.Map;
import github.benlewis9000.adventuregame.mapping.MapGenerator;
import github.benlewis9000.adventuregame.player.Player;
import github.benlewis9000.adventuregame.player.PlayerState;

import java.io.*;
import java.util.Random;

public class Main {

    /*
        Todo:
            - Implement Armour
            - Implement upgradeable Weapons
            - Improve monster generation
            - Implement Boss mobs and Portal/puzzle pieces
            - Implement enchants(?) & weaknesses(?)
                - Pillars/shrines on map to enable
            - Only render cells explored (in radius)
     */

    /*  Settings    */
    // Todo: Have settings saved and loaded from file
    public static boolean debug = false;  // Prints debug messages
    public static final boolean SEED_ENTITIES = true;  // Spawns entities in same place based on seed
    public static final boolean TESTING = false;

    public static void main(String[] args) {

        System.out.println("Program running...");

        /*   TESTING SITE!   */

        if (TESTING) {


            for (Weapon weapon : Weapon.values()) {
                TestSite.testWeapon(weapon);
            }

            //TestSite.forceBattle(Weapon.SWORD, Monster.MonsterType.TIER_2);


        }


        /*   MAIN GAME      */
        else {

            // Generate map
            MapGenerator mapGenerator = new MapGenerator();
            Map map = mapGenerator.generateMap(70, 40);
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

            player.setWeapon(Weapon.BATTLE_AXE);
            player.setHealth(5);

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