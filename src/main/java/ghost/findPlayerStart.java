package ghost;
import java.util.*;
import java.io.*;

public class findPlayerStart {
    
    /**
     * Finds the starting x coordinates of player on the map
     * @param filename the map text file it is going to search
     * @return a list of x coordinates for player on the map
     */
    public static int findx(String filename) {
        ArrayList<String[]> f = fileReader.readLines(filename);
        for (int y = 0; y < f.size(); y ++) {
            for (int x = 0; x < f.get(y).length; x ++) {
                if (f.get(y)[x].equals("p")) {
                    return x;
                }
            }
        }
        return 0;
    }

    /**
     * Finds the starting y coordinates of player on the map
     * @param filename the map text file it is going to search
     * @return a list of y coordinates for player on the map
     */
    public static int findy(String filename) {
        ArrayList<String[]> f = fileReader.readLines(filename);
        for (int y = 0; y < f.size(); y ++) {
            for (int x = 0; x < f.get(y).length; x ++) {
                if (f.get(y)[x].equals("p")) {
                    return y;
                }
            }
        }
        return 0;
    }
}