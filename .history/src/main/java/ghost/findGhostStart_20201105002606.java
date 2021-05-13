package ghost;
import java.util.*;
import java.io.*;

public class findGhostStart {
    //private HashMap<String, Integer> map_x;
    //private HashMap<String, Integer> map_y;
    public static HashMap<String, Integer> findx(String filename) {
        HashMap<String, Integer> tmp = new HashMap<String, Integer>();
        ArrayList<String[]> f = fileReader.readLines(filename);
        for (int y = 0; y < f.size(); y ++) {
            for (int x = 0; x < f.get(y).length; x ++) {
                if (f.get(y)[x].equals("a")) {
                    map_x.put("a", x);
                }
                else if (f.get(y)[x].equals("c")) {
                    map_x.put("c", x);
                }
                else if (f.get(y)[x].equals("i")) {
                    map_x.put("i", x);
                }
                else if (f.get(y)[x].equals("w")) {
                    map_x.put("w", x);
                }
            }
        }
        return tmp;
    }
    public static HashMap<String, Integer> findy(String filename) {
        this.map_y = new HashMap<String, Integer>();
        ArrayList<String[]> f = fileReader.readLines(filename);
        for (int y = 0; y < f.size(); y ++) {
            for (int x = 0; x < f.get(y).length; x ++) {
                if (f.get(y)[x].equals("a")) {
                    map_y.put("a", y);
                }
                else if (f.get(y)[x].equals("c")) {
                    map_y.put("c", y);
                }
                else if (f.get(y)[x].equals("i")) {
                    map_y.put("i", y);
                }
                else if (f.get(y)[x].equals("w")) {
                    map_y.put("w", y);
                }
            }
        }
        return tmp;
    }
    
    public HashMap<String, Integer> getMapX() {
        return this.map_x;
    }

    public HashMap<String, Integer> getMapY() {
        return this.map_y;
    }

}
// public class findGhostStart {
//     public static ArrayList<Integer> findx(String filename) {
//         ArrayList<Integer> tmp = new ArrayList<Integer>();
//         ArrayList<String[]> f = fileReader.readLines(filename);
//         for (int y = 0; y < f.size(); y ++) {
//             for (int x = 0; x < f.get(y).length; x ++) {
//                 if (f.get(y)[x].equals("g")) {
//                     tmp.add(x);
//                 }
//             }
//         }
//         return tmp;
//     }
//     public static ArrayList<Integer> findy(String filename) {
//         ArrayList<Integer> tmp = new ArrayList<Integer>();
//         ArrayList<String[]> f = fileReader.readLines(filename);
//         for (int y = 0; y < f.size(); y ++) {
//             for (int x = 0; x < f.get(y).length; x ++) {
//                 if (f.get(y)[x].equals("g")) {
//                     tmp.add(y);
//                 }
//             }
//         }
//         return tmp;
//     }
    

// }