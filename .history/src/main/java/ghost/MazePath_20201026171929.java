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

        // for (int y = 1; y < maze.length; y ++) {
        //     for (int x = 1; x < maze[0].length; x ++)
        for (int i = 1; i < 36; i ++) {
            for (int j = 1; x < 28; j ++) {
                if (before == true) {
                    if (maze[i][j].equals("7") || maze[i][j].equals("g") || maze[i][j].equals("p") || maze[i][j].equals("0")){
                        before = true;
                    }
                    else {
                        end = j - 1;
                        for (int k = start*16-4; k < end*16-3; k ++) {
                            maze_final[i*16-5][k] = true;
                        }
                        before = false;
                    }
                }
                else if (maze[i][j].equals("7") || maze[i][j].equals("g") || maze[i][j].equals("p") || maze[i][j].equals("0")){
                    System.out.println("here");
                    start = j;
                    before = true;
                }
            }
        }
        //before = false;
        for (int j = 1; j < 28; j ++) {
            for (int i = 1; i < 36; i ++) {
                if (before == true) {
                    if (maze[i][j].equals("7") || maze[i][j].equals("g") || maze[i][j].equals("p") || maze[i][j].equals("0")){
                        before = true;
                    }
                    else {
                        end = i - 1;
                        for (int k = start*16-5; k < end*16-4; k ++) {
                            maze_final[k][j*16-4] = true;
                        }
                        before = false;
                    }
                }
                else if (maze[i][j].equals("7") || maze[i][j].equals("g") || maze[i][j].equals("p") || maze[i][j].equals("0")){
                    start = i;
                    before = true;
                }
            }
        }

        for (int i = 0; i < 75; i ++) {
            for (int j = 0; j < 60; j ++){
                if (maze_final[i][j]) {
                    System.out.print("X");
                }
                else {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
        //         if (maze[y][x].equals("0")) {
        //             continue;
        //         }
        //         if (maze[y][x].equals("1")) {
        //             continue;
        //         }
        //         if (maze[y][x].equals("2")) {
        //             continue;
        //         }
        //         if (maze[y][x].equals("3")) {
        //             continue;
        //         }
        //         if (maze[y][x].equals("4")) {
        //             continue;
        //         }
        //         if (maze[y][x].equals("5")) {
        //             continue;
        //         }
        //         if (maze[y][x].equals("6")) {
        //             continue;
        //         }
        //         if (maze[y][x].equals("p")) {
        //             for (int y1 = ((y*16)); y1 < ((y*16) + 16); y1 ++) {
        //                 maze_final[y1][x*16] = true;
        //             }
        //             for (int x1 = (x*16); x1 < ((x*16) + 16); x1 ++) {
        //                 maze_final[(y*16)][x1] = true;
        //             }
        //         }
        //         if (maze[y][x].equals("g")) {
        //             for (int y1 = ((y*16)); y1 < ((y*16) + 16); y1 ++) {
        //                 maze_final[y1][x*16] = true;
        //             }
        //             for (int x1 = (x*16); x1 < ((x*16) + 16); x1 ++) {
        //                 maze_final[(y*16)][x1] = true;
        //             }
        //         }

        //         if (maze[y][x].equals("7")) {
        //             // if (maze[y][x].equals("7") & maze[y][x+1].equals("2")& maze[y-1][x].equals("7") & maze[y+1][x].equals("7")) {
        //             //     //System.out.println("Here"); & maze[y-1][x].equals("7") & maze[y+1][x].equals("7")
        //             //     maze_final[y*16][x*16] = true;
        //             //     continue;
        //             // }
        //             for (int y1 = ((y*16)); y1 < ((y*16) + 16); y1 ++) {
        //                 maze_final[y1][x*16] = true;
        //             }
        //             for (int x1 = (x*16); x1 < ((x*16) + 16); x1 ++) {
        //                 maze_final[(y*16)][x1] = true;
        //             }
        //         }
        //     }
        // }
        return maze_final;

    }
}