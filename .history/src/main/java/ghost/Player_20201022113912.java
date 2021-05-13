package ghost;
import processing.core.PApplet;
import processing.core.PImage;
import java.util.*;
import java.io.*;
public class Player {
    public int x;
    public int y;

    public int vel;

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

    public void tick() {
        this.x -= this.vel;
    }

    public void draw(PApplet app) {
        app.image(this.playerClosed, x*16, (y*16)-4);
    }



}