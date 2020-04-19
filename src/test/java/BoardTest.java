import monopoly.Square;
import monopoly.Board;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    private Board board;
    private Square initialSquare;
    private Square lastSquare;

    @BeforeEach
    void initBoardAndSquare(){
        board = new Board();
        initialSquare = board.getInitalLocation();
        lastSquare = board.getSquare(initialSquare, 39 );
    }
    @Test
    void getLocation() {

        Square firstMoveSquare = board.getSquare(initialSquare, 10);
        Square secondMoveSquare = board.getSquare(initialSquare, 10);
        Square thirdMoveSquare = board.getSquare(firstMoveSquare, 30);

        // Simple check we get the good square
        assertSame(firstMoveSquare, secondMoveSquare);

        // Check that when we have reach the end of the board, we come back to the first squares.
        assertSame(thirdMoveSquare, initialSquare);
    }

    @Test
    public void itShouldWork() {

        assertEquals(true, true);
    }

}