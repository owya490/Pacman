package ghost;
import java.util.*;
import java.io.*;
import processing.core.*;

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


    public boolean setOtherGhosts(ArrayList<GhostObject> o) {
        this.other_ghosts = o;
        return true;
    }

    public boolean setAllDead() {
        for (GhostObject g : other_ghosts) {
            g.x = g.x_beg;
            g.y = g.y_beg;
        }
        return true;
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


}