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
    
    protected PImage sodaGhost;

    protected ArrayList<GhostObject> other_ghosts;

    protected boolean isDead = false;

    protected boolean isFrightened = false;

    protected int frightenedLength;

    protected int frightenedFrames;

    protected char direction = 'a';

    protected int frames = 0;
    protected int index_scatter = 0;



    public boolean setOtherGhosts(ArrayList<GhostObject> o) {
        this.other_ghosts = o;
        return true;
    }
    public boolean setDead(boolean b) {
        this.isDead = b;
        return b;
    }
    public boolean setAllDead() {
        for (GhostObject g : other_ghosts) {
            g.x = g.x_beg;
            g.y = g.y_beg;
            g.isDead = false;
            g.direction = 'a';
        }
        return true;
    }

    public boolean setFrightened(boolean b) {
        this.isFrightened = b;
        return b;
    }

    public boolean getFrightened() {
        return this.isFrightened;
    }

    public boolean resetFrightenedFrames() {
        this.frightenedFrames = 0;
        return true;
    }

    public boolean resetFrames() {
        this.frames = 0;
        return true;
    }

    public boolean resetScatterIndex() {
        this.index_scatter = 0;
        return true;
    }

    public boolean setScatterExact(boolean b) {
        this.scatter = b;
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