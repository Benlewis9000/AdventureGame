package github.benlewis9000.adventuregame.game;

import github.benlewis9000.adventuregame.mapping.Map;
import github.benlewis9000.adventuregame.mapping.MapGenerator;

public class Main {

    public static void main(String[] args) {

        System.out.println("Program running...");

        // Generate RECTANGLE map
        MapGenerator mapGenerator = new MapGenerator();
        Map map = mapGenerator.generateMap(100, 20, 5657964);
        System.out.println("Seed: " + map.getSeed() + "\n");

        Player player = new Player(map);

        System.out.println(
                "Index: (" + player.getX_index() + ", " + player.getY_index() + ")\n"
                + "Cords: (" + player.getX_cords() + ", " + player.getY_cords() + ")");

        player.getMap().printMap();


    }

}

/*
        Movement:
            - boolean canMove(), check adjacent cell in direction of movement
            - ^if true, move(), deleting player Unit from previous cell and adding to new one(?),
                also check for current unit
                Should moving be done by fake coords and indexes? a player unit isn't needed?
 */