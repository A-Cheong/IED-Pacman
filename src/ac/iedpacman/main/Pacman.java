package ac.iedpacman.main;

public class Pacman {

    // variables to hold pacmans current position and direction
    private int xPosition;
    private int yPosition;
    private String facing;

    public Pacman(int xPosition, int yPosition, String facing)
    {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.facing = facing;
    }

    // getters and setters
    public int getxPosition() {
        return xPosition;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public String getFacing() {
        return facing;
    }

    public void setFacing(String facing) {
        this.facing = facing;
    }
}
