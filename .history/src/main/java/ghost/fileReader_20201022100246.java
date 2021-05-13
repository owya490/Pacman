//package ghost;

import java.util.*;
import java.io.*;

public class fileReader {

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
        ArrayList<String[]> tmp = readLines("../../../../map.txt");
        System.out.println(Arrays.toString(tmp.get(3)));
    }
}