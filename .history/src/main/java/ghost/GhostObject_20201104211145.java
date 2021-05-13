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

    private boolean scatter = true;


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


}