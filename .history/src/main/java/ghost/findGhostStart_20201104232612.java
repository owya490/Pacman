package ghost;
import java.util.*;
import java.io.*;

public class findGhostStart {
    public static HashMap<String, Integer> findx(String filename) {
        HashMap<String, Integer> tmp = new HashMap<String, Integer>();
        ArrayList<String[]> f = fileReader.readLines(filename);
        for (int y = 0; y < f.size(); y ++) {
            for (int x = 0; x < f.get(y).length; x ++) {
                if (f.get(y)[x].equals("g")) {
                    tmp.add(x);
                }
            }
        }
        return tmp;
    }
    public static HashMap<String, Integer> findy(String filename) {
        HashMap<String, Integer> tmp = HashMap<String, Integer>();
        ArrayList<String[]> f = fileReader.readLines(filename);
        for (int y = 0; y < f.size(); y ++) {
            for (int x = 0; x < f.get(y).length; x ++) {
                if (f.get(y)[x].equals("g")) {
                    tmp.add(y);
                }
            }
        }
        return tmp;
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