package ghost;
import processing.core.PApplet;
import processing.core.PImage;
import java.util.*;
import java.io.*;
import org.json.simple.JSONArray; 
import org.json.simple.JSONObject; 
import java.lang.*;

public class Chaser extends GhostObject {


    private PImage ghost;

    private char direction = 'a';

    private int check = 0;

    private int frames = 0;
    private int seconds = 0;

    private int index_scatter = 0;

    private int[] corner_a = new int[2];
    
    
    
    public Ambusher(int x, int y, PImage ghost, PImage ghost_scared, ArrayList<Integer> modeLengths1, int speed, boolean[][] path, Player player_g){
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