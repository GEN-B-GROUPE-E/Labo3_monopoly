import monopoly.*;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    private Board board;
    private List<Die> dice;
    private Player player;

    @BeforeEach
    public void init(){
        board = new Board();
        dice = new ArrayList<>();
        for (int idxDie = 0; idxDie < 2; ++idxDie) {
            dice.add(new Die());
        }

        player = new Player(1, dice, board);
    }


    @RepeatedTest(50)
    public void takeTurnShouldChangePlayerPosition() {
        Square beforeTakeTurn = player.getPiece().getLocation();
        int upperBound = player.getPiece().getLocation().getId()+12;
        int lowerBound = player.getPiece().getLocation().getId()+2;
        player.takeTurn();
        Square afterTakeTurn = player.getPiece().getLocation();

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
        assertThrows(IllegalArgumentException.class, ()-> new Player(-1, dice, board));
    }
}