package github.benlewis9000.adventuregame.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Monster implements Entity {

    // Health, attack strength, accuracy, ArrayList of drops
    int maxHealth;
    int health;
    int dmg;
    ArrayList<Resource> drops;

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

    public ArrayList<Resource> getDrops() {
        return drops;
    }

    public void setDrops(ArrayList<Resource> drops) {
        this.drops = drops;
    }



    public Monster (int maxHealth, int health, int dmg){
        setMaxHealth(maxHealth);
        setHealth(health);
        setDmg(dmg);
        setDrops(generateDrops());
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

}
