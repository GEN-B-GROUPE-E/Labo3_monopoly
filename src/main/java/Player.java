package main.java;

public class Player {

    private String name;
    //private Piece piece;
    // ref to dice
    // ref to board


    public Player(String name){
        this.name = name;
        //this.piece = piece;
    }

    /**
     * @brief : player takes turn : rolls dice, finds new location for its piece and moves it to the right destination
     * */
    public void takeTurn(){
        // unsigned faceValue = dice.rolls();
        // assuming Board is an array of Squares and each Square has a coordonate value (int x for ex.)
        // Square destination = board.[piece.getCurrentSquare().getCoord() + faceValue]
        // setCurrentPosition(destination);
    }
}


