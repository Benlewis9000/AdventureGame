package github.benlewis9000.adventuregame.player;

import github.benlewis9000.adventuregame.entity.Misc;
import github.benlewis9000.adventuregame.entity.Potion;
import github.benlewis9000.adventuregame.entity.Weapon;
import github.benlewis9000.adventuregame.mapping.Direction;
import github.benlewis9000.adventuregame.game.Inventory;
import github.benlewis9000.adventuregame.mapping.Cell;
import github.benlewis9000.adventuregame.mapping.Map;
import github.benlewis9000.adventuregame.mapping.Terrain;
import github.benlewis9000.adventuregame.mapping.Unit;

public class Player {

    Map map;
    Inventory inventory;

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

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
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

        // Create and set Inventory
        Inventory inventory = new Inventory();
        this.setInventory(inventory);

        this.getInventory().addItem(Potion.HEALTH_POTION);

        this.getInventory().addItem(Misc.BOAT);
        this.getInventory().addItem(Misc.BOAT);
        this.getInventory().addItem(Misc.BOAT);

        this.getInventory().addItem(Weapon.BATTLE_AXE);

        this.getInventory().addItem(Potion.HEALTH_POTION);
        this.getInventory().addItem(Potion.HEALTH_POTION);
        this.getInventory().addItem(Potion.HEALTH_POTION);
        this.getInventory().addItem(Potion.HEALTH_POTION);
        this.getInventory().addItem(Potion.HEALTH_POTION);
        this.getInventory().addItem(Potion.HEALTH_POTION);
        this.getInventory().addItem(Potion.HEALTH_POTION);


        if (this.getInventory().containsItem(Misc.BOAT)) System.out.println("You have " + this.getInventory().getItems().get(Misc.BOAT) + " boat.");
        if (this.getInventory().containsItem(Weapon.BATTLE_AXE)) System.out.println("You have " + this.getInventory().getItems().get(Weapon.BATTLE_AXE) + " battle axe.\n");

        // Set indexes for player on map grid (round to int)
        this.setX_index(map.getX_Spawn());
        this.setY_index(map.getY_Spawn());

        // Initialise reference cords at (0,0)
        this.setX_cords(this.getX_index() - (map.getX_length()/2 - 1));
        this.setY_cords((this.getY_index() - (map.getY_length()/2 - 1)) *-1);  // Correct Y orientation

        Cell[][] cells = map.getCells();

        // Place player at generated spawn points
        cells[map.getY_Spawn()][map.getX_Spawn()].setUnit(Unit.PLAYER);

    }

    public void walk(Direction direction){

        switch (direction){
            case NORTH:
                if(this.canMove(0, -1)){
                    movePlayer(0, -1);
                }
                break;
            case EAST:
                if(this.canMove(1, 0)){
                    movePlayer(1, 0);
                }
                break;
            case SOUTH:
                if(this.canMove(0, 1)){
                    movePlayer(0, 1);
                }
                break;
            case WEST:
                if(this.canMove(-1, 0)){
                    movePlayer(-1, 0);
                }
                break;
        }

        /*

            switch (direction)
            case: N, S, E, W etc

            check Unit in direction,
                if null, cancel,
                if unit (to do) trigger unit even (util?) - convert units to an arraylist
            then move,
                shift index,
                shift coord,
                update map/cells(?) etc.

         */
    }

    private boolean canMove(int x, int y) {

        if (!(getX_index() + x >= 0 && getX_index() + x <= this.getMap().getX_length() - 1
                && getY_index() + y >= 0 && getY_index() + y <= this.getMap().getY_length() - 1)){
            System.out.println("You have reached the map boundary!");
            return false;
        }
        if (getMap().getCells()[getY_index() + y][getX_index() + x].getTerrain().equals(Terrain.WATER)){
            // if (player.hasBoat) true;
            System.out.println("You need a boat to cross water!");
            return false;
        }

        return true;
    }

    private void movePlayer (int x, int y){

        Cell[][] cells = this.getMap().getCells();

        cells[getY_index()][getX_index()].setUnit(Unit.EMPTY);

        // Move index
        this.setX_index(getX_index() + x);
        this.setY_index(getY_index() + (y));
        // Move cords
        this.setX_cords(getX_cords() + x);
        this.setY_cords(getY_cords() + (y * -1)); // Correct Y orientation for cords

        cells[getY_index()][getX_index()].setUnit(Unit.PLAYER);

        System.out.println("You have moved to (" + getX_cords() + ", " + getY_cords() + ").");


    }

}
