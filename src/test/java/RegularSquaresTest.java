package test.java;

import monopoly.squares.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RegularSquaresTest {

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,5,6,7,8,9,11,12,13,14,15,16,17,18,19,
                        20,21,22,23,24,25,26,27,28,29,31,32,33,34,35,36,37,38,39})
    void regularSquaresShouldBeNamedCorrectly(int index){
        assertEquals("Square " + index, new RegularSquare(index).toString());
    }

    @Test
    void squaresShouldNotBeOutOfBounds() {
        assertAll(
                () -> assertThrows(IllegalArgumentException.class, () -> new RegularSquare(-1)),
                () -> assertThrows(IllegalArgumentException.class, () -> new RegularSquare(40))
        );
    }

}
