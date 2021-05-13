package ghost;
import java.util.*;
import java.io.*;

import processing.core.*;
import processing.core.PApplet;
import processing.core.PImage;

public class MazeBuilder extends PApplet{
    private ArrayList<String[]> lines;

    private static final int WIDTH = 448;
    private static final int HEIGHT = 576;

    public PImage downLeft;
    private PImage downRight;
    private PImage horizontal;
    public PImage upLeft;
    public PImage upRight;
    private PImage vertical;
    private PImage fruit;

    public MazeBuilder(PImage downLeft, PImage downRight, PImage horizontal, PImage upLeft, PImage upRight, PImage vertical, PImage fruit) {
        this.downLeft = downLeft;
        this.downRight = downRight;
        this.horizontal = horizontal;
        this.upLeft = upLeft;
        this.upRight = upRight;
        this.vertical = vertical;
        this.fruit = fruit;
        this.lines = fileReader.readLines("../../../map.txt");
    }





    public void draw(PApplet app) {
        for (int y = 0; y < this.lines.size(); y ++) {
            for (int x = 0; x < this.lines.get(y).length; x ++) {
                if (this.lines.get(y)[x].equals("0")) {
                    continue;
                }
                if (this.lines.get(y)[x].equals("6")) {
                    image(this.downRight, x*16,y*16);
                }
                if (this.lines.get(y)[x].equals("1")) {
                    image(this.horizontal, x*16,y*16);
                }
                if (this.lines.get(y)[x].equals("5")) {
                    image(this.downLeft, x*16,y*16);
                }
                if (this.lines.get(y)[x].equals("2")) {
                    image(this.vertical, x*16,y*16);
                }
                if (this.lines.get(y)[x].equals("4")) {
                    image(this.upRight, x*16,y*16);
                }
                if (this.lines.get(y)[x].equals("3")) {
                    image(this.upLeft, x*16,y*16);
                }

                // if (this.lines.get(y)[x].equals("g")) {
                //     image(this.ghost, x*16,(y*16)-4);
                // }
                // if (this.lines.get(y)[x].equals("p")) {
                //     image(this.playerClosed, x*16,(y*16)-4);
                // }
                if (this.lines.get(y)[x].equals("7")) {
                    image(this.fruit, x*16,y*16);
                }
            }
        }

    }


}
