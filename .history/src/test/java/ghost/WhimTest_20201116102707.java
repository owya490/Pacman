package ghost;
import processing.core.PApplet;
import java.util.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WhimTest {
    @Test 
    public void constructorTest() {
        ArrayList<Integer> ml = new ArrayList<Integer>();
        ml.add(1);
        boolean[][] b = new boolean[1][1];
        ArrayList<GhostObject> go = new ArrayList<GhostObject>(); 
        ArrayList<soda> s = new ArrayList<soda>();
        ArrayList<superFruit> sf = new ArrayList<superFruit>();
        ArrayList<Fruit> f = new ArrayList<Fruit>();

        Player p = new Player(s, sf, f, null, null, 1, 1, "null", null, null, null, null, null);
        
        Whim a = new Whim(null, 1, 1, null, null, ml, 1, b, p, go, 1, 1);
        assertNotNull(a);
        assertEquals(a.modeLengths_f[0], 60);
        assertEquals(a.getX(), 12);
        assertEquals(a.getY(), 11);

        //asserEquals(m.lives, 1);
    }

    @Test
    public void upOrDownCornerTest() {
        ArrayList<Integer> ml = new ArrayList<Integer>();
        ml.add(1);
        boolean[][] b = new boolean[1][1];
        ArrayList<GhostObject> go = new ArrayList<GhostObject>(); 
        ArrayList<soda> s = new ArrayList<soda>();
        ArrayList<superFruit> sf = new ArrayList<superFruit>();
        ArrayList<Fruit> f = new ArrayList<Fruit>();

        Player p = new Player(s, sf, f, null, null, 1, 1, "null", null, null, null, null, null);
    
        Whim a = new Whim(null, 3, 3, null, null, ml, 1, b, p, go, 1, 1);

        char[] c = new char[]{'s', 'w', 'd', 'a'};
        assertNotNull(a.upOrDownCorner());
        assertArrayEquals(a.upOrDownCorner(), c);

        a = new Whim(null, 20, 20, null, null, ml, 1, b, p, go, 1, 1);

        c = new char[]{'s', 'w', 'd', 'a'};
        assertNotNull(a.upOrDownCorner());
        assertArrayEquals(a.upOrDownCorner(), c);
        
        a = new Whim(null, 40, 30, null, null, ml, 1, b, p, go, 1, 1);

        c = new char[]{'a', 'd', 's', 'w'};
        assertNotNull(a.upOrDownCorner());
        assertArrayEquals(a.upOrDownCorner(), c);
        
        a = new Whim(null, 35, -3, null, null, ml, 1, b, p, go, 1, 1);

        c = new char[]{'s', 'w', 'a', 'd'};
        assertNotNull(a.upOrDownCorner());
        assertArrayEquals(a.upOrDownCorner(), c);

        a = new Whim(null, 28, -3, null, null, ml, 1, b, p, go, 1, 1);

        c = new char[]{'s', 'w', 'd', 'a'};
        assertNotNull(a.upOrDownCorner());
        assertArrayEquals(a.upOrDownCorner(), c);

        a = new Whim(null, 29, -3, null, null, ml, 1, b, p, go, 1, 1);

        c = new char[]{'s', 'w', 'a', 'd'};
        assertNotNull(a.upOrDownCorner());
        assertArrayEquals(a.upOrDownCorner(), c);

        a = new Whim(null, -1, 0, null, null, ml, 1, b, p, go, 1, 1);

        c = new char[]{'s', 'w', 'd', 'a'};
        assertNotNull(a.upOrDownCorner());
        assertArrayEquals(a.upOrDownCorner(), c);
        
        a = new Whim(null, 0, 1, null, null, ml, 1, b, p, go, 1, 1);

        c = new char[]{'s', 'w', 'd', 'a'};
        assertNotNull(a.upOrDownCorner());
        assertArrayEquals(a.upOrDownCorner(), c);
        
        a = new Whim(null, 0, -1, null, null, ml, 1, b, p, go, 1, 1);

        c = new char[]{'s', 'w', 'd', 'a'};
        assertNotNull(a.upOrDownCorner());
        assertArrayEquals(a.upOrDownCorner(), c);

        a = new Whim(null, 1, -2, null, null, ml, 1, b, p, go, 1, 1);

        c = new char[]{'s', 'w', 'd', 'a'};
        assertNotNull(a.upOrDownCorner());
        assertArrayEquals(a.upOrDownCorner(), c);

        a = new Whim(null, -10, 35, null, null, ml, 1, b, p, go, 1, 1);

        c = new char[]{'d', 'a', 's', 'w'};
        assertNotNull(a.upOrDownCorner());
        assertArrayEquals(a.upOrDownCorner(), c);

        a = new Whim(null, -1, 45, null, null, ml, 1, b, p, go, 1, 1);

        c = new char[]{'d', 'a', 'w', 's'};
        assertNotNull(a.upOrDownCorner());
        assertArrayEquals(a.upOrDownCorner(), c);

        a = new Whim(null, -20, 45, null, null, ml, 1, b, p, go, 1, 1);

        c = new char[]{'d', 'a', 'w', 's'};
        assertNotNull(a.upOrDownCorner());
        assertArrayEquals(a.upOrDownCorner(), c);

        a = new Whim(null, 29, 50, null, null, ml, 1, b, p, go, 1, 1);

        c = new char[]{'w', 's', 'a', 'd'};
        assertNotNull(a.upOrDownCorner());
        assertArrayEquals(a.upOrDownCorner(), c);
    }

    @Test
    public void upOrDownTest() {
        ArrayList<Integer> ml = new ArrayList<Integer>();
        ml.add(1);
        boolean[][] b = new boolean[1][1];
        ArrayList<GhostObject> go = new ArrayList<GhostObject>(); 
        ArrayList<soda> s = new ArrayList<soda>();
        ArrayList<superFruit> sf = new ArrayList<superFruit>();
        ArrayList<Fruit> f = new ArrayList<Fruit>();

        Player p = new Player(s, sf, f, null, null, 1, 1, "map2.txt", null, null, null, null, null);
    
        Whim a = new Whim(null, 3, 3, null, null, ml, 1, b, p, go, 1, 1);
        Whim Whim = new Whim(null, 1, 1, null, null, ml, 1, b, p, go, 1, 1);
        a.setCurrentWhim(Whim);

        char[] c = new char[]{'s', 'w', 'd', 'a'};
        p.setDirection('d');
        assertNotNull(a.upOrDown());
        assertArrayEquals(a.upOrDown(), c);

        p = new Player(s, sf, f, null, null, 1, 1, "map2.txt", null, null, null, null, null);
        p.setX(500);
        a = new Whim(null, 3, 3, null, null, ml, 1, b, p, go, 1, 1);
        Whim = new Whim(null, 1, 1, null, null, ml, 1, b, p, go, 1, 1);
        a.setCurrentWhim(Whim);
        c = new char[]{'s', 'w', 'd', 'a'};
        p.setDirection('d');
        assertNotNull(a.upOrDown());
        assertArrayEquals(a.upOrDown(), c);


        p = new Player(s, sf, f, null, null, 1, 1, "map2.txt", null, null, null, null, null);
        p.setX(500);
        p.setY(600);
        a = new Whim(null, 3, 3, null, null, ml, 1, b, p, go, 1, 1);
        Whim = new Whim(null, 1, 1, null, null, ml, 1, b, p, go, 1, 1);
        a.setCurrentWhim(Whim);
        c = new char[]{'s', 'w', 'd', 'a'};
        p.setDirection('w');
        assertNotNull(a.upOrDown());
        assertArrayEquals(a.upOrDown(), c);


        p = new Player(s, sf, f, null, null, 1, 1, "map2.txt", null, null, null, null, null);
        p.setX(0);
        p.setY(0);
        a = new Whim(null, 3, 3, null, null, ml, 1, b, p, go, 1, 1);
        Whim = new Whim(null, 1, 1, null, null, ml, 1, b, p, go, 1, 1);
        a.setCurrentWhim(Whim);
        c = new char[]{'a', 'd', 's', 'w'};
        p.setDirection('s');
        assertNotNull(a.upOrDown());
        assertArrayEquals(a.upOrDown(), c);

        p = new Player(s, sf, f, null, null, 1, 1, "map2.txt", null, null, null, null, null);
        p.setX(0);
        p.setY(0);
        a = new Whim(null, 3, 3, null, null, ml, 1, b, p, go, 1, 1);
        Whim = new Whim(null, 1, 1, null, null, ml, 1, b, p, go, 1, 1);
        a.setCurrentWhim(Whim);
        c = new char[]{'a', 'd', 'w', 's'};
        p.setDirection('a');
        assertNotNull(a.upOrDown());
        assertArrayEquals(a.upOrDown(), c);

        p = new Player(s, sf, f, null, null, 1, 1, "map2.txt", null, null, null, null, null);
        p.setX(0);
        p.setY(0);
        a = new Whim(null, 3, 3, null, null, ml, 1, b, p, go, 1, 1);
        a.setPlayerX_g(0);
        Whim = new Whim(null, 1, 1, null, null, ml, 1, b, p, go, 1, 1);
        a.setCurrentWhim(Whim);
        c = new char[]{'a', 'd', 'w', 's'};
        p.setDirection('w');
        assertNotNull(a.upOrDown());
        assertArrayEquals(a.upOrDown(), c);

        p = new Player(s, sf, f, null, null, 1, 1, "map2.txt", null, null, null, null, null);
        p.setX(0);
        p.setY(0);
        a = new Whim(null, 3, 3, null, null, ml, 1, b, p, go, 1, 1);
        a.setPlayerY_g(600);
        Whim = new Whim(null, 1, 1, null, null, ml, 1, b, p, go, 1, 1);
        a.setCurrentWhim(Whim);
        c = new char[]{'s', 'w', 'a', 'd'};
        p.setDirection('s');
        assertNotNull(a.upOrDown());
        assertArrayEquals(a.upOrDown(), c);

        p = new Player(s, sf, f, null, null, 1, 1, "map2.txt", null, null, null, null, null);
        p.setX(0);
        p.setY(0);
        a = new Whim(null, 3, 3, null, null, ml, 1, b, p, go, 1, 1);
        a.setPlayerX_g(100);
        Whim = new Whim(null, 1, 1, null, null, ml, 1, b, p, go, 1, 1);
        a.setCurrentWhim(Whim);
        c = new char[]{'d', 'a', 'w', 's'};
        p.setDirection('a');
        assertNotNull(a.upOrDown());
        assertArrayEquals(a.upOrDown(), c);

        p = new Player(s, sf, f, null, null, 1, 1, "map2.txt", null, null, null, null, null);
        p.setX(0);
        p.setY(0);
        a = new Whim(null, 3, 3, null, null, ml, 1, b, p, go, 1, 1);
        a.setPlayerY_g(0);
        a.setPlayerX_g(45);
        Whim = new Whim(null, 1, 1, null, null, ml, 1, b, p, go, 1, 1);
        a.setCurrentWhim(Whim);
        c = new char[]{'w', 's', 'a', 'd'};
        p.setDirection('a');
        assertNotNull(a.upOrDown());
        assertArrayEquals(a.upOrDown(), c);
    }

    @Test 
    public void tickTest() {
        MazeBuilder mb = new MazeBuilder("mapWhimTest.txt", null, null, null, null, null, null, null, null, null);
        ArrayList<soda> s = mb.sodaList();
        ArrayList<Fruit> f = mb.fruitList();
        ArrayList<superFruit> sf = mb.superFruitList();
        ArrayList<GhostObject> g = new ArrayList<GhostObject>();
        ArrayList<Integer> ml = new ArrayList<Integer>();


        String[][] map = fileReader.convertToArray(fileReader.readLines("mapWhimTest.txt"));
        MazePath mp = new MazePath();
        boolean[][] path = mp.createPath(map);
        Player p = new Player(s, sf, f, map, path, 1, 1, "mapWhimTest.txt", null, null, null, null, null);

        ml.add(1);
    
        Whim a = new Whim(null, findGhostStart.Whimfindx("mapWhimTest.txt").get(0), findGhostStart.Whimfindy("mapWhimTest.txt").get(0), null, null, ml, 1, path, p, g, 1, 1);


        a.setFrightened(true);
        for (int i = 0; i < 70; i ++) {
            a.tick('a');
        }
        assertFalse(a.getFrightened());

        a.sodaEffectSet(true);
        for (int i = 0; i < 70; i ++) {
            a.tick('a');
        }
        assertFalse(a.sodaEffectGet());
        for (int i = 0; i < 50; i ++) {
            a.tick('a');
        }

        mb = new MazeBuilder("mapWhimTest2.txt", null, null, null, null, null, null, null, null, null);
        s = mb.sodaList();
        f = mb.fruitList();
        sf = mb.superFruitList();
        g = new ArrayList<GhostObject>();
        ml = new ArrayList<Integer>();


        map = fileReader.convertToArray(fileReader.readLines("mapWhimTest2.txt"));
        mp = new MazePath();
        path = mp.createPath(map);
        p = new Player(s, sf, f, map, path, 3, 1, "mapWhimTest2.txt", null, null, null, null, null);

        ml.add(1);
    
        a = new Whim(null, findGhostStart.Whimfindx("mapWhimTest2.txt").get(0), findGhostStart.Whimfindy("mapWhimTest2.txt").get(0), null, null, ml, 1, path, p, g, 4, 4);
        for (int i = 0; i < 100; i ++) {
            p.tick('a');
            a.tick('a');
        }
        assertEquals(a.getX(), 352);
        assertEquals(a.getY(), 411);

        a.setFrightened(true);
        for (int i = 0; i < 200; i ++) {
            p.tick('a');
            a.tick('a');
        }
        assertEquals(a.getX(), 359);
        assertEquals(a.getY(), 411);

        mb = new MazeBuilder("mapWhimTest3.txt", null, null, null, null, null, null, null, null, null);
        s = mb.sodaList();
        f = mb.fruitList();
        sf = mb.superFruitList();
        g = new ArrayList<GhostObject>();
        ml = new ArrayList<Integer>();


        map = fileReader.convertToArray(fileReader.readLines("mapWhimTest3.txt"));
        mp = new MazePath();
        path = mp.createPath(map);
        p = new Player(s, sf, f, map, path, 3, 1, "mapWhimTest3.txt", null, null, null, null, null);

        ml.add(1);
    
        a = new Whim(null, findGhostStart.Whimfindx("mapWhimTest3.txt").get(0), findGhostStart.Whimfindy("mapWhimTest3.txt").get(0), null, null, ml, 1, path, p, g, 4, 4);
        for (int i = 0; i < 100; i ++) {
            p.tick('a');
            a.tick('a');
        }
        assertEquals(a.getX(), 172);
        assertEquals(a.getY(), 407);
        a.setFrightened(true);
        for (int i = 0; i < 201; i ++) {
            p.tick('a');
            a.tick('a');
        }
        assertEquals(a.getX(), 172);
        assertEquals(a.getY(), 398);

        mb = new MazeBuilder("map.txt", null, null, null, null, null, null, null, null, null);
        s = mb.sodaList();
        f = mb.fruitList();
        sf = mb.superFruitList();
        g = new ArrayList<GhostObject>();
        ml = new ArrayList<Integer>();


        map = fileReader.convertToArray(fileReader.readLines("map.txt"));
        mp = new MazePath();
        path = mp.createPath(map);
        p = new Player(s, sf, f, map, path, 3, 1, "map.txt", null, null, null, null, null);

        ml.add(1);
    
        a = new Whim(null, findGhostStart.Whimfindx("map.txt").get(0), findGhostStart.Whimfindy("map.txt").get(0), null, null, ml, 1, path, p, g, 4, 4);
        for (int i = 0; i < 500; i ++) {
            p.tick('a');
            a.tick('a');
        }
        assertEquals(a.getX(), 272);
        assertEquals(a.getY(), 219);

        for (int i = 0; i < 500; i ++) {
            p.tick('a');
            a.tick('a');
        }
        assertEquals(a.getX(), 284);
        assertEquals(a.getY(), 275);
    }
}