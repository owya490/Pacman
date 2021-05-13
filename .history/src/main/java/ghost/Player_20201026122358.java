package ghost;
import processing.core.PApplet;
import processing.core.PImage;
import java.util.*;
import java.io.*;
public class Player {
    public int x;
    public int y;

    // public int x_f;
    // public int y;

    public int xvel = 0;
    public int yvel = 0;

    public int lives;
    public int speed;

    public PImage playerClosed;
    public PImage playerDown;
    public PImage playerLeft;
    public PImage playerRight;
    public PImage playerUp;

    public boolean openMouth;
    public char input;

    public boolean[][] path;

    public int direction;
    public String[][] map;


    public Player(String[][] map, boolean[][] path, int lives, int speed, String filename, PImage playerClosed, PImage playerDown, PImage playerLeft, PImage playerRight, PImage playerUp) {
        this.x = (findPlayerStart.findx(filename))*16 +8;
        this.y = (findPlayerStart.findy(filename))*16 +8;
        this.playerClosed = playerClosed;
        this.playerDown = playerDown;
        this.playerLeft = playerLeft;
        this.playerRight = playerRight;
        this.playerUp = playerUp;
        this.lives = lives;
        this.speed = speed;
        this.path = path;
        this.map = map;
    }

    public void tick(char input) {
        this.input = input;
        if (input == 'w') {
            //System.out.println("w");
            this.yvel = -speed;
            this.xvel =0;
            this.direction = 4;

        }
        if (input == 'a') {
            //System.out.println("a");
            this.xvel = -speed;
            this.yvel =0;
            this.direction = 2;

        }
        if (input == 's') {
            //System.out.println("s");
            this.yvel = speed;
            this.xvel =0;
            this.direction = 3;

        }
        if (input == 'd') {
            //System.out.println("d");
            this.xvel = speed;
            this.yvel =0;
            this.direction = 1;
        }
        if (input == ' ') {
            this.xvel = 0;
            this.yvel = 0;
        }

        collide(this.map, this.direction);
        this.x += this.xvel;
        this.y += this.yvel;
        


        // System.out.println(this.x);
        // System.out.println(this.y);

        // System.out.println(this.x + this.xvel);
        // System.out.println(this.y + this.yvel);
        // //System.out.println(path[0][0]);
        // System.out.println(path[this.y += this.yvel][this.x += this.xvel]);

        // if (path[this.y + this.yvel][this.x + this.xvel] == true) {
        //     this.x += this.xvel;
        //     this.y += this.yvel;
        // } else {
        //     this.xvel = 0;
        //     this.yvel = 0;
        // }
        //this.x += this.xvel;
        //this.y += this.yvel;
    }

    public void draw(PApplet app) {
        if (this.openMouth && this.input =='w') {
            app.image(this.playerUp, x-12 , y-13);
        } 
        else if (this.openMouth && this.input =='a') {
            app.image(this.playerLeft, x-12 , y-13);
        } 
        else if (this.openMouth && this.input =='s') {
            app.image(this.playerDown, x-12 , y-13);
        } 
        else if (this.openMouth && this.input =='d') {
            app.image(this.playerRight, x-12 , y-13);
        } 
        
        else {
            app.image(this.playerClosed, x-12 , y-13);

        }

        //System.out.println(this.x);
        //System.out.println(this.y-5);

    }

    public void openMouth(boolean open){
        this.openMouth = open;
    }
    public boolean collide(String[][] map, int d){
        int[] c = new int[2];
        c[0] = this.y/ 16;
        c[1] = this.x/ 16;
        
        
        if (d == 1){
            //String next = map[][14];
            String next = map[c[0]][c[1]+1];
            if (next.equals("2") | next.equals("3") | next.equals("4") | next.equals("5") | next.equals("6") | next.equals("1")){
                if (this.x % 16 == 8){
                    this.xvel = 0;
                    return true;
                }
            }
        } 
        else if (d == 2){
            String next = map[c[0]][c[1]-1];
            if (next.equals("2") | next.equals("3") | next.equals("4") | next.equals("5") | next.equals("6") | next.equals("1")){
                if (this.x % 16 == 8){
                    this.xvel = 0;
                    return true;
                }
            }
        } else if (d == 3){
            String next = map[c[0]+1][c[1]];
            if (next.equals("2") | next.equals("3") | next.equals("4") | next.equals("5") | next.equals("6") | next.equals("1")){
                if (this.y % 16 == 8){
                    this.yvel = 0;
                    return true;
                }
            }
        } else if (d == 4){
            String next = map[c[0]-1][c[1]];
            if (next.equals("2") | next.equals("3") | next.equals("4") | next.equals("5") | next.equals("6") | next.equals("1")){
                if (this.y % 16 == 8){
                    this.yvel = 0;
                    return true;
                }
                
            }
        }

        return false;
    }



}