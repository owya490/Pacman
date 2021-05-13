package ghost;
import java.util.*;
import java.io.*;

public class findGhostStart {
    /**
     * Finds the starting x coordinates of ambushers on the map
     * @param filename the map text file it is going to search
     * @return a list of x coordinates for ambushers on the map
     */
    public static ArrayList<Integer> ambusherfindx(String filename) {
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        ArrayList<String[]> f = fileReader.readLines(filename);
        for (int y = 0; y < f.size(); y ++) {
            for (int x = 0; x < f.get(y).length; x ++) {
                if (f.get(y)[x].equals("a")) {
                    tmp.add(x);
                }
            }
        }
        return tmp;
    }

    /**
     * Finds the starting y coordinates of ambushers on the map
     * @param filename the map text file it is going to search
     * @return a list of y coordinates for ambushers on the map
     */
    public static ArrayList<Integer> ambusherfindy(String filename) {
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        ArrayList<String[]> f = fileReader.readLines(filename);
        for (int y = 0; y < f.size(); y ++) {
            for (int x = 0; x < f.get(y).length; x ++) {
                if (f.get(y)[x].equals("a")) {
                    tmp.add(y);
                }
            }
        }
        return tmp;
    }

    /**
     * Finds the starting x coordinates of chaser on the map
     * @param filename the map text file it is going to search
     * @return a list of x coordinates for chaser on the map
     */
    public static ArrayList<Integer> chaserfindx(String filename) {
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        ArrayList<String[]> f = fileReader.readLines(filename);
        for (int y = 0; y < f.size(); y ++) {
            for (int x = 0; x < f.get(y).length; x ++) {
                if (f.get(y)[x].equals("c")) {
                    tmp.add(x);
                }
            }
        }
        return tmp;
    }

    /**
     * Finds the starting y coordinates of chaser on the map
     * @param filename the map text file it is going to search
     * @return a list of y coordinates for chaser on the map
     */
    public static ArrayList<Integer> chaserfindy(String filename) {
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        ArrayList<String[]> f = fileReader.readLines(filename);
        for (int y = 0; y < f.size(); y ++) {
            for (int x = 0; x < f.get(y).length; x ++) {
                if (f.get(y)[x].equals("c")) {
                    tmp.add(y);
                }
            }
        }
        return tmp;
    }

    /**
     * Finds the starting x coordinates of ignorant on the map
     * @param filename the map text file it is going to search
     * @return a list of x coordinates for ignorant on the map
     */
    public static ArrayList<Integer> ignorantfindx(String filename) {
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        ArrayList<String[]> f = fileReader.readLines(filename);
        for (int y = 0; y < f.size(); y ++) {
            for (int x = 0; x < f.get(y).length; x ++) {
                if (f.get(y)[x].equals("i")) {
                    tmp.add(x);
                }
            }
        }
        return tmp;
    }
    
    /**
     * Finds the starting y coordinates of ignorant on the map
     * @param filename the map text file it is going to search
     * @return a list of y coordinates for ignorant on the map
     */
    public static ArrayList<Integer> ignorantfindy(String filename) {
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        ArrayList<String[]> f = fileReader.readLines(filename);
        for (int y = 0; y < f.size(); y ++) {
            for (int x = 0; x < f.get(y).length; x ++) {
                if (f.get(y)[x].equals("i")) {
                    tmp.add(y);
                }
            }
        }
        return tmp;
    }
    
    /**
     * Finds the starting x coordinates of whim on the map
     * @param filename the map text file it is going to search
     * @return a list of x coordinates for whim on the map
     */
    public static ArrayList<Integer> whimfindx(String filename) {
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        ArrayList<String[]> f = fileReader.readLines(filename);
        for (int y = 0; y < f.size(); y ++) {
            for (int x = 0; x < f.get(y).length; x ++) {
                if (f.get(y)[x].equals("w")) {
                    tmp.add(x);
                }
            }
        }
        return tmp;
    }
    
    /**
     * Finds the starting y coordinates of whim on the map
     * @param filename the map text file it is going to search
     * @return a list of y coordinates for whim on the map
     */
    public static ArrayList<Integer> whimfindy(String filename) {
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        ArrayList<String[]> f = fileReader.readLines(filename);
        for (int y = 0; y < f.size(); y ++) {
            for (int x = 0; x < f.get(y).length; x ++) {
                if (f.get(y)[x].equals("w")) {
                    tmp.add(y);
                }
            }
        }
        return tmp;
    }
}