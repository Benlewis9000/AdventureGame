package github.benlewis9000.adventuregame.game;

import github.benlewis9000.adventuregame.mapping.Map;

public class Main {

    public static void main(String[] args) {

        System.out.println("Program running...");

        // Generate RECTANGLE map
        Map map = new Map(100, 20);
        System.out.println("Seed: " + map.getSeed() + "\n");

        Player player = new Player(map);

        player.getMap().printMap();

        System.out.println("Index: (" + player.getX_index() + ", " + player.getY_index() + ")");
        System.out.println("Cords: (" + player.getX_cords() + ", " + player.getY_cords() + ")");



    }

}

/*
        Movement:
            - boolean canMove(), check adjacent cell in direction of movement
            - ^if true, move(), deleting player Unit from previous cell and adding to new one(?),
                also check for current unit
                Should moving be done by fake coords and indexes? a player unit isn't needed?
 */