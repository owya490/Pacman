package ghost;
import processing.core.PApplet;
import processing.core.PImage;
import java.util.*;
import java.io.*;
import org.json.simple.JSONArray; 
import org.json.simple.JSONObject; 
import java.lang.*;

public class Ambusher extends GhostObject {
    /**
     * The sprite for the Ghost
     */
    private PImage ghost;
    /**
     * Marks the amount of possible paths the Ghost can take at a given moment
     */
    private int check = 0;
    /**
     * The corner destination for the Ghost
     */
    private int[] corner_a = new int[2];
    /**
     * The given target location for the Ghost
     */
    private int[] target = new int[2];
    /**
     * The absolute difference between destination Y and ghost Y
     */
    private int y_diff_f;
    /**
     * The absolute difference between destination X and ghost X
     */
    private int x_diff_f;
    /**
     * The difference between destination Y and ghost Y
     */
    private int y_diff;
    /**
     * The difference between destination X and ghost X
     */
    private int x_diff;
    
    /**
     * The constructor for the Ambusher Ghost
     * @param sodaGhost The sprite for the soda affected Ghosts
     * @param x The X coordinates of Ghost
     * @param y The Y coordinates of Ghost
     * @param ghost The sprite for the Ghost
     * @param ghost_scared The sprite for frightened Ghost
     * @param modeLengths1 The mode Length array for the Ghost Scatter mode
     * @param speed The speed of the Ghost
     * @param path The traversable path 
     * @param player_g The player object in the game
     * @param other_ghosts The other ghost objects in the game
     * @param frightenedLength The length of being frightened for the Ghost
     * @param sodaLength The length of being affected by soda for the Ghost
     */
    public Ambusher(PImage sodaGhost, int x, int y, PImage ghost, PImage ghost_scared, ArrayList<Integer> modeLengths1, int speed, boolean[][] path, Player player_g, ArrayList<GhostObject> other_ghosts, int frightenedLength, int sodaLength){
        this.sodaLength = sodaLength;
        
        this.sodaGhost = sodaGhost;
        
        this.other_ghosts = other_ghosts;
        this.frightenedLength = frightenedLength;

        this.ghost_scared = ghost_scared;
        this.ghost = ghost;
        this.modeLengths1 = modeLengths1;
        this.x_beg = x*16-4;
        this.y_beg = y*16-5;
        this.x = x*16-4;
        this.y = y*16-5;
        this.speed = speed;
        this.path = path;
        this.player_g = player_g;
        this.player_x = player_g.getX();
        this.player_y = player_g.getY();
        this.modeLengths_f = new int[modeLengths1.size()];
        int accumul = 0;
        int index =0;
        for (int i : modeLengths1) {
            accumul += i*60;
            modeLengths_f[index] = accumul;
            index ++;
        }
    }

    /**
     * Handles the Logic of the Ghost Object
     */
    public void tick(char input) {
        if (this.isFrightened == true) {
            if (this.frightenedFrames == frightenedLength*60) {
                this.isFrightened = false;
                this.frightenedFrames = 0;

            } else{
                this.frightenedFrames ++;
            }
        } else if (this.sodaEffect == true) {
            if (this.sodaFrames == this.sodaLength*60) {
                this.sodaEffect = false;
                this.sodaFrames = 0;

            } else{
                this.sodaFrames ++;
            }
        }
        else {
            this.frames ++;
            if (this.index_scatter == modeLengths_f.length) {
                this.index_scatter =0;
            }
            if (this.frames == (modeLengths_f[this.index_scatter])) {
                setScatter();
                this.index_scatter ++;
                System.out.println(this.scatter);
            }
            // if (this.index_scatter == modeLengths_f.length -1) {
            //     this.index_scatter =0;
            // }
        }

        this.player_x = player_g.getX();
        this.player_y = player_g.getY();

        if (this.player_x == this.x & this.player_y == this.y) {
            if (this.isFrightened == true) {
                this.isDead = true;
                this.x = this.x_beg;
                this.y = this.y_beg;
            }
            else if(this.isFrightened == false & this.isDead == false) {
                player_g.setDead(true);
                this.x = this.x_beg;
                this.y = this.y_beg;
                this.setAllDead();
            }

        }
        else if (Math.abs(this.player_x - this.x) <= 16 & this.player_y == this.y) {
            if (this.isFrightened == true) {
                this.isDead = true;
                this.x = this.x_beg;
                this.y = this.y_beg;
            }
            else if(this.isFrightened == false & this.isDead == false) {
                player_g.setDead(true);
                this.x = this.x_beg;
                this.y = this.y_beg;
                this.setAllDead();
            }

        }

        else if (this.player_x == this.x & Math.abs(this.player_y - this.y) <= 16) {
            if (this.isFrightened == true) {
                this.isDead = true;
                this.x = this.x_beg;
                this.y = this.y_beg;
            }
            else if(this.isFrightened == false & this.isDead == false) {
                player_g.setDead(true);
                this.x = this.x_beg;
                this.y = this.y_beg;
                this.setAllDead();
            }

        }
        

        if (path[y][x+1] == true) {
            check ++;
        }
        if (path[y][x-1] == true) {
            check ++;
        }
        if (path[y+1][x] == true) {
            check ++;
        }
        if (path[y-1][x] == true) {
            check ++;
        }
        if (check > 2) {
            char[] tmp;
            if (this.isFrightened == true) {
                tmp = upOrDownRandom();
            }
            else if (this.scatter == true) {
                tmp = upOrDownCorner();

            } else {
                tmp = upOrDown();
            }

            if (path[y][x+1] == true & this.direction != 'a' & tmp[0] == 'd') {
                this.direction = 'd';
            }
            else if (path[y][x-1] == true & this.direction != 'd' & tmp[0] == 'a') {
                this.direction = 'a';
            }
            else if (path[y+1][x] == true & this.direction != 'w' & tmp[0] == 's') {
                this.direction = 's';
            }
            else if (path[y-1][x] == true & this.direction != 's' & tmp[0] == 'w') {
                this.direction = 'w';
            }
            else if (path[y][x+1] == true & this.direction != 'a' & tmp[2] == 'd') {
                this.direction = 'd';
            }
            else if (path[y][x-1] == true & this.direction != 'd' & tmp[2] == 'a') {
                this.direction = 'a';
            }
            else if (path[y+1][x] == true & this.direction != 'w' & tmp[2] == 's') {
                this.direction = 's';
            }
            else if (path[y-1][x] == true & this.direction != 's' & tmp[2] == 'w') {
                this.direction = 'w';
            }

            check = 0;
            
        } else {
            if (path[y][x+1] == true & this.direction != 'a') {
                this.direction = 'd';
            }
            else if (path[y][x-1] == true & this.direction != 'd') {
                this.direction = 'a';
            }
            else if (path[y+1][x] == true & this.direction != 'w') {
                this.direction = 's';
            }
            else 
            if (path[y-1][x] == true & this.direction != 's') {
                this.direction = 'w';
            }
            else {
                if (path[y][x+1] == true) {
                    this.direction = 'd';
                } else if (path[y][x-1] == true) {
                    this.direction = 'a';
                } else if (path[y+1][x] == true) {
                    this.direction = 's';
                } else if (path[y-1][x] == true) {
                    this.direction = 'w';
                }
            }
            check = 0;
        }

        if (this.direction == 'w') {
            this.yvel = -speed;
            this.xvel =0;
        }
        if (this.direction == 'a') {
            this.xvel = -speed;
            this.yvel =0;

        }
        if (this.direction == 's') {
            this.yvel = speed;
            this.xvel =0;
        }
        if (this.direction == 'd') {
            this.xvel = speed;
            this.yvel =0;
        }

        if (path[this.y + this.yvel][this.x + this.xvel] == true) {
            this.x += this.xvel;
            this.y += this.yvel;
        }
    }

    /**
     * Method for Ghost to determine which way to go at an intersection to reach its desired corner
     * @return a character array detailing the best moves
     */
    public char[] upOrDownCorner() {
        char[] char_ret = new char[4];
        int[] corner = new int[2];
        this.corner_a = corner;
        corner[0] = 0;
        corner[1] = 448; 
        int x_diff = this.x - corner[1];
        int y_diff = this.y - corner[0];
        int x_diff_f = Math.abs(x_diff);
        int y_diff_f = Math.abs(y_diff);
        
        if (x_diff_f >= y_diff_f) {
            if (x_diff >= 0 ) {
                char_ret[0] = 'a';
                char_ret[1] = 'd';
            } else {
                char_ret[0] = 'd';
                char_ret[1] = 'a';
            }
            if (y_diff >= 0 ) {
                char_ret[2] = 'w';
                char_ret[3] = 's';
            } else {
                char_ret[2] = 's';
                char_ret[3] = 'w';
            }
        } else {
            if (y_diff >= 0 ) {
                char_ret[0] = 'w';
                char_ret[1] = 's';
            } else {
                char_ret[0] = 's';
                char_ret[1] = 'w';
            }
            if (x_diff >= 0 ) {
                char_ret[2] = 'a';
                char_ret[3] = 'd';
            } else {
                char_ret[2] = 'd';
                char_ret[3] = 'a';
            }
        }
        return char_ret;
    }

    /**
     * Method for Ghost to determine which way to go at an intersection to reach the targeted destination
     * @return a character array detailing the best moves
     */
    public char[] upOrDown() {
        char[] char_ret = new char[4];

        if (this.player_g.getDirection() == 'w') {
            this.x_diff = this.x - player_x;
            this.x_diff_f = Math.abs(x_diff);
            if (player_y - 64 < 0) {
                this.y_diff = this.y - (0);
                this.y_diff_f = Math.abs(y_diff);
            } else {
                this.y_diff = this.y - (player_y - 64);
                this.y_diff_f = Math.abs(y_diff);
            }
            this.target[0] = player_y - 64;
            this.target[1] = player_x;
        }
        else if (this.player_g.getDirection() == 's') {
            this.x_diff = this.x - player_x;
            this.x_diff_f = Math.abs(x_diff);
            if (player_y + 64 > 576) {
                this.y_diff = this.y - (576);
                this.y_diff_f = Math.abs(y_diff);
            } else {
                this.y_diff = this.y - (player_y + 64);
                this.y_diff_f = Math.abs(y_diff);
            }
            this.target[0] = player_y + 64;
            this.target[1] = player_x;
        }
        else if (this.player_g.getDirection() == 'a') {
            if (player_x - 64 < 0) {
                this.x_diff = this.x - (0);
                this.x_diff_f = Math.abs(x_diff);
            } else { 
                this.x_diff = this.x - (player_x - 64);
                this.x_diff_f = Math.abs(x_diff);
            }
            this.y_diff = this.y - (player_y);
            this.y_diff_f = Math.abs(y_diff);
            this.target[0] = player_y;
            this.target[1] = player_x - 64;
        }
        else if (this.player_g.getDirection() == 'd') {
            if (player_x + 64 > 448) {
                this.x_diff = this.x - (448);
                this.x_diff_f = Math.abs(x_diff);
            } else { 
                this.x_diff = this.x - (player_x + 64);
                this.x_diff_f = Math.abs(x_diff);
            }
            this.y_diff = this.y - (player_y);
            this.y_diff_f = Math.abs(y_diff);
            this.target[0] = player_y;
            this.target[1] = player_x + 64;
        }

        if (x_diff_f >= y_diff_f) {
            if (x_diff >= 0 ) {
                char_ret[0] = 'a';
                char_ret[1] = 'd';
            } else {
                char_ret[0] = 'd';
                char_ret[1] = 'a';
            }
            if (y_diff >= 0 ) {
                char_ret[2] = 'w';
                char_ret[3] = 's';
            } else {
                char_ret[2] = 's';
                char_ret[3] = 'w';
            }
        } else {
            if (y_diff >= 0 ) {
                char_ret[0] = 'w';
                char_ret[1] = 's';
            } else {
                char_ret[0] = 's';
                char_ret[1] = 'w';
            }
            if (x_diff >= 0 ) {
                char_ret[2] = 'a';
                char_ret[3] = 'd';
            } else {
                char_ret[2] = 'd';
                char_ret[3] = 'a';
            }
        }

        return char_ret;
    }
    
    /**
     * Set the player X Coordinates
     * @param x the new X coordinates
     * @return the new X coordinates
     */
    public int setPlayerX_g(int x) {
        this.player_x = x;
        return this.player_x;
    }

    /**
     * Set the player Y Coordinates
     * @param y the new Y coordinates
     * @return the new Y coordinates
     */
    public int setPlayerY_g(int y) {
        this.player_y = y;
        return this.player_y;
    }

    /**
     * Draws the Ambusher Object to the screen
     */
    public void draw (PApplet app) {
        if (this.isDead == false) {
            if (this.debug & this.isFrightened == false) {
                if (this.scatter == false) {
                    app.stroke(255, 255, 255);
                    upOrDown();
                    app.line(this.x+13, this.y+13, this.target[1]+13, this.target[0]+13);
                }
                else if (this. scatter == true) {
                    app.stroke(255, 255, 255);
                    upOrDownCorner();
                    app.line(this.x+13, this.y+13, this.corner_a[1], this.corner_a[0]);
                }
            }
            if (this.isFrightened == true) {
                app.image(this.ghost_scared, this.x-2, this.y);

            } else if (this.sodaEffect == true) {
                app.image(this.sodaGhost, this.x-2, this.y);

            } else {
                app.image(this.ghost, this.x-2, this.y);
            }
        }
    }
}

