package ghost;
import java.util.*;
import java.io.*;

public class Fruit{
    public boolean eaten = false;

    public int x;
    public int y;

    public Fruit(int x, int y) {
        this.x = x - 4;
        this.y = y - 5;
    }
}