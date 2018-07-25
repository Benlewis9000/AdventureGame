package github.benlewis9000.adventuregame.game;

import github.benlewis9000.adventuregame.mapping.Map;
import github.benlewis9000.adventuregame.player.Player;

import java.util.Scanner;

public class Game {

    Map map;
    Player player;



    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }



    public Game(Player player){

        this.setPlayer(player);
        this.setMap(player.getMap());

        this.runGame();
    }



    public void runGame(){

        Player player = this.getPlayer();
        Map map = this.getMap();

        Scanner scanner = new Scanner(System.in);

        boolean gameLive = true;

        while (gameLive){

            String input = scanner.nextLine();

            switch (input){
                case "w":
                    player.walk(Direction.NORTH);
                    break;
                case "a":
                    player.walk(Direction.WEST);
                    break;
                case "s":
                    player.walk(Direction.SOUTH);
                    break;
                case "d":
                    player.walk(Direction.EAST);
                    break;
                case "map":
                    map.printMap();

            }

        }

    }

}
