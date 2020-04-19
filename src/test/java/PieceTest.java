package test.java;

import main.java.Piece;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PieceTest {
    @Test
    public void piecesShouldHaveNames() {
        assertEquals(new Piece("Plane").toString(), "Plane");
    }

}