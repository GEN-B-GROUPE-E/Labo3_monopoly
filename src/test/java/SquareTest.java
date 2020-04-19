package test.java;

import monopoly.squares.*;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class SquareTest {
    @Test
    void squaresShouldBeNamedCorrectly() {
        assertEquals("Square 1", new RegularSquare(1).toString());
    }

    @Test
    void squareGoShouldBeNamedCorrectly() {
        assertEquals("Go", new GoSquare(0).toString());
    }

    @Test
    void squaresShouldNotBeOutOfBounds() {
        assertAll(
                () -> assertThrows(IllegalArgumentException.class, () -> new RegularSquare(-1)),
                () -> assertThrows(IllegalArgumentException.class, () -> new RegularSquare(40))
        );
    }
}
