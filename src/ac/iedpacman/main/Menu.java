package ac.iedpacman.main;
import ac.iedpacman.file.ReadFile;
import ac.iedpacman.user.UserCommands;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Menu
{
    // bulk of menu code credited to Charles
    public void runMenu() throws IOException {
        Scanner scanner = new Scanner(System.in);
        int response = -1;
        do {
            displayMenu();

            while (!scanner.hasNextInt()) {
                displayMenu();
                System.out.print("Enter selection: ");
            }
            response = Integer.parseInt(scanner.nextLine());
            selectMenuItem(response, scanner);
        }
        while (response != 0);
    }

    public void selectMenuItem(int response, Scanner scanner) throws IOException {

        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
        UserCommands commandsToExecute = new UserCommands();

        switch (response) {
            case 0:
                System.out.println("You are now exiting the system.");
                break;

            case 1:
                commandsToExecute.playPacman(null, false);
                break;

            case 2:
                System.out.println("Please enter text file name: ");
                String file_name = userInput.readLine();

                // attempt to look into the file and add the commands to commands[]
                // if so the parse that array into playPacman()
                try {
                    ReadFile file = new ReadFile(file_name);
                    String[] commands = file.openFile();
                    commandsToExecute.playPacman(commands,true);
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
                break;

            default:
                System.out.println("Invalid selection, please try again.\n");
                break;
        }
    }

    public void displayMenu() {
        String menuTitle = "Pacman Simulation";
        System.out.printf("******************** %S "
                + "********************\n\n", menuTitle);

        System.out.println("1. Read in Commands");
        System.out.println("2. Read in file");

        System.out.printf("0. Exit\n");
        System.out.println("********************************"
                + "***************************\n\n");

        System.out.println("Enter selection: ");
    }
}
