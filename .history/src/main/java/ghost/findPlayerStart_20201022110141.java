package ghost;

public class findPlayerStart {
    public int findx(String filename) {
        ArrayList<String> f = fileReader.readLines(filename);
        for (int y = 0; y < f.size(); y ++) {
            for (int x = 0; x < f.get(y).length; x ++) {
                if (f.get(y)[x].equals("p")) {
                    return x;
                }
            }
        }
    }
    public int findy(String filename) {
        ArrayList<String> f = fileReader.readLines(filename);
        for (int y = 0; y < f.size(); y ++) {
            for (int x = 0; x < f.get(y).length; x ++) {
                if (f.get(y)[x].equals("p")) {
                    return y;
                }
            }
        }
    }
}