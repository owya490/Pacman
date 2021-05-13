package ghost;
import processing.core.PApplet;
import processing.core.PImage;
import java.util.*;
import java.io.*;
public class Player {
    public long x;
    public long y;

    public long xvel;
    public long yvel;

    public long lives;
    public long speed;

    public PImage playerClosed;
    public PImage playerDown;
    public PImage playerLeft;
    public PImage playerRight;
    public PImage playerUp;

    public boolean openMouth;
    public char input;


    public Player(long lives, long speed, String filename, PImage playerClosed, PImage playerDown, PImage playerLeft, PImage playerRight, PImage playerUp) {
        this.x = (findPlayerStart.findx(filename))*16;
        this.y = (findPlayerStart.findy(filename))*16;
        this.playerClosed = playerClosed;
        this.playerDown = playerDown;
        this.playerLeft = playerLeft;
        this.playerRight = playerRight;
        this.playerUp = playerUp;
        this.lives = lives;
        this.speed = speed;
    }

    public void tick(char input) {
        this.input = input;
        if (input == 'w') {
            System.out.println("w");
            this.yvel = -speed;
            this.xvel =0;
        }
        if (input == 'a') {
            System.out.println("a");
            this.xvel = -speed;
            this.yvel =0;
        }
        if (input == 's') {
            System.out.println("s");
            this.yvel = speed;
            this.xvel =0;
        }
        if (input == 'd') {
            System.out.println("d");
            this.xvel = speed;
            this.yvel =0;
        }
        this.x += this.xvel;
        this.y += this.yvel;
    }

    public void draw(PApplet app) {
        if (this.openMouth && this.input =='w') {
            app.image(this.playerUp, x, y-5);
        } 
        else if (this.openMouth && this.input =='a') {
            app.image(this.playerLeft, x, y-5);
        } 
        else if (this.openMouth && this.input =='s') {
            app.image(this.playerDown, x, y-5);
        } 
        else if (this.openMouth && this.input =='d') {
            app.image(this.playerRight, x, y-5);
        } 
        
        else {
            app.image(this.playerClosed, x, y-5);

        }

        System.out.println(this.x);
        Sysetm.out.println(this.y-5);

    }

    public void openMouth(boolean open){
        this.openMouth = open;
    }



}