package ghost;
import java.util.*;
import java.io.*;
import processing.core.*;


public class soda extends GameObject{
    /**
     * Whether the soda has been eaten by the waka
     */
    public boolean eaten = false;
    /**
     * The sprite for soda
     */
    private PImage sprite;

    /**
     * The constructor for creating a soda object
     * responsible for setting the coordinates of the object and the sprite
     * @param x the x coordinate of the soda
     * @param y the y coordinate of the soda
     * @param sprite the sprite for the soda
     */
    public soda(int x, int y, PImage sprite) {
        this.x = x - 4;
        this.y = y - 5;
        this.sprite = sprite;
    }
}