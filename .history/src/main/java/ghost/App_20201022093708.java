package ghost;

import processing.core.PApplet;
import processing.core.PImage;

public class App extends PApplet {

    public static final int WIDTH = 448;
    public static final int HEIGHT = 576;

    private PImage downLeft;



    public App() {
        //Set up your objects
    }

    public void setup() {
        frameRate(60);
        //this.downLeft = this.loadImage("src/main/resources/downLeft.png");

        // Load images
    }

    public void settings() {
        size(WIDTH, HEIGHT);
    }

    public void draw() { 
        background(0, 0, 0);
        this.image(this.downLeft, 0, 0);
    }

    public static void main(String[] args) {
        PApplet.main("ghost.App");
    }

}
