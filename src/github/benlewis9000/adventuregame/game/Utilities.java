package github.benlewis9000.adventuregame.game;

import github.benlewis9000.adventuregame.entity.Entity;
import github.benlewis9000.adventuregame.entity.Monster;
import github.benlewis9000.adventuregame.mapping.Cell;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class Utilities {

    public static String[] stringToArgs(String string) {

        char[] chars = string.toLowerCase().toCharArray();

        ArrayList<String> argsList = new ArrayList<>();

        String stringBuffer = new String();

        boolean endSpace = false;

        for (char c : chars) {
            if (c == ' ') {
                endSpace = true;
                argsList.add(stringBuffer);
                stringBuffer = "";
            } else {
                endSpace = false;
                stringBuffer = stringBuffer + Character.toString(c);
            }
        }

        if (!endSpace) {
            argsList.add(stringBuffer);
        }

        String[] args = new String[argsList.size()];

        for (int i = 0; i < args.length; i++) {

            args[i] = (String) argsList.toArray()[i];

        }

        return args;
    }

    public static void debug(String string) {
        if (Main.debug) {
            System.out.println(string);
        }
    }

    // Take Player yes/no input and return as boolean (query a yes/no question)
    public static boolean query() {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            char[] chars = scanner.nextLine().toCharArray();
            if (chars.length != 1) {
                System.out.println("Please enter either \"Y\" for yes, or \"N\" for no.");
                continue;
            }

            String answer = String.valueOf(chars[0]).toLowerCase();

            switch (answer) {
                case "y":
                    return true;
                case "n":
                    return false;
                default:
                    System.out.println("Please enter either \"Y\" for yes, or \"N\" for no.");
                    break;
            }

        }

    }

    // Returns random variables of input at +-variance decimal
    public static int applyVariance(int input, float variance) {

        Random random = new Random();
        return Math.round(Math.abs(input * (1 + (random.nextInt(Math.round(variance * 1000 * 2)) / 1000.0f - variance))));

    }

    /*
    public static void removeEntities(Cell cell, Entity entity) {

        Iterator<Entity> cellIterator = cell.getEntities().iterator();

        while(cellIterator.hasNext())

        {

            if (cellIterator.next() instanceof ..? ) {      // instanceof entitity.getType

                Utilities.debug("#      removing " + entity.getId());
                cellIterator.remove();

            }

        }

    }
    */

    // Delay by x milliseconds
    public static void delay(int milliseconds){

        try {
            Thread.sleep(milliseconds);

        } catch (InterruptedException e){

            System.out.println("Sleep failed for: " + String.valueOf(milliseconds) + "ms");
            System.out.println(e.getMessage());

        }
    }

    public static void pause(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("\n(Press ENTER to continue...)");

        scanner.nextLine();

    }

}
