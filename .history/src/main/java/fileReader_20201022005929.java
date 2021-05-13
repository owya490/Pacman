public class fileReader {

    public static ArrayList<String>[] readLines(String filename) {
        ArrayList<String[]> lines = new ArrayList<String[]>();
        File f = new File(filename);
        try{
            while (f.hasNextLine()) {
                String s = f.nextLine();
                String[] s1 = s.split("");
                lines.add(s1);
        } catch (FileNotFoundError e) {
            return null;
        }

        return lines;

        }
    }
}