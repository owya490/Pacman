package ghost;
import processing.core.PApplet;
import java.util.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MazeBuilderTest {
    @Test 
    public void constructorTest() {
        MazeBuilder mb = new MazeBuilder("map2.txt", null, null, null, null, null, null, null, null, null);
        assertNotNull(mb);
    }

    @Test
    public void constructList() {
        MazeBuilder mb = new MazeBuilder("map2.txt", null, null, null, null, null, null, null, null, null);
        ArrayList<soda> s = mb.sodaList();
        ArrayList<Fruit> f = mb.fruitList();
        ArrayList<superFruit> sf = mb.superFruitList();
        assertNotNull(f);
        assertNotNull(f.get(0));
        assertEquals(f.size(), 1);

        assertNotNull(sf);
        assertNotNull(sf.get(0));
        assertEquals(sf.size(), 1);

        assertNotNull(s);
        assertNotNull(s.get(0));
        assertEquals(s.size(), 1);

        assertFalse(mb.checkFruitListDone());

        assertFalse(mb.checkSuperFruitListDone());

        for (Fruit fruit : f) {
            fruit.eaten = true;
        }

        for (superFruit fruit : sf) {
            fruit.eaten = true;
        }
        assertTrue(mb.checkFruitListDone());

        assertTrue(mb.checkSuperFruitListDone());
    }

    @Test
    public void buildTest() {
        App app = new App();
        PApplet.runSketch(new String[] {"App"}, app);
        GameManager m = new GameManager();
        MazeBuilder mb = new MazeBuilder("map2.txt", null, null, null, null, null, null, null, null, null);
        try {
            mb.draw();
        } 
        catch (NullPointerException e) {
            throw new AssertionError();
        }
        catch (ArrayIndexOutOfBounds e) {
            throw new AssertionError();
        }
    }
}