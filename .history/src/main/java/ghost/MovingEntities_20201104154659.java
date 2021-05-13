package ghost;
import java.util.*;
import java.io.*;
import processing.core.*;

public abstract class MovingEntities extends GameObject {

    private int x_beg;
    private int y_beg;
    

    public abstract void tick(char input);
    public abstract void draw(PApplet app);


}