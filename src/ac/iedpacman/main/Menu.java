package ac.iedpacman.main;
import java.io.IOException;
import java.util.Scanner;

public class Menu
{

    public void runMenu() throws IOException
    {
        Scanner scanner = new Scanner(System.in);
        int response = -1;

        do
        {
            displayMenu();

            while (!scanner.hasNextInt())
            {
                displayMenu();
                System.out.print("Enter selection: ");
            }
            response = Integer.parseInt(scanner.nextLine());

            selectMenuItem(response, scanner);

        }
        while (response != 0);

    }

    public void selectMenuItem(int response, Scanner scanner) throws IOException
    {

        switch (response)

        {
            case 0:

                System.out.println("You are now exiting the system.");
                break;

            case 1:

                UserCommands input = new UserCommands();
                input.showBoard();
                input.playPacman();
                break;
            case 2:

                System.out.println("case 2");

                break;

            default:

                System.out.println("Invalid selection, please try again.\n");
                break;
        }
    }

    public void displayMenu()
    {
        String menuTitle = "Pacman Simulation";
        System.out.printf("******************** %S "
                + "********************\n\n", menuTitle);

        System.out.println("1. Read in Commands");
        System.out.println("2. Read in file");

        System.out.printf("0. Exit\n");
        System.out.println("********************************"
                + "******************************************\n\n");

        System.out.println("Enter selection: ");
    }
}
