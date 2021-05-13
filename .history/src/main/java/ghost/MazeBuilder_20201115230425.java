package ghost;
import java.util.*;
import java.io.*;

import processing.core.*;
import processing.core.PApplet;
import processing.core.PImage;

public class MazeBuilder extends PApplet{
    /**
     * The 2D ArrayList of cells for the map
     */
    private ArrayList<String[]> lines;

    // private static final int WIDTH = 448;
    // private static final int HEIGHT = 576;

    /**
     * The sprite for the a corner facing down left
     */
    public PImage downLeft;
    /**
     * The sprite for the a corner facing down right
     */
    private PImage downRight;
    /**
     * The sprite for the a horizontal wall
     */
    private PImage horizontal;
    /**
     * The sprite for the a corner facing up left
     */
    public PImage upLeft;
    /**
     * The sprite for the a corner facing up right
     */
    public PImage upRight;
    /**
     * The sprite for the a vertical wall
     */
    private PImage vertical;
    /**
     * The sprite for a fruit object
     */
    private PImage fruit;
    /**
     * The sprite for a superFruit object
     */
    private PImage superFruit;
    /**
     * The sprite for a soda object
     */
    private PImage soda;

    /**
     * An arraylist of all the fruit objects on the map
     */
    public ArrayList<Fruit> fruitList;
    /**
     * An arraylist of all the superFruit objects on the map
     */
    public ArrayList<superFruit> superFruitList;
    /**
     * An arraylist of all the soda objects on the map
     */
    public ArrayList<soda> sodaList;

    /**
     * The constructor the the Mazebuilder object receiving all the sprites
     * @param filename The filename for the map file (map.txt)
     * @param downLeft The downLeft sprite
     * @param downRight The downRight sprite
     * @param horizontal The horizontal sprite
     * @param upLeft The upLeft sprite
     * @param upRight The upRight sprite
     * @param vertical The vertical sprite
     * @param fruit The fruit sprite
     * @param superFruit The superFruit sprite
     * @param soda The soda sprite
     */
    public MazeBuilder(String filename, PImage downLeft, PImage downRight, PImage horizontal, PImage upLeft, PImage upRight, PImage vertical, PImage fruit, PImage superFruit, PImage soda) {
        this.downLeft = downLeft;
        this.downRight = downRight;
        this.horizontal = horizontal;
        this.upLeft = upLeft;
        this.upRight = upRight;
        this.vertical = vertical;
        this.fruit = fruit;
        this.superFruit = superFruit;
        this.lines = fileReader.readLines(filename);
        this.soda = soda;

    }

    /**
     * Searches the map for fruit objects and creates new fruit objects with the correct coordinates
     * @return An arraylist of all the fruit objects on the map
     */
    public ArrayList<Fruit> fruitList(){
        ArrayList<Fruit> tmpList = new ArrayList<Fruit>();
        for (int y = 0; y < this.lines.size(); y ++) {
            for (int x = 0; x < this.lines.get(y).length; x ++) {
                if (this.lines.get(y)[x].equals("7")) {
                    Fruit tmp = new Fruit(x*16, y*16, this.fruit);
                    tmpList.add(tmp);
                }
            }
        }
        this.fruitList = tmpList;
        return tmpList;
    }

    /**
     * Searches the map for soda objects and creates new soda objects with the correct coordinates
     * @return An arraylist of all the soda objects on the map
     */
    public ArrayList<soda> sodaList(){
        ArrayList<soda> tmpList = new ArrayList<soda>();
        for (int y = 0; y < this.lines.size(); y ++) {
            for (int x = 0; x < this.lines.get(y).length; x ++) {
                if (this.lines.get(y)[x].equals("s")) {
                    soda tmp = new soda(x*16, y*16, this.soda);
                    //System.out.println("f");
                    tmpList.add(tmp);
                }
            }
        }
        this.sodaList = tmpList;
        return tmpList;
    }

    /**
     * Searches the map for superFruit objects and creates new superFruit objects with the correct coordinates
     * @return An arraylist of all the superFruit objects on the map
     */
    public ArrayList<superFruit> superFruitList(){
        ArrayList<superFruit> tmpList = new ArrayList<superFruit>();
        for (int y = 0; y < this.lines.size(); y ++) {
            for (int x = 0; x < this.lines.get(y).length; x ++) {
                if (this.lines.get(y)[x].equals("8")) {
                    superFruit tmp = new superFruit(x*16, y*16, this.superFruit);
                    //System.out.println("f");
                    tmpList.add(tmp);
                }
            }
        }
        this.superFruitList = tmpList;
        return tmpList;
    }

    /**
     * Checks if the all the fruit objects are eaten
     * @return whether or not all the fruit objects have been eaten
     */
    public boolean checkFruitListDone() {
        int total = 0;
        for (Fruit f : this.fruitList) {
            if (f.eaten == true) {
                total ++;
            }
        }
        if (total == this.fruitList.size()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks if the all the superFruit objects are eaten
     * @return whether or not all the superFruit objects have been eaten
     */
    public boolean checkSuperFruitListDone() {
        int total = 0;
        for (superFruit f : this.superFruitList) {
            if (f.eaten == true) {
                total ++;
            }
        }
        if (total == this.superFruitList.size()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Draws to the screen the map based off the map.txt file
     * @param app the app which it will draw to the screen through
     */
    public void draw(PApplet app) {
        for (int y = 0; y < this.lines.size(); y ++) {
            for (int x = 0; x < this.lines.get(y).length; x ++) {
                if (this.lines.get(y)[x].equals("0")) {
                    continue;
                }
                if (this.lines.get(y)[x].equals("6")) {
                    app.image(this.downRight, x*16,y*16);
                }
                if (this.lines.get(y)[x].equals("1")) {
                    app.image(this.horizontal, x*16,y*16);
                }
                if (this.lines.get(y)[x].equals("5")) {
                    app.image(this.downLeft, x*16,y*16);
                }
                if (this.lines.get(y)[x].equals("2")) {
                    app.image(this.vertical, x*16,y*16);
                }
                if (this.lines.get(y)[x].equals("4")) {
                    app.image(this.upRight, x*16,y*16);
                }
                if (this.lines.get(y)[x].equals("3")) {
                    app.image(this.upLeft, x*16,y*16);
                }
                if (this.lines.get(y)[x].equals("7")) {

                    for (Fruit f : fruitList){
                        if (((f.getX() + 4)/16) == x & ((f.getY() + 5)/16) == y & f.eaten == false) {
                            app.image(this.fruit, x*16,y*16);
                        } 
                    }
                }
                if (this.lines.get(y)[x].equals("8")) {

                    for (superFruit f : superFruitList){
                        if (((f.getX() + 4)/16) == x & ((f.getY() + 5)/16) == y & f.eaten == false) {
                            app.image(this.superFruit, x*16,y*16);
                        } 
                    }
                }
                if (this.lines.get(y)[x].equals("s")) {
                    for (soda s : sodaList){
                        if (((s.getX() + 4)/16) == x & ((s.getY() + 5)/16) == y & s.eaten == false) {
                            app.image(this.soda, x*16,y*16);
                        } 
                    }
                }
            }
        }
    }
}

