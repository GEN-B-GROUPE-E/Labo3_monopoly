package monopoly.squares;

import monopoly.Player;

public class IncomeTaxSquare extends Square {

    public IncomeTaxSquare(int id){
        super(id);
        this.name = "Income-Tax";
    }

    @Override
    public void landedOn(Player player) {
        int worth = player.getNetWorth();
        player.reduceCash(worth);
    }
}
