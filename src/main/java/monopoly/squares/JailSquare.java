package monopoly.squares;

import monopoly.Player;

public class JailSquare extends Square {

    public JailSquare(int id){
        super(id);
        this.name = "Jail";
    }

    @Override
    public void landedOn(Player player) {/*does nothing at this stage*/}
}
