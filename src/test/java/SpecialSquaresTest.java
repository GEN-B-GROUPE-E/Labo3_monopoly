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
    void init(){
        board = new Board();
        cup = new Cup(2);
        player = new Player(1, cup, board);
    }

    @Test
    void playerShouldGet200OnGoSquare(){
        player.addCash(1500);
        int playerMoneyBeforeGoSquare = player.getNetWorth();
        Square destination = new GoSquare(0);
        destination.landedOn(player);
        int playerMoneyAfterGoSquare = player.getNetWorth();

        assertEquals(playerMoneyBeforeGoSquare + 200, playerMoneyAfterGoSquare);
    }

    @Test
    void goSquareShouldBeNamedCorrectly() {
        assertEquals("Go", new GoSquare(0).toString());
    }

    @Test
    void playerShouldPayTaxOnIncomeTaxSquare(){
        player.addCash(1500);
        int playerMoneyBeforeIncomeTaxSquare = player.getNetWorth();
        Square destination = new IncomeTaxSquare(4);
        destination.landedOn(player);
        int playerMoneyAfterIncomeTaxSquare = player.getNetWorth();

        assertEquals(playerMoneyBeforeIncomeTaxSquare - 150, playerMoneyAfterIncomeTaxSquare);
    }

    @Test
    void incomeTaxSquareShouldBeNamedCorrectly() {
        assertEquals("Income-Tax", new IncomeTaxSquare(4).toString());
    }

    @Test
    void playerShouldGotToJailOnGoToJailSquare(){
        Square destination = new GoToJailSquare(30, board);
        destination.landedOn(player);

        assertSame(player.getLocation(), board.getJailSquare());
    }

    @Test
    void goToJailSquareShouldBeNamedCorrectly() {
        assertEquals("Go-To-Jail", new GoToJailSquare(30, board).toString());
    }

    @Test
    void jailSquareShouldBeNamedCorrectly() {
        assertEquals("Jail", new JailSquare(10).toString());
    }

    @Test
    void getJailSquareAndgetInitialSquareShouldReturnASquare(){
        assertAll(
                () -> assertNotNull(board.getJailSquare()),
                () -> assertNotNull(board.getInitialLocation())
        );
    }




}
