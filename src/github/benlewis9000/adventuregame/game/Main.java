package github.benlewis9000.adventuregame.game;

import github.benlewis9000.adventuregame.mapping.Map;

public class Main {

    public static void main(String[] args) {

        System.out.println("Program running...\n");

        //double x = SimplexNoise.noise(10, 8.7);

        //System.out.println(x);
        //System.out.println(String.valueOf(x));

        // Todo: Fix (x, y) orientation
        Map map = new Map(40, 100);
        map.printMap();


    }

}