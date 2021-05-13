package ghost;
import processing.core.PApplet;

import java.util.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GameManagerTest {
    @Test 
    public void constructorTest() {

    GameManager m = new GameManager(a);
    assertNotNull(m);
    }

    @Test
    public void readConfigFileTest() {
        GameManager m = new GameManager();

        assertTrue(m.readConfigFile("configTest.json"));
        assertEquals(m.getMap(), "map.txt");
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
            assertEquals(m.getModeLengths.get(i), tmp.get(i))
        }
    }

    @Test
    public void instantiateGhostObjectsTest() {
        
    }
}
