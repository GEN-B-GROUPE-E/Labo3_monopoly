package test;


import static org.junit.jupiter.api.Assertions.assertTrue;
import monopoly.Square;
import org.junit.jupiter.api.Test;

class TestBoard {

    @Test
    void getLocation() {
        monopoly.Board board = new monopoly.Board();
        Square initalSquare= new Square(0);
        Square firstMoveSquare = new Square(9);
        Square secondMoveSquare = new Square(1);
        Square firstMoveSquareVerif = board.getLocation(initalSquare, 9);
        Square secondMoveSquareVerif = board.getLocation(secondMoveSquare, 40);
        // simple check we get the good square
        assertTrue(firstMoveSquareVerif.getId() == firstMoveSquare.getId());
        // check that when we reach the end of the board we get the first squares we move from (square 40 + 1 => Square 1)
        assertTrue(secondMoveSquareVerif.getId() == secondMoveSquare.getId());
        assertTrue(false);

    }
}