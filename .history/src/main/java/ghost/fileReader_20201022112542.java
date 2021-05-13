package ghost;

import java.util.*;
import java.io.*;

public class fileReader {


    //private ArrayList<String[]> lines;

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

    public static void main(String[] args) {
        ArrayList<String[]> lines = readLines("../../../../map.txt");
        for (int y = 0; y < lines.size(); y ++) {
            for (int x = 0; x < lines.get(y).length; x ++) {
                if (lines.get(y)[x].equals("p")) {
                    System.out.println("help");

                }
            }
        }
    }
}