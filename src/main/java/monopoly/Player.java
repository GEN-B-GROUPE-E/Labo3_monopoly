package monopoly;

public class Player {

    private String name;
    private Piece piece;
    private Die die;
    private Board board;


    public Player(String name, Piece piece){
        this.name = name;
        this.piece = piece;
    }

    /**
     * @brief : player takes turn : rolls dice, finds new location for its piece and moves it to the right destination
     * */
    public void takeTurn(){
        // roll dice twice
        int faceValue1 = die.getFaceValue();
        int faceValue2 = die.getFaceValue();
        // calculate new square destination
        Square destination = board.getLocation(piece.getCurrentPosition() , faceValue1 + faceValue2);
        // set piece to new square position
        piece.move(destination);
    }


}


