import monopoly.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    @Test
    public void takeTurnShouldChangePlayerPosition() {

        Board board = new Board();
        List<Die> dice = new ArrayList<>();
        for (int idxDie = 0; idxDie < 2; ++idxDie) {
            dice.add(new Die());
        }

        Player player = new Player(1, dice, board);

        Square beforeTakeTurn = player.getPiece().getCurrentPosition();
        player.takeTurn();
        Square afterTakeTurn = player.getPiece().getCurrentPosition();

        assertNotSame(beforeTakeTurn, afterTakeTurn);
    }


}