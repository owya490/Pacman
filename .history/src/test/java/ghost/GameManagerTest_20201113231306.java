package ghost;
import processing.core.PApplet;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GameManagerTest {
    @Test 
    public void constructorTest() {
    //     App a = new App();
    //     GameManager m = new GameManager(a);
    //     assertNotNull(m);
    //     //asserEquals(m.lives, 1);
    }

    @Test
    public void readConfigFileTest() {
        readConfigFile("config.json")
    }

    @Test
    public void instantiateGhostObjectsTest() {
        
    }
}