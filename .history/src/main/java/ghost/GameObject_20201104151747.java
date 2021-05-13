package ghost;
import java.util.*;
import java.io.*;
import processing.core.*;


public abstract class GameObject {
    public int x;
    public int y;
    public PImage sprite;

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}