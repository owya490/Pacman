public class fileReader {

    public static ArrayList<String>[] readLines(String filename) {
        ArrayList<String[]> lines = new ArrayList<String[]>();
        File f = new File(filename);
        try {
            while (f.hasNextLine()) {
                String s = f.nextLine();
                String[] s1 = s.split("");
                lines.add(s1);
        } 
        catch (FileNotFoundException e) {
            System.out.println("red");
        }

        return lines;

        }
    }

    public static void main(String[] args) {
        readLines("../../../map.txt");
    }
}