package monopoly;

import java.util.List;

public class Player {

    private String name;
    private Piece piece;
    private List<Die> dice;
    private Board board;


    public Player(int id, List<Die> dice, Board board){
        if(id < 0){
            throw new IllegalArgumentException("Invalid id for Piece");
        }
        this.name = "Player"+id;
        this.piece =  new Piece( id, board.getInitalLocation());
        this.dice = dice;
        this.board = board;
    }

    /**
     * @brief : player takes turn : rolls dice, finds new location for its piece and moves it to the right destination
     * */
    public void takeTurn(){
        int total=0;
        // roll dice twice
        for(Die die : dice){
            die.roll();
            total += die.getFaceValue();
        }
        System.out.println(String.format("%s est sur %s", this, piece.getCurrentPosition()));
        System.out.println(String.format("%s lance le dé et fait %d", this, total));

        // calculate new square destination
        Square destination = board.getSquare(piece.getCurrentPosition(), total);

        // set piece to new square position
        piece.move(destination);
        System.out.println(String.format("%s se déplace sur %s", this, piece.getCurrentPosition()));
    }

    public Piece getPiece(){
        return this.piece;
    }

    @Override
    public String toString() {
        return name;
    }
}


