import monopoly.squares.Square;
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
        initialSquare = board.getInitialLocation();
        lastSquare = board.getSquare(initialSquare, 39 );
    }

    @Test
    void initialSquareShouldBe0(){
        assertEquals(initialSquare.getId(), 0);
    }

    @Test
    void squareAddingShouldWork() {

        Square firstMoveSquare = board.getSquare(initialSquare, 10);
        Square secondMoveSquare = board.getSquare(initialSquare, 10);

        // Simple check we get the good square
        assertSame(firstMoveSquare, secondMoveSquare);


    }

    @Test
    void squaresShouldLoop() {
        Square moveSquare = board.getSquare(initialSquare, 42);

        // Check that when we have reach the end of the board, we come back to the first squares.
        assertSame(moveSquare, board.getSquare(initialSquare, 2));
    }
}