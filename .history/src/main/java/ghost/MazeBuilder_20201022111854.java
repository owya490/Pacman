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

    public MazeBuilder(PImage downLeft, PImage downRight, PImage horizontal, PImage upLeft, PImage upRight, PImage vertical) {
        this.downLeft = downLeft;
        this.downRight = downRight;
        this.horizontal = horizontal;
        this.upLeft = upLeft;
        this.upRight = upRight;
        this.Vertical = vertical;
        this.lines = fileReader.readLines("../../../map.txt");
    }





    public void draw() {

    }


}

