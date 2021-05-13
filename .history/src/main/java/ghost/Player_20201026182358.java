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
    public char input = 'd';

    public boolean[][] path;

    public char direction;
    public String[][] map;

    public ArrayList<Fruit> fruitList;



    public Player(ArrayList<Fruit> fruitList, String[][] map, boolean[][] path, int lives, int speed, String filename, PImage playerClosed, PImage playerDown, PImage playerLeft, PImage playerRight, PImage playerUp) {
        this.x = (findPlayerStart.findx(filename))*16 -4;
        this.y = ((findPlayerStart.findy(filename))*16) -5;
        this.playerClosed = playerClosed;
        this.playerDown = playerDown;
        this.playerLeft = playerLeft;
        this.playerRight = playerRight;
        this.playerUp = playerUp;
        this.lives = lives;
        this.speed = speed;
        this.path = path;
        this.map = map;
        this.fruitList = fruitList;
    }

    public void tick(char input) {
        if (this.direction == 'w') {
            if (path[this.y-1][this.x]){
                this.input = 'w';
            }
        }
        if (this.direction == 's') {
            if (path[this.y+1][this.x]){
                this.input = 's';
            }
        }
        if (this.direction == 'a') {
            if (path[this.y][this.x-1]){
                this.input = 'a';
            }
        }
        if (this.direction == 'd') {
            if (path[this.y][this.x+1]){
                this.input = 'd';
            }
        }
        if (this.input == 'w') {
            this.yvel = -speed;
            this.xvel =0;
        }
        if (this.input == 'a') {
            this.xvel = -speed;
            this.yvel =0;

        }
        if (this.input == 's') {
            this.yvel = speed;
            this.xvel =0;
        }
        if (this.input == 'd') {
            this.xvel = speed;
            this.yvel =0;
        }
        if (input == ' ') {
            this.xvel = 0;
            this.yvel = 0;
        }

        if (path[this.y + this.yvel][this.x + this.xvel] == true) {
            this.x += this.xvel;
            this.y += this.yvel;
            for (Fruit f : fruit)
        } else {
            this.xvel = 0;
            this.yvel = 0;
        }
    }

    public void draw(PApplet app) {
        if (this.openMouth && this.input =='w') {
            app.image(this.playerUp, x , y);
        } 
        else if (this.openMouth && this.input =='a') {
            app.image(this.playerLeft, x , y);
        } 
        else if (this.openMouth && this.input =='s') {
            app.image(this.playerDown, x , y);
        } 
        else if (this.openMouth && this.input =='d') {
            app.image(this.playerRight, x , y);
        } 
        
        else {
            app.image(this.playerClosed, x , y);

        }
    }

    public void openMouth(boolean open){
        this.openMouth = open;
    }


}