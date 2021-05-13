package ghost;
import processing.core.PApplet;
import processing.core.PImage;
import java.util.*;
import java.io.*;
import org.json.simple.JSONArray; 
import org.json.simple.JSONObject; 
import java.lang.*;

public class Ghost {

    public int x;
    public int y;
    public int xvel;
    public int yvel;

    public int player_x;
    public int player_y;

    public Player player_g;

    public PImage ghost;
    public JSONArray modeLengths;
    public char direction = 'd';
    public int speed;
    public boolean[][] path;

    public int check = 0;

    public boolean scatter = true;

    public int frames = 0;

    public Ghost(int x, int y, PImage ghost, JSONArray modeLengths, int speed, boolean[][] path, Player player_g){
        this.ghost = ghost;
        this.modeLengths = modeLengths;
        this.x = x*16-4;
        this.y = y*16-5;
        this.speed = speed;
        this.path = path;
        this.player_g = player_g;
        this.player_x = player_g.x;
        this.player_y = player_g.y;
    }

    public void setScatter() {
        this.scatter = false;
    }

    public void tick() {
        this.player_x = player_g.x;
        this.player_y = player_g.y;


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
            char[] tmp = upOrDown();
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
                System.out.println("here");
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
        app.image(this.ghost, this.x, this.y);
        
    }

}