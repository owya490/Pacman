public class Player {
    public int x;
    public int y;

    public int vel;

    public PImage playerClosed;
    public PImage playerDown;
    public PImage playerLeft;
    public PImage playerRight;
    public PImage playerUp;

    public Dino(String filename, PImage playerClosed, PImage playerDown, PImage playerLeft, PImage playerRight, PImage playerUp) {
        this.x = findPlayerStart.find(filename);
        this.y = findPlayerStart.findy(filename);
        this.playerClosed = playerClosed;
        this.playerDown = playerDown;
        this.playerLeft = playerLeft;
        this.playerRight = playerRight;
        this.playerUp = playerUp;
    }



}