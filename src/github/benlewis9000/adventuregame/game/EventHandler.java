package github.benlewis9000.adventuregame.game;

import github.benlewis9000.adventuregame.entity.Weapon;
import github.benlewis9000.adventuregame.mapping.Unit;
import github.benlewis9000.adventuregame.player.Player;

public class EventHandler {

    /*

        Static library for events e.g. player collides with unit

     */

    public static void onCollision(Unit unit, Player player){

        Inventory inv = player.getInventory();

        // Check what Unit was collided with
        switch (unit){

            case DAGGER:

                System.out.println("You've found a dagger! "  /* + Weapon.DAGGER // get desc method? */);

                if (inv.containsItem(Weapon.DAGGER)){
                    System.out.println("You already have this weapon.");
                } else {
                    inv.addItem(Weapon.DAGGER);
                    System.out.println("The dagger has been added to your inventory.");
                }
                break;

            case SWORD:

                System.out.println("You've found a sword! "  /* + Weapon.DAGGER // get desc method? */);

                if (inv.containsItem(Weapon.DAGGER)){
                    System.out.println("You already have this weapon.");
                } else {
                    inv.addItem(Weapon.DAGGER);
                    System.out.println("The sword has been added to your inventory.");
                }
                break;

            case BATTLE_AXE:

                System.out.println("You've found a battle axe! "  /* + Weapon.DAGGER // get desc method? */);

                if (inv.containsItem(Weapon.DAGGER)){
                    System.out.println("You already have this weapon.");
                } else {
                    inv.addItem(Weapon.DAGGER);
                    System.out.println("The battle axe has been added to your inventory.");
                }
                break;

            case WAR_HAMMER:

                System.out.println("You've found a war hammer! "  /* + Weapon.DAGGER // get desc method? */);

                if (inv.containsItem(Weapon.DAGGER)){
                    System.out.println("You already have this weapon.");
                } else {
                    inv.addItem(Weapon.DAGGER);
                    System.out.println("The war hammer has been added to your inventory.");
                }
                break;


        }

        player.setInventory(inv);

    }

}
