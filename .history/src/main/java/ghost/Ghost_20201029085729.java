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

    public PImage ghost;
    public JSONArray modeLengths;
    public char direction = 'd';
    public int speed;
    public boolean[][] path;

    public Ghost(int x, int y, PImage ghost, JSONArray modeLengths, int speed, boolean[][] path, int player_x, int player_y, Player player_g){
        this.ghost = ghost;
        this.modeLengths = modeLengths;
        this.x = x*16-4;
        this.y = y*16-5;
        this.speed = speed;
        this.path = path;
        this.player_x = player_x;
        this.player_y = player_y;
    }

    public void tick() {
        this.player_x = 

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
        System.out.println(this.player_x);
        app.image(this.ghost, this.x, this.y);
        
    }

}