package github.benlewis9000.adventuregame.game;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Utilities {

    public static String[] stringToArgs(String string){

        char[] chars = string.toLowerCase().toCharArray();

        ArrayList<String> argsList = new ArrayList<>();

        String stringBuffer = new String();

        boolean endSpace = false;

        for (char c : chars){
            if (c == ' '){
                endSpace = true;
                argsList.add(stringBuffer);
                stringBuffer = "";
            }
            else {
                endSpace = false;
                stringBuffer = stringBuffer + Character.toString(c);
            }
        }

        if (!endSpace){
            argsList.add(stringBuffer);
        }

        String[] args = new String[argsList.size()];

        for (int i = 0; i < args.length; i++){

             args[i] = (String) argsList.toArray()[i];

        }

        return args;
    }

    public static void debug(String string){
        if (Main.debug){
            System.out.println(string);
        }
    }

    public static boolean query() {

        Scanner scanner = new Scanner(System.in);

        // Todo: Redo with a .toLowerCase() and switch statement

        while (true) {

            char[] chars = scanner.nextLine().toCharArray();
            if (chars.length != 1) {
                System.out.println("Please enter either \"Y\" for yes, or \"N\" for no.");
            }
            else if (chars[0] != 'Y' && chars[0] != 'N' && chars[0] != 'y' && chars[0] != 'n'){
                System.out.println("Please enter either \"Y\" for yes, or \"N\" for no.");
            }
            else if (chars[0] == 'Y' || chars[0] == 'y') return true;
            else return false;

        }

    }

    // Returns random variables of input at +-variance decimal
    public static int applyVariance (int input, float variance){

        Random random = new Random();
        return Math.round(Math.abs(input * (1 + (random.nextInt(Math.round(variance * 1000 * 2)) / 1000.0f - variance))));

    }

    // Delay by x milliseconds
    public static void delay(int milliseconds){

        try {
            Thread.sleep(milliseconds);

        } catch (InterruptedException e){

            System.out.println("Sleep failed for: " + String.valueOf(milliseconds) + "ms");
            System.out.println(e.getMessage());

        }
    }

}
