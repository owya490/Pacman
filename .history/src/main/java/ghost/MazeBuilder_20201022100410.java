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
    private PImage Vertical;

    public MazeBuilder() {
        this.downLeft = this.loadImage("../../resources/downLeft.png");
        this.downRight = this.loadImage("src/main/resources/downRight.png");
        this.horizontal = this.loadImage("src/main/resources/horizontal.png");
        this.upLeft = this.loadImage("src/main/resources/upLeft.png");
        this.upRight = this.loadImage("src/main/resources/upRight.png");
        this.Vertical = this.loadImage("src/main/resources/Vertical.png");
        this.lines = fileReader.readLines("../../../map.txt");
    }





    public void draw() {

    }


}

