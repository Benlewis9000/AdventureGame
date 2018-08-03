package github.benlewis9000.adventuregame.entity;

import github.benlewis9000.adventuregame.game.Utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Monster implements Entity {

    public enum MonsterType {

        TIER_1 ("Tier 1", 10, 5),
        TIER_2 ("Tier 2", 25, 10),
        TIER_3 ("Tier 3", 50, 15);

        String name;
        int maxHealth;
        int dmg;

        MonsterType(String name, int maxHealth, int dmg){
            this.name = name;
            this.maxHealth = maxHealth;
            this.dmg = dmg;
        }

    }

    // Health, attack strength, accuracy, ArrayList of drops
    String name;
    int maxHealth;
    int health;
    int dmg;
    boolean isDead;
    ArrayList<Resource> drops;

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    public ArrayList<Resource> getDrops() {
        return drops;
    }

    public void setDrops(ArrayList<Resource> drops) {
        this.drops = drops;
    }

    /*
    public int getTier() {
        return tier;
    }

    public void setTier(int tier) {

        // Make sure given tier is available
        if (tier < 1) tier = 1;
        if (tier > 3) tier = 3;
        this.tier = tier;

    }
    */

    public Monster(MonsterType type){

        //setTier(tier);

        // Todo: take type, randomise values (10%), & create Monster with

        Random random = new Random();

        this.setName(type.name + " Monster");
        // Randomise macHealth (thus health) by +-20%
        this.setMaxHealth(
                Math.round((float) type.maxHealth * (1.0f + ((float) random.nextInt(400)/1000) - 0.2f ))
        );
        this.setHealth(this.getMaxHealth());
        this.setDmg(type.dmg);
        this.setDead(false);
        this.setDrops(generateDrops());

        Utilities.debug("#monster maxHealth = " + this.getMaxHealth());

        // Todo: Tier based drops

    }

    //  Resources Monster holds that can be dropped upon death
    public ArrayList<Resource> generateDrops(){

        // ArrayList of resources - no order, & object duplication
        ArrayList<Resource> drops = new ArrayList<Resource>();

        Random random = new Random();

        // Chances of resource being present
        float hasWood = random.nextFloat();
        float hasIron = random.nextFloat();

        // Probability of x quantity is n^x
        while (true) {
            if (hasWood <= 0.5) {
                hasWood = random.nextFloat();
                drops.add(Resource.WOOD);
            }
            else break;
        }
        while (true) {
            if (hasIron <= 0.7){
                hasIron = random.nextFloat();
                drops.add(Resource.IRON);
            }
            else break;
        }

        return drops;
    }

    public void generateMonster (int maxHealth, int health, int dmg){

        // Todo: Randomised custom variables to make each Monster unique

    }

    public void damage(int dmg){

        this.setHealth(getHealth() - dmg);
        if (getHealth() <= 0){
            setHealth(0);
            setDead(true);
        }

    }
}
