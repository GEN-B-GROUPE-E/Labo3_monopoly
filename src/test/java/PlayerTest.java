import monopoly.*;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    @RepeatedTest(50)
    public void takeTurnShouldChangePlayerPosition() {

        Board board = new Board();
        List<Die> dice = new ArrayList<>();
        for (int idxDie = 0; idxDie < 2; ++idxDie) {
            dice.add(new Die());
        }

        Player player = new Player(1, dice, board);

        Square beforeTakeTurn = player.getPiece().getCurrentPosition();
        int upperBound = player.getPiece().getCurrentPosition().getId()+12;
        int lowerBound = player.getPiece().getCurrentPosition().getId()+2;
        player.takeTurn();
        Square afterTakeTurn = player.getPiece().getCurrentPosition();

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


}