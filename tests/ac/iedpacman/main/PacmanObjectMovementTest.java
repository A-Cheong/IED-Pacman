package ac.iedpacman.main;

import org.junit.Test;

import static org.junit.Assert.*;

public class PacmanObjectMovementTest {

    private Pacman pacman = new Pacman(3, 5 , "NORTH");

    @Test
    public void testTurningRight() throws Exception {
        pacman.movePacmanRight(pacman.getFacing());
        assertEquals("EAST", pacman.getFacing());
    }
    @Test
    public void testTurningLeft() throws Exception {
        pacman.movePacmanLeft(pacman.getFacing());
        assertEquals("WEST", pacman.getFacing());
    }
    @Test
    public void testMovingForward() throws Exception {
        pacman.movePacmanForward(pacman.getFacing());
        assertEquals(4, pacman.getxPosition());
        assertEquals(5, pacman.getyPosition());
    }
    @Test
    public void testCorrectCoordinates() throws Exception {
        assertTrue(pacman.validateCoordinates(5));
        assertFalse(pacman.validateCoordinates(6));
    }
    @Test
    public void testDirectionExists() throws Exception {
        assertTrue(pacman.validateDirection("WEST"));
        assertFalse(pacman.validateDirection("BISCUIT"));
    }

}