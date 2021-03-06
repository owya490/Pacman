package ghost;
import processing.core.PApplet;
import java.util.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    @Test 
    public void constructorTest() {
        ArrayList<soda> s = new ArrayList<soda>();
        ArrayList<superFruit> sf = new ArrayList<superFruit>();
        ArrayList<Fruit> f = new ArrayList<Fruit>();

        Player p = new Player(s, sf, f, null, null, 1, 1, "null", null, null, null, null, null);
        assertNotNull(p);
        //asserEquals(m.lives, 1);
    }

    @Test
    public void getAndSetAttributes() {
        ArrayList<soda> s = new ArrayList<soda>();
        ArrayList<superFruit> sf = new ArrayList<superFruit>();
        ArrayList<Fruit> f = new ArrayList<Fruit>();

        Player p = new Player(s, sf, f, null, null, 1, 1, "null", null, null, null, null, null);

        assertEquals(p.getLives(), 1);

        assertTrue(p.setLives(1));
        assertTrue(p.updateFruitList(f));
        assertTrue(p.updateSuperFruitList(sf));
        assertTrue(p.updateSodaList(s));
        
        assertTrue(p.openMouth(true));

        assertEquals(p.setX(1), 1);
        assertEquals(p.setY(1), 1);

        assertEquals(p.setDirection('d'), 'd');

        assertEquals(p.getDirection(), 'd');

        ArrayList<GhostObject> g = new ArrayList<GhostObject>();

        assertTrue(p.setGhostObj(g));
    }

    @Test
    public void tickTest() {
        System.out.println("hello");
        MazeBuilder mb = new MazeBuilder("map1.txt", null, null, null, null, null, null, null, null, null);
        ArrayList<soda> s = mb.sodaList();
        ArrayList<Fruit> f = mb.fruitList();
        ArrayList<superFruit> sf = mb.superFruitList();
        ArrayList<GhostObject> g = new ArrayList<GhostObject>();
        ArrayList<Integer> ml = new ArrayList<Integer>();


        String[][] map = fileReader.convertToArray(fileReader.readLines("map1.txt"));
        MazePath mp = new MazePath();
        boolean[][] path = mp.createPath(map);
        Player p = new Player(s, sf, f, map, path, 1, 1, "map1.txt", null, null, null, null, null);

        ml.add(1);
        g.add(new Chaser(null, 1, 1, null, null, ml, 1, path, p, g, 1, 1));
        //App a = new App();
        //GameManager m = new GameManager(a);
        p.setGhostObj(g);
        assertTrue(p.setDead(true));
        p.tick('d');
        assertFalse(p.getDead());
        p.tick('w');
        assertEquals(p.setDirection('w'), 'w');
        p.tick('w');
        assertEquals(p.getInput(), 'd');

        assertEquals(p.setDirection('s'), 's');
        p.tick('s');
        assertEquals(p.getInput(), 'd');

        assertEquals(p.setDirection('a'), 'a');
        p.tick('a');
        assertEquals(p.getInput(), 'a');
        //assertEquals(p.setDirection('d'), 'd');
        //assertEquals(p.getDirection(), 'a');


        for (int i = 0; i < 100; i ++) {
            //assertEquals(p.setDirection('d'), 'd');
            p.tick('d');

        }
        assertEquals(p.setDirection('w'), 'w');
        p.tick('w');
        assertEquals(p.getInput(), 'w');

        assertEquals(p.setDirection('s'), 's');
        p.tick('s');
        assertEquals(p.getInput(), 's');
        p.tick('s');
        for (int i = 0; i < 10; i ++) {
            assertEquals(p.setDirection('s'), 's');
            p.tick('s');

        }
        for (GhostObject ghost : g) {
            assertTrue(ghost.getFrightened());
            assertTrue(ghost.sodaEffectGet());
        }

        assertEquals(p.setDirection('d'), 'd');
        p.tick('w');

        assertEquals(p.getInput(), 's');

        assertEquals(p.setDirection('a'), 'a');
        p.tick('a');
        assertEquals(p.getInput(), 's');
        for (int i = 0; i < 99; i ++) {
            assertEquals(p.setDirection('s'), 's');
            p.tick('s');
        }
    }

    // @Test
    // public void drawTest() {
    //     MazeBuilder mb = new MazeBuilder("map1.txt", null, null, null, null, null, null, null, null, null);
    //     ArrayList<soda> s = mb.sodaList();
    //     ArrayList<Fruit> f = mb.fruitList();
    //     ArrayList<superFruit> sf = mb.superFruitList();
    //     ArrayList<GhostObject> g = new ArrayList<GhostObject>();
    //     ArrayList<Integer> ml = new ArrayList<Integer>();


    //     String[][] map = fileReader.convertToArray(fileReader.readLines("map1.txt"));
    //     MazePath mp = new MazePath();
    //     boolean[][] path = mp.createPath(map);
    //     Player p = new Player(s, sf, f, map, path, 1, 1, "map1.txt", null, null, null, null, null);

    //     ml.add(1);
    //     g.add(new Chaser(null, 1, 1, null, null, ml, 1, path, p, g, 1, 1));
    //     App a = new App();
    //     PApplet.runSketch(new String[] {"App"}, a);
    //     GameManager m = new GameManager();
    //     m.constructGame();
    //     m.getPlayer().draw(a);
    // }
}
