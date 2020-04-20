import monopoly.squares.*;
import monopoly.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SpecialSquaresTest {

    private Board board;
    private Cup cup;
    private Player player;

    @BeforeEach
    public void init(){
        board = new Board();
        cup = new Cup(2);
        player = new Player(1, cup, board);
    }

    @Test
    public void playerShouldGet200OnGoSquare(){
        player.addCash(1500);
        int playerMoneyBeforeGoSquare = player.getNetWorth();
        Square destination = new GoSquare(0);
        destination.landedOn(player);
        int playerMoneyAfterGoSquare = player.getNetWorth();

        assertEquals(playerMoneyBeforeGoSquare + 200, playerMoneyAfterGoSquare);
    }

    @Test
    public void playerShouldPayTaxOnIncomeTaxSquare(){
        player.addCash(1500);
        int playerMoneyBeforeIncomeTaxSquare = player.getNetWorth();
        Square destination = new IncomeTaxSquare(4);
        destination.landedOn(player);
        int playerMoneyAfterIncomeTaxSquare = player.getNetWorth();

        assertEquals(playerMoneyBeforeIncomeTaxSquare - 150, playerMoneyAfterIncomeTaxSquare);
    }

    @Test
    public void playerShouldGotToJailOnGoToJailSquare(){
        Square destination = new GoToJailSquare(30, board);
        destination.landedOn(player);

        assertSame(player.getLocation(), board.getJailSquare());
    }

}
