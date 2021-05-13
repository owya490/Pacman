package ghost;
import processing.core.PApplet;
import java.util.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SupportingClassTest {
    @Test 
    public void constructorTest() {
        MazeBuilder mb = new MazeBuilder("map2.txt", null, null, null, null, null, null, null, null, null);
        assertNotNull(mb);
        fileReader fr = new fileReader();
        assertNotNull(fr);
    }

    @Test
    public void readLinesTest() {
        ArrayList<String[]> lines = fileReader.readLines("map.txt");
        assertEquals(lines.get(20)[5], "2");
        assertEquals(lines.get(20)[16], "7");

        ArrayList<String[]> tmp = new ArrayList<String[]>();
        tmp.add(new String[] {"0", "2", "0"});
        String[][] lines_f = fileReader.convertToArray(tmp);
        assertArrayEquals(lines_f, null);

    }
}