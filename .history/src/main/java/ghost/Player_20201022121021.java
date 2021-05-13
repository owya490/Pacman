package ghost;
import processing.core.PApplet;
import processing.core.PImage;
import java.util.*;
import java.io.*;
public class Player {
    public int x;
    public int y;

    public int xvel;
    public int yvel;

    public PImage playerClosed;
    public PImage playerDown;
    public PImage playerLeft;
    public PImage playerRight;
    public PImage playerUp;

    public Player(String filename, PImage playerClosed, PImage playerDown, PImage playerLeft, PImage playerRight, PImage playerUp) {
        this.x = (findPlayerStart.findx(filename))*16;
        this.y = (findPlayerStart.findy(filename))*16;
        this.playerClosed = playerClosed;
        this.playerDown = playerDown;
        this.playerLeft = playerLeft;
        this.playerRight = playerRight;
        this.playerUp = playerUp;

        this.vel = 1;
    }

    public void tick(char input) {
        if (input == 'w') {
            System.out.println("w");
            this.yvel = 1;
            this.xvel =0;
        }
        if (input == 'a') {
            System.out.println("a");
            this.xvel = -1;
            this.yvel =0;
        }
        if (input == 's') {
            System.out.println("s");
            this.yvel = -1;
            this.xvel =0;
        }
        if (input == 'd') {
            System.out.println("d");
            this.xvel = 1;
            this.yvel =0;
        }
    }

    public void draw(PApplet app) {
        app.image(this.playerClosed, x, y-4);
    }



}