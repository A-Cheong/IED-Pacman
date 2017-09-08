package ac.iedpacman.main;

import java.util.Arrays;
import java.util.List;

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

    public void movePacmanRight (String direction)
    {
        switch(direction) {
            case "WEST":
                setFacing("NORTH");
                break;
            case "SOUTH":
                setFacing("WEST");
                break;
            case "EAST":
                setFacing("SOUTH");
                break;
            case "NORTH":
                setFacing("EAST");
                break;
        }
    }

    public void movePacmanLeft (String direction)
    {
        switch(direction) {
            case "WEST":
                setFacing("SOUTH");
                break;
            case "SOUTH":
                setFacing("EAST");
                break;
            case "EAST":
                setFacing("NORTH");
                break;
            case "NORTH":
                setFacing("WEST");
                break;
        }
    }

    public boolean movePacmanForward(String direction)
    {
        int tempY;
        int tempX;

        switch(direction) {
            case "WEST":
                tempY = getyPosition();
                if (validateCoordinates(--tempY)) {
                    setyPosition(tempY);
                    return true;
                }
                else {
                    return false;
                }

            case "SOUTH":
                tempX = getxPosition();
                if (validateCoordinates(--tempX)) {
                    setxPosition(tempX);
                    return true;
                }
                else{
                    return false;
                }

            case "EAST":
                tempY = getyPosition();
                if (validateCoordinates(++tempY)) {
                    setyPosition(tempY);
                    return true;
                }
                else{
                    return false;
                }

            case "NORTH":
                tempX = getxPosition();
                if (validateCoordinates(++tempX)) {
                    setxPosition(tempX);
                    return true;
                }
                else{
                    return false;
                }

            default:
                throw new IllegalArgumentException(direction + " is an invalid direction");
        }
    }

    public boolean validateCoordinates (int coordinate)
    {
        return (coordinate >=0 && coordinate <=5);
    }

    public boolean validateDirection (String facing)
    {
        final String[] directions = new String[] {"WEST","EAST","SOUTH","NORTH"};

        // convert String Array to List
        List<String> list = Arrays.asList(directions);

        if(list.contains(facing))
        {
            return true;
        }
        else
        {
            return false;
        }
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
