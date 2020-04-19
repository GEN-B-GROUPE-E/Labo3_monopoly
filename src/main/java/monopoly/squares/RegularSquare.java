package monopoly.squares;

import monopoly.Player;

public class RegularSquare extends Square{

    private int id;

    public RegularSquare(int id){
        super(id);
        this.name = "Square "+ (id);
    }

    @Override
    public void landedOn(Player player) { }
}
