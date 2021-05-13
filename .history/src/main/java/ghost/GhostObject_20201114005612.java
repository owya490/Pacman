package ghost;
import java.util.*;
import java.io.*;
import processing.core.*;
import java.util.concurrent.ThreadLocalRandom;


public abstract class GhostObject extends MovingEntities {
    /**
     * The Ghost's horizontal velocity 
     */
    protected int xvel;
    /**
     * the Ghost's vertical velocity
     */
    protected int yvel;

    /**
     * The player object
     */
    protected Player player_g;

    /**
     * The player's current X coordinate
     */
    protected int player_x;
    /**
     * The player's current Y coordinate
     */
    protected int player_y;

    /**
     * Marks if the ghost is currently in scatter mode
     */
    protected boolean scatter = true;

    /**
     * Marks if the ghost is currently in debug mode
     */
    protected boolean debug = false;
    /**
     * Marks if the ghost is currently effected by Soda
     */
    protected boolean sodaEffect = false;

    /** 
     * The length of the soda effect
     */
    protected int sodaLength;
    /**
     * The speed which the ghost moves at
     */
    protected int speed;

    /**
     * An list containing a procession for the lengths of Scatter and Chase modes
     */
    protected ArrayList<Integer> modeLengths1;
    /**
     * An array containing a procession for the lengths of Scatter and Chase modes
     */
    protected int[] modeLengths_f;
    /**
     * A 2D boolean array marking the traversable path for Entities
     */
    protected boolean[][] path;
    
    /**
     * Sprite for frightened ghosts
     */
    protected PImage ghost_scared;
    
    /**
     * Sprite for soda affected ghosts
     */
    protected PImage sodaGhost;

    /**
     * List of all other ghost objects in the game
     */
    protected ArrayList<GhostObject> other_ghosts;

    /**
     * Marks if the ghost is dead
     */
    protected boolean isDead = false;

    /**
     * Marks if the ghost is frightened
     */
    protected boolean isFrightened = false;

    /**
     * Marks the length that the frightened effect should last
     */
    protected int frightenedLength;

    /**
     * The amount of frames that has elapsed since the ghost was last frightened
     */
    protected int frightenedFrames;

    /**
     * The amount of frames that has elapsed since the ghost was last affected by soda
     */
    protected int sodaFrames;

    /**
     * The current direction the ghost is travelling in 
     */
    protected char direction = 'a';

    /**
     * Amount of frames that has elapsed
     */
    protected int frames = 0;
    /**
     * Marks which element the ghost should be in for modeLength array to determine whether in scatter or chase mode
     */
    protected int index_scatter = 0;


    /**
     * Gets if the ghost is currently affected by soda
     * @return if the ghost is affected by soda
     */
    public boolean sodaEffectGet() {
        return this.sodaEffect;
    }

    /**
     * Sets the ghost to be affected by soda or not
     * @param b whether the ghost is affected by soda
     * @return the new state whether the ghost is affected by soda
     */
    public boolean sodaEffectSet(boolean b) {
        this.sodaEffect = b;
        return b;
    }

    /**
     * Resets the amount of frames elapsed since affected by soda
     * @return if the reset was successful
     */
    public boolean resetSodaFrames() {
        this.sodaFrames = 0;
        return true;
    }

    /**
     * Sets a new list of GhostObjects of other ghosts in the game
     * @param o the new list of GhostObjects
     * @return whehter the new list has been successfully updated
     */
    public boolean setOtherGhosts(ArrayList<GhostObject> o) {
        this.other_ghosts = o;
        return true;
    }

    /**
     * Sets Ghost dead attribute to new state
     * @param b the new state of dead attribute
     * @return the new state of the dead attribute
     */
    public boolean setDead(boolean b) {
        this.isDead = b;
        return b;
    }

    /**
     * Sets all of the ghost objects in the game to dead
     * Sets all of the ghosts objects dead attribute to true
     * @return whether the update of states has been succesfull
     */
    public boolean setAllDead() {
        for (GhostObject g : other_ghosts) {
            g.x = g.x_beg;
            g.y = g.y_beg;
            g.isDead = false;
            g.direction = 'a';
        }
        return true;
    }

    /**
     * Sets the frightened attributes of ghost to new state
     * @param b the new state for the frightened attribute
     * @return the new state of the frightened attribute
     */
    public boolean setFrightened(boolean b) {
        this.isFrightened = b;
        return b;
    }

    /**
     * Gets the current state of the frightened attribute
     * @return the current state of the frightened attribute
     */
    public boolean getFrightened() {
        return this.isFrightened;
    }

    /**
     * Resets the elapsed frames since the ghost was last frightened
     * @return whether the frames has been sucessfully reset
     */
    public boolean resetFrightenedFrames() {
        this.frightenedFrames = 0;
        return true;
    }

    /**
     * Resets the elapsed frames
     * @return whether the frames has been sucessfully reset
     */
    public boolean resetFrames() {
        this.frames = 0;
        return true;
    }

    /**
     * Resets the scatter index of ghosts reseting the mode types
     * @return whether if the reset was successful
     */
    public boolean resetScatterIndex() {
        this.index_scatter = 0;
        return true;
    }

    /**
     * Sets the Scatter attribute of ghosts for an exact state
     * @param b the new state of the scatter attribute
     * @return the new state of the scatter attribute
     */
    public boolean setScatterExact(boolean b) {
        this.scatter = b;
        return b;
    }

    /**
     * Sets the scatter attribute for the opposite of the previous state
     * @return whether the update was successful
     */
    public boolean setScatter() {
        this.scatter = !this.scatter;
        return true;
    }

    /**
     * Sets the debug attribute state to the opposite of the previous state
     * @return the current state of the debug attribute
     */
    public boolean setDebug() {
        this.debug = !this.debug;
        //System.out.println(this.debug);
        return this.debug;
    }

    /**
     * Sets the player X coordinates to a new value
     * @param x the new value for the new position
     * @return the new X coordinates of the player
     */
    public int setPlayerX_g(int x) {
        this.player_x = x;
        return this.player_x;
    }

    /**
     * Sets the player Y coordinates to a new value
     * @param y the new value for the new position
     * @return the new Y coordinates of the player
     */
    public int setPlayerY_g(int y) {
        this.player_y = y;
        return this.player_y;
    }

    /**
     * Abstract Method for Ghost to determine which way to go at an intersection to reach the targeted destination
     * @return a character array detailing the best moves
     */
    public abstract char[] upOrDown();

    /**
     * Abstract Method for Ghost to determine which way to go at an intersection to reach its desired corner
     * @return a character array detailing the best moves
     */
    public abstract char[] upOrDownCorner();

    /**
     * To randomly select a turn at a intersection when under the effects of soda
     * @return the randomly generated charater array of moves
     */
    public char[] upOrDownRandom() {
        char[] char_ret = new char[4];
        for (int i = 0; i < 4; i ++) {
            int randomNum = ThreadLocalRandom.current().nextInt(1, 4 + 1);
            if (randomNum == 1) {
                char_ret[0] = 'w';
                char_ret[1] = 'a';
                char_ret[2] = 's';
                char_ret[3] = 'd';
            }
            if (randomNum == 2) {
                char_ret[0] = 'a';
                char_ret[1] = 's';
                char_ret[2] = 'd';
                char_ret[3] = 'w';
            }
            if (randomNum == 3) {
                char_ret[0] = 's';
                char_ret[1] = 'd';
                char_ret[2] = 'w';
                char_ret[3] = 'a';            }
            if (randomNum == 4) {
                char_ret[0] = 'd';
                char_ret[1] = 'w';
                char_ret[2] = 'a';
                char_ret[3] = 's';            }
        }
        return char_ret;
    }
}