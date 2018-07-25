package github.benlewis9000.adventuregame.mapping;

import java.util.Random;

public class Map {

    private Cell[][] cells;
    private int x_length;
    private int y_length;
    private int x_Spawn;
    private int y_Spawn;
    private int seed;



    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }

    public int getX_length() {
        return x_length;
    }

    public void setX_length(int x_length) {
        this.x_length = x_length;
    }

    public int getY_length() {
        return y_length;
    }

    public void setY_length(int y_length) {
        this.y_length = y_length;
    }

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

    public int getSeed() {
        return seed;
    }

    public void setSeed(int seed) {
        this.seed = seed;
    }



    // RECTANGULAR map
    public Map (Cell[][] cells, int X_SPAWN, int Y_SPAWN, int seed){

        setCells(cells);

        this.setX_length(cells[0].length);
        this.setY_length(cells.length);

        // Set spawn points for player
        setX_Spawn(X_SPAWN);
        setY_Spawn(Y_SPAWN);

        setSeed(seed);

    }



    public void printMap(){

        // Iterate through each cell
        for (int y = 0; y < this.y_length; y++){
            for (int x = 0; x < this.x_length; x++){

                char out = 'x';

                Terrain terrain = cells[y][x].getTerrain();

                // Random factor for showing tree's - Todo: Move randomness to terrain generator
                Random random = new Random();
                float treeChance = random.nextFloat();

                // Parse terrain types to char's for graphic
                switch (terrain){
                    case GRASS:
                        out = '#';
                        break;
                    case SAND:
                        out = ':';
                        break;
                    case WATER:
                        out = '~';
                        break;
                    case LIGHT_FOREST:
                        if (treeChance > 0.6){
                            out = '#';
                        } else out = '#';
                        break;
                    case DENSE_FOREST:
                        if (treeChance > 0.2){
                            out = '#';
                        } else out = '#';
                        break;
                    case ISLAND:
                        out = '#';
                        break;
                }

                // Override terrain with player icon - Todo: Apply to all units(?)
                if (cells[y][x].getUnit() != null){
                    if (cells[y][x].getUnit().equals(Unit.PLAYER)){
                        out = 'O';
                    }
                }

                System.out.print(out + " ");
            }
            System.out.println();
        }

    }

}
