import monopoly.Board;
import monopoly.Piece;
import monopoly.Square;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PieceTest {
    private Board board;
    @BeforeEach
    public void init(){
        board = new Board();
    }

    @Test
    public void checkName(){
        Piece piece = new Piece(1, board.getInitalLocation());
        assertEquals(piece.toString(), "Piece1");
    }

    @Test
    public void checkId(){
        assertThrows(IllegalArgumentException.class, ()-> new Piece(-1, board.getInitalLocation()));
    }

    @Test
    public void checkMove(){
        Piece piece = new Piece(0, board.getInitalLocation());
        Square square = board.getSquare(board.getInitalLocation(), 10);
        piece.move(square);

        assertSame(piece.getCurrentPosition(), square);
    }
}