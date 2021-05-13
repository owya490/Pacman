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
        assertEquals(lines_f[0][0], "0");
    }

    @Test
    public void findGhostStartTest() {
        assertEquals(findGhostStart.ambusherfindx("map.txt").get(0), 16);
        assertEquals(findGhostStart.ambusherfindy("map.txt").get(0), 14);
        assertEquals(findGhostStart.chaserfindx("map.txt").get(0), 14);
        assertEquals(findGhostStart.chaserfindy("map.txt").get(0), 14);
        assertEquals(findGhostStart.ignorantfindx("map.txt").get(0), 10);
        assertEquals(findGhostStart.ignorantfindy("map.txt").get(0), 14);
        assertEquals(findGhostStart.whimfindx("map.txt").get(0), 12);
        assertEquals(findGhostStart.whimfindy("map.txt").get(0), 14);
    }

    @Test
    public void findPlayerStartTest() {
        assertEquals(findPlayerStart.findx("map.txt"), 13);
        assertEquals(findPlayerStart.findy("map.txt"), 20);
    }

    @Test 
    public void GameObjectTest() {
        GameObject g = new GameObject();
    }
}