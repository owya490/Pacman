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

public class GameManager {
    
    public static final int WIDTH = 448;
    public static final int HEIGHT = 576;

    private PImage downLeft;
    private PImage downRight;
    private PImage horizontal;
    private PImage upLeft;
    private PImage upRight;
    private PImage vertical;
    private PImage fruit;
    private PImage chaser;
    private PImage ambusher;
    private PImage whim;
    private PImage ignorant;
    private PImage playerClosed;
    private PImage playerDown;
    private PImage playerLeft;
    private PImage playerRight;
    private PImage playerUp;
    private PImage ghost_scared;
    private PImage superFruit;
    private PImage gameover;

    private PFont font;

    private MazeBuilder mb;
    private ArrayList<String[]> lines;
    private String[][] lines_f;
    public boolean[][] mazepath;

    public char direction;
    public ArrayList<Fruit> fruitList;
    public ArrayList<superFruit> superFruitList;

    private int deathTimer = 0;



    public Player player;
    public ArrayList<GhostObject> ghost_obj = new ArrayList<GhostObject>();
    public ArrayList<Integer> ambusher_ghost_x;
    public ArrayList<Integer> ambusher_ghost_y;
    public ArrayList<Integer> chaser_ghost_x;
    public ArrayList<Integer> chaser_ghost_y;
    public ArrayList<Integer> ignorant_ghost_x;
    public ArrayList<Integer> ignorant_ghost_y;
    public ArrayList<Integer> whim_ghost_x;
    public ArrayList<Integer> whim_ghost_y;

    public boolean openMouth = false;

    public int lives;
    public int speed;
    public String map;
    public JSONArray modeLengths1;
    public ArrayList<Integer> modeLengths_i_f;
    public int frightenedLength;

    public PApplet app;

    private int n;


    public GameManager(PApplet app) {

        this.app = app;
        try{
            Object obj = new JSONParser().parse(new FileReader("config.json"));
            JSONObject jo = (JSONObject) obj; 
          
            this.map = (String) jo.get("map"); 

            long life_tmp = (long) jo.get("lives"); 
            this.lives = (int) life_tmp;
            long speed_tmp = (long) jo.get("speed"); 
            this.speed = (int) speed_tmp;
            long frightened_temp = (long) jo.get("frightenedLength"); 
            this.frightenedLength = (int) frightened_temp;
            System.out.println(frightenedLength);
            //System.out.println(speed);
            this.modeLengths1 = (JSONArray) jo.get("modeLengths");
            ArrayList<Integer> modeLengths_i = new ArrayList<Integer>();

            for (int i = 0; i < modeLengths1.size(); i ++) {
                //System.out.println(modeLengths1.get(i));
                long tmp = (long)modeLengths1.get(i);
                modeLengths_i.add((int) tmp);
            }

            this.modeLengths_i_f = modeLengths_i;


        } catch (FileNotFoundException e) {
            System.out.println("Nope");
        } catch (IOException i) {
            System.out.println("Nope1");
        } catch (ParseException p) {
            System.out.println("Nope2");
        }
        

    

        // Load images
        this.downLeft = app.loadImage("src/main/resources/downLeft.png");
        this.downRight = app.loadImage("src/main/resources/downRight.png");
        this.horizontal = app.loadImage("src/main/resources/horizontal.png");
        this.upLeft = app.loadImage("src/main/resources/upLeft.png");
        this.upRight = app.loadImage("src/main/resources/upRight.png");
        this.vertical = app.loadImage("src/main/resources/vertical.png");
        this.fruit = app.loadImage("src/main/resources/fruit.png");
        this.chaser = app.loadImage("src/main/resources/chaser.png");
        this.ambusher = app.loadImage("src/main/resources/ambusher.png");

        this.whim = app.loadImage("src/main/resources/whim.png");

        this.ignorant = app.loadImage("src/main/resources/ignorant.png");

        this.playerClosed = app.loadImage("src/main/resources/playerClosed.png");
        this.playerDown = app.loadImage("src/main/resources/playerDown.png");
        this.playerLeft = app.loadImage("src/main/resources/playerLeft.png");
        this.playerRight = app.loadImage("src/main/resources/playerRight.png");
        this.playerUp = app.loadImage("src/main/resources/playerUp.png");
        this.ghost_scared = app.loadImage("src/main/resources/frightened.png");
        this.superFruit = app.loadImage("src/main/resources/superFruit.png");
        this.gameover = app.loadImage("src/main/resources/gameover - Copy.png");
        this.font = app.createFont("src/main/resources/PressStart2P-Regular.ttf", 16);





        this.lines = fileReader.readLines(this.map);
        this.lines_f = fileReader.convertToArray(this.lines);

        

        this.mazepath = MazePath.createPath(this.lines_f);
        this.mb = new MazeBuilder(this.map, this.downLeft, this.downRight, this.horizontal, this.upLeft, this.upRight, this.vertical, this.fruit, this.superFruit);
        this.fruitList = this.mb.fruitList();
        this.superFruitList = this.mb.superFruitList();

        this.player = new Player(this.superFruitList, this.fruitList, this.lines_f, this.mazepath, this.lives, this.speed, this.map, this.playerClosed, this.playerDown, this.playerLeft, this.playerRight, this.playerUp);




        this.ambusher_ghost_x = findGhostStart.ambusherfindx(this.map);
        this.ambusher_ghost_y = findGhostStart.ambusherfindy(this.map);
        this.chaser_ghost_x = findGhostStart.chaserfindx(this.map);
        this.chaser_ghost_y = findGhostStart.chaserfindy(this.map);
        this.ignorant_ghost_x = findGhostStart.ignorantfindx(this.map);
        this.ignorant_ghost_y = findGhostStart.ignorantfindy(this.map);
        this.whim_ghost_x = findGhostStart.whimfindx(this.map);
        this.whim_ghost_y = findGhostStart.whimfindy(this.map);
        int index = 0;

        for(Integer g : this.ambusher_ghost_x) {
            this.ghost_obj.add(new Ambusher(this.ambusher_ghost_x.get(index), this.ambusher_ghost_y.get(index), this.ambusher, this.ghost_scared, this.modeLengths_i_f, this.speed, this.mazepath, this.player, this.ghost_obj, this.frightenedLength));
            index ++;
        }
        index = 0;
        for(Integer g : this.ignorant_ghost_x) {
            this.ghost_obj.add(new Ignorant(this.ignorant_ghost_x.get(index), this.ignorant_ghost_y.get(index), this.ignorant, this.ghost_scared, this.modeLengths_i_f, this.speed, this.mazepath, this.player, this.ghost_obj, this.frightenedLength));
            index ++;
        }
        index = 0;

        for(Integer g : this.chaser_ghost_x) {
            this.ghost_obj.add(new Chaser(this.chaser_ghost_x.get(index), this.chaser_ghost_y.get(index), this.chaser, this.ghost_scared, this.modeLengths_i_f, this.speed, this.mazepath, this.player, this.ghost_obj, this.frightenedLength));
            index ++;
        }
        index = 0;

        for(Integer g : this.whim_ghost_x) {
            this.ghost_obj.add(new Whim(this.whim_ghost_x.get(index), this.whim_ghost_y.get(index), this.whim, this.ghost_scared, this.modeLengths_i_f, this.speed, this.mazepath, this.player, this.ghost_obj, this.frightenedLength));
            index ++;
        }


        for (GhostObject g : this.ghost_obj) {
            g.setOtherGhosts(this.ghost_obj);
        }

        this.player.setGhostObj(this.ghost_obj);

    }

    public boolean winScreen() {
        app.textFont(this.font);
            app.text("You Win", 168, 204);
            //this.textFont("You Win", 168, 204);
            if (deathTimer == 600) {
                this.player.setLives(this.lives);
                this.deathTimer =0;
                mb.fruitList();
                mb.superFruitList();
                this.player.updateFruitList(mb.fruitList());
                this.player.updateSuperFruitList(mb.superFruitList());
                this.player.setX(this.player.beg_x);
                this.player.setY(this.player.beg_y);

                for (GhostObject g : ghost_obj) {
                    g.setScatterExact(true);
                    g.resetFrames();
                    g.resetScatterIndex();
                    g.setAllDead();
                    g.setFrightened(false);
                }
                for (GhostObject g : ghost_obj) {
                    g.setDead(false);
                }
            } else {
                this.deathTimer ++;
            }
        
        return true;
    }

    public boolean loseScreen() {
        app.image(this.gameover, 168, 204);
        if (deathTimer == 600) {
            this.player.setLives(this.lives);
            this.deathTimer =0;
            mb.fruitList();
            mb.superFruitList();
            this.player.updateFruitList(mb.fruitList());
            this.player.updateSuperFruitList(mb.superFruitList());
            this.player.setX(this.player.beg_x);
            this.player.setY(this.player.beg_y);
            for (GhostObject g : ghost_obj) {
                g.setScatterExact(true);
                g.resetFrames();
                g.resetScatterIndex();
                g.setAllDead();
                g.setFrightened(false);
            }
            for (GhostObject g : ghost_obj) {
                g.setDead(false);
            }
        } else {
            this.deathTimer ++;
        }
    }

    public void drawCall() {
        this.n = app.frameCount;

        if (mb.checkFruitListDone() == true & mb.checkSuperFruitListDone() == true){
            winScreen();
            // app.textFont(this.font);
            // app.text("You Win", 168, 204);
            // //this.textFont("You Win", 168, 204);
            // if (deathTimer == 600) {
            //     this.player.setLives(this.lives);
            //     this.deathTimer =0;
            //     mb.fruitList();
            //     mb.superFruitList();
            //     this.player.updateFruitList(mb.fruitList());
            //     this.player.updateSuperFruitList(mb.superFruitList());
            //     this.player.setX(this.player.beg_x);
            //     this.player.setY(this.player.beg_y);

            //     for (GhostObject g : ghost_obj) {
            //         g.setScatterExact(true);
            //         g.resetFrames();
            //         g.resetScatterIndex();
            //         g.setAllDead();
            //         g.setFrightened(false);
            //     }
            //     for (GhostObject g : ghost_obj) {
            //         g.setDead(false);
            //     }
            // } else {
            //     this.deathTimer ++;
            // }
        }
        else if (this.player.getLives() > 0){
            this.mb.draw(app);

            if (n%8== 0) {
                this.openMouth = !this.openMouth;
                this.player.openMouth(this.openMouth);
            }
            this.player.tick(this.direction);
            this.player.draw(app);
            for (GhostObject g : ghost_obj) {
                g.tick('a');
                g.draw(app);

            }
        } else {
            loseScreen();
        //     app.image(this.gameover, 168, 204);
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
        // this.player.tick(this.direction);
        // this.player.draw(this);
    }

    public void keyPressedCall(KeyEvent key) {
        if (key.getKeyCode() == 38) {
            this.player.setDirection('w');
        }
        if (key.getKeyCode() == 40) {
            this.player.setDirection('s');
        }
        if (key.getKeyCode() == 37) {
            this.player.setDirection('a');
        }
        if (key.getKeyCode() == 39) {
            this.player.setDirection('d');
        }
        if (key.getKeyCode() == 32) {
            for (GhostObject g : ghost_obj) {
                g.setDebug();
            }
        }
    }
}