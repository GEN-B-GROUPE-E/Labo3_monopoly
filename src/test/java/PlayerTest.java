import monopoly.*;

import monopoly.squares.Square;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    private Board board;
    private Cup cup;
    private Player player;

    @BeforeEach
    void init(){
        board = new Board();
        cup = new Cup(2);
        player = new Player(1, cup, board);
    }

    @RepeatedTest(50)
    void takeTurnShouldChangePlayerPosition() {
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
    void checkPlayerName(){
        assertEquals(player.toString(), "Player1");
    }

    @Test
    void checkPlayerId(){
        assertThrows(IllegalArgumentException.class, ()-> new Player(-1, cup, board));
    }

    @Test
    void setLocationShouldChangePlayerLocation(){
        Square square = board.getSquare(board.getInitialLocation(), 10);
        player.setLocation(square);

        assertSame(player.getLocation(), square);
    }

    @Test
    void getLocationShouldReturnASquare(){
        Square square = board.getSquare(board.getInitialLocation(), 10);
        player.setLocation(square);

        assertNotNull(player.getLocation());
    }

    @ParameterizedTest
    @ValueSource(ints = {1500, 200})
    void addCashShouldAddRightAmountToPlayerWorth(int amount){
        int playerWorthBeforeAddCash = player.getNetWorth();
        player.addCash(amount);
        int playerWorthAfterAddCash = player.getNetWorth();
        assertEquals(playerWorthBeforeAddCash + amount, playerWorthAfterAddCash);
    }

    @ParameterizedTest
    @ValueSource(ints = {200, 500, 700})
    void reduceCashShouldSubtractRightAmountFromPlayerWorth(int amount){
        player.addCash(1500);
        int playerWorthBeforeReduceCash = player.getNetWorth();
        player.reduceCash(amount);
        int playerWorthAfterReduceCash = player.getNetWorth();
        assertEquals(playerWorthBeforeReduceCash - amount, playerWorthAfterReduceCash);
    }
}