package ghost;
import processing.core.PApplet;

import java.util.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GameManagerTest {
    @Test 
    public void constructorTest() {

    GameManager m = new GameManager();
    assertNotNull(m);
    }

    @Test
    public void readConfigFileTest() {
        GameManager m = new GameManager();

        assertTrue(m.readConfigFile("configTest.json"));
        assertEquals(m.getMap(), "mapGameManagerTest.txt");
        assertEquals(m.getLives(), 3);
        assertEquals(m.getSpeed(), 1);
        assertEquals(m.getSodaLength(), 7);
        assertEquals(m.getFrightenedLength(), 7);
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        tmp.add(7);
        tmp.add(20);
        tmp.add(7);
        tmp.add(20);
        tmp.add(5);
        tmp.add(20);
        tmp.add(5);
        tmp.add(1000);
        for (int i = 0; i < tmp.size(); i ++) {
            assertEquals(m.getModeLengths().get(i), tmp.get(i));
        }
        assertFalse(m.readConfigFile("configTest2.json"));
        assertFalse(m.readConfigFile("yes.txt"));

    }


    @Test
    public void instantiateGhostObjectsTest() {
        GameManager m = new GameManager();
        m.readConfigFile(("configTest.json"));
        m.buildMap();
        m.instantiateObjects();
        m.instantiateGhostObjects();
        assertTrue(m.instantiateGhostObjects());
        for (GhostObject g : m.getGhostObj()) {
            assertNotNull(g);
        }
        assertEquals(m.getGhostObj().get(0).getX(), 364);
        assertEquals(m.getGhostObj().get(0).getY(), 364);

        assertEquals(m.getGhostObj().get(1).getX(), 364);
        assertEquals(m.getGhostObj().get(1).getY(), 364);

        assertEquals(m.getGhostObj().get(2).getX(), 364);
        assertEquals(m.getGhostObj().get(2).getY(), 364);

        assertEquals(m.getGhostObj().get(3).getX(), 364);
        assertEquals(m.getGhostObj().get(3).getY(), 364);

    }
}
