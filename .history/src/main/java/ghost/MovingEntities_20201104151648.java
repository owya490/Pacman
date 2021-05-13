package ghost;
import java.util.*;
import java.io.*;
import processing.core.*;

public abstract class MovingEntities extends GameObject {

    public int x;
    public int y;
    public int x_beg;
    public int y_beg;
    

    public abstract void tick(char input);
    public abstract void draw(PApplet app);


}