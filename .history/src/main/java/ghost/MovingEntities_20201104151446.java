package ghost;
import java.util.*;
import java.io.*;
import processing.core.*;

public abstract class MovingEntities extends GameObject {

    public int x;
    public int y;
    

    public abstract void tick(char input);
    public abstract void draw(PApplet app);


}