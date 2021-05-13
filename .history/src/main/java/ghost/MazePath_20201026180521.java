package ghost;
import java.util.*;
import java.io.*;

public class MazePath {
    //public boolean[][] maze_final;

    public MazePath(){};

    public static void main(String[] args) {
        ArrayList<String[]> lines = fileReader.readLines("../../../../map.txt");
        String[][] lines_f = fileReader.convertToArray(lines);
        String[][] yes = new String[2][2];
        yes[0] = new String[]{"0", "7"};
        yes[1] = new String[]{"0", "7"};
        System.out.println(Arrays.deepToString(lines_f));
        boolean[][] tmp = createPath(lines_f);
        System.out.println(tmp[11][24]);
        //System.out.println(Arrays.deepToString(tmp));
    }

    public static boolean[][] createPath(String[][] maze) {
        boolean[][] maze_final = new boolean[maze.length*16][maze[0].length*16];
        for (int t = 0; t < maze_final.length; t ++) {
            Arrays.fill(maze_final[t], false);
        }

        int start = 0;
        int end = 0;

        boolean before = false;

        for (int y = 1; y < 36; y ++) {
            for (int x = 1; x < 28; x ++) {
                if (before == true) {
                    if (maze[y][x].equals("7") || maze[y][x].equals("g") || maze[y][x].equals("p")){
                        before = true;
                    }
                    else {
                        end = x - 1;
                        for (int k = start*16-4; k < end*16-3; k ++) {
                            maze_final[y*16-5][k] = true;
                        }
                        before = false;
                    }
                }
                else if (maze[y][x].equals("7") || maze[y][x].equals("g") || maze[y][x].equals("p")){
                    System.out.println("here");
                    start = x;
                    before = true;
                }
            }
        }
        //before = false;
        for (int x = 1; x < 28; x ++) {
            for (int y = 1; y < 36; y ++) {
                if (before == true) {
                    if (maze[y][x].equals("7") || maze[y][x].equals("g") || maze[y][x].equals("p")){
                        before = true;
                    }
                    else {
                        end = y - 1;
                        for (int k = start*16-5; k < end*16-4; k ++) {
                            maze_final[k][x*16-4] = true;
                        }
                        before = false;
                    }
                }
                else if (maze[y][x].equals("7") || maze[y][x].equals("g") || maze[y][x].equals("p")){
                    start = y;
                    before = true;
                }
            }
        }
        return maze_final;

    }
}