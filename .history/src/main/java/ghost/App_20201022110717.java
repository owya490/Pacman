package ghost;

import processing.core.PApplet;
import processing.core.PImage;
import java.util.*;
import java.io.*;

public class App extends PApplet {

    public static final int WIDTH = 448;
    public static final int HEIGHT = 576;

    private PImage downLeft;
    private PImage downRight;
    private PImage horizontal;
    private PImage upLeft;
    private PImage upRight;
    private PImage vertical;
    private PImage fruit;
    private PImage ghost;
    private PImage playerClosed;
    private PImage playerDown;
    private PImage playerLeft;
    private PImage playerRight;
    private PImage playerUp;

    private MazeBuilder mb;
    private ArrayList<String[]> lines;

    public Player player;



    public App() {
        //Set up your objects
        
    }

    public void setup() {
        frameRate(60);
        this.mb = new MazeBuilder();
        this.player = new Player("map.txt", playerClosed, playerDown, playerLeft, playerRight, playerUp);


    

        // Load images
        this.downLeft = this.loadImage("src/main/resources/downLeft.png");
        this.downRight = this.loadImage("src/main/resources/downRight.png");
        this.horizontal = this.loadImage("src/main/resources/horizontal.png");
        this.upLeft = this.loadImage("src/main/resources/upLeft.png");
        this.upRight = this.loadImage("src/main/resources/upRight.png");
        this.vertical = this.loadImage("src/main/resources/vertical.png");
        this.fruit = this.loadImage("src/main/resources/fruit.png");
        this.ghost = this.loadImage("src/main/resources/ghost.png");
        this.playerClosed = this.loadImage("src/main/resources/playerClosed.png");
        this.playerDown = this.loadImage("src/main/resources/playerDown.png");
        this.playerLeft = this.loadImage("src/main/resources/playerLeft.png");
        this.playerRight = this.loadImage("src/main/resources/playerRight.png");
        this.playerUp = this.loadImage("src/main/resources/playerUp.png");

        this.lines = fileReader.readLines("map.txt");

    }


    public void settings() {
        size(WIDTH, HEIGHT);
    }

    public void draw() { 
        background(0,0,0);
        for (int y = 0; y < this.lines.size(); y ++) {
            for (int x = 0; x < this.lines.get(y).length; x ++) {
                if (this.lines.get(y)[x].equals("0")) {
                    continue;
                }
                if (this.lines.get(y)[x].equals("6")) {
                    image(this.downRight, x*16,y*16);
                }
                if (this.lines.get(y)[x].equals("1")) {
                    image(this.horizontal, x*16,y*16);
                }
                if (this.lines.get(y)[x].equals("5")) {
                    image(this.downLeft, x*16,y*16);
                }
                if (this.lines.get(y)[x].equals("2")) {
                    image(this.vertical, x*16,y*16);
                }
                if (this.lines.get(y)[x].equals("4")) {
                    image(this.upRight, x*16,y*16);
                }
                if (this.lines.get(y)[x].equals("3")) {
                    image(this.upLeft, x*16,y*16);
                }

                if (this.lines.get(y)[x].equals("g")) {
                    image(this.ghost, x*16,(y*16)-4);
                }
                if (this.lines.get(y)[x].equals("p")) {
                    image(this.playerClosed, x*16,(y*16)-4);
                }
                if (this.lines.get(y)[x].equals("7")) {
                    image(this.fruit, x*16,y*16);
                }
            }
        }

    }

    public static void main(String[] args) {
        PApplet.main("ghost.App");
    }

}