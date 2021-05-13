package ghost;

import processing.core.PApplet;
import processing.event.KeyEvent;

public class App extends PApplet {

    public static final int WIDTH = 448;
    public static final int HEIGHT = 576;

    public GameManager manager;

    public App() {
        //Set up your objects
    }

    public void setup() {
        frameRate(60);
        this.manager = new GameManager(this);
    }

    public void settings() {
        size(WIDTH, HEIGHT);
    }

    public void draw() { 
        background(0,0,0);
        manager.drawCall();
    }

    public void keyPressed(KeyEvent key) {
        this.manager.keyPressedCall(key);
    }

    public static void main(String[] args) {
        PApplet.main("ghost.App");
    }

}
