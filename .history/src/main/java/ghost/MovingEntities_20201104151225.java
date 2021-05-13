package ghost;
import java.util.*;
import java.io.*;
import processing.core.*;

public abstract class MovingEntities extends GameObject {

    public int x;
    public int y;
    

    public void tick();
    public void draw();

}