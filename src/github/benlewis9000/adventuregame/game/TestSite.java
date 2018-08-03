package github.benlewis9000.adventuregame.game;

import github.benlewis9000.adventuregame.entity.Weapon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class TestSite {

    /*
        This class holds static methods that run various tests, which can then
        be called in the main class when testing=true.
     */

    public static void testWeapon(Weapon weapon){

        Random random = new Random();

        int weaponDamage = weapon.getDamage();
        float weaponSpeed = weapon.getSpeed();

        float weaponAccuracy = weapon.getAccuracy();

        int totalDmg;
        int totalSwings;
        int totalHit;
        int totalMiss;
        int totalSlow;

        for (int i = 0; i < 1000; i++){

            float randomSpeed = random.nextFloat();
            //if (randomSpeed <= weaponS)

        }

    }

}
