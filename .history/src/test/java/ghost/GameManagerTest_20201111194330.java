package ghost;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GameManagerTest {
    @Test 
    public void constructorTest() {
        GameManager m = new GameManager();
        assertNotNull(classUnderTest);
        asserEquals(m.lives, 1);
    }
}
