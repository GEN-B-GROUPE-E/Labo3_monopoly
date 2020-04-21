package monopoly.squares;

import monopoly.Player;

public class RegularSquare extends Square{

    public RegularSquare(int id){
        super(id);
        this.name = "Square "+ (id);
    }

    @Override
    public void landedOn(Player player) {/*does nothing*/}
}
