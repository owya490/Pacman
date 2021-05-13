package ghost;

import processing.core.PApplet;
import processing.event.KeyEvent;

public class App extends PApplet {

    /**
     * The Width of the game window
     */
    public static final int WIDTH = 448;

    /**
     * The Height of the game window
     */
    public static final int HEIGHT = 576;

    /**
     * The GameManager responsible for managing the current game state
     */
    public GameManager manager;

    /**
     * Constructor the a new App Class
     */
    public App() {
        //Set up your objects
    }

    /**
     * The Setup for the App Class
     * Within the Setup, the framerate is set, a new manager class is created as well as constructing the maze and game objects
     */
    public void setup() {
        frameRate(60);
        this.manager = new GameManager();
        this.manager.loadSprites(this);
        this.manager.constructGame();
    }

    /**
     * Applys the settings for the game window
     */
    public void settings() {
        size(WIDTH, HEIGHT);
    }

    /**
     * Draws to the screen the game for the player to see
     */
    public void draw() { 
        background(0,0,0);
        manager.drawCall();
    }

    /**
     * Detects a keypress by the player and passes the manager class the corresponding keyEvent
     * @param key the keyEvent being pressed
     */
    public void keyPressed(KeyEvent key) {
        this.manager.keyPressedCall(key.getKeyCode());
    }

    /**
     * The main method calling for the PApplet.main method with the package ghost
     * @param args arguments for the main method inputed by the player
     */
    public static void main(String[] args) {
        PApplet.main("ghost.App");
    }
}
