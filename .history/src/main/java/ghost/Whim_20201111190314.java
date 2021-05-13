package ghost;
import processing.core.PApplet;
import processing.core.PImage;
import java.util.*;
import java.io.*;
import org.json.simple.JSONArray; 
import org.json.simple.JSONObject; 
import java.lang.*;

public class Whim extends GhostObject {


    private PImage ghost;

    //private char direction = 'a';

    private int check = 0;

    //private int frames = 0;
    private int seconds = 0;

    //private int index_scatter = 0;

    private int[] corner_a = new int[2];

    private ArrayList<GhostObject> chasers = new ArrayList<GhostObject>();

    private GhostObject current_chaser;

    private int temp_player_x;
    private int temp_player_y;

    private int x_dest;
    private int y_dest;

    private int[] target = new int[2];

    private boolean tempScatter = false;
    
    
    
    public Whim(PImage sodaGhost, int x, int y, PImage ghost, PImage ghost_scared, ArrayList<Integer> modeLengths1, int speed, boolean[][] path, Player player_g, ArrayList<GhostObject> other_ghosts, int frightenedLength, int sodaLength){
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

    public void tick(char input) {
        for (GhostObject g : this.other_ghosts) {
            if (Chaser.class.isInstance(g)) {
                this.chasers.add(g);
            }
        }
        int deathIndex = 0;
        for (GhostObject g : this.chasers) {
            if (g.isDead == false) {
                this.current_chaser = g;
                this.tempScatter = false;
                break;
            } else {
                deathIndex ++;
            }
            if (deathIndex == this.chasers.size()) {
                this.tempScatter = true;
            }
        }
        if (this.isFrightened == true) {
            if (this.frightenedFrames == frightenedLength*60) {
                this.isFrightened = false;
                this.frightenedFrames = 0;

            } else{
                this.frightenedFrames ++;
            }
        } else if (this.sodaEffect == true) {
            if (this.sodaFrames == 7*60) { //implement soda length
                this.sodaEffect = false;
                this.sodaFrames = 0;

            } else{
                this.sodaFrames ++;
            }
        }
        else {
            this.frames ++;
            this.seconds = this.frames/60;
            if (this.frames == (modeLengths_f[this.index_scatter])) {
                setScatter();
                this.index_scatter ++;
                System.out.println(this.scatter);
            }
            if (this.index_scatter == modeLengths_f.length -1) {
                this.index_scatter =0;
            }
        }
        // this.frames ++;
        // this.seconds = this.frames/60;
        // //System.out.println(seconds); 7,27,34, 54, 59,79,84




        // if (this.frames == (modeLengths_f[this.index_scatter])) {
        //     setScatter();
        //     this.index_scatter ++;
        //     System.out.println(this.scatter);
        // }
        // if (this.index_scatter == modeLengths_f.length -1) {
        //     this.index_scatter =0;
        // }


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
            

            //this.index_scatter =0;
            //this.scatter = true;
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
            
            //this.index_scatter =0;
            //this.scatter = true;
        }
        // else if (this.player_x + 8 == this.x & this.player_y == this.y) {
        //     player_g.setDead(true);
        //     this.x = this.beg_x;
        //     this.y = this.beg_y;
        //     //this.index_scatter =0;
        //     //this.scatter = true;
        // }
        // else if (this.player_x - 8 == this.x & this.player_y == this.y) {
        //     player_g.setDead(true);
        //     this.x = this.beg_x;
        //     this.y = this.beg_y;
        //     //this.index_scatter =0;
        //     //this.scatter = true;
        // }
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
            
            //this.index_scatter =0;
            //this.scatter = true;
        }
        // else if (this.player_x == this.x & this.player_y + 8 == this.y) {
        //     player_g.setDead(true);
        //     this.x = this.beg_x;
        //     this.y = this.beg_y;
        //     //this.index_scatter =0;
        //     //this.scatter = true;
        // }
        // else if (this.player_x == this.x & this.player_y- 8== this.y) {
        //     player_g.setDead(true);
        //     this.x = this.beg_x;
        //     this.y = this.beg_y;
        //     //this.index_scatter =0;
        //     //this.scatter = true;
        // }


        if (path[y][x+1] == true) {
            //System.out.println(1);
            check ++;
        }
        if (path[y][x-1] == true) {
            //System.out.println(2);
            check ++;
        }
        if (path[y+1][x] == true) {
            //System.out.println(3);
            check ++;
        }
        if (path[y-1][x] == true) {
            //System.out.println(4);
            check ++;
        }
        if (check > 2) {
            // System.out.println("hey");
            // System.out.println(this.x);
            // System.out.println(this.y);
            // System.out.println(upOrDown());

                
            char[] tmp;
            if (this.isFrightened == true) {
                tmp = upOrDownRandom();
            }
            else if (this.scatter == true | this.tempScatter == true) {
                tmp = upOrDownCorner();

            } else {
                tmp = upOrDown();
            }
            //char[] tmp = upOrDown();

            // System.out.println(this.player_x);
            // System.out.println(this.player_y);
            // System.out.println(this.direction);

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
            //System.out.println(this.x);

            if (path[y][x+1] == true & this.direction != 'a') {
                this.direction = 'd';
            }
            else if (path[y][x-1] == true & this.direction != 'd') {
                this.direction = 'a';
            }
            else if (path[y+1][x] == true & this.direction != 'w') {
                this.direction = 's';
            }
            else if (path[y-1][x] == true & this.direction != 's') {
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
        //System.out.println(this.direction +"end");

    }
    public char[] upOrDownCorner() {
        char[] char_ret = new char[4];
        int[] corner = new int[2];
        this.corner_a = corner;
        corner[0] = 576;
        corner[1] = 448; 
        int x_diff = this.x - corner[1];
        int y_diff = this.x - corner[0];
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

    public char[] upOrDown() {
        char[] char_ret = new char[4];
        if (this.player_g.getDirection() == 'd') {
            this.temp_player_x = player_x + 32;
            this.temp_player_y = player_y;
        }
        else if (this.player_g.getDirection() == 'a') {
            this.temp_player_x = player_x - 32;
            this.temp_player_y = player_y;
        }
        else if (this.player_g.getDirection() == 'w') {
            this.temp_player_x = player_x;
            this.temp_player_y = player_y - 32;
        }
        else if (this.player_g.getDirection() == 's') {
            this.temp_player_x = player_x;
            this.temp_player_y = player_y + 32;
        }
        
        int x_diff = this.temp_player_x - this.current_chaser.getX();
        int y_diff = this.temp_player_y - this.current_chaser.getY();

        this.x_dest = this.current_chaser.getX() + (2*x_diff);
        this.y_dest = this.current_chaser.getY() + (2*y_diff);
        if (this.x_dest > 448) {
            this.x_dest = 448;
        }
        if (this.x_dest < 0) {
            this.x_dest = 0;
        }
        if (this.y_dest > 576) {
            this.y_dest = 576;
        }
        if (this.y_dest < 0) {
            this.y_dest = 0;
        }

        this.target[0] = this.y_dest;

        this.target[1] = this.x_dest;

        x_diff = this.x - this.x_dest;
        int x_diff_f = Math.abs(x_diff);
        y_diff = this.y - this.y_dest;
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

    public void draw (PApplet app) {
        //System.out.println(this.player_x);
        if (this.isDead == false) {
            if (this.debug & this.isFrightened == false) {
                if (this.scatter == false & this.tempScatter == false) {
                    app.stroke(255, 255, 255);
                    upOrDown();
                    app.line(this.x+13, this.y+13, this.target[1]+13, this.target[0]+13);
                }
                else if (this.scatter == true | this.tempScatter == true) {
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