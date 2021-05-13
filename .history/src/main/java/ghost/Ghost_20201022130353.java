package ghost;
import processing.core.PApplet;
import processing.core.PImage;
import java.util.*;
import java.io.*;
import org.json.simple.JSONArray; 
import org.json.simple.JSONObject; 
public class Ghost {

    public PImage ghost;
    public JSONArray modeLengths;

    public Ghost(PImage ghost, JSONArray modeLengths){
        this.ghost = ghost;
        this.modeLengths = modeLengths;
    }

}