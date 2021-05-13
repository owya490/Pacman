package ghost;

import processing.core.PApplet;
import processing.core.PImage;

public class App extends PApplet {

    public static final int WIDTH = 448;
    public static final int HEIGHT = 576;

    public PImage downLeft;
    private PImage downRight;
    private PImage horizontal;
    public PImage upLeft;
    public PImage upRight;
    private PImage Vertical;
    private MazeBuilder mb;



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
        this.Vertical = this.loadImage("src/main/resources/Vertical.png");
    }

    public void settings() {
        size(WIDTH, HEIGHT);
    }

    public void draw() { 
        //background(0, 0, 0);
        //this.mb = new MazeBuilder();
        image(this.downLeft, 17, 89);

        //this.image(this.mb.upLeft, 0, 0);
        //this.image(m.upRight, 17, 0);
    }

    public static void main(String[] args) {
        PApplet.main("ghost.App");
    }

}
