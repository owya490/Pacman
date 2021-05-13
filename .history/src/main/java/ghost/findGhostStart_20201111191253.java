package ghost;
import java.util.*;
import java.io.*;

public class findGhostStart {
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