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

        Boolean pacmanPlaced = false;
        Boolean commandRun = true;

        while(commandRun)
        {
        System.out.println(pacman.getxPosition());
        System.out.println(pacman.getyPosition());
        System.out.println(pacman.getFacing());

            try {
                // getting the input stream from user in the command line
                BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Please enter coordinates to place Pacman");
                String placement = userInput.readLine();

                // using split() as StringTokenizer is a legacy class
                // regex to split on a space (based off of whitespace regex)
                // string can still get first command regardless of splitting with regex

                String[] splitInput = placement.split("\\s+");

                if ((Objects.equals(splitInput[0], new String("PLACE")))) {
                    String[] splitCoordinates = splitInput[1].split(",");

                    int xPos = Integer.parseInt(splitCoordinates[0]);
                    int yPos = Integer.parseInt(splitCoordinates[1]);
                    String direction = splitCoordinates[2];

                    if (validateCoordinates(xPos) && validateCoordinates(yPos) && validateDirection(direction)) {
                        pacman.setxPosition(xPos);
                        pacman.setyPosition(yPos);
                        pacman.setFacing(direction);

                        pacmanPlaced = true;

                    } else {
                        System.out.println("Please enter proper number (between 0 to 5), or direction.");
                    }
                } else if (pacmanPlaced && ((Objects.equals(splitInput[0], new String("MOVE"))))) {
                    movePacmanForward(pacman.getFacing());

                } else {
                    System.out.println("Incorrect command, please try placing Pacman first.");
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }

    }

    public boolean movePacmanForward(String direction)
    {
        int tempY;
        int tempX;

        switch(direction) {
            case "WEST":
                tempY = pacman.getyPosition();
                tempY--;
                if (validateCoordinates(--tempY)) {
                    pacman.setyPosition(tempY);
                }
                break;
            case "SOUTH":
                tempX = pacman.getyPosition();
                tempX--;
                pacman.setyPosition(tempX);
                break;
            case "EAST":
                tempY = pacman.getyPosition();
                tempY++;
                pacman.setyPosition(tempY);
                break;
            case "NORTH":
                tempX = pacman.getyPosition();
                tempX++;
                pacman.setyPosition(tempX);
                break;
            default:
                throw new IllegalArgumentException(direction + " is an invalid direction");
        }
        return false;
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
