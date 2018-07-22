package github.benlewis9000.adventuregame.mapping;

public class Map {

    private Cell[][] cells;
    private int mapSize;
    private int x_length;
    private int y_length;

    /*
        Getters and Setters
     */

    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }

    public int getMapSize() {
        return mapSize;
    }

    private void setMapSize(int mapSize) {
        this.mapSize = mapSize;
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

    /*
            Constructor
    */

    // SQUARE map
    public Map (int mapSize){

        // Create MapGenerator, generate map in accordance to encapsulated mapSize
        MapGenerator mapGenerator = new MapGenerator();
        this.setCells(mapGenerator.generateMap(mapSize));

        this.setX_length(mapSize);
        this.setY_length(mapSize);

    }

    // VARIED map
    public Map (int x_length, int y_length){

        this.setX_length(x_length);
        this.setY_length(y_length);

        // Create MapGenerator, generate map in accordance to encapsulated mapSize
        MapGenerator mapGenerator = new MapGenerator();
        this.setCells(mapGenerator.generateMap(x_length, y_length));

    }

    /*
        Methods
     */

    public void printMap(){     // DEBUG FEATURE

        for (int x = 0; x < this.x_length; x++){
            for (int y = 0; y < this.y_length; y++){

                char out = 'o';

                Terrain terrain = cells[x][y].getTerrain();

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
                    case OUT:
                        out = 3;
                }
                System.out.print(out + " ");
            }
            System.out.println();
        }

    }

}
