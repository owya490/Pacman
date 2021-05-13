package ghost;
import processing.core.PApplet;

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

        m.readConfigFile("config.json");
    }

    @Test
    public void instantiateGhostObjectsTest() {
        
    }
}
