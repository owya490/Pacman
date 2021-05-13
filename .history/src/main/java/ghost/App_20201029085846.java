package ghost;

import processing.core.PApplet;
import processing.core.PImage;
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
    public boolean[][] mazepath;

    public char direction;
    public ArrayList<Fruit> fruitList;


    public Player player;
    public ArrayList<Ghost> ghost_obj = new ArrayList<Ghost>();
    public ArrayList<Integer> ghost_x;
    public ArrayList<Integer> ghost_y;

    public boolean openMouth = false;

    public int lives;
    public int speed;
    public String map;
    public JSONArray modeLengths;


    public App() {
        //Set up your objects
        
    }

    public void setup() {
        frameRate(60);
        try{
            Object obj = new JSONParser().parse(new FileReader("config.json"));
            JSONObject jo = (JSONObject) obj; 
          
            this.map = (String) jo.get("map"); 
            long life_tmp = (long) jo.get("lives"); 
            this.lives = (int) life_tmp;
            long speed_tmp = (long) jo.get("speed"); 
            this.speed = (int) speed_tmp;
            this.modeLengths = (JSONArray) jo.get("modeLength");

        } catch (FileNotFoundException e) {
            System.out.println("Nope");
        } catch (IOException i) {
            System.out.println("Nope1");
        } catch (ParseException p) {
            System.out.println("Nope2");
        }
        

    

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

        this.lines = fileReader.readLines(this.map);
        this.lines_f = fileReader.convertToArray(this.lines);

        

        this.mazepath = MazePath.createPath(this.lines_f);
        this.mb = new MazeBuilder(this.map, this.downLeft, this.downRight, this.horizontal, this.upLeft, this.upRight, this.vertical, this.fruit);
        this.fruitList = this.mb.fruitList();
        this.player = new Player(this.fruitList, this.lines_f, this.mazepath, this.lives, this.speed, this.map, this.playerClosed, this.playerDown, this.playerLeft, this.playerRight, this.playerUp);




        this.ghost_x = findGhostStart.findx(this.map);
        this.ghost_y = findGhostStart.findy(this.map);
        int index = 0;
        for (int x = 0; x < this.ghost_x.size(); x ++) {
            this.ghost_obj.add(new Ghost(this.ghost_x.get(x), this.ghost_y.get(index), this.ghost, this.modeLengths, this.speed, this.mazepath, this.player));
            index ++;
        }

    }


    public void settings() {
        size(WIDTH, HEIGHT);
    }

    public void draw() { 
        background(0,0,0);
        int n = frameCount;
        if (n%8== 0) {
            this.openMouth = !this.openMouth;
            this.player.openMouth(this.openMouth);
        }
        for (Ghost g : ghost_obj) {
            g.tick();
            g.draw(this);

        }
        
        this.player.tick(this.direction);
        this.player.draw(this);
        this.mb.draw(this);
    }

    public void keyPressed(KeyEvent key) {
        if (key.getKeyCode() == 38) {
            this.player.direction = 'w';
        }
        if (key.getKeyCode() == 40) {
            this.player.direction = 's';
        }
        if (key.getKeyCode() == 37) {
            this.player.direction = 'a';
        }
        if (key.getKeyCode() == 39) {
            this.player.direction = 'd';
        }
    }



    public static void main(String[] args) {
        PApplet.main("ghost.App");
    }

}
