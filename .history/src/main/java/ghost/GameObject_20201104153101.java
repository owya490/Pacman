package ghost;
import java.util.*;
import java.io.*;
import processing.core.*;


public abstract class GameObject {
    protected int x;
    protected int y;
    public PImage sprite;

    public abstract int getX();

    public abstract int getY();

    public abstract int setX();

    public abstract int setY();
}