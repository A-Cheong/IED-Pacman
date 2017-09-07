package ac.iedpacman.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class UserCommands {

    Pacman pacman = new Pacman();

    public void playPacman()
    {
        Boolean pacmanPlaced = false; // for initial PLACE command
        Boolean commandRun = true;

        while(commandRun)
        {
            try {
                // getting the input stream from user in the command line
                BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Please enter your command: ");
                String placement = userInput.readLine();

                // using split() as StringTokenizer is a legacy class
                // regex to split on a space (based off of whitespace regex)
                // string can still get first command regardless of splitting with regex
                String[] splitInput = placement.split("\\s+");

                // first command to run is PLACE
                if ((Objects.equals(splitInput[0], new String("PLACE")))) {
                    String[] splitCoordinates = splitInput[1].split(",");

                    int xPos = Integer.parseInt(splitCoordinates[0]);
                    int yPos = Integer.parseInt(splitCoordinates[1]);
                    String direction = splitCoordinates[2];

                    // ensure that the coordinates given match the required board dimensions
                    if (validateCoordinates(xPos) && validateCoordinates(yPos) && validateDirection(direction)) {
                        pacman.setxPosition(xPos);
                        pacman.setyPosition(yPos);
                        pacman.setFacing(direction);

                        pacmanPlaced = true;
                    } else {
                        System.out.println("Please enter proper number (between 0 to 5), or direction.");
                    }
                    // method to move pacman forward
                } else if (pacmanPlaced && ((Objects.equals(splitInput[0], new String("MOVE"))))) {
                    if(movePacmanForward(pacman.getFacing())) {
                        System.out.println("Moved forward successfully");
                    }
                    else{
                        System.out.println("Out of bounds, please change directions and move again.");
                    }
                    // method to turn pacman left
                } else if (pacmanPlaced && ((Objects.equals(splitInput[0], new String("LEFT"))))){
                        movePacmanLeft(pacman.getFacing());
                    // method to turn pacman right
                } else if (pacmanPlaced && ((Objects.equals(splitInput[0], new String("RIGHT"))))){
                        movePacmanRight(pacman.getFacing());
                    // method to report the current status of pacman
                } else if (pacmanPlaced && ((Objects.equals(splitInput[0], new String("REPORT"))))){
                    reportCoordinates();
                    // method to exit back to the main menu
                } else if (((Objects.equals(splitInput[0], new String("EXIT"))))){
                        commandRun = false;
                } else {
                    System.out.println("Incorrect command, please try placing Pacman first.");
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }

    }

    public void reportCoordinates(){
        System.out.println("X-Position is: " + pacman.getxPosition());
        System.out.println("Y-Position is: " + pacman.getyPosition());
        System.out.println("Direction is: " + pacman.getFacing());
    }

    public void movePacmanRight (String direction)
    {
        switch(direction) {
            case "WEST":
                pacman.setFacing("NORTH");
                break;
            case "SOUTH":
                pacman.setFacing("WEST");
                break;
            case "EAST":
                pacman.setFacing("SOUTH");
                break;
            case "NORTH":
                pacman.setFacing("EAST");
                break;
        }
    }

    public void movePacmanLeft (String direction)
    {
        switch(direction) {
            case "WEST":
                pacman.setFacing("SOUTH");
                break;
            case "SOUTH":
                pacman.setFacing("EAST");
                break;
            case "EAST":
                pacman.setFacing("NORTH");
                break;
            case "NORTH":
                pacman.setFacing("WEST");
                break;
        }
    }
    public boolean movePacmanForward(String direction)
    {
        int tempY;
        int tempX;

        switch(direction) {
            case "WEST":

                tempY = pacman.getyPosition();
                if (validateCoordinates(--tempY)) {
                    pacman.setyPosition(tempY);
                    return true;
                }
                else {
                    return false;
                }

            case "SOUTH":

                tempX = pacman.getxPosition();
                if (validateCoordinates(--tempX)) {
                    pacman.setxPosition(tempX);
                    return true;
                }
                else{
                    return false;
                }

            case "EAST":

                tempY = pacman.getyPosition();
                if (validateCoordinates(++tempY)) {
                    pacman.setyPosition(tempY);
                    return true;
                }
                else{
                    return false;
                }

            case "NORTH":

                tempX = pacman.getxPosition();
                if (validateCoordinates(++tempX)) {
                    pacman.setxPosition(tempX);
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

    // for viewing purposes
    public void showBoard()
    {
        char gameBoard[][] = new char[5][5];
        Board board  = new Board();

        board.initialiseBoard(gameBoard);
    }
}
