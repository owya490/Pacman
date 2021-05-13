//package ghost;

import java.util.*;
import java.io.*;

public class fileReader {


    private static ArrayList<String[]> lines;

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
        this.lines = readLines("../../../../map.txt");
        for (int y = 0; y < this.lines.size(); y ++) {
            for (int x = 0; x < this.lines.get(y).length; x ++) {
                if (this.lines.get(y)[x].equals("0")) {
                    System.out.println("help");

                }
            }
        }
    }
}