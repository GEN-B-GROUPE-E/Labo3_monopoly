package monopoly;
import java.util.ArrayList;
import java.util.List;

public class Board {
    public final static int NB_CASE = 40;
    private List<Square> board = new ArrayList<>(NB_CASE);
    public Board(){
        for(int i = 0 ; i < NB_CASE; i++){
            board.add(new Square(i));
        }
    }
    public Square getLocation(Square oldLocation, int diceTotal){
        System.out.println((oldLocation.getId() + diceTotal) % NB_CASE);
        System.out.println(board.size());
        return board.get((oldLocation.getId() + diceTotal) % NB_CASE);
    }
}
