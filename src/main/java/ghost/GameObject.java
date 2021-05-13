package ghost;
import java.util.*;
import java.io.*;
import processing.core.*;


public abstract class GameObject {
    /**
     * The X coordinate of the GameObject
     */
    protected int x;
    /**
     * The Y coordinate of the GameObject
     */
    protected int y;
    /**
     * The sprite for the GameObject
     */
    public PImage sprite;

    /**
     * Gets the X coordinate of the GameObject
     * @return the X coordinate of the GameObject
     */
    public int getX() {
        return this.x;
    }
    
    /**
     * Gets the Y coordinate of the GameObject
     * @return the Y coordinate of the GameObject
     */
    public int getY() {
        return this.y;
    }

    
    /**
     * Sets the X coordinate of the GameObject
     * @param x the new X coordinate for the GameObject
     * @return the new set X coordinate for the GameObject
     */
    public int setX(int x) {
        this.x = x;
        return this.x;
    }

    
    /**
     * Sets the y coordinate of the GameObject
     * @param y the new Y coordinate for the GameObject
     * @return the new set Y coordinate for the GameObject
     */
    public int setY(int y) {
        this.y = y;
        return this.y;
    }
}