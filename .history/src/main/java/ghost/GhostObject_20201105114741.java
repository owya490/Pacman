package ghost;
import java.util.*;
import java.io.*;
import processing.core.*;
import java.util.concurrent.ThreadLocalRandom;


public abstract class GhostObject extends MovingEntities {
    protected int xvel;
    protected int yvel;

    protected Player player_g;

    protected int player_x;
    protected int player_y;

    protected boolean scatter = true;

    protected boolean debug = false;


    protected int speed;

    protected ArrayList<Integer> modeLengths1;
    protected int[] modeLengths_f;
    protected boolean[][] path;


    protected PImage ghost_scared;

    protected ArrayList<GhostObject> other_ghosts;

    protected boolean isDead = false;

    protected boolean isFrightened = false;

    protected int frightenedLength;


    public boolean setOtherGhosts(ArrayList<GhostObject> o) {
        this.other_ghosts = o;
        return true;
    }

    public boolean setAllDead() {
        for (GhostObject g : other_ghosts) {
            g.x = g.x_beg;
            g.y = g.y_beg;
            g.isDead = false;
        }
        return true;
    }

    public boolean setFrightened(boolean b) {
        this.isFrightened = b;
        return b;
    }




    public boolean setScatter() {
        this.scatter = !this.scatter;
        return true;
    }

    public boolean setDebug() {
        this.debug = !this.debug;
        System.out.println(this.debug);
        return this.debug;
    }

    public abstract char[] upOrDown();

    public abstract char[] upOrDownCorner();

    public char[] upOrDownRandom() {
        char[] char_ret = new char[4];
        for (int i = 0; i < 4; i ++) {
            int randomNum = ThreadLocalRandom.current().nextInt(1, 4 + 1);
            if (randomNum == 1) {
                char_ret[0] = 'w';
                char_ret[1] = 'a';
                char_ret[2] = 's';
                char_ret[3] = 'd';
            }
            if (randomNum == 2) {
                char_ret[0] = 'a';
                char_ret[1] = 's';
                char_ret[2] = 'd';
                char_ret[3] = 'w';
            }
            if (randomNum == 3) {
                char_ret[0] = 's';
                char_ret[1] = 'd';
                char_ret[2] = 'w';
                char_ret[3] = 'a';            }
            if (randomNum == 4) {
                char_ret[0] = 'd';
                char_ret[1] = 'w';
                char_ret[2] = 'a';
                char_ret[3] = 's';            }
        }
        return char_ret;
    }


}