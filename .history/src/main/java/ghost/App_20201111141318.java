package ghost;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PFont;

import java.util.*;
import java.io.*;
import java.io.FileReader; 
import java.util.Iterator; 
import java.util.Map; 
import processing.event.KeyEvent;
  
// import org.json.simple.JSONArray; 
// import org.json.simple.JSONObject; 
// import org.json.simple.parser.*;

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
