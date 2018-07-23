package github.benlewis9000.adventuregame.mapping;

import java.util.Random;

public class MapGenerator {

    private int seed;

    public int getSeed() {
        return seed;
    }

    public void setSeed(int seed) {
        this.seed = seed;
    }



    // Construct generator with RANDOM seed
    public MapGenerator(){
        Random random = new Random();
        this.setSeed(random.nextInt(10000000));

    }

    // Construct generator with DEFINED seed
    public MapGenerator(int seed){
        this.setSeed(seed);     // Seed: 6461964 is a cool seed (y>200)
    }



    public Cell[][] generateMap(int mapSize){

        // Create grid of Cell's (2D array)
        Cell[][] newMap = new Cell[mapSize][mapSize];

        // Generate Cell's for the map, and return
        return generateCells(newMap);

    }

    public Cell[][] generateMap(int x_mapSize, int y_mapSize){

        // Create grid of Cell's (2D array)
        Cell[][] newMap = new Cell[y_mapSize][x_mapSize];

        // Generate Cell's for the map
        newMap = generateCells(newMap);

        return newMap;

    }

    public Cell[][] generateCells(Cell[][] cells){

        // cycle each Cell (for inner array, index [0] of the outer array is used to get the inner ray and find it's length)
        for (int y = 0; y < cells.length; y++){
            for (int x = 0; x < cells[0].length; x++){

                /*      v3 Noise Usage          */
                // Generate noise at specific Cell cords, make positive, enlarge noise by dividing cords (AS DECIMALS)
                double noiseValue = Math.abs(SimplexNoise.noise((float) (x) / 32, (float) (y) / 32, seed));  // <- dividing cords enlarges grid - MUST BE A DECIMAL DATATYPE!

                Cell cell = new Cell();

                // Assign Cell type at cords depending on noise given
                if (noiseValue <= 0.5){
                    cell.setTerrain(Terrain.GRASS);
                    cells[y][x] = cell;
                }
                else if (noiseValue <= 0.6){
                    cell.setTerrain(Terrain.SAND);
                    cells[y][x] = cell;
                }
                else if (noiseValue <= 0.9){
                    cell.setTerrain(Terrain.WATER);
                    cells[y][x] = cell;
                }
                else if (noiseValue <= 0.92){
                    cell.setTerrain(Terrain.SAND);
                    cells[y][x] = cell;
                }
                else {
                    cell.setTerrain(Terrain.GRASS);
                    cells[y][x] = cell;
                }

            }
        }

    return cells;
    }

}
