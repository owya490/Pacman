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
    private PImage Vertical;
    private MazeBuilder mb;
    private ArrayList<String[]> lines;



    public App() {
        //Set up your objects
        
    }

    public void setup() {
        frameRate(60);
        this.mb = new MazeBuilder();

    

        // Load images
        this.downLeft = this.loadImage("src/main/resources/downLeft.png");
        this.downRight = this.loadImage("src/main/resources/downRight.png");
        this.horizontal = this.loadImage("src/main/resources/horizontal.png");
        this.upLeft = this.loadImage("src/main/resources/upLeft.png");
        this.upRight = this.loadImage("src/main/resources/upRight.png");
        this.Vertical = this.loadImage("src/main/resources/vertical.png");
        this.lines = fileReader.readLines("map.txt");

    }


    public void settings() {
        size(WIDTH, HEIGHT);
    }

    public void draw() { 
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
            }
        }




        // for (String[] line : this.lines) {
        //     for (String c : line) {
        //         if (c.equals)
        //     }
        // }

        //image(this.upRight, 0,0);
        //image(this.upLeft, 16,0);


    }

    public static void main(String[] args) {
        PApplet.main("ghost.App");
    }

}
