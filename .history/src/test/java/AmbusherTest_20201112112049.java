package ghost;
import processing.core.PApplet;
import java.util.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    @Test 
    public void constructorTest() {
        ArrayList<Integer> ml = new ArrayList<Integer>();
        boolean[][] b = new boolean[][]
        ArrayList<GhostObject> go = new ArrayList<GhostObject>();



        Ambusher a = new Ambusher(null, 1, 1, null, null, ml, 1, b, null, go, 1, 1);
        assertNotNull(a);
        //asserEquals(m.lives, 1);
    }