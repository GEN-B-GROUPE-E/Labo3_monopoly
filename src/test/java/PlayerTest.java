import monopoly.*;

import monopoly.squares.Square;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    private Board board;
    private Cup cup;
    private Player player;

    @BeforeEach
    public void init(){
        board = new Board();
        cup = new Cup(2);
        player = new Player(1, cup, board);
    }


    @RepeatedTest(50)
    public void takeTurnShouldChangePlayerPosition() {
        Square beforeTakeTurn = player.getLocation();
        int upperBound = player.getLocation().getId()+12;
        int lowerBound = player.getLocation().getId()+2;
        player.takeTurn();
        Square afterTakeTurn = player.getLocation();

        boolean looped = beforeTakeTurn.getId()>afterTakeTurn.getId();
        if(looped)
        {
            assertAll(
                    () -> assertTrue(afterTakeTurn.getId()+40>= lowerBound),
                    () -> assertTrue(afterTakeTurn.getId()+40<= upperBound)
            );
        }
        else
        {
            assertAll(
                    () -> assertTrue(afterTakeTurn.getId()>=lowerBound),
                    () -> assertTrue(afterTakeTurn.getId()<=upperBound)
            );
        }

    }

    @Test
    public void checkPlayerName(){
        assertEquals(player.toString(), "Player1");
    }

    @Test
    public void checkPlayerId(){
        assertThrows(IllegalArgumentException.class, ()-> new Player(-1, cup, board));
    }

    @Test
    public void checkMove(){
        Square square = board.getSquare(board.getInitialLocation(), 10);
        player.setLocation(square);

        assertSame(player.getLocation(), square);
    }
}