//package ghost;
import java.util.*;
import java.io.*;

public class MazePath {
    //public boolean[][] maze_final;

    public MazePath(){};

    public static void main(String[] args) {
        ArrayList<String[]> lines = fileReader.readLines("../../../../map_test.txt");
        String[][] lines_f = fileReader.convertToArray(lines);
        String[][] yes = new String[2][2];
        yes[0] = new String[]{"0", "7"};
        yes[1] = new String[]{"0", "7"};
        System.out.println(Arrays.toString(yes[1]));
        boolean[][] tmp = createPath(lines_f);
        System.out.println(tmp[0][289]);
        System.out.println(Arrays.toString(tmp[0]));
    }

    public static boolean[][] createPath(String[][] maze) {
        boolean[][] maze_final = new boolean[maze.length*16][maze[0].length*16];
        for (int t = 0; t < maze_final.length; t ++) {
            Arrays.fill(maze_final[t], false);
        }

        for (int y = 0; y < maze.length; y ++) {
            for (int x = 0; x < maze[0].length; x ++) {
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
                if (maze[y][x].equals("p")) {
                    for (int y1 = ((y*16)); y1 < ((y*16) + 16); y1 ++) {
                        maze_final[y1][x*16] = true;
                    }
                    for (int x1 = (x*16); x1 < ((x*16) + 16); x1 ++) {
                        maze_final[(y*16)][x1] = true;
                    }
                }
                if (maze[y][x].equals("g")) {
                    for (int y1 = ((y*16)); y1 < ((y*16) + 16); y1 ++) {
                        maze_final[y1][x*16] = true;
                    }
                    for (int x1 = (x*16); x1 < ((x*16) + 16); x1 ++) {
                        maze_final[(y*16)][x1] = true;
                    }
                }

                if (maze[y][x].equals("7")) {
                    if (maze[y][x].equals("7") & maze[y][x+1].equals("2")) {
                        //System.out.println("Here");
                        continue;
                    }
                    for (int y1 = ((y*16)); y1 < ((y*16) + 16); y1 ++) {
                        maze_final[y1][x*16] = true;
                    }
                    for (int x1 = (x*16); x1 < ((x*16) + 16); x1 ++) {
                        maze_final[(y*16)][x1] = true;
                    }
                }
            }
        }
        return maze_final;

    }
}