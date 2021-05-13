package ghost;
import java.util.*;
import java.io.*;
import processing.core.*;

public abstract class MovingEntities extends GameObject {

    protected int x_beg;
    protected int y_beg;
    protected boolean dead = false;
    

    public abstract void tick(char input);
    public abstract void draw(PApplet app);
    // public abstract boolean setDead(boolean b);
    public boolean setDead(boolean b) {
        this.dead = b;
        return this.dead;
    }

    // public boolean setDead(boolean b) {
    //     this.dead = b;
    //     return this.dead;
    // }



}