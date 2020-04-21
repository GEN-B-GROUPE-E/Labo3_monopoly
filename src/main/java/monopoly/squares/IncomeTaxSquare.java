package monopoly.squares;

import monopoly.Player;

import static java.lang.Math.min;

public class IncomeTaxSquare extends Square {

    private final int MINIMAL_TAX = 200;
    private final int MINIMAL_PERCENTAGE = 10;

    public IncomeTaxSquare(int id){
        super(id);
        this.name = "Income-Tax";
    }

    @Override
    public void landedOn(Player player) {
        int worth = player.getNetWorth();
        player.reduceCash(min(MINIMAL_TAX, worth/MINIMAL_PERCENTAGE));
    }
}
