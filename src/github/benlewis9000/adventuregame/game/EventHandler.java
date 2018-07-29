package github.benlewis9000.adventuregame.game;

import github.benlewis9000.adventuregame.entity.*;
import github.benlewis9000.adventuregame.mapping.Terrain;
import github.benlewis9000.adventuregame.player.Player;

import static github.benlewis9000.adventuregame.entity.Weapon.DAGGER;
import static github.benlewis9000.adventuregame.entity.Weapon.SWORD;
import static github.benlewis9000.adventuregame.entity.Weapon.BATTLE_AXE;
import static github.benlewis9000.adventuregame.entity.Weapon.WAR_HAMMER;

public class EventHandler {

    /*

        Static library for events e.g. player collides with unit

     */

    public static void onEntityCollision(Entity entity, Player player){

        Inventory inv = player.getInventory();

        /*   ITEMS   */
        if (entity instanceof Item){

            /*   WEAPONS    */
            if (entity instanceof Weapon) {

                // Check what Weapon was collided with
                switch ((Weapon) entity) {

                    case DAGGER:

                        System.out.println("You've found a dagger! "  /* + Weapon.DAGGER // get desc method? */);

                        if (inv.containsItem(DAGGER)) {
                            System.out.println("You already have this weapon.");
                        } else {
                            inv.addItem(DAGGER);
                            System.out.println("The dagger has been added to your inventory.");
                        }
                        break;

                    case SWORD:

                        System.out.println("You've found a sword! "  /* + Weapon.DAGGER // get desc method? */);

                        if (inv.containsItem(SWORD)) {
                            System.out.println("You already have this weapon.");
                        } else {
                            inv.addItem(SWORD);
                            System.out.println("The sword has been added to your inventory.");
                        }
                        break;

                    case BATTLE_AXE:

                        System.out.println("You've found a battle axe! "  /* + Weapon.DAGGER // get desc method? */);

                        if (inv.containsItem(BATTLE_AXE)) {
                            System.out.println("You already have this weapon.");
                        } else {
                            inv.addItem(BATTLE_AXE);
                            System.out.println("The battle axe has been added to your inventory.");
                        }
                        break;

                    case WAR_HAMMER:

                        System.out.println("You've found a war hammer! "  /* + Weapon.DAGGER // get desc method? */);

                        if (inv.containsItem(WAR_HAMMER)) {
                            System.out.println("You already have this weapon.");
                        } else {
                            inv.addItem(WAR_HAMMER);
                            System.out.println("The war hammer has been added to your inventory.");
                        }
                        break;
                }
            }

            player.setInventory(inv);
        }

        /*   ENEMY     */

        if (entity instanceof Monster){

            // Todo: begin Battle

        }

    }

    public static void onMonsterDeath(Player player, Monster monster){

        Inventory inv = player.getInventory();

        for (Resource resource : monster.getDrops()){

        }

    }

}





















