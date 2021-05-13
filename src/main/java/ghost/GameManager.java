package ghost;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PFont;

import java.util.*;
import java.io.*;

import processing.event.KeyEvent;
  
import org.json.simple.JSONArray; 
import org.json.simple.JSONObject; 
import org.json.simple.parser.*;


public class GameManager {

    /**
     * The sprite for a corner facing downLeft
     */
    private PImage downLeft;
    /**
     * The sprite for a corner facing downRight
     */
    private PImage downRight;
    /**
     * The sprite for a horizontal wall
     */
    private PImage horizontal;
    /**
     * The sprite for a corner facing upLeft
     */
    private PImage upLeft;
    /**
     * The sprite for a corner facing upRight
     */
    private PImage upRight;
    /**
     * The sprite for a vertical wall
     */
    private PImage vertical;
    /**
     * The sprite for a fruit Object
     */
    private PImage fruit;
    /**
     * The sprite for the chaser ghost
     */
    private PImage chaser;
    /**
     * The sprite for the ambusher ghost
     */
    private PImage ambusher;
    /**
     * The sprite for the whim ghost
     */
    private PImage whim;
    /**
     * The sprite for the ignorant ghost
     */
    private PImage ignorant;
    /**
     * The sprite for the waka with mouth closed
     */
    private PImage playerClosed;
    /**
     * The sprite for the waka with mouth open facing down
     */
    private PImage playerDown;
    /**
     * The sprite for the waka with mouth open facing left
     */
    private PImage playerLeft;
    /**
     * The sprite for the waka with mouth open facing right
     */
    private PImage playerRight;
    /**
     * The sprite for the waka with mouth open facing up
     */
    private PImage playerUp;
    /**
     * The sprite for the ghost when frightened
     */
    private PImage ghost_scared;
    /**
     * The sprite for a superFruit object
     */
    private PImage superFruit;
    /**
     * The sprite for the gameover screen
     */
    private PImage gameover;
    /**
     * The sprite for a soda object
     */
    private PImage soda;
    /**
     * The sprite for the waka when affected by soda
     */
    private PImage sodaGhost;

    /**
     * The font for printing you win to screen
     */
    private PFont font;

    /**
     * The mazebuilder object
     */
    private MazeBuilder mb;
    /**
     * An array list of string arrays containing cells from the map
     */
    private ArrayList<String[]> lines;
    /**
     * A 2D array containing cells from the map
     */
    private String[][] lines_f;
    /**
     * A 2D boolean array containing the traversable path
     */
    private boolean[][] mazepath;

    /**
     * The direction the waka is heading in 
     */
    private char direction;
    /**
     * An arraylist of all the fruit objects in the map
     */
    private ArrayList<Fruit> fruitList;
    /**
     * An arraylist of all the superFruit objects in the map
     */
    private ArrayList<superFruit> superFruitList;
    /**
     * An arraylist of all the soda objects in the map
     */
    private ArrayList<soda> sodaList;

    /**
     * The timer for the end game screen
     */
    private int deathTimer = 0;


    /**
     * The player object
     */
    private Player player;
    /** 
     * An array list containing all the ghost Objects within the game
     */
    private ArrayList<GhostObject> ghost_obj = new ArrayList<GhostObject>();
    /**
     * The ambusher X starting coordinates
     */
    private ArrayList<Integer> ambusher_ghost_x;
    /**
     * The ambusher Y starting coordinates
     */
    private ArrayList<Integer> ambusher_ghost_y;
    /**
     * The chaser X starting coordinates
     */
    private ArrayList<Integer> chaser_ghost_x;
    /**
     * The chaser Y starting coordinates
     */
    private ArrayList<Integer> chaser_ghost_y;
    /**
     * The ignorant X starting coordinates
     */
    private ArrayList<Integer> ignorant_ghost_x;
    /**
     * The ignorant Y starting coordinates
     */
    private ArrayList<Integer> ignorant_ghost_y;
    /**
     * The whim X starting coordinates
     */
    private ArrayList<Integer> whim_ghost_x;
    /**
     * The whim Y starting coordinates
     */
    private ArrayList<Integer> whim_ghost_y;

    /**
     * Marks whether the waka's mouth is open or not
     */
    private boolean openMouth = false;

    /**
     * The amount of lives for the player
     */
    private int lives;
    /** 
     * The speed at which the player/ waka moves
     */
    private int speed;
    /** 
     * The map.txt filename/ path
     */
    private String map;
    /** 
     * The modeLengths for the scatter mode of ghosts
     */
    private JSONArray modeLengths1;
    /** 
     * The modeLengths for the scatter mode of ghosts in an array list
     */
    private ArrayList<Integer> modeLengths_i_f;
    /**
     * The frightened length of ghosts
     */
    private int frightenedLength;
    /**
     * The soda effect length on ghosts
     */
    private int sodaLength;

    /** 
     * The current app which through the class draws to the screen
     */
    private PApplet app;

    /** 
     * The total amount of frames that has elapsed
     */
    private int n;


    /**
     * The constructor for the GameManager Class
     */
    public GameManager() {
    }

    /**
     * All the sprites are loaded in and assigned to their attributes
     * @param app the app through which the sprites are loaded in
     * @return whether the sprite loading was completed successfully
     */
    public boolean loadSprites(PApplet app) {
        this.app = app;
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
        this.soda = app.loadImage("src/main/resources/soda.png");
        this.sodaGhost = app.loadImage("src/main/resources/sodaGhost.png");
        return true;
    }

    /**
     * Constructs the game state
     * Reads the config file, builds the map and instantiates all the objects of the game
     * @return whether constructing the game was successful
     */
    public boolean constructGame() {
        readConfigFile("config.json");
        buildMap();
        instantiateObjects();
        instantiateGhostObjects();
        return true;
    }

    /**
     * Instantiates all the ghost objects in the game
     * @return whether the ghost objects have been successfully instantiated
     */
    public boolean instantiateGhostObjects() {
        this.ambusher_ghost_x = findGhostStart.ambusherfindx(this.map);
        this.ambusher_ghost_y = findGhostStart.ambusherfindy(this.map);
        this.chaser_ghost_x = findGhostStart.chaserfindx(this.map);
        this.chaser_ghost_y = findGhostStart.chaserfindy(this.map);
        this.ignorant_ghost_x = findGhostStart.ignorantfindx(this.map);
        this.ignorant_ghost_y = findGhostStart.ignorantfindy(this.map);
        this.whim_ghost_x = findGhostStart.whimfindx(this.map);
        this.whim_ghost_y = findGhostStart.whimfindy(this.map);
        int index = 0;

        for (Integer g : this.ambusher_ghost_x) {
            this.ghost_obj.add(new Ambusher(this.sodaGhost, this.ambusher_ghost_x.get(index), this.ambusher_ghost_y.get(index), this.ambusher, this.ghost_scared, this.modeLengths_i_f, this.speed, this.mazepath, this.player, this.ghost_obj, this.frightenedLength, this.sodaLength));
            index ++;
        }
        index = 0;
        for (Integer g : this.ignorant_ghost_x) {
            this.ghost_obj.add(new Ignorant(this.sodaGhost, this.ignorant_ghost_x.get(index), this.ignorant_ghost_y.get(index), this.ignorant, this.ghost_scared, this.modeLengths_i_f, this.speed, this.mazepath, this.player, this.ghost_obj, this.frightenedLength, this.sodaLength));
            index ++;
        }
        index = 0;

        for (Integer g : this.chaser_ghost_x) {
            this.ghost_obj.add(new Chaser(this.sodaGhost, this.chaser_ghost_x.get(index), this.chaser_ghost_y.get(index), this.chaser, this.ghost_scared, this.modeLengths_i_f, this.speed, this.mazepath, this.player, this.ghost_obj, this.frightenedLength, this.sodaLength));
            index ++;
        }
        index = 0;

        for (Integer g : this.whim_ghost_x) {
            this.ghost_obj.add(new Whim(this.sodaGhost, this.whim_ghost_x.get(index), this.whim_ghost_y.get(index), this.whim, this.ghost_scared, this.modeLengths_i_f, this.speed, this.mazepath, this.player, this.ghost_obj, this.frightenedLength, this.sodaLength));
            index ++;
        }


        for (GhostObject g : this.ghost_obj) {
            g.setOtherGhosts(this.ghost_obj);
        }

        this.player.setGhostObj(this.ghost_obj);
        return true;
    }

    /**
     * Instantiates all the objects in the game
     * Creates the player and consumable objects
     * @return whether the objects have been successfully instantiated
     */
    public boolean instantiateObjects() {
        this.fruitList = this.mb.fruitList();
        this.superFruitList = this.mb.superFruitList();
        this.sodaList = this.mb.sodaList();
        this.player = new Player(this.sodaList, this.superFruitList, this.fruitList, this.lines_f, this.mazepath, this.lives, this.speed, this.map, this.playerClosed, this.playerDown, this.playerLeft, this.playerRight, this.playerUp);
        return true;
    }

    /**
     * Reads the map.txt file and constructs the map and the traversable path
     * @return whether the building of the map has been completed succesfully
     */
    public boolean buildMap() {
        this.lines = fileReader.readLines(this.map);
        this.lines_f = fileReader.convertToArray(this.lines);
        this.mazepath = MazePath.createPath(this.lines_f);
        this.mb = new MazeBuilder(this.map, this.downLeft, this.downRight, this.horizontal, this.upLeft, this.upRight, this.vertical, this.fruit, this.superFruit, this.soda);
        return true;
    }

    /**
     * Reads the config.json file and assigns the appropriate attributes
     * @param filename the config filename to be read
     * @return whether reading from the config.json file was successful
     */
    public boolean readConfigFile(String filename) {
        try{
            Object obj = new JSONParser().parse(new FileReader(filename));
            JSONObject jo = (JSONObject) obj; 
          
            this.map = (String) jo.get("map"); 

            long life_tmp = (long) jo.get("lives"); 
            this.lives = (int) life_tmp;
            long speed_tmp = (long) jo.get("speed"); 
            this.speed = (int) speed_tmp;
            long frightened_temp = (long) jo.get("frightenedLength"); 
            this.frightenedLength = (int) frightened_temp;
            long soda_temp = (long) jo.get("sodaLength"); 
            this.sodaLength = (int) soda_temp;
            System.out.println(this.sodaLength);
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
            return false;
        } catch (IOException i) {
            System.out.println("Nope1");
            return false;
        } catch (ParseException p) {
            System.out.println("Nope2");
            return false;
        }
        
        return true;
    }

    /**
     * Gets the fruit list for the game
     * @return the fruit list
     */
    public ArrayList<Fruit> getFruitList() {
        return this.fruitList;
    }
    /**
     * Gets the superFruit list for the game
     * @return the superFruit list
     */
    public ArrayList<superFruit> getSuperFruitList() {
        return this.superFruitList;
    }
    /**
     * Gets the soda list for the game
     * @return the soda list
     */
    public ArrayList<soda> getSodaList() {
        return this.sodaList;
    }

    /**
     * Gets the player object
     * @return the player object
     */
    public Player getPlayer() {
        return this.player;
    }

    /**
     * Gets the 2D array of cells for the map
     * @return the 2D array of cells for the map
     */
    public String[][] getLines_f() {
        return this.lines_f;
    }

    /**
     * Gets the map filename 
     * @return the map filename
     */
    public String getMap() {
        return this.map;
    }

    /**
     * Gets the total amount of lives the waka has
     * @return the total amount of lives for the waka
     */
    public int getLives() {
        return this.lives;
    }

    /**
     * Gets the speed in which the waka travels
     * @return the speed of the waka
     */
    public int getSpeed() {
        return this.speed;
    }

    /**
     * Gets the length of the soda effect
     * @return the length of the soda effect
     */
    public int getSodaLength() {
        return this.sodaLength;
    }

    /**
     * Gets the length of the frightened effect
     * @return the length of the frightened effect
     */
    public int getFrightenedLength() {
        return this.frightenedLength;
    }

    /**
     * Gets the array list of the scatter and chase mode lengths
     * @return the array list of the scatter and chase mode lengths
     */
    public ArrayList<Integer> getModeLengths() {
        return this.modeLengths_i_f;
    }

    /**
     * Gets an array list of all the ghost objects in the game
     * @return an array list of all the ghost objects in the game
     */
    public ArrayList<GhostObject> getGhostObj() {
        return this.ghost_obj;
    }

    /**
     * Displays the win screen if all fruit and superFruit have been eaten
     * @return whether the win screen has been successfully displayed
     */
    public boolean winScreen() {
        app.background(0,0,0);

        app.textFont(this.font);
            app.text("You Win", 168, 204);
            //this.textFont("You Win", 168, 204);
            resetAll();
        
        return true;
    }

    /**
     * Displays the lose screen if the player has run out of lives
     * @return whether the lose screen has been successfully displayed
     */
    public boolean loseScreen() {
        app.background(0,0,0);

        app.image(this.gameover, 168, 204);
        resetAll();

        return true;
    }

    /**
     * Performs resets on all the objects in the game
     * @return whether the reset was successful
     */
    public boolean resetAll() {
        if (deathTimer == 600) {
            this.player.setLives(this.lives);
            this.deathTimer =0;
            mb.fruitList();
            mb.superFruitList();
            mb.sodaList();

            this.player.updateFruitList(mb.fruitList());
            this.player.updateSuperFruitList(mb.superFruitList());
            this.player.updateSodaList(mb.sodaList());

            this.player.setX(this.player.beg_x);
            this.player.setY(this.player.beg_y);
            for (GhostObject g : ghost_obj) {
                g.setScatterExact(true);
                g.resetFrames();
                g.resetScatterIndex();
                g.setAllDead();
                g.setFrightened(false);
                g.sodaEffectSet(false);
                g.resetSodaFrames();

            }
            for (GhostObject g : ghost_obj) {
                g.setDead(false);
            }
            return true;

        } else {
            this.deathTimer ++;
            return false;
        }
    }

    /**
     * Performs the logic in determining whether the waka's mouth is open or closed
     * @return whether the waka's mouth is open or closed
     */
    public boolean openMouthLogic() {
        if (n % 8 == 0) {
            this.openMouth = !this.openMouth;
            this.player.openMouth(this.openMouth);
        }
        return this.openMouth;
    }

    /**
     * Displays the game running, drawing objects to the screen at the correct location
     * @return whether the game running screen is displayed successfully
     */
    public boolean gameRun() {
        this.mb.draw(app);
        openMouthLogic();
        this.player.tick(this.direction);
        this.player.draw(app);
        for (GhostObject g : ghost_obj) {
            g.tick('a');
            g.draw(app);

        }
        return true;
    }

    /**
     * Sets the total elasped frames to a certain integer
     * @param n the new elapsed frames
     * @return the new elapsed frames
     */
    public int setN(int n) {
        this.n = n;
        return n;
    }

    /**
     * Gets the death time that has elapsed
     * @return the death time that has elapsed
     */
    public int getDeathTimer() {
        return this.deathTimer;
    }

    /**
     * Draws to the screen the appropriate sprites and backgrounds
     */
    public void drawCall() {
        this.n = app.frameCount;

        if (mb.checkFruitListDone() == true & mb.checkSuperFruitListDone() == true){
            winScreen();
        }
        else if (this.player.getLives() > 0){
            gameRun();
        } else {
            loseScreen();
        }
    }

    /**
     * Determines which key the player has pressed
     * @param key the key which the player has pressed
     */

    public void keyPressedCall(int code) {
        if (code == 38) {
            this.player.setDirection('w');
        }
        if (code == 40) {
            this.player.setDirection('s');
        }
        if (code == 37) {
            this.player.setDirection('a');
        }
        if (code == 39) {
            this.player.setDirection('d');
        }
        if (code == 32) {
            for (GhostObject g : ghost_obj) {
                g.setDebug();
            }
        }
    }
}