package test.java;

import monopoly.Square;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class TestSquare {
    @Test
    void squaresShouldBeNamedCorrectly() {
        assertEquals("Square 1", new Square(0).toString());
    }

    @Test
    void squaresShouldNotTakeNegativeID() {
        assertThrows(IllegalArgumentException.class, () -> new Square(-1));
    }
}
