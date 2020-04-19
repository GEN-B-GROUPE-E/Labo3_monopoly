package monopoly.squares;

import monopoly.Board;
import monopoly.Player;

public class GoToJailSquare extends Square{

    private Square jail;

    public GoToJailSquare(int id, Board board){
        super(id);
        this.name = "Go-To-Jail";
        this.jail = board.getJailSquare();
    }

    @Override
    public void landedOn(Player player) {
        player.setLocation(jail);
        System.out.println(String.format("%s va à la case Jail", player));
    }
}
