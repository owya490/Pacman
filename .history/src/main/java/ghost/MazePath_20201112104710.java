package ghost;
import java.util.*;
import java.io.*;

public class MazePath {

    public MazePath(){};

    public static boolean[][] createPath(String[][] maze) {
        boolean[][] maze_final = new boolean[maze.length*16][maze[0].length*16];
        for (int t = 0; t < maze_final.length; t ++) {
            Arrays.fill(maze_final[t], false);
        }

        int start = 0;
        int end = 0;

        boolean cellBefore = false;

        for (int y = 1; y < 36; y ++) {
            for (int x = 1; x < 28; x ++) {
                if (cellBefore == true) {
                    if (maze[y][x].equals("7") | maze[y][x].equals("c") | maze[y][x].equals("p") | maze[y][x].equals("a") | maze[y][x].equals("i") | maze[y][x].equals("w") | maze[y][x].equals("8") | maze[y][x].equals("s")){
                        cellBefore = true;
                    }
                    else {
                        end = x - 1;
                        for (int i = start*16-4; i < end*16-3; i ++) {
                            maze_final[y*16-5][i] = true;
                        }
                        cellBefore = false;
                    }
                }
                else if (maze[y][x].equals("7") || maze[y][x].equals("c") || maze[y][x].equals("p") || maze[y][x].equals("a") || maze[y][x].equals("i") || maze[y][x].equals("w") || maze[y][x].equals("8") || maze[y][x].equals("s")){
                    start = x;
                    cellBefore = true;
                }
            }
        }
        for (int x = 1; x < 28; x ++) {
            for (int y = 1; y < 36; y ++) {
                if (cellBefore == true) {
                    if (maze[y][x].equals("7") || maze[y][x].equals("c") || maze[y][x].equals("p") || maze[y][x].equals("a") || maze[y][x].equals("i") || maze[y][x].equals("w") || maze[y][x].equals("8") || maze[y][x].equals("s")){
                        cellBefore = true;
                    }
                    else {
                        end = y - 1;
                        for (int i = start*16-5; i < end*16-4; i ++) {
                            maze_final[i][x*16-4] = true;
                        }
                        cellBefore = false;
                    }
                }
                else if (maze[y][x].equals("7") || maze[y][x].equals("c") || maze[y][x].equals("p") || maze[y][x].equals("a") || maze[y][x].equals("i") || maze[y][x].equals("w") || maze[y][x].equals("8") || maze[y][x].equals("s")){
                    start = y;
                    cellBefore = true;
                }
            }
        }
        return maze_final;
    }
}