/*
    All credits to @Felithium#6893 for this class,
    much appreciated!
 */

package github.benlewis9000.adventuregame.game;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class CircleCheck {

    public static void main(String[] args) {

        int[][] map = new int[4][4];

        map[3][3] = 42;

        System.out.println(findSpawn(map, 2, 2)); // prints 3=3
    }

    enum Direction {LEFT, RIGHT, UP, DOWN}

    // returns a pair of x and y -> map[x][y] == 42
    // order of indexes that get checked
    // 9 2 3
    // 8 1 4
    // 7 6 5

    static Pair<Integer, Integer> findSpawn(int[][] map, int startX, int startY) {

        int x = startX;
        int y = startY;

        Queue<Direction> operations = new LinkedList<>();
        operations.offer(Direction.UP);
        operations.offer(Direction.LEFT);

        int counter = 1;

        boolean up = true;
        boolean down = true;
        boolean left = true;
        boolean right = true;

        while (map[x][y] != 42) {

            Direction dir = operations.poll();

            switch (dir) {
                case LEFT:
                    x--;
                    right = true;
                    up = true;
                    down = true;
                    if (left) {
                        for (int i = 0; i < counter; i++) {
                            operations.offer(Direction.RIGHT);
                        }
                        left = false;
                    }
                    break;
                case RIGHT:
                    x++;
                    left = true;
                    up = true;
                    down = true;
                    if (right) {
                        for (int i = 0; i < counter; i++) {
                            operations.offer(Direction.LEFT);
                        }
                        right = false;
                    }
                    break;
                case UP:
                    y--;
                    left = true;
                    right = true;
                    down = true;
                    if (up) {
                        counter++;
                        up = false;
                        for (int i = 0; i < counter; i++) {
                            operations.offer(Direction.DOWN);
                        }
                    }
                    break;
                case DOWN:
                    y++;
                    left = true;
                    right = true;
                    up = true;
                    if (down) {
                        counter++;
                        down = false;
                        for (int i = 0; i < counter; i++) {
                            operations.offer(Direction.UP);
                        }
                    }
                    break;
            }
        }

        return new Pair<>(x, y);
    }
}