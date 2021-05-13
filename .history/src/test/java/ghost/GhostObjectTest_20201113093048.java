package ghost;
import processing.core.PApplet;
import java.util.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GhostObjectTest {
    @Test 
    public void sodaTests() {
        ArrayList<Integer> ml = new ArrayList<Integer>();
        ml.add(1);
        boolean[][] b = new boolean[1][1];
        ArrayList<GhostObject> go = new ArrayList<GhostObject>(); 
        ArrayList<soda> s = new ArrayList<soda>();
        ArrayList<superFruit> sf = new ArrayList<superFruit>();
        ArrayList<Fruit> f = new ArrayList<Fruit>();

        Player p = new Player(s, sf, f, null, null, 1, 1, "null", null, null, null, null, null);
        
        GhostObject a = new Chaser(null, 1, 1, null, null, ml, 1, b, p, go, 1, 1);
        
        assertFalse(a.sodaEffectGet());
        assertTrue(a.sodaEffectSet(true));
        assertTrue(a.sodaEffectGet());
        assertTrue(a.resetSodaFrames());
        assertEquals(a.sodaFrames, 0);
    }

    @Test 
    public void deadTests() {
        ArrayList<Integer> ml = new ArrayList<Integer>();
        ml.add(1);
        boolean[][] b = new boolean[1][1];
        ArrayList<GhostObject> go = new ArrayList<GhostObject>(); 
        ArrayList<soda> s = new ArrayList<soda>();
        ArrayList<superFruit> sf = new ArrayList<superFruit>();
        ArrayList<Fruit> f = new ArrayList<Fruit>();

        Player p = new Player(s, sf, f, null, null, 1, 1, "null", null, null, null, null, null);
        
        GhostObject a = new Chaser(null, 1, 1, null, null, ml, 1, b, p, go, 1, 1);
        ArrayList<GhostObject> go1 = new ArrayList<GhostObject>(); 
        GhostObject a1 = new Chaser(null, 1, 1, null, null, ml, 1, b, p, go, 1, 1);
        go1.add(a1);
        assertTrue(a.setOtherGhosts(go1));
        assertEquals(a.other_ghosts, go1);
        assertTrue(a.setDead(true));
        assertTrue(a.isDead);
        assertFalse(a.setDead(false));
        assertFalse(a.isDead);
        for (GhostObject g : a.other_ghosts) {
            assertTrue(g.setDead(true)));
        }

        assertTrue(a.setAllDead());
        for (GhostObject g : a.other_ghosts) {
            assertFalse(g.isDead);
        }

    }
}