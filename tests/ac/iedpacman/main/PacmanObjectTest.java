package ac.iedpacman.main;

import org.junit.Test;

import static org.junit.Assert.*;

public class PacmanObjectTest {
    private Pacman pacman = new Pacman(3, 5 , "NORTH");

    @Test
    public void testXPosition() throws Exception {
        assertEquals(3, pacman.getxPosition());
    }
    @Test
    public void testyPosition() throws Exception {
        assertEquals(5,pacman.getyPosition());
    }
    @Test
    public void testFacingDirection() throws Exception {
        assertEquals("NORTH", pacman.getFacing());
    }

}