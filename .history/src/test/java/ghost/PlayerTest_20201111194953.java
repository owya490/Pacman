package ghost;
import processing.core.PApplet;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    @Test 
    public void constructorTest() {
        ArrayList<?> a = new ArrayList<?>();
        Player p = new Player(null, null, null, null, null, null, null, null, null, null, null, null, null);
        assertNotNull(p);
        //asserEquals(m.lives, 1);
    }
}
