package github.benlewis9000.adventuregame.game;

import github.benlewis9000.adventuregame.entity.Monster;
import github.benlewis9000.adventuregame.entity.Weapon;
import github.benlewis9000.adventuregame.player.Player;
import github.benlewis9000.adventuregame.player.PlayerState;

import java.util.Random;
import java.util.Scanner;

import static github.benlewis9000.adventuregame.game.Utilities.applyVariance;
import static github.benlewis9000.adventuregame.game.Utilities.delay;
import static github.benlewis9000.adventuregame.game.Utilities.stringToArgs;

public class Battle {

    Player player;
    Monster monster;
    boolean running;


    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public Battle (Player player, Monster monster){
        setPlayer(player);
        setMonster(monster);

        getPlayer().setState(PlayerState.IN_BATTLE);

        setRunning(true);

        beginBattle();

    }


    public void beginBattle(){

        System.out.println("The battle begins... ");

        Scanner scanner = new Scanner(System.in);

        // Boolean for Battle loop
        int roundNumber = 0;

        // Enter battle loop
        while (isRunning()){

            // Run through BattleCommands, if none, run through Commands
            while(true) {

                delay(500);
                System.out.println("What's your next move?");

                // Take Player's command, convert to String[] args
                String input = scanner.nextLine();
                String[] args = stringToArgs(input);

                delay(500);
                // Check for BattleCommand, else regular Command
                if (!CommandHandler.onBattleCommand(this, getPlayer(), args))
                    CommandHandler.onCommand(getPlayer(), args);

                // If battleCommand, e.g. fight, or consume, exit for Monster turn, execute and exit turn
                else break;
            }

            System.out.println("(Press ENTER key to continue.)");
            scanner.nextLine();

            // Check Monster is alive...
            if (getMonster().isDead()) break;
            // ...if true, Monster attacks
            monsterAttack();

            roundNumber++;
        }

        // Print winning/losing message
        System.out.print("The battle is over... ");
        delay(1000);
        if (player.getState() == PlayerState.DEAD) {
            System.out.println("you have been slaughtered.");
        }
        else {
            player.setState(PlayerState.ROAMING);
            System.out.println("you come out victorious!");
        }


    }


    public void playerAttack() {

        Random random = new Random();

        Weapon weapon = getPlayer().getWeapon();

        int baseDmg = weapon.getDamage();
        float attackSpeed = weapon.getSpeed();
        float attackAccuracy = weapon.getAccuracy();

        int strikes = 0;

        float ranSpeed = random.nextFloat();

        while (ranSpeed <= attackSpeed){

            delay(200);

            System.out.println("You swing your " + weapon.getName().toLowerCase() + "...");
            delay (500);

            float ranAccuracy = random.nextFloat();
            if (ranAccuracy <= attackAccuracy){

                //attackDmg = Math.round( Math.abs( attackDmg * (1 + (random.nextInt(400)/1000 - 0.2f)) ) ); //+-20% modifier
                int attackDmg = applyVariance(baseDmg, 0.2f);

                getMonster().damage(attackDmg);

                delay(500);

                System.out.println("Successful hit!");
                delay(300);
                System.out.println("You dealt " + attackDmg + " damage to the monster.");
                delay(300);
                System.out.println("The monster now has " + getMonster().getHealth() + " health remaining.");

                delay(500);
                if (getMonster().isDead()){
                    System.out.println("You have killed the monster. Well done!");
                    setRunning(false);
                    break;
                }

                Scanner scanner = new Scanner(System.in);
                System.out.println("(Press ENTER to continue.)");
                scanner.nextLine();

            }
            else {
                System.out.println("You have missed!");
            }
            ranSpeed = random.nextFloat();
        }
        // else,
        if ( !(ranSpeed <= attackSpeed) ) {
            System.out.print("You swing your " + weapon.getName().toLowerCase() + "...");
            delay(500);
            System.out.println(" too slow!");
        }
    }

    public void monsterAttack() {

        Random random = new Random();

        int baseDmg = getMonster().getDmg();
        int attackDmg = applyVariance(baseDmg, 0.2f);

        player.damage(attackDmg);

        delay(200);
        System.out.println("The monster strikes, dealing " + attackDmg + " damage.");
        delay(200);
        System.out.println("You have " + player.getHealth() + " health remaining.");

        if (player.getState() == PlayerState.DEAD){
            setRunning(false);
        }

    }
}
