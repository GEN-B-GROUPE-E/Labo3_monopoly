package monopoly.squares;

import monopoly.Player;

public class GoSquare extends Square {

    private static final int CASH_GIVEN_ON_GOSQUARE = 200;

    public GoSquare(int id){
        super(id);
        this.name = "Go";
    }

    @Override
    public void landedOn(Player player) {
        player.addCash(CASH_GIVEN_ON_GOSQUARE);
    }

}
