package github.benlewis9000.adventuregame.mapping;

import github.benlewis9000.adventuregame.entity.*;
import github.benlewis9000.adventuregame.game.Main;
import github.benlewis9000.adventuregame.game.Utilities;

import java.util.*;

public class MapGenerator {

    private int x_Spawn;
    private int y_Spawn;
    private int seed;
    private double shortestDistance = -1.0;
    private ArrayList<Integer> islandXCords = new ArrayList<>();
    private ArrayList<Integer> islandYCords = new ArrayList<>();


    /*

        Todo: Optimise BOSS mob placement;
            Add all Island terrain cords to a collection, allows for quicker
            selecting of random spawn points for Island Boss

     */


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

    public double getShortestDistance() {
        return shortestDistance;
    }

    public void setShortestDistance(double shortestDistance) {
        this.shortestDistance = shortestDistance;
    }

    public ArrayList<Integer> getIslandXCords() {
        return islandXCords;
    }

    public void setIslandXCords(ArrayList<Integer> islandXCords) {
        this.islandXCords = islandXCords;
    }

    public ArrayList<Integer> getIslandYCords() {
        return islandYCords;
    }

    public void setIslandYCords(ArrayList<Integer> islandYCords) {
        this.islandYCords = islandYCords;
    }

    // RANDOM map
    public Map generateMap(int x_mapSize, int y_mapSize){

        // Generate seed for map
        Random random = new Random();
        int seed = (random.nextInt(10000000));
        this.setSeed(seed);

        Cell[][] cells = generateCells(x_mapSize, y_mapSize, seed);

        return new Map(cells, getX_Spawn(), getY_Spawn(), seed);

    }

    // SEEDED map
    public Map generateMap(int x_mapSize, int y_mapSize, int seed){

        this.setSeed(seed);

        Cell[][] cells = generateCells(x_mapSize, y_mapSize, seed);

        return new Map(cells, getX_Spawn(), getY_Spawn(), seed);

    }



    public Cell[][] generateCells(int x_mapSize, int y_mapSize, int seed){

        // New 2D array of cells (each holding Terrain, HashSet<Entity>)
        Cell[][] cells = new Cell[y_mapSize][x_mapSize];

        // Random object in relation to seed
        /*
            Random(seed) always generates same set of seeds for each cell,
            but each cell will generate different probabilities for Entities
         */
        Random random = new Random(seed);

        // cycle each Cell (for inner array, index [0] of the outer array is used to get the inner ray and find it's length)
        for (int y = 0; y < cells.length; y++){
            for (int x = 0; x < cells[0].length; x++){

                // Create new cell at (x, y)
                cells[y][x] = new Cell();

                // Randomising number (in correlation to seed)
                random.nextInt(Integer.MAX_VALUE);

                // Generate Terrain for cell (according to noise value)
                cells[y][x].setTerrain(generateTerrain(x, y, seed));
                cells[y][x].setEntities(generateEntities(cells[y][x].getTerrain(), random.nextInt(Integer.MAX_VALUE), x, y));

                // Find spawn point
                double distance = findDistance(x, y, cells[0].length/2 - 1, cells.length/2 - 1);
                if ((shortestDistance == -1.0 || distance < this.shortestDistance) && (cells[y][x].getTerrain().equals(Terrain.GRASS))){
                    shortestDistance = distance;
                    setX_Spawn(x);
                    setY_Spawn(y);
                }
            }
        }

        generateBossMonsters(cells, x_mapSize, y_mapSize, 0.7f, random);

        return cells;
    }

    public Terrain generateTerrain(int x, int y, int seed){

        /*      v3 Noise Usage          */
        // Generate noise at specific Cell cords, make positive, enlarge noise by dividing cords (AS DECIMALS)
        double noiseValue = Math.abs(SimplexNoise.noise((float) (x) / 16, (float) (y) / 16, seed));  // <- dividing cords enlarges grid - MUST BE A DECIMAL DATATYPE!

        // Return Terrain type at cords depending on noise given
        /* if (noiseValue <= 0.09){
            return Terrain.DENSE_FOREST;
        }
        else if (noiseValue <= 0.1){
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
            // Add island coords to HashMap for faster island boss spawn location searching
            islandXCords.add(x);
            islandYCords.add(y);
            return Terrain.ISLAND;
        }
    }

    public HashSet<Entity> generateEntities (Terrain terrain, int randomisedSeed, int x, int y){

        HashSet<Entity> entities = new HashSet<Entity>();

        // Declare Random, assign to seeded or unseeded Random() depending on Settings
        Random random;
        if (Main.SEED_ENTITIES) {
            random = new Random(randomisedSeed);
        } else {
            random = new Random();
        }

        float hasBoat = random.nextFloat();
        float hasWeapon = random.nextFloat();
        float hasPotion = random.nextFloat();
        float hasMonster = random.nextFloat();

        float weaponType = random.nextFloat();
        float potionType = random.nextFloat();
        float monsterTier = random.nextFloat();

        if(terrain.equals(Terrain.SAND)){
            Utilities.debug("#terrain sand");
            if (hasBoat <= 0.1f) entities.add(Misc.BOAT);
        }

        // Check for land
        if(!terrain.equals(Terrain.WATER)){

            Utilities.debug("#(" + x + ", " + y + ")");
            Utilities.debug("#not water");

            /*  WEAPON  */
            if (hasWeapon <= 0.05f){

                Utilities.debug("   #has weapon");

                // Select Weapon type
                if (weaponType <= 0.4f){
                    Utilities.debug("       #dagger");
                    entities.add(Weapon.DAGGER);
                }
                else if (weaponType <= 0.7f){
                    Utilities.debug("       #sword");
                    entities.add(Weapon.SWORD);
                }
                else if (weaponType <= 0.9f){
                    Utilities.debug("       #battle axe");
                    entities.add(Weapon.BATTLE_AXE);
                }
                else if (weaponType <= 1.0f){
                    Utilities.debug("       #war hammer");
                    entities.add(Weapon.WAR_HAMMER);
                }

            }

            /*  POTION  */
            if (hasPotion <= 0.10f){ // Todo: Increase as more potions are added

                Utilities.debug("   #has potion");

                // Select Potion
                if (potionType <= 0.6f){
                    Utilities.debug("       #health potion");
                    entities.add(Potion.HEALTH_POTION);
                }
                else if (potionType <= 1.0f){
                    Utilities.debug("       #strength potion");
                    entities.add(Potion.STRENGTH_POTION);
                }

            }

            /*  MONSTER */
            if (hasMonster <= 0.1f){

                Utilities.debug("   #has monster");

                Monster monster;

                // Calculate Tier
                if (monsterTier >= 0.5) {
                    Utilities.debug("       #tier 1");
                    monster = new Monster(Monster.MonsterType.TIER_1);
                }
                else if (monsterTier >= 0.8) {
                    Utilities.debug("       #tier 2");
                    monster = new Monster(Monster.MonsterType.TIER_2);
                }
                else {
                    Utilities.debug(        "#tier 3");
                    monster = new Monster(Monster.MonsterType.TIER_3);
                }

                entities.add(monster);

            }
        }

        return entities;
    }

    public void generateBossMonsters(Cell[][] cells, int x_Length, int y_Length, float landToIslandRatio, Random random){

        Utilities.debug("#generate boss monsters");

        int x,y;
        int i = 0;

        int landQuantity = (int) Math.round(Main.BOSSES * landToIslandRatio);
        int islandQuantity = (int) Math.round(Main.BOSSES * (1-landToIslandRatio));

        while (i < landQuantity){

            Monster grassBoss = new Monster(Monster.MonsterType.BOSS_LAND);

            x = Math.abs( random.nextInt(x_Length) );
            y = Math.abs( random.nextInt(y_Length) );

            Utilities.debug("   #attempting GRASS BOSS at (" + x + ", " + y +")");

            if (cells[y][x].getTerrain().equals(Terrain.GRASS)){

                Utilities.debug("   #is GRASS");

                Iterator<Entity> cellIterator = cells[y][x].getEntities().iterator();

                while (cellIterator.hasNext()){

                    if (cellIterator.next() instanceof Monster) {

                        Utilities.debug("#      removing Monster");
                        cellIterator.remove();

                    }

                }

                cells[y][x].getEntities().add(grassBoss);

                i++;
            }

        }

        i = 0;

        while (i < islandQuantity){

            Monster islandBoss = new Monster(Monster.MonsterType.BOSS_ISLAND);

            x = getIslandXCords().get( Math.abs( random.nextInt(getIslandXCords().size()) ) );
            y = getIslandYCords().get( Math.abs( random.nextInt(getIslandYCords().size()) ) );

            Utilities.debug("   #attempting ISLAND BOSS at (" + x + ", " + y +")");

            if (cells[y][x].getTerrain().equals(Terrain.ISLAND)){

                Utilities.debug("   #is ISLAND");

                Iterator<Entity> cellIterator = cells[y][x].getEntities().iterator();

                while (cellIterator.hasNext()){

                    if (cellIterator.next() instanceof Monster) {

                        Utilities.debug("#      removing Monster");
                        cellIterator.remove();

                    }

                }

                cells[y][x].getEntities().add(islandBoss);

                i++;
            }

        }
    }

    public double findDistance(int x_Cell, int y_Cell, int x_Center, int y_Center){

        // Find the distance between the origin and the queried cell using Pythagoras a^2 + b^2 = c^2
        double distance = Math.sqrt(Math.pow((x_Cell - x_Center), 2) + Math.pow(y_Cell - y_Center, 2)); // Use Math.pow, ^2 is not a function in Java

        return distance;

    }

}
