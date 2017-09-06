package ac.iedpacman.main;

public class Board {

    public Board()
    {

    }

    public void initialiseBoard(char board[][]){

        // cycle through rows from end to start
        // for x we gradually decrease from left to right
        for (int x = board.length; x >= 0; x--) {
            //for y we gradually increase from left to right
            for (int y = 0; y <= board.length; y++) {
                System.out.print("(" + x + "," + y + ") | ");
            }
            System.out.println("");
        }
    }
}
