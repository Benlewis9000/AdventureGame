package github.benlewis9000.adventuregame.game;

import java.util.ArrayList;

public class Utilities {

    public static String[] stringToArgs(String string){

        char[] chars = string.toCharArray();

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

}
