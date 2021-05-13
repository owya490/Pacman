package ghost;
import java.util.*;
import java.io.*;

public class MazePath {
    //public boolean[][] maze_final;

    public MazePath(){};

    public static void main(String[] args) {

    }

    public static Boolean[][] createPath(String[][] maze) {
        Boolean[][] maze_final = new Boolean[maze.length*16][maze[0].length*16];
        Arrays.fill(maze_final, false);

        for (int y = 0; y < maze.length; y ++) {
            for (int x = 0; x < maze[1].length; x ++) {
                if (maze[y][x].equals("0")) {
                    continue;
                }
                if (maze[y][x].equals("1")) {
                    continue;
                }
                if (maze[y][x].equals("2")) {
                    continue;
                }
                if (maze[y][x].equals("3")) {
                    continue;
                }
                if (maze[y][x].equals("4")) {
                    continue;
                }
                if (maze[y][x].equals("5")) {
                    continue;
                }
                if (maze[y][x].equals("6")) {
                    continue;
                }
                if (maze[y][x].equals("7")) {
                    for (int y1 = ((y*16) - 5); y1 < ((y*16) + 11); y1 ++) {
                        maze_final[y1][x*16] = true;
                    }
                    for (int x1 = (x*16); x1 < ((x*16) + 16); x1 ++) {
                        maze_final[(y*16)-5][x1] = true;
                    }
                }
            }
        }
        return maze_final;

    }
}