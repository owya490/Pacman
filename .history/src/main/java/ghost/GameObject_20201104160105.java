package ghost;
import java.util.*;
import java.io.*;
import processing.core.*;


public abstract class GameObject {
    // protected int x;
    // protected int y;
    public PImage sprite;

    // public abstract int getX();
    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }

    public int setX(int x) {
        this.x = x;
        return this.x;
    }

    public int setY(int y) {
        this.y = y;
        return this.y;
    }

    // public abstract int getY();

    // public abstract int setX(int x);

    // public abstract int setY(int y);
}