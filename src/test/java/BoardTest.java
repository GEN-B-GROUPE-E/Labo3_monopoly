import monopoly.squares.Square;
import monopoly.Board;
import monopoly.Cup;
import java.util.Random;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BoardTest {

    private Board board;
    private Square initialSquare;
    private Square lastSquare;
    private Random rand;

    @BeforeAll
    void initBoardAndSquare(){
        board = new Board();
        initialSquare = board.getInitialLocation();
        lastSquare = board.getSquare(initialSquare, 39 );

        rand = new Random();
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


    @RepeatedTest(50)
    void move() {
        Cup c = new Cup(2);
        c.rollCup();
        int total = c.getTotal();
        Square startSquare = board.getSquare(rand.nextInt(40));
        int upperBound = startSquare.getId()+12;
        int lowerBound = startSquare.getId()+2;
        Square endSquare = board.getSquare(startSquare, total);

        boolean looped = startSquare.getId()>endSquare.getId();
        if(looped)
        {
            assertAll(
                    () -> assertTrue(endSquare.getId()+40>= lowerBound),
                    () -> assertTrue(endSquare.getId()+40<= upperBound)
            );
        }
        else
        {
            assertAll(
                    () -> assertTrue(endSquare.getId()>=lowerBound),
                    () -> assertTrue(endSquare.getId()<=upperBound)
            );
        }

    }
}