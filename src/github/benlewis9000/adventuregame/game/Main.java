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
            - Implement Boss mobs (DONE) and Portal/puzzle pieces
            - Implement enchants(?) & weaknesses(?)
                - Pillars/shrines on map to enable
            - Only render cells explored (in radius)        - DONE
            - Clear cell player spawns in? Add portalBase/wizrd etc.
            - Add shops across map?
     */

    /*  Settings    */
    // Todo: Have settings saved and loaded from file, have debug printed to file
    public static boolean debug = false;  // Prints debug messages
    public static final boolean SEED_ENTITIES = true;  // Spawns entities in same place based on seed
    // public static final boolean TESTING = false;     - Todo: Remove, all testing in TestSite main method
    public static final boolean TITLE_SEQUENCE = true;
    public static final int BOSSES = 7;

    public static void main(String[] args) {

        System.out.println("Main game running...\n");


        // Generate map
        MapGenerator mapGenerator = new MapGenerator();
        Map map = mapGenerator.generateMap(70, 40); //Todo - generateMap args to belong to MapGenerator?

        System.out.println("Seed: " + map.getSeed());

        // Create Player (assigned to Map, and placed on Map)
        Player player = new Player(map, 50);

        //System.out.println("Index: (" + player.getX_index() + ", " + player.getY_index() + ")");
        System.out.println("Cords: (" + player.getX_cords() + ", " + player.getY_cords() + ")");

        Game game = new Game(player);
        game.runGame();

    }

}