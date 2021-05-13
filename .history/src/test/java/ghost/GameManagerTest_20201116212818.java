package ghost;
import processing.core.PApplet;

import java.util.*;

import java.awt.Robot;
import java.awt.*;
//import processing.event.KeyEvent;
import java.awt.event.KeyEvent;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GameManagerTest {
    @Test 
    public void constructorTest() {

    GameManager m = new GameManager();
    assertNotNull(m);
    assertTrue(m.constructGame());
    }

    @Test
    public void readConfigFileTest() {
        GameManager m = new GameManager();

        assertTrue(m.readConfigFile("configTest.json"));
        assertEquals(m.getMap(), "mapGameManagerTest.txt");
        assertEquals(m.getLives(), 3);
        assertEquals(m.getSpeed(), 1);
        assertEquals(m.getSodaLength(), 7);
        assertEquals(m.getFrightenedLength(), 7);
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        tmp.add(7);
        tmp.add(20);
        tmp.add(7);
        tmp.add(20);
        tmp.add(5);
        tmp.add(20);
        tmp.add(5);
        tmp.add(1000);
        for (int i = 0; i < tmp.size(); i ++) {
            assertEquals(m.getModeLengths().get(i), tmp.get(i));
        }
        assertFalse(m.readConfigFile("configTest2.json"));
        assertFalse(m.readConfigFile("yes.txt"));

    }


    @Test
    public void instantiateGhostObjectsTest() {
        GameManager m = new GameManager();
        m.readConfigFile(("configTest.json"));
        m.buildMap();
        m.instantiateObjects();
        m.instantiateGhostObjects();
        assertTrue(m.instantiateGhostObjects());
        for (GhostObject g : m.getGhostObj()) {
            assertNotNull(g);
        }
        assertEquals(m.getGhostObj().get(0).getX(), 364);
        assertEquals(m.getGhostObj().get(0).getY(), 411);

        assertEquals(m.getGhostObj().get(1).getX(), 396);
        assertEquals(m.getGhostObj().get(1).getY(), 411);

        assertEquals(m.getGhostObj().get(2).getX(), 412);
        assertEquals(m.getGhostObj().get(2).getY(), 411);

        assertEquals(m.getGhostObj().get(3).getX(), 380);
        assertEquals(m.getGhostObj().get(3).getY(), 411);
    }

    @Test
    public void buildMapTest() {
        GameManager m = new GameManager();
        m.readConfigFile(("configTest.json"));
        assertTrue(m.buildMap());
        assertArrayEquals(m.getLines_f(), fileReader.convertToArray(fileReader.readLines("mapGameManagerTest.txt")));
    }

    @Test 
    public void instantiateObjectsTest() {
        GameManager m = new GameManager();
        m.readConfigFile(("configTest.json"));
        m.buildMap();
        assertTrue(m.instantiateObjects());
        assertNotNull(m.getSuperFruitList());
        assertNotNull(m.getFruitList());
        assertNotNull(m.getSodaList());
        assertNotNull(m.getPlayer());
    }

    @Test
    public void resetAllTest() {
        GameManager m = new GameManager();
        m.constructGame();
        assertFalse(m.resetAll());
        assertEquals(m.getDeathTimer(), 1);
        for (int i = 0; i < 599; i ++) {
            m.resetAll();
        }
        assertTrue(m.resetAll());
    }

    @Test
    public void openMouthLogicTest() {
        GameManager m = new GameManager();
        m.constructGame();
        assertTrue(m.openMouthLogic());
        assertEquals(m.setN(8), 8);
        assertFalse(m.openMouthLogic());
    }

    @Test
    public void keyPressedCallTest() {
        GameManager m = new GameManager();
        m.constructGame();
        m.keyPressedCall(38);
        assertEquals(m.getPlayer().getDirection(), 'w');
        m.keyPressedCall(40);
        assertEquals(m.getPlayer().getDirection(), 's');
        m.keyPressedCall(37);
        assertEquals(m.getPlayer().getDirection(), 'a');
        m.keyPressedCall(39);
        assertEquals(m.getPlayer().getDirection(), 'd');
        m.keyPressedCall(32);
        assertFalse(m.getGhostObj().get(0).setDebug());
    }

    @Test
    public void loadImagesTest() {
        App app = new App();
        PApplet.runSketch(new String[] {"App"}, app);
        GameManager m = new GameManager();
        assertTrue(m.loadSprites(app));
    }

    @Test
    public void winLoseScreenTest() {
        App app = new App();
        PApplet.runSketch(new String[] {"App"}, app);
        GameManager m = new GameManager();
        m.constructGame();
        m.getPlayer().setLives(1);
        for (int i = 0; i < 601; i ++) {
            m.resetAll();
        }
        //assertTrue(m.loseScreen());
        assertEquals(m.getPlayer().getLives(), 3);


        //assertTrue(m.winScreen());
    }
}
