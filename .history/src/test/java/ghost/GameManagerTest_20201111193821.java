package ghost;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test 
    public void simpleTest() {
        App classUnderTest = new App();
        assertNotNull(classUnderTest);
    }
}
