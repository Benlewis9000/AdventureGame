package github.benlewis9000.adventuregame.game;

import github.benlewis9000.adventuregame.mapping.Cell;
import github.benlewis9000.adventuregame.mapping.Map;
import github.benlewis9000.adventuregame.mapping.Terrain;
import github.benlewis9000.adventuregame.mapping.Unit;

public class Player {

    Map map;

    int maxHealth;
    int health;

    int x_index;    // Cords on grid (indexes)
    int y_index;

    int x_cords; // Location in relation to fake origin
    int y_cords;

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getX_index() {
        return x_index;
    }

    public void setX_index(int x_index) {
        this.x_index = x_index;
    }

    public int getY_index() {
        return y_index;
    }

    public void setY_index(int y_index) {
        this.y_index = y_index;
    }

    public int getX_cords() {
        return x_cords;
    }

    public void setX_cords(int x_cords) {
        this.x_cords = x_cords;
    }

    public int getY_cords() {
        return y_cords;
    }

    public void setY_cords(int y_cords) {
        this.y_cords = y_cords;
    }

    // Todo: Health, Item[] items, Item equipped, armor (head/torso/legs/feet)?
    // Todo: Place player in center of map, allow for player movement (seperate move mechanic/methods)


    public Player (Map map) {

        // Set map to given Map
        this.setMap(map);

        // Set indexes for player on map grid (round to int)
        this.setX_index(Math.round(map.getX_length() / 2 - 1));
        this.setY_index(Math.round(map.getY_length() / 2 - 1));

        // Initialise reference cords at (0,0)
        this.setX_cords(0);
        this.setY_cords(0);

        Cell[][] cells = map.getCells();

        //cells[this.getY_index()][this.getX_index()].setUnit(Unit.PLAYER);

        // Todo: Check for nearest land and alter both cords and index (spiral/rectangles?)

        boolean foundLand = false;

        // Loop along Y axis
        for (int y = this.getY_index(); y < this.getMap().getY_length(); y++) {
            // If end of Y or landFound, exit
            if (y == this.getMap().getY_length() || foundLand) break;
            // Loop along X axis at Y level
            for (int x = this.getX_index(); x < this.getMap().getX_length(); x++) {
                // If X is maxed, break (todo: is this needed?)
                if (x == this.getMap().getX_length()) break;
                else {
                    if (!(this.getMap().getCells()[y][x].getTerrain().equals(Terrain.WATER))) {

                        int ogX = this.getX_index();
                        int ogY = this.getY_index();

                        // Calculate offset of trial index to original index, use for player cords (0,0) -> (x_off, y_off)
                        int x_offset = x - ogX;
                        int y_offset = y - ogY;
                        this.setX_cords(x_offset);
                        this.setY_cords(y_offset);

                        // Place player here
                        this.setX_index(x);
                        this.setY_index(y);
                        cells[this.getY_index()][this.getX_index()].setUnit(Unit.PLAYER);

                        foundLand = true;
                        break;
                    }
                }
            }
        }

        if (!foundLand) System.out.println("ERROR: Land not found.");
    }

}
