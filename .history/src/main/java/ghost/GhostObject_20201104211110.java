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

    public boolean setScatter() {
        this.scatter = !this.scatter;
        return true;
    }

    public abstract char[] upOrDown();


}