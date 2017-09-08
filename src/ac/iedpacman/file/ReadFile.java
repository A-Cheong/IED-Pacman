package ac.iedpacman.file;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class ReadFile {

    private String path;

    // passing in the name of the file
    public ReadFile(String file_path) {
        path = file_path;
    }

    // String[] will contain the lines read
    public String[] openFile() throws IOException {

        FileReader fr = new FileReader(path); // reads bytes from a text file
        BufferedReader commandReader = new BufferedReader(fr); // passing fr to Bufferedreader to read a whole line

        int numberOfLines = readLines();
        String[] commands = new String[numberOfLines];

        // adding each line/command to the array
        for (int i=0; i<numberOfLines; i++){
            commands[i] = commandReader.readLine();
        }

        commandReader.close();
        return commands;
    }

    // return the number of lines in the file
    public int readLines() throws IOException {

        FileReader fileToRead = new FileReader(path);
        BufferedReader bf = new BufferedReader(fileToRead);

        String aLine;
        int numberOfLines = 0;

        while (( aLine = bf.readLine()) != null) {
            numberOfLines++;
        }
        bf.close();

        return numberOfLines;
    }
}
