package ghost;
import processing.core.PApplet;
import processing.core.PImage;
import java.util.*;
import java.io.*;
public class Player extends MovingEntities{
    private int x;
    private int y;

    public int beg_x;
    public int beg_y;

    // public int x_f;
    // public int y;

    private int xvel = 0;
    private int yvel = 0;

    private int lives;
    private int speed;

    private PImage playerClosed;
    private PImage playerDown;
    private PImage playerLeft;
    private PImage playerRight;
    private PImage playerUp;

    private boolean openMouth;
    private char input = 'd';

    private boolean[][] path;

    private char direction;
    private String[][] map;

    public ArrayList<Fruit> fruitList;

    public boolean dead = false;



    public Player(ArrayList<Fruit> fruitList, String[][] map, boolean[][] path, int lives, int speed, String filename, PImage playerClosed, PImage playerDown, PImage playerLeft, PImage playerRight, PImage playerUp) {
        
        this.beg_x = (findPlayerStart.findx(filename))*16 -4;
        this.beg_y = ((findPlayerStart.findy(filename))*16) -5;
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
        if (this.dead == true) {
            this.lives --;
            this.x = this.beg_x;
            this.y = this.beg_y;
            this.direction = 'd';
            this.dead = false;
        }


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
            for (Fruit f : this.fruitList) {
                if (this.x  == f.getX() & this.y == f.getY()) {
                    f.eaten = true;
                } 
                // else if (this.x == f.getX() & this.y == f.getY()) {
                //     f.eaten = true;
                // }
                // else if (this.x == f.getX() & this.y == f.getY()) {
                //     f.eaten = true;
                // }
                // else if (this.x == f.getX() & this.y == f.getY()) {
                //     f.eaten = true;
                // }
            }
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

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int setX(int x) {
        this.x = x;
        return this.x;
    }

    public int setY(int y) {
        this.y = y;
        return this.y;
    }


}