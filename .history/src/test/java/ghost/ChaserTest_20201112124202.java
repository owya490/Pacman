package ghost;
import processing.core.PApplet;
import java.util.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ChaserTest {
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
        
        Chaser a = new Chaser(null, 1, 1, null, null, ml, 1, b, p, go, 1, 1);
        assertNotNull(a);
        assertEquals(a.modeLengths_f[0], 60);
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
    
        Chaser a = new Chaser(null, 3, 3, null, null, ml, 1, b, p, go, 1, 1);

        char[] c = new char[]{'a', 'd', 'w', 's'};
        assertNotNull(a.upOrDownCorner());
        assertArrayEquals(a.upOrDownCorner(), c);

        a = new Chaser(null, 20, 20, null, null, ml, 1, b, p, go, 1, 1);

        c = new char[]{'w', 's', 'd', 'a'};
        assertNotNull(a.upOrDownCorner());
        assertArrayEquals(a.upOrDownCorner(), c);
        
        a = new Chaser(null, 40, 30, null, null, ml, 1, b, p, go, 1, 1);

        c = new char[]{'w', 's', 'a', 'd'};
        assertNotNull(a.upOrDownCorner());
        assertArrayEquals(a.upOrDownCorner(), c);
        
        a = new Chaser(null, 35, -3, null, null, ml, 1, b, p, go, 1, 1);

        c = new char[]{'a', 'd', 's', 'w'};
        assertNotNull(a.upOrDownCorner());
        assertArrayEquals(a.upOrDownCorner(), c);

        a = new Chaser(null, 28, -3, null, null, ml, 1, b, p, go, 1, 1);

        c = new char[]{'s', 'w', 'd', 'a'};
        assertNotNull(a.upOrDownCorner());
        assertArrayEquals(a.upOrDownCorner(), c);

        a = new Chaser(null, 29, -3, null, null, ml, 1, b, p, go, 1, 1);

        c = new char[]{'s', 'w', 'a', 'd'};
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
    
        Chaser a = new Chaser(null, 3, 3, null, null, ml, 1, b, p, go, 1, 1);

        char[] c = new char[]{'s', 'w', 'd', 'a'};
        p.setDirection('d');
        assertNotNull(a.upOrDown());
        assertArrayEquals(a.upOrDown(), c);

        p = new Player(s, sf, f, null, null, 1, 1, "map2.txt", null, null, null, null, null);
        p.setX(500);
        a = new Chaser(null, 3, 3, null, null, ml, 1, b, p, go, 1, 1);

        c = new char[]{'d', 'a', 's', 'w'};
        p.setDirection('d');
        assertNotNull(a.upOrDown());
        assertArrayEquals(a.upOrDown(), c);


        p = new Player(s, sf, f, null, null, 1, 1, "map2.txt", null, null, null, null, null);
        p.setX(500);
        p.setY(600);
        a = new Chaser(null, 3, 3, null, null, ml, 1, b, p, go, 1, 1);

        c = new char[]{'s', 'w', 'd', 'a'};
        p.setDirection('w');
        assertNotNull(a.upOrDown());
        assertArrayEquals(a.upOrDown(), c);


        p = new Player(s, sf, f, null, null, 1, 1, "map2.txt", null, null, null, null, null);
        p.setX(0);
        p.setY(0);
        a = new Chaser(null, 3, 3, null, null, ml, 1, b, p, go, 1, 1);

        c = new char[]{'a', 'd', 's', 'w'};
        p.setDirection('s');
        assertNotNull(a.upOrDown());
        assertArrayEquals(a.upOrDown(), c);

        p = new Player(s, sf, f, null, null, 1, 1, "map2.txt", null, null, null, null, null);
        p.setX(0);
        p.setY(0);
        a = new Chaser(null, 3, 3, null, null, ml, 1, b, p, go, 1, 1);

        c = new char[]{'a', 'd', 'w', 's'};
        p.setDirection('a');
        assertNotNull(a.upOrDown());
        assertArrayEquals(a.upOrDown(), c);

        p = new Player(s, sf, f, null, null, 1, 1, "map2.txt", null, null, null, null, null);
        p.setX(0);
        p.setY(0);
        a = new Chaser(null, 3, 3, null, null, ml, 1, b, p, go, 1, 1);
        a.setPlayerX_g(0);
        c = new char[]{'a', 'd', 'w', 's'};
        p.setDirection('w');
        assertNotNull(a.upOrDown());
        assertArrayEquals(a.upOrDown(), c);

        p = new Player(s, sf, f, null, null, 1, 1, "map2.txt", null, null, null, null, null);
        p.setX(0);
        p.setY(0);
        a = new Chaser(null, 3, 3, null, null, ml, 1, b, p, go, 1, 1);
        a.setPlayerY_g(600);
        c = new char[]{'s', 'w', 'a', 'd'};
        p.setDirection('s');
        assertNotNull(a.upOrDown());
        assertArrayEquals(a.upOrDown(), c);

        p = new Player(s, sf, f, null, null, 1, 1, "map2.txt", null, null, null, null, null);
        p.setX(0);
        p.setY(0);
        a = new Chaser(null, 3, 3, null, null, ml, 1, b, p, go, 1, 1);
        a.setPlayerX_g(100);
        c = new char[]{'w', 's', 'a', 'd'};
        p.setDirection('a');
        assertNotNull(a.upOrDown());
        assertArrayEquals(a.upOrDown(), c);
    }
}