package ghost;

import java.util.*;
import java.io.*;

public class fileReader {

    public fileReader();
    private ArrayList<String[]> lines;

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