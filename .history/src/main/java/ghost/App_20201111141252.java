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
  
import org.json.simple.JSONArray; 
import org.json.simple.JSONObject; 
import org.json.simple.parser.*;

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

        // int n = this.frameCount;

        // if (mb.checkFruitListDone() == true & mb.checkSuperFruitListDone() == true){
        //     this.textFont(this.font);
        //     this.text("You Win", 168, 204);
        //     //this.textFont("You Win", 168, 204);
        //     if (deathTimer == 600) {
        //         this.player.setLives(this.lives);
        //         this.deathTimer =0;
        //         mb.fruitList();
        //         mb.superFruitList();
        //         this.player.updateFruitList(mb.fruitList());
        //         this.player.updateSuperFruitList(mb.superFruitList());
        //         this.player.setX(this.player.beg_x);
        //         this.player.setY(this.player.beg_y);

        //         for (GhostObject g : ghost_obj) {
        //             g.setScatterExact(true);
        //             g.resetFrames();
        //             g.resetScatterIndex();
        //             g.setAllDead();
        //             g.setFrightened(false);
        //         }
        //         for (GhostObject g : ghost_obj) {
        //             g.setDead(false);
        //         }
        //     } else {
        //         this.deathTimer ++;
        //     }
        // }
        // else if (this.player.getLives() > 0){
        //     this.mb.draw(this);

        //     if (n%8== 0) {
        //         this.openMouth = !this.openMouth;
        //         this.player.openMouth(this.openMouth);
        //     }
        //     this.player.tick(this.direction);
        //     this.player.draw(this);
        //     for (GhostObject g : ghost_obj) {
        //         g.tick('a');
        //         g.draw(this);

        //     }
        // } else {
        //     this.image(this.gameover, 168, 204);
        //     if (deathTimer == 600) {
        //         this.player.setLives(this.lives);
        //         this.deathTimer =0;
        //         mb.fruitList();
        //         mb.superFruitList();
        //         this.player.updateFruitList(mb.fruitList());
        //         this.player.updateSuperFruitList(mb.superFruitList());
        //         this.player.setX(this.player.beg_x);
        //         this.player.setY(this.player.beg_y);
        //         for (GhostObject g : ghost_obj) {
        //             g.setScatterExact(true);
        //             g.resetFrames();
        //             g.resetScatterIndex();
        //             g.setAllDead();
        //             g.setFrightened(false);
        //         }
        //         for (GhostObject g : ghost_obj) {
        //             g.setDead(false);
        //         }
        //     } else {
        //         this.deathTimer ++;
        //     }
        // }
        // // this.player.tick(this.direction);
        // // this.player.draw(this);
    }

    public void keyPressed(KeyEvent key) {
        this.manager.keyPressedCall(key);
        // if (key.getKeyCode() == 38) {
        //     this.player.setDirection('w');
        // }
        // if (key.getKeyCode() == 40) {
        //     this.player.setDirection('s');
        // }
        // if (key.getKeyCode() == 37) {
        //     this.player.setDirection('a');
        // }
        // if (key.getKeyCode() == 39) {
        //     this.player.setDirection('d');
        // }
        // if (key.getKeyCode() == 32) {
        //     for (GhostObject g : ghost_obj) {
        //         g.setDebug();
        //     }
        // }
    }



    public static void main(String[] args) {
        PApplet.main("ghost.App");
    }

}
