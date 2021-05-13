package ghost;
import java.util.*;
import java.io.*;
import processing.core.*;


public class Fruit extends GameObject{
    public boolean eaten = false;

    private int x;
    private int y;
    private PImage sprite;

    public Fruit(int x, int y, PImage sprite) {
        this.x = x - 4;
        this.y = y - 5;
        this.sprite = sprite;
    }

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
}