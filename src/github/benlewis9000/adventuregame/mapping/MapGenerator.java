package github.benlewis9000.adventuregame.mapping;

import java.util.Random;

public class MapGenerator {

    // TODO: Make static?

    private int x_Spawn;
    private int y_Spawn;
    private double shortestDistance = -1.0;



    public int getX_Spawn() {
        return x_Spawn;
    }

    public void setX_Spawn(int x_Spawn) {
        this.x_Spawn = x_Spawn;
    }

    public int getY_Spawn() {
        return y_Spawn;
    }

    public void setY_Spawn(int y_Spawn) {
        this.y_Spawn = y_Spawn;
    }



    // RANDOM map
    public Map generateMap(int x_mapSize, int y_mapSize){

        Random random = new Random();
        int seed = (random.nextInt(10000000));

        Cell[][] cells = generateCells(x_mapSize, y_mapSize, seed);

        return new Map(cells, getX_Spawn(), getY_Spawn(), seed);

    }

    // SEEDED map
    public Map generateMap(int x_mapSize, int y_mapSize, int seed){

        Cell[][] cells = generateCells(x_mapSize, y_mapSize, seed);

        return new Map(cells, getX_Spawn(), getY_Spawn(), seed);

    }

    // Todo: Put land finding algorithm in this loop so it only runs over each cell once

    public Cell[][] generateCells(int x_mapSize, int y_mapSize, int seed){

        Cell[][] cells = new Cell[y_mapSize][x_mapSize];

        // cycle each Cell (for inner array, index [0] of the outer array is used to get the inner ray and find it's length)
        for (int y = 0; y < cells.length; y++){
            for (int x = 0; x < cells[0].length; x++){

                // Create new cell at (x, y)
                cells[y][x] = new Cell();

                // Generate Terrain for cell (according to noise value)
                cells[y][x].setTerrain(generateTerrain(x, y, seed));

                // Find spawn point
                double distance = findDistance(x, y, cells[0].length/2 - 1, cells.length/2 - 1);
                if ((shortestDistance == -1.0 || distance < this.shortestDistance) && (cells[y][x].getTerrain().equals(Terrain.GRASS))){
                    shortestDistance = distance;
                    setX_Spawn(x);
                    setY_Spawn(y);
                }
            }
        }

        return cells;
    }

    public Terrain generateTerrain(int x, int y, int seed){

        /*      v3 Noise Usage          */
        // Generate noise at specific Cell cords, make positive, enlarge noise by dividing cords (AS DECIMALS)
        double noiseValue = Math.abs(SimplexNoise.noise((float) (x) / 16, (float) (y) / 16, seed));  // <- dividing cords enlarges grid - MUST BE A DECIMAL DATATYPE!

        // Return Terrain type at cords depending on noise given
        /*if (noiseValue <= 0.1){
            return Terrain.LIGHT_FOREST;
        }
        else if (noiseValue <= 0.15){
            return Terrain.LIGHT_FOREST;
        }
        else */ if (noiseValue <= 0.5){
            return Terrain.GRASS;
        }
        else if (noiseValue <= 0.6){
            return Terrain.SAND;
        }
        else if (noiseValue <= 0.9){
            return Terrain.WATER;
        }
        else if (noiseValue <= 0.92){
            return Terrain.SAND;
        }
        else {
            return Terrain.ISLAND;
        }
    }

    public double findDistance(int x_Cell, int y_Cell, int x_Center, int y_Center){

        // Find the distance between the origin and the queried cell using Pythagoras a^2 + b^2 = c^2
        double distance = Math.sqrt(Math.pow((x_Cell - x_Center), 2) + Math.pow(y_Cell - y_Center, 2)); // Use Math.pow, ^2 is not a function in Java
        //System.out.println(distance); // DEBUG
        return distance;

    }



}
