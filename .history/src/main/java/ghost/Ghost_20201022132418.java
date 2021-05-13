package ghost;
import processing.core.PApplet;
import processing.core.PImage;
import java.util.*;
import java.io.*;
import org.json.simple.JSONArray; 
import org.json.simple.JSONObject; 
public class Ghost {

    public int x;
    public int y;

    public PImage ghost;
    public JSONArray modeLengths;

    public Ghost(int x, int y, PImage ghost, JSONArray modeLengths){
        this.ghost = ghost;
        this.modeLengths = modeLengths;
    }

    public void draw (PApplet app) {
        app.image(this.ghost, x, y);
        
    }

}