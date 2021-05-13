package ghost;
import processing.core.PApplet;
import processing.core.PImage;
import java.util.*;
import java.io.*;
import org.json.simple.JSONArray; 
import org.json.simple.JSONObject; 
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

    public void tick() {
        this.player_x = player_g.x;
        this.player_y = player_g.y;

        if (path[y][x+1] == true) {
            check ++;
        }
        if (path[y][x-1] == true) {
            check ++;
        }
        if (path[y+1][x] == true) {
            check ++;
        }
        if (path[y-1][x+1] == true) {
            check ++;
        }
        if (check > 2) {
            System.out.println("hey");
            System.out.println(this.x);
            check = 0;
        } else {
            if (path[y][x+1] == true & this.direction != 'a') {
                this.direction = 'd';
            }
            if (path[y][x-1] == true & this.direction != 'd') {
                this.direction = 'a';
            }
            if (path[y+1][x] == true & this.direction != 'w') {
                this.direction = 's';
            }
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

    }

    public void draw (PApplet app) {
        //System.out.println(this.player_x);
        app.image(this.ghost, this.x, this.y);
        
    }

}