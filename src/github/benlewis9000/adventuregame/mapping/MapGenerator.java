package github.benlewis9000.adventuregame.mapping;

import java.util.Random;

public class MapGenerator {

    /*
        Constructor
     */

    public MapGenerator(){

    }

    /*
        Methods
     */


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

        Random random = new Random();
        int seed = random.nextInt(10000000);


        // cycle each Cell (for inner array, index [0] of the outer array is used to get the inner ray and find it's length)
        for (int y = 0; y < cells.length; y++){
            for (int x = 0; x < cells[0].length; x++){

                /*      v2 Noise Usage          */
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
                else if (noiseValue <= 1.0){
                    cell.setTerrain(Terrain.WATER);
                    cells[y][x] = cell;
                }
                else {
                    cell.setTerrain(Terrain.OUT);
                    cells[y][x] = cell;
                }

                /*      v1 Noise Usage

                // Generate noise with X, Y coordinates, round to int, make positive, cast to int
                int noiseValue = (int) Math.abs(Math.round(SimplexNoise.noise(u1, u2)));

                switch (noiseValue) {

                    case :
                        map[u1][u2] = Cell.EMPTY;
                        break;
                    case 1:
                        map[u1][u2] = Cell.ITEM;
                        break;
                    case 2:
                        map[u1][u2] = Cell.MOB;
                        break;
                    default:
                        map[u1][u2] = Cell.OUT;
                }

                */

                /*
                // Randomly select each Cell
                Random random = new Random();
                //True random:
                int randomCell = random.nextInt(3);
                */


            }
        }

    return cells;
    }

}
