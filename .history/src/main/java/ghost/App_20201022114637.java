package ghost;

import processing.core.PApplet;
import processing.core.PImage;
import procecssing.core.*;
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
    private String[][] lines_f;

    public Player player;



    public App() {
        //Set up your objects
        
    }

    public void setup() {
        frameRate(60);

    

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
        this.player = new Player("map.txt", this.playerClosed, this.playerDown, this.playerLeft, this.playerRight, this.playerUp);
        this.mb = new MazeBuilder(this.downLeft, this.downRight, this.horizontal, this.upLeft, this.upRight, this.vertical, this.fruit);
        this.lines_f = fileReader.convertToArray(this.lines);

    }


    public void settings() {
        size(WIDTH, HEIGHT);
    }

    public void draw() { 
        background(0,0,0);
        this.player.tick();
        this.player.draw(this);
        this.mb.draw(this);

    }

    public void keyPressed(KeyEvent event) {
        if (event == 'a') {
            System.out.println("yes");
        }
    }

    public static void main(String[] args) {
        PApplet.main("ghost.App");
    }

}
