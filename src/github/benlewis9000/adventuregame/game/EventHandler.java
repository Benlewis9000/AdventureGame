package github.benlewis9000.adventuregame.game;

import github.benlewis9000.adventuregame.entity.*;
import github.benlewis9000.adventuregame.player.Player;

import static github.benlewis9000.adventuregame.entity.Weapon.DAGGER;
import static github.benlewis9000.adventuregame.entity.Weapon.SWORD;
import static github.benlewis9000.adventuregame.entity.Weapon.BATTLE_AXE;
import static github.benlewis9000.adventuregame.entity.Weapon.WAR_HAMMER;

public class EventHandler {

    /*

        Static library for events e.g. player collides with unit

     */

    // Boolean as player has the choice to not move when queried
    public static boolean  onEntityCollision(Entity entity, Player player){

        Inventory inv = player.getInventory();

        /*   ITEMS   */
        if (entity instanceof Item){

            // When instance of Weapon:
            //      return true;    - pickup and remove Item from cell
            //      return false;   - leave Item

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
                            //player.getCell().getEntities().remove(DAGGER); -> return true etc.
                            System.out.println("The dagger has been added to your inventory.");
                            return true;
                        }
                        break;

                    case SWORD:

                        System.out.println("You've found a sword! "  /* + Weapon.DAGGER // get desc method? */);

                        if (inv.containsItem(SWORD)) {
                            System.out.println("You already have this weapon.");
                        } else {
                            inv.addItem(SWORD);
                            //player.getCell().getEntities().remove(SWORD);
                            System.out.println("The sword has been added to your inventory.");
                            return true;
                        }
                        break;

                    case BATTLE_AXE:

                        System.out.println("You've found a battle axe! "  /* + Weapon.DAGGER // get desc method? */);

                        if (inv.containsItem(BATTLE_AXE)) {
                            System.out.println("You already have this weapon.");
                        } else {
                            inv.addItem(BATTLE_AXE);
                            //player.getCell().getEntities().remove(BATTLE_AXE);
                            System.out.println("The battle axe has been added to your inventory.");
                            return true;
                        }
                        break;

                    case WAR_HAMMER:

                        System.out.println("You've found a war hammer! "  /* + Weapon.DAGGER // get desc method? */);

                        if (inv.containsItem(WAR_HAMMER)) {
                            System.out.println("You already have this weapon.");
                        } else {
                            inv.addItem(WAR_HAMMER);
                            //player.getCell().getEntities().remove(WAR_HAMMER);
                            System.out.println("The war hammer has been added to your inventory.");
                            return true;
                        }
                        break;
                }
            }

            else if (entity instanceof Misc){

                switch ((Misc) entity){

                    case BOAT:

                        System.out.println("You've found a boat!");
                        if (inv.containsItem(Misc.BOAT)){
                            System.out.println("You already have a boat.");
                        }
                        else {
                            System.out.println("Boats my be used to travel across water.");
                            inv.addItem(Misc.BOAT);
                            return true;
                        }
                        break;

                }

            }

            player.setInventory(inv);
        }

        /*   ENEMY     */

        if (entity instanceof Monster){

            Monster monster = (Monster) entity;

            System.out.println("You've run into a " + monster.getId() + " Monster!" +
                    "\n    Monster Health: " + monster.getHealth() +
                    "\n    Strength: " + monster.getDmg());


            System.out.println("Would you like to engage the monster, or retreat to your previous position? (\"Y\"/\"N\")");

            if (Utilities.query()){

                new Battle(player, (Monster) entity);
                return true;

            }
            else {

                player.setPlayer(player.getPreviousX_index(), player.getPreviousY_index());
                System.out.println("You cower as you retreat...");
                return false;

            }

        }

        return false;
    }

    public static void onMonsterDeath(Player player, Monster monster){

        Inventory inv = player.getInventory();

        for (Resource resource : monster.getDrops()){

        }

    }

}





















