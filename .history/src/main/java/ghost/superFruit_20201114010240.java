package ghost;
import java.util.*;
import java.io.*;
import processing.core.*;


public class superFruit extends GameObject{
    /**
     * Whether the superFruit has been eaten by the waka
     */
    public boolean eaten = false;
    /**
     * The sprite for superFruit
     */
    private PImage sprite;

    /**
     * The constructor for creating a superFruit object
     * responsible for setting the coordinates of the object and the sprite
     * @param x the x coordinate of the superFruit
     * @param y the y coordinate of the superFruit
     * @param sprite the sprite for the superFruit
     */
    public superFruit(int x, int y, PImage sprite) {
        this.x = x - 4;
        this.y = y - 5;
        this.sprite = sprite;
    }
}