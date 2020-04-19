package test.java;

import monopoly.Square;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class SquareTest {
    @Test
    void squaresShouldBeNamedCorrectly() {
        assertEquals("Square 1", new Square(1).toString());
    }

    @Test
    void squareGoShouldBeNamedCorrectly() {
        assertEquals("GO", new Square(0).toString());
    }

    @Test
    void squaresShouldNotBeOutOfBounds() {
        assertAll(
                () -> assertThrows(IllegalArgumentException.class, () -> new Square(-1)),
                () -> assertThrows(IllegalArgumentException.class, () -> new Square(40))
        );
    }
}
