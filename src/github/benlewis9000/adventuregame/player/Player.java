package github.benlewis9000.adventuregame.player;

import github.benlewis9000.adventuregame.entity.*;
import github.benlewis9000.adventuregame.game.EventHandler;
import github.benlewis9000.adventuregame.game.Utilities;
import github.benlewis9000.adventuregame.mapping.Direction;
import github.benlewis9000.adventuregame.game.Inventory;
import github.benlewis9000.adventuregame.mapping.Cell;
import github.benlewis9000.adventuregame.mapping.Map;
import github.benlewis9000.adventuregame.mapping.Terrain;

import java.util.HashSet;
import java.util.Iterator;

public class Player implements Entity {

    private String name = "Player";
    Map map;
    Inventory inventory;

    int maxHealth;
    int health;

    int x_index;    // Cords on grid (indexes)
    int y_index;
    int previousX_index;
    int previousY_index;
    int renderDistance;

    int x_cords; // Location in relation to fake origin
    int y_cords;

    Weapon weapon;
    // Todo: Armour armour; (?)

    PlayerState state;


    public String getName() { return name; }

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

    public int getPreviousX_index() {
        return previousX_index;
    }

    public void setPreviousX_index(int previousX_index) {
        this.previousX_index = previousX_index;
    }

    public int getPreviousY_index() {
        return previousY_index;
    }

    public void setPreviousY_index(int previousY_index) {
        this.previousY_index = previousY_index;
    }

    public int getRenderDistance() {
        return renderDistance;
    }

    public void setRenderDistance(int renderDistance) {
        this.renderDistance = renderDistance;
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

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public PlayerState getState() {
        return state;
    }

    public void setState(PlayerState state) {
        this.state = state;
    }

    //  Todo: armor (head/torso/legs/feet)?

    /*   TEST PLAYER CONSTRUCTOR     */
    ////   DO NOT USE!   ////
    public Player(){
        this.setMaxHealth(100);
        this.setHealth(this.getMaxHealth());
    }
    ////////////////////////

    public Player (Map map) {

        // Set map to given Map
        this.setMap(map);

        this.setMaxHealth(100);
        this.setHealth(getMaxHealth());

        // Create and set Inventory
        Inventory inventory = new Inventory();
        this.setInventory(inventory);

        // Set indexes for player on map grid (round to int)
        this.setX_index(map.getX_Spawn());
        this.setY_index(map.getY_Spawn());

        // Initialise reference cords at (0,0)
        this.setX_cords(this.getX_index() - (map.getX_length()/2 - 1));
        this.setY_cords((this.getY_index() - (map.getY_length()/2 - 1)) *-1);  // Correct Y orientation

        Cell[][] cells = map.getCells();

        // Add Player entity to Cell at spawn indexes
        cells[map.getY_Spawn()][map.getX_Spawn()].getEntities().add(this);

        this.setRenderDistance(5);
        renderCells(getRenderDistance());

        this.setWeapon(Weapon.FIST);
        this.setState(PlayerState.ROAMING);

    }

    public Cell getCell(){
        return this.getMap().getCells()[getY_index()][getX_index()];
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
    }

    private boolean canMove(int x, int y) {

        // If player reaches map boundary...
        if (!(getX_index() + x >= 0 && getX_index() + x <= this.getMap().getX_length() - 1
                && getY_index() + y >= 0 && getY_index() + y <= this.getMap().getY_length() - 1)){
            System.out.println("You have reached the map boundary!");
            return false;
        }

        if (getMap().getCells()[getY_index() + y][getX_index() + x].getTerrain().equals(Terrain.WATER)){

            // If player does NOT have boat...
            if(! getInventory().getItems().containsKey(Misc.BOAT)){
                System.out.println("You need a boat to cross water!");
                return false;
            }
            else return true;
        }

        return true;
    }

    public void movePlayer (int x, int y){

        System.out.println("You have moved to (" + (getX_cords() + x) + ", " + (getY_cords() + y * -1) + ").");

        Cell[][] cells = this.getMap().getCells();

        // Remove Player from original cell
        cells[getY_index()][getX_index()].getEntities().remove(this);

        // SET NEW INDEXES
        // Set previous index
        this.setPreviousX_index(getX_index());
        this.setPreviousY_index(getY_index());
        // Move index
        this.setX_index(getX_index() + x);
        this.setY_index(getY_index() + y);
        // Move cords
        this.setX_cords(getX_cords() + x);
        this.setY_cords(getY_cords() + (y * -1)); // Correct Y orientation for cords


        /* Iterator test */

        HashSet<Entity> entities = cells[getY_index()][getX_index()].getEntities();
        Iterator<Entity> entityIterator = entities.iterator();

        // Call EventHandler on entities in new Cell
        // THROWS: CME - collection modified during iteration, :. use Iterator
        while (entityIterator.hasNext()) {

            Entity entity = entityIterator.next();

            if (EventHandler.onEntityCollision(entity, this) ) {
                if (entity instanceof Item) entityIterator.remove();
            }
        }

        // Add Player entity to new cell
        cells[getY_index()][getX_index()].getEntities().add(this);

        // Render new cells
        renderCells(getRenderDistance());

    }

    public void setPlayer(int x, int y){

        Cell[][] cells = this.getMap().getCells();
        HashSet<Entity> entities = cells[getY_index()][getX_index()].getEntities();

        // Check for player instances and remove them from entities of retreating cell
        for (Entity entity : entities){
            if (entity instanceof Player){
                entities.remove(entity);
            }
        }

        // SET NEW INDEXES
        // Move index
        this.setX_index(x);
        this.setY_index(y);
        // Move cords
        this.setX_cords(x - (map.getX_length()/2 - 1));
        this.setY_cords((y - (map.getY_length()/2 - 1)) *-1); // Correct Y orientation for cords

        cells[getY_index()][getX_index()].getEntities().add(this);

        renderCells(getRenderDistance());

        System.out.println("You have moved to (" + getX_cords() + ", " + getY_cords() + ").");


    }

    public void renderCells(int radius){

        Utilities.debug("#rendering...");

        /*
                pi * r^2 = area
         */

        // Start and end point of sqaure based iteration
        int startX = getX_index() - radius;
        int endX = getX_index() + radius;
        int startY = getY_index() - radius;
        int endY = getY_index() + radius;

        // Make sure iteration does not spill outside map
        if (startX < 0) startX = 0;
        if (endX > getMap().getX_length()) endX = getMap().getX_length();

        if (startY < 0) startY = 0;
        if (endY > getMap().getY_length()) endY = getMap().getY_length();

        // Iterate over decreased area
        for (int y = startY; y < endY; y++){
            for (int x = startX; x < endX; x++){

                Utilities.debug("#  loop");

                // Find hypotenuse between origin and reference point
                double hyp = (double) Math.sqrt( Math.pow( (getY_index() - y), 2.0) + Math.pow( (getX_index() - x), 2.0) );

                // If hyp is greater than radius, Cell is within circle, therefore isVisible(true);
                if (hyp < radius){
                    Utilities.debug("#  (" + x + ", " + y + ") rendered" );
                    getMap().getCells()[y][x].setVisible(true);
                }

            }
        }
    }

    public void damage(int dmg){

        this.setHealth(getHealth() - dmg);
        if (getHealth() <= 0){
            setHealth(0);
            setState(PlayerState.DEAD);
        }

    }

}
