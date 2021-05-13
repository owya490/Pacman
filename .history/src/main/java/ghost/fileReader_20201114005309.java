package ghost;

import java.util.*;
import java.io.*;

public class fileReader {
    /**
     * A list of arrays of symbols read from the map text file
     */
    private ArrayList<String[]> lines;


    /**
     * The Constructor for a fileReader Object
     */
    public fileReader(){
    }

    /**
     * Converts a List to an Array
     * @param a the list to be converted
     * @return the converted array
     */
    public static String[][] convertToArray(ArrayList<String[]> a) {
        int one = a.size();
        int two = a.get(0).length;

        String[][] converted = new String[one][two];

        for (int x = 0; x < one; x ++){
            for (int y = 0; y < two; y ++) {
                converted[x][y] = a.get(x)[y];
            }
        }
        return converted;
    }

    /**
     * Reads from a text file and converts the text lines into a list of arrays for each line
     * @param filename the text file it will read from
     * @return the converted list of arrays
     */
    public static ArrayList<String[]> readLines(String filename) {
        ArrayList<String[]> lines = new ArrayList<String[]>();
        File f = new File(filename);
        try {
            Scanner scan = new Scanner(f);
            while (scan.hasNextLine()) {
                String s = scan.nextLine();
                String[] s1 = s.split("");
                lines.add(s1);
            }
        } 
        catch (FileNotFoundException e) {
            System.out.println("red");
        }

        return lines;
    }
}