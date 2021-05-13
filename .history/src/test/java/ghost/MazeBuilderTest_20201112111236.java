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
        assertNotNull(mb.fruitList());
        assertNotNull(mb.fruitList().get(0));
        assertEquals(mb.fruitList().size(), 1);

        assertNotNull(mb.superFruitList());
        assertNotNull(mb.superFruitList().get(0));
        assertEquals(mb.superFruitList().size(), 1);

        assertNotNull(mb.sodaList());
        assertNotNull(mb.sodaList().get(0));
        assertEquals(mb.sodaList().size(), 1);

        assertFalse(mb.checkFruitListDone());

        assertFalse(mb.checkSuperFruitListDone());
    }
}