package ghost;
import java.util.*;
import java.io.*;
import processing.core.*;


public class Fruit extends GameObject{
    public boolean eaten = false;

    public int x;
    public int y;
    public PImage sprite;

    public Fruit(int x, int y, PImage sprite) {
        this.x = x - 4;
        this.y = y - 5;
        this.sprite = sprite;
    }
}