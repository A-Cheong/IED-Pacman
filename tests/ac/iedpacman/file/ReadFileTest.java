package ac.iedpacman.file;

import org.junit.Test;
import static org.junit.Assert.*;

public class ReadFileTest {

    ReadFile file = new ReadFile("TEST4.txt");

    @Test
    public void openFile() throws Exception {
        String commands[] = file.openFile();
        assertEquals("MOVE", commands[1]);
    }
    @Test
    public void readLines() throws Exception {
        assertEquals(15, file.readLines());
    }

}