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
        assertEquals(mb.fruitList().size(), 1);
    }