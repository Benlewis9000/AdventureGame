package github.benlewis9000.adventuregame.game;

import github.benlewis9000.adventuregame.entity.Entity;
import github.benlewis9000.adventuregame.entity.Monster;
import github.benlewis9000.adventuregame.entity.Weapon;
import github.benlewis9000.adventuregame.player.Player;
import github.benlewis9000.adventuregame.player.PlayerState;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class TestSite {

    /*
        This class holds static methods that run various tests, which can then
        be called in the main class when testing=true.
     */

    public static void main(String[] args){



    }

    public static void testBossQuantity(){

        Random random = new Random();

        int target = 0;
        int other = 0;

        for (int i = 0; i < 1000; i++) {

            float ran = random.nextFloat();

            int land = (int) Math.round(Main.BOSSES * ran);
            int island = (int) Math.round(Main.BOSSES * (1-ran));

            if (land + island == Main.BOSSES) target++;
            else other++;

        }

        System.out.println("Target: " + target + "\nOther: " + other);

    }

    public static void testWeapon(Weapon weapon){

        Random random = new Random();

        int weaponDamage = weapon.getDamage();
        float weaponSpeed = weapon.getSpeed();
        float weaponAccuracy = weapon.getAccuracy();

        int totalDmg = 0;
        int totalSwings = 1000;
        int totalHit = 0;
        int totalMiss = 0;
        int totalSlow = 0;

        for (int i = 0; i < 1000; i++){

            float randomSpeed = random.nextFloat();

            if (randomSpeed <= weaponSpeed){

                float randomAccuracy = random.nextFloat();

                if (randomAccuracy <= weaponAccuracy){

                    totalDmg = totalDmg + Utilities.applyVariance(weaponDamage, 0.2f);
                    totalHit++;

                }
                else {

                    totalMiss++;

                }
            }
            else {

                totalSlow++;

            }

        }

        System.out.println(weapon.getId() + ":" +
                "\n    Total damage: " + totalDmg +
                "\n    Total swings: " + totalSwings +
                "\n    Total hits: " + totalHit +
                "\n    Total misses: " + totalMiss +
                "\n    Total slow: " + totalSlow +
                "\n    Mean damage per hit: " + (double) totalDmg/totalHit +
                "\n    Mean dmg per turn: " + (double) totalDmg/totalSwings);

    }



    public static void forceBattle(Weapon weapon, Monster.MonsterType monsterType){

        Player player = new Player();
        player.setState(PlayerState.IN_BATTLE);
        player.setWeapon(weapon);

        Monster monster = new Monster(monsterType);

        new Battle(player, monster);

    }

    public static void listCellEntities(Player player, int x, int y){
        System.out.println("\nEntities (" + x + ", " + y + "):");
        for (Entity entity : player.getMap().getCells()[y][x].getEntities()) {
            System.out.println(entity.getId());
        }
    }

}
