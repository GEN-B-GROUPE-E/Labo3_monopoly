package monopoly;

import monopoly.squares.*;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private final static int NB_CASE = 40;
    private final static int GO_CASE_ID = 0;
    private final static int INCOME_TAX_CASE_ID = 4;
    private final static int GO_TO_JAIL_CASE_ID = 30;
    private final static int JAIL_CASE_ID = 10;

    private List<Square> board = new ArrayList<>(NB_CASE);

    public Board(){
        for(int i = 0 ; i < NB_CASE; i++){
            switch(i){
                case GO_CASE_ID :
                    board.add(new GoSquare(i));
                    break;
                case INCOME_TAX_CASE_ID :
                    board.add(new IncomeTaxSquare(i));
                    break;
                case JAIL_CASE_ID :
                    board.add(new JailSquare(i));
                    break;
                case GO_TO_JAIL_CASE_ID :
                    board.add(new GoToJailSquare(i, this));
                    break;
                default :
                    board.add(new RegularSquare(i));
            }
        }
    }

    public Square getInitialLocation(){
        return board.get(GO_CASE_ID);
    }
    public Square getSquare(int id)
    {
        return board.get(id);
    }
    public Square getSquare(Square oldLocation, int diceTotal){
        return board.get((oldLocation.getId() + diceTotal) % NB_CASE);
    }
    public Square getJailSquare(){
        return board.get(JAIL_CASE_ID);
    }
}
