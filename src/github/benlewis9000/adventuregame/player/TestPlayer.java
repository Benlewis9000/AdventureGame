package github.benlewis9000.adventuregame.player;

import github.benlewis9000.adventuregame.entity.Entity;
import github.benlewis9000.adventuregame.entity.Weapon;
import github.benlewis9000.adventuregame.game.Inventory;

    /*
            TestPlayer is used for methods in the TestSite.
            It is strictly NOT to be used as part of the game.
     */

public class TestPlayer {

    public class Player implements Entity {

        private String id = "Test Player";
        Inventory inventory;

        int maxHealth;
        int health;

        Weapon weapon;
        PlayerState state;


        public String getId() { return id; }

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


        /*
            TEST PLAYER CONSTRUCTOR
         */
        // DO NOT USE!
        public Player(){
            this.setMaxHealth(100);
            this.setHealth(this.getMaxHealth());
        }

        public void damage(int dmg){

            this.setHealth(getHealth() - dmg);
            if (getHealth() <= 0){
                setHealth(0);
                setState(PlayerState.DEAD);
            }

        }

    }


}
