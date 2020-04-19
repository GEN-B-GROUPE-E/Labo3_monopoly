import monopoly.*;
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

    @Test
    public void takeTurnShouldChangePlayerPosition() {

        Square beforeTakeTurn = player.getPiece().getCurrentPosition();
        player.takeTurn();
        Square afterTakeTurn = player.getPiece().getCurrentPosition();

        assertNotSame(beforeTakeTurn, afterTakeTurn);
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