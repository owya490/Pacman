package ghost;
import processing.core.PApplet;
import java.util.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    @Test 
    public void constructorTest() {
        ArrayList<soda> s = new ArrayList<soda>();
        ArrayList<superFruit> sf = new ArrayList<superFruit>();
        ArrayList<Fruit> f = new ArrayList<Fruit>();

        Player p = new Player(s, sf, f, null, null, 1, 1, "null", null, null, null, null, null);
        assertNotNull(p);
        //asserEquals(m.lives, 1);
    }

    @Test
    public void getAndSetAttributes() {
        ArrayList<soda> s = new ArrayList<soda>();
        ArrayList<superFruit> sf = new ArrayList<superFruit>();
        ArrayList<Fruit> f = new ArrayList<Fruit>();

        Player p = new Player(s, sf, f, null, null, 1, 1, "null", null, null, null, null, null);

        assertEquals(p.getLives(), 1);

        assertTrue(p.setLives(1));
        assertTrue(p.updateFruitList(f));
        assertTrue(p.updateSuperFruitList(sf));
        assertTrue(p.updateSodaList(s));
        
        assertTrue(p.openMouth(true));

        assertEquals(p.setX(1), 1);
        assertEquals(p.setY(1), 1);




    }
}
