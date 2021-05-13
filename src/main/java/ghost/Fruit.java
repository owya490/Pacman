package ghost;
import java.util.*;
import java.io.*;
import processing.core.*;


public class Fruit extends GameObject{
    /**
     * Whether the fruit has been eaten by the waka
     */
    public boolean eaten = false;

    /**
     * The sprite for fruit
     */
    private PImage sprite;

    /**
     * The constructor for creating a fruit object
     * responsible for setting the coordinates of the object and the sprite
     * @param x the x coordinate of the fruit
     * @param y the y coordinate of the fruit
     * @param sprite the sprite for the fruit
     */
    public Fruit(int x, int y, PImage sprite) {
        this.x = x - 4;
        this.y = y - 5;
        this.sprite = sprite;
    }
}