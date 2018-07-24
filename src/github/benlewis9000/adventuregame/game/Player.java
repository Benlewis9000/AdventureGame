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
        this.setX_index(map.getX_Spawn());
        this.setY_index(map.getY_Spawn());

        // Initialise reference cords at (0,0)
        this.setX_cords(this.getX_index() - (map.getX_length()/2 - 1));
        this.setY_cords(this.getY_index() - (map.getY_length()/2 - 1));

        Cell[][] cells = map.getCells();

        // Place player at generated spawn points
        cells[map.getY_Spawn()][map.getX_Spawn()].setUnit(Unit.PLAYER);

    }

}
