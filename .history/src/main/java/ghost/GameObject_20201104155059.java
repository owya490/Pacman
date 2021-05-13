package ghost;
import java.util.*;
import java.io.*;
import processing.core.*;


public interface GameObject {
    // protected int x;
    // protected int y;
    // public PImage sprite;

    public abstract int getX();

    public abstract int getY();

    public abstract int setX(int x);

    public abstract int setY(int y);
}