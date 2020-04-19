package main.java.monopoly;

public class Piece {

    private String name;
    private Square currentPosition;

    public Piece(String name, Square currentPosition){
        this.name = name;
        this.currentPosition = currentPosition;
    }


    public Square getCurrentPosition(){
        return currentPosition;
    }

    public void move(Square newPosition){
        this.currentPosition = newPosition;
    }

}
