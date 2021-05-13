package ghost;
import java.util.*;
import java.io.*;

import processing.core.*;
import processing.core.PApplet;
import processing.core.PImage;

public class MazeBuilder extends PApplet{
    private ArrayList<String[]> lines;
    private PImage downLeft;
    private PImage downRight;
    private PImage horizontal;
    private PImage upLeft;
    private PImage upRight;
    private PImage Vertical;

    public MazeBuilder() {
        this.downLeft = this.loadImage("src/main/resources/downLeft.png");
        this.downRight = this.loadImage("src/main/resources/downRight.png");
        this.horizontal = this.loadImage("src/main/resources/horizontal.png");
        this.upLeft = this.loadImage("src/main/resources/upLeft.png");
        this.upRight = this.loadImage("src/main/resources/upRight.png");
        this.Vertical = this.loadImage("src/main/resources/Vertical.png");

    }

    

    public void draw() {

    }


}

