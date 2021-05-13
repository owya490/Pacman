package ghost;

public class findPlayerStart {
    public int findx(String filename) {
        ArrayList<String> f = fileReader.readLines("../../../../map.txt");
        for (int y = 0; y < this.lines.size(); y ++) {
            for (int x = 0; x < this.lines.get(y).length; x ++) {
                if (this.lines.get(y)[x].equals("p")) {
                    return x;
                }
            }
        }
    }
    public int findy(String filename) {
        for (int y = 0; y < this.lines.size(); y ++) {
            for (int x = 0; x < this.lines.get(y).length; x ++) {
                if (this.lines.get(y)[x].equals("p")) {
                    return y;
                }
            }
        }
    }
}