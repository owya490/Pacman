package ghost;
import java.util.*;
import java.io.*;
import processing.core.*;

public abstract class MovingEntities extends GameObject {

    /**
     * The entities beginning X coordinates
     */
    protected int x_beg;
    /**
     * The entities beginning Y coordinates
     */
    protected int y_beg;
    /**
     * Marks if the entity is dead or not
     */
    protected boolean dead = false;
    
    /**
     * Handles the logic of the entity
     * @param input The directional input of the entity
     */
    public abstract void tick(char input);
    /**
     * The draw method of the Entity drawing to the screen
     * @param app the app which to draw through
     */
    public abstract void draw(PApplet app);
    
    /**
     * Sets the entities dead attribute
     * @param b the new state of the dead attribute
     * @return the new state of the dead attribute
     */
    public boolean setDead(boolean b) {
        this.dead = b;
        return this.dead;
    }
}