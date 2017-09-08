package ac.iedpacman.user;

import ac.iedpacman.main.Board;
import ac.iedpacman.main.Pacman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class UserCommands {

    Pacman pacman = new Pacman(0 ,0, "");

    public void playPacman(String fileCommands[], boolean fileToRead)
    {
        Boolean pacmanPlaced = false; // for initial PLACE command
        Boolean commandRun = true;
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
        int commandNumber = 0;
        String placement = "";

        while(commandRun)
        {
            try {
                // if there is no file to read then ask user for input
                if(!fileToRead) {
                    System.out.println("Please enter your command: ");
                     placement = userInput.readLine();
                }
                else{
                    // read the amount of commands in the file, if none then exit
                    if (commandNumber < fileCommands.length) {
                        placement = fileCommands[commandNumber];
                        commandNumber++;
                    }
                    else {
                        break;
                    }
                }
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
                    if (pacman.validateCoordinates(xPos) && pacman.validateCoordinates(yPos)
                            && pacman.validateDirection(direction)) {
                        pacman.setxPosition(xPos);
                        pacman.setyPosition(yPos);
                        pacman.setFacing(direction);

                        pacmanPlaced = true;
                    } else {
                        System.out.println("Please enter proper number (between 0 to 5), or direction.");
                    }
                    // method to move pacman forward
                } else if (pacmanPlaced && ((Objects.equals(splitInput[0], new String("MOVE"))))) {
                    if(pacman.movePacmanForward(pacman.getFacing())) {
                    }
                    else{
                        System.out.println("Out of bounds, please change directions and move again.");
                    }
                    // method to turn pacman left
                } else if (pacmanPlaced && ((Objects.equals(splitInput[0], new String("LEFT"))))){
                        pacman.movePacmanLeft(pacman.getFacing());
                    // method to turn pacman right
                } else if (pacmanPlaced && ((Objects.equals(splitInput[0], new String("RIGHT"))))){
                        pacman.movePacmanRight(pacman.getFacing());
                    // method to report the current status of pacman
                } else if (pacmanPlaced && ((Objects.equals(splitInput[0], new String("REPORT"))))){
                    reportCoordinates();
                    // method to exit back to the main menu
                } else if (((Objects.equals(splitInput[0], new String("EXIT"))))){
                        commandRun = false;
                } else {
                    System.out.println("Unknown command.");
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

    // for viewing purposes
    public void showBoard()
    {
        char gameBoard[][] = new char[5][5];
        Board board  = new Board();

        board.initialiseBoard(gameBoard);
    }
}
