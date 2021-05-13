package ghost;
import java.util.*;
import java.io.*;
import processing.core.*;

public abstract class MovingEntities extends GameObject {

    protected int x_beg;
    protected int y_beg;
    

    public abstract void tick(char input);
    public abstract void draw(PApplet app);


}