package ghost;
import processing.core.PApplet;
import processing.core.PImage;
import java.util.*;
import java.io.*;
import org.json.simple.JSONArray; 
import org.json.simple.JSONObject; 
import java.lang.*;


public class Ghost extends MovingEntities{

    // private int x;
    // private int y;
    private int xvel;
    private int yvel;

    private int beg_x;
    private int beg_y;

    private int player_x;
    private int player_y;

    private Player player_g;

    private PImage ghost;
    private PImage ghost_scared;
    private ArrayList<Integer> modeLengths1;
    private int[] modeLengths_f;
    private String[] arr;
    private char direction = 'a';
    private int speed;
    private boolean[][] path;

    private int check = 0;

    private boolean scatter = true;

    private int frames = 0;
    private int seconds = 0;

    private int index_scatter = 0;

    private boolean debug = false;

    private int[] corner_a = new int[2];

    public Ghost(int x, int y, PImage ghost, PImage ghost_scared, ArrayList<Integer> modeLengths1, int speed, boolean[][] path, Player player_g){
        this.ghost_scared = ghost_scared;
        this.ghost = ghost;
        this.modeLengths1 = modeLengths1;
        this.beg_x = x*16-4;
        this.beg_y = y*16-5;
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

        // System.out.println(modeLengths_f[0]);
        // System.out.println(modeLengths_f[1]);
        // System.out.println(modeLengths_f[2]);

        //System.out.println(modeLengths1);

        // this.arr = new String[modeLengths.size()];

        // for (int i = 0; i < modeLengths.size(); i ++) {
        //     arr[i] = modeLengths.getString(i);
        // }

    }

    public boolean setScatter() {
        this.scatter = !this.scatter;
        return true;
    }

    public void tick(char input) {
        this.frames ++;
        this.seconds = this.frames/60;
        //System.out.println(seconds); 7,27,34, 54, 59,79,84




        if (this.frames == (modeLengths_f[this.index_scatter])) {
            setScatter();
            this.index_scatter ++;
            System.out.println(this.scatter);
        }
        if (this.index_scatter == modeLengths_f.length -1) {
            this.index_scatter =0;
        }


        this.player_x = player_g.getX();
        this.player_y = player_g.getY();

        if (this.player_x == this.x & this.player_y == this.y) {
            player_g.setDead(true);
            this.x = this.beg_x;
            this.y = this.beg_y;
            //this.index_scatter =0;
            //this.scatter = true;
        }
        else if (Math.abs(this.player_x - this.x) <= 16 & this.player_y == this.y) {
            player_g.setDead(true);
            this.x = this.beg_x;
            this.y = this.beg_y;
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
            player_g.setDead(true);
            this.x = this.beg_x;
            this.y = this.beg_y;
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
            if (this.scatter == true) {
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
            else 
            if (path[y-1][x] == true & this.direction != 's') {
                this.direction = 'w';
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
        if (this.x >= 224 & this.y <= 288) {
            corner[0] = 0;
            corner[1] = 448; 
        }
        else if (this.x < 224 & this.y < 288) {
            corner[0] = 0;
            corner[1] = 0; 
        }
        else if (this.x > 224 & this.y > 288) {
            corner[0] = 576;
            corner[1] = 448; 
        }
        else if (this.x < 224 & this.y > 288) {
            corner[0] = 576;
            corner[1] = 0; 
        }
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
        int x_diff = this.x - player_x;
        int x_diff_f = Math.abs(x_diff);
        int y_diff = this.y - player_y;
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
        if (this.debug) {
            if (this.scatter == false) {
                app.stroke(255, 255, 255);
                app.line(this.x+13, this.y+13, this.player_x+13, this.player_y+13);
            }
            else if (this. scatter == true) {
                app.stroke(255, 255, 255);
                app.line(this.x+13, this.y+13, this.corner_a[1], this.corner_a[0]);
            }
        }
        if (this.scatter == true) {
            app.image(this.ghost_scared, this.x, this.y);

        } else {
            app.image(this.ghost, this.x, this.y);
        }
        
    }

    public boolean setDebug() {
        this.debug = !this.debug;
        System.out.println(this.debug);
        return this.debug;
    }


    // public int getX() {
    //     return this.x;
    // }

    // public int getY() {
    //     return this.y;
    // }

    // public int setX(int x) {
    //     this.x = x;
    //     return this.x;
    // }

    // public int setY(int y) {
    //     this.y = y;
    //     return this.y;
    // }
    // public boolean setDead(boolean b) {
    //     this.dead = b;
    //     return this.dead;
    // }



}