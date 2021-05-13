package ghost;
import processing.core.PApplet;
import processing.core.PImage;
import java.util.*;
import java.io.*;
public class Player {
    public int x;
    public int y;

    // public int x_f;
    // public int y;

    public int xvel = 0;
    public int yvel = 0;

    public int lives;
    public int speed;

    public PImage playerClosed;
    public PImage playerDown;
    public PImage playerLeft;
    public PImage playerRight;
    public PImage playerUp;

    public boolean openMouth;
    public char input = 'd';

    public boolean[][] path;

    public int direction = 1;
    public String[][] map;
    public int wanted_direction = 1;



    public Player(String[][] map, boolean[][] path, int lives, int speed, String filename, PImage playerClosed, PImage playerDown, PImage playerLeft, PImage playerRight, PImage playerUp) {
        this.x = (findPlayerStart.findx(filename))*16 +8;
        this.y = (findPlayerStart.findy(filename))*16 +8;
        this.playerClosed = playerClosed;
        this.playerDown = playerDown;
        this.playerLeft = playerLeft;
        this.playerRight = playerRight;
        this.playerUp = playerUp;
        this.lives = lives;
        this.speed = speed;
        this.path = path;
        this.map = map;
    }

    public void tick(char input) {
        this.input = input;
        if (this.input == 'w') {
            // this.yvel = -speed;
            // this.xvel =0;
            this.wanted_direction = 4;
            // if (!collide(this.map, this.direction)) {
            //     this.yvel = -speed;
            //     this.xvel =0;
            // }

        }
        if (input == 'a') {
            //System.out.println("a");
            // this.xvel = -speed;
            // this.yvel =0;
            this.wanted_direction = 2;

        }
        if (input == 's') {
            //System.out.println("s");
            // this.yvel = speed;
            // this.xvel =0;
            this.wanted_direction = 3;

        }
        if (input == 'd') {
            //System.out.println("d");
            // this.xvel = speed;
            // this.yvel =0;
            this.wanted_direction = 1;
        }
        if (input == ' ') {
            this.xvel = 0;
            this.yvel = 0;
        }


        if (this.direction == 1) {
            if (collide(this.map, this.wanted_direction)) {
                if (collide(this.map, this.direction)) {
                    if (this.x % 16 == 8){
                        this.xvel = 0;
                    }
                }
            } else {
                //System.out.println("here");
                this.direction = this.wanted_direction;
                if (this.direction == 1) {
                    this.xvel = speed;
                    this.yvel =0;
                }
                if (this.direction == 2) {
                    this.xvel = -speed;
                    this.yvel =0;
                }
                if (this.direction == 3) {
                    this.xvel =0;
                    this.yvel =speed;
                }
                if (this.direction == 4) {
                    this.xvel = 0;
                    this.yvel = -speed;
                }
            }
        }
        if (this.direction == 2) {
            if (collide(this.map, this.wanted_direction)) {
                if (collide(this.map, this.direction)) {
                    if (this.x % 16 == 8){
                        this.xvel = 0;
                    }
                }
            } else {
                //System.out.println("here");
                this.direction = this.wanted_direction;
                if (this.direction == 1) {
                    this.xvel = speed;
                    this.yvel =0;
                }
                if (this.direction == 2) {
                    System.out.println("here");
                    this.xvel = -speed;
                    this.yvel =0;
                }
                if (this.direction == 3) {
                    this.xvel =0;
                    this.yvel =speed;
                }
                if (this.direction == 4) {
                    this.xvel = 0;
                    this.yvel = -speed;
                }
            }
        }
        if (this.direction == 3) {
            if (collide(this.map, this.wanted_direction)) {
                if (collide(this.map, this.direction)) {
                    if (this.y % 16 == 8){
                        this.yvel = 0;
                    }
                }
            } else {
                //System.out.println("here");
                this.direction = this.wanted_direction;
                if (this.direction == 1) {
                    this.xvel = speed;
                    this.yvel =0;
                }
                if (this.direction == 2) {
                    this.xvel = -speed;
                    this.yvel =0;
                }
                if (this.direction == 3) {
                    this.xvel =0;
                    this.yvel =speed;
                }
                if (this.direction == 4) {
                    this.xvel = 0;
                    this.yvel = -speed;
                }
            }
        }
        if (this.direction == 4) {
            if (collide(this.map, this.wanted_direction)) {
                if (collide(this.map, this.direction)) {
                    if (this.y % 16 == 8){
                        this.yvel = 0;
                    }
                }
            } else {
                //System.out.println("here");
                this.direction = this.wanted_direction;
                if (this.direction == 1) {
                    this.xvel = speed;
                    this.yvel =0;
                }
                if (this.direction == 2) {
                    this.xvel = -speed;
                    this.yvel =0;
                }
                if (this.direction == 3) {
                    this.xvel =0;
                    this.yvel =speed;
                }
                if (this.direction == 4) {
                    this.xvel = 0;
                    this.yvel = -speed;
                }
            }
        }

        // if (collide(this.map, this.wanted_direction) {
        //     if (collide(this.map, this.direction) {
        //         if(this.y )
        //     }
        // }





        // if (collide(this.map, this.wanted_direction) {
        //     if (collide(this.map, this.prev_direction)) {
        //         if (this.y % 16 == 8){
        //             this.yvel = 0;
        //     }
        // }

        // if (!collide(this.map, this.direction) {
        //     //System.out.println(this.prev_direction);
        //     this.x += this.xvel;
        //     this.y += this.yvel;
        // }
        // this.prev_direction = this.direction;

        // //collide(this.map, this.direction);
        // // this.x += this.xvel;
        // // this.y += this.yvel;
        


        // // System.out.println(this.x);
        // // System.out.println(this.y);

        // // System.out.println(this.x + this.xvel);
        // // System.out.println(this.y + this.yvel);
        // // //System.out.println(path[0][0]);
        // // System.out.println(path[this.y += this.yvel][this.x += this.xvel]);

        // // if (path[this.y + this.yvel][this.x + this.xvel] == true) {
        // //     this.x += this.xvel;
        // //     this.y += this.yvel;
        // // } else {
        // //     this.xvel = 0;
        // //     this.yvel = 0;
        // // }
        this.x += this.xvel;
        this.y += this.yvel;
    }

    public void draw(PApplet app) {
        if (this.openMouth && this.input =='w') {
            app.image(this.playerUp, x-12 , y-13);
        } 
        else if (this.openMouth && this.input =='a') {
            app.image(this.playerLeft, x-12 , y-13);
        } 
        else if (this.openMouth && this.input =='s') {
            app.image(this.playerDown, x-12 , y-13);
        } 
        else if (this.openMouth && this.input =='d') {
            app.image(this.playerRight, x-12 , y-13);
        } 
        
        else {
            app.image(this.playerClosed, x-12 , y-13);

        }

        //System.out.println(this.x);
        //System.out.println(this.y-5);

    }

    public void openMouth(boolean open){
        this.openMouth = open;
    }
    public boolean collide(String[][] map, int d){
        int[] c = new int[10];
        c[0] = this.y/ 16;
        c[1] = this.x/ 16;

        c[2] = (this.y - 8)/ 16;
        c[3] = (this.x - 6)/ 16;

        c[4] = (this.y - 7)/ 16;
        c[5] = (this.x + 8)/ 16;

        c[6] = (this.y + 7)/ 16;
        c[7] = (this.x + 8)/ 16;

        c[8] = (this.y + 7)/ 16;
        c[9] = (this.x - 4)/ 16;
        
        
        if (d == 1){
            //String next = map[][14];
            String next = map[c[0]][c[1]+1];
            String next1 = map[c[4]][c[5]+1];
            String next2 = map[c[6]][c[7]+1];
            if ((next.equals("2") | next.equals("3") | next.equals("4") | next.equals("5") | next.equals("6") | next.equals("1")) | (next1.equals("2") | next1.equals("3") | next1.equals("4") | next1.equals("5") | next1.equals("6") | next1.equals("1")) | (next2.equals("2") | next2.equals("3") | next2.equals("4") | next2.equals("5") | next2.equals("6") | next2.equals("1"))){
                // if (next1.equals("2") | next1.equals("3") | next1.equals("4") | next1.equals("5") | next1.equals("6") | next1.equals("1")){
                //     if (next2.equals("2") | next2.equals("3") | next2.equals("4") | next2.equals("5") | next2.equals("6") | next2.equals("1")){
                if (this.x % 16 == 8){
                    //this.xvel = 0;
                    return true;
                }
                // if (this.x % 16 == 8){
                //     //this.xvel = 0;
                //     return true;
                // }
            }
        } 
        else if (d == 2){
            String next = map[c[0]][c[1]-1];
            String next1 = map[c[2]][c[3]-1];
            String next2 = map[c[8]][c[9]-1];
            if ((next.equals("2") | next.equals("3") | next.equals("4") | next.equals("5") | next.equals("6") | next.equals("1")) | (next1.equals("2") | next1.equals("3") | next1.equals("4") | next1.equals("5") | next1.equals("6") | next1.equals("1")) | (next2.equals("2") | next2.equals("3") | next2.equals("4") | next2.equals("5") | next2.equals("6") | next2.equals("1"))){
                if (this.x % 16 == 8){
                    //this.xvel = 0;
                    return true;
                }
            }
        } else if (d == 3){
            String next = map[c[0]+1][c[1]];
            String next1 = map[c[2]+1][c[3]];
            String next2 = map[c[4]+1][c[5]];
            if ((next.equals("2") | next.equals("3") | next.equals("4") | next.equals("5") | next.equals("6") | next.equals("1")) | (next1.equals("2") | next1.equals("3") | next1.equals("4") | next1.equals("5") | next1.equals("6") | next1.equals("1")) | (next2.equals("2") | next2.equals("3") | next2.equals("4") | next2.equals("5") | next2.equals("6") | next2.equals("1"))){
                if (this.y % 16 == 8){
                    //this.yvel = 0;
                    return true;
                }
            }
        } else if (d == 4){
            String next = map[c[0]-1][c[1]];
            if (next.equals("2") | next.equals("3") | next.equals("4") | next.equals("5") | next.equals("6") | next.equals("1")){
                if (this.y % 16 == 8){
                    //this.yvel = 0;
                    return true;
                }
                
            }
        }

        return false;
    }



}