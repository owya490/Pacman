package ghost;
import processing.core.PApplet;
import processing.core.PImage;
import java.util.*;
import java.io.*;
public class Player extends MovingEntities{
     /** 
     * The beginning X coordinates
     */
    public int beg_x;
    /** 
     * The beginning Y coordinates
     */
    public int beg_y;
    /**
     * The horizontal velocity of the Waka
     */
    private int xvel = 0;
    /**
     * The vertical velocity of the Waka
     */
    private int yvel = 0;
    /**
     * The amount of lives the waka has left
     */
    private int lives;
    /**
     * The speed the waka moves at
     */
    private int speed;

    /**
     * The sprite for waka when mouth is closed
     */
    private PImage playerClosed;
    /** 
     * The sprite for waka when mouth is open and facing down
     */
    private PImage playerDown;
    /** 
     * The sprite for waka when mouth is open and facing left
     */
    private PImage playerLeft;
    /** 
     * The sprite for waka when mouth is open and facing right
     */
    private PImage playerRight;
    /** 
     * The sprite for waka when mouth is open and facing up
     */
    private PImage playerUp;

    /**
     * Marks if wakas mouth currently should be open or not
     */
    private boolean openMouth;

    /**
     * The input direction the player wants the waka to travel
     */
    private char input = 'd';

    /**
     * The mazepath available for Entities to traverse
     * True is traversable
     * False is not traversable
     */
    private boolean[][] path;

    /**
     * The direction the waka is currently travelling in 
     */
    private char direction;

    /**
     * The map of cells read from the map text file
     */
    private String[][] map;

    /**
     * List of all fruit objects and locations in the map
     */
    private ArrayList<Fruit> fruitList;

    /**
     * List of all superFruit objects and locations in the map
     */
    private ArrayList<superFruit> superFruitList;

    /**
     * List of all soda objects and locations in the map
     */
    private ArrayList<soda> sodaList;

    /**
     * List of all ghost objects currently in the game
     */
    private ArrayList<GhostObject> ghost_obj;

    public Player(ArrayList<soda> sodaList, ArrayList<superFruit> superFruitList, ArrayList<Fruit> fruitList, String[][] map, boolean[][] path, int lives, int speed, String filename, PImage playerClosed, PImage playerDown, PImage playerLeft, PImage playerRight, PImage playerUp) {
        this.sodaList = sodaList;

        this.superFruitList = superFruitList;
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

        if (path[this.y + this.yvel][this.x + this.xvel] == true) {
            this.x += this.xvel;
            this.y += this.yvel;
            for (Fruit f : this.fruitList) {
                if (this.x  == f.getX() & this.y == f.getY()) {
                    f.eaten = true;
                } 
            }
            for (superFruit f : this.superFruitList) {
                if (this.x  == f.getX() & this.y == f.getY() & f.eaten == false) {
                    f.eaten = true;
                    for (GhostObject g : this.ghost_obj) {
                        if (g.getFrightened() == false) {
                            g.setFrightened(true);
                        } else {
                            g.resetFrightenedFrames();
                        }
                    }
                } 
            }
            for (soda s : this.sodaList) {
                if (this.x  == s.getX() & this.y == s.getY() & s.eaten == false) {
                    s.eaten = true;
                    for (GhostObject g : this.ghost_obj) {
                        if (g.sodaEffectGet() == false) {
                            g.sodaEffectSet(true);
                        } else {
                            g.resetSodaFrames();
                        }
                    }
                } 
            }
        } else {
            this.xvel = 0;
            this.yvel = 0;
        }
    }

    public void draw(PApplet app) {
        for (int i = 0; i < lives; i ++) {
            app.image(this.playerRight, 8 + (28*i), 544);
        }
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

    public boolean openMouth(boolean open){
        this.openMouth = open;
        return open;
    }

    public int setX(int x) {
        this.x = x;
        return this.x;
    }

    public int setY(int y) {
        this.y = y;
        return this.y;
    }

    public char setDirection(char c) {
        this.direction = c;
        return this.direction;
    }

    public char getDirection() {
        return this.direction;
    }

    public boolean setGhostObj(ArrayList<GhostObject> o){
        this.ghost_obj = o;
        return true;
    }

    public int getLives() {
        return this.lives;
    }

    public boolean setLives(int l) {
        this.lives = l;
        return true;
    }

    public boolean updateFruitList(ArrayList<Fruit> f) {
        this.fruitList = f;
        return true;
    }
    public boolean updateSuperFruitList(ArrayList<superFruit> f) {
        this.superFruitList = f;
        return true;
    }
    public boolean updateSodaList(ArrayList<soda> s) {
        this.sodaList = s;
        return true;
    }
    public boolean getDead() {
        return this.dead;
    }

    public char getInput() {
        return this.input;
    }


}