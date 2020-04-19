package monopoly;

import java.security.InvalidParameterException;

public class Piece {

    private String name;
    private Square currentPosition;

    public Piece(int num, Square currentPosition){
        if(num < 0){
            throw new IllegalArgumentException("Invalid id for Piece");
        }
        this.name = "Piece"+num;
        this.currentPosition = currentPosition;
    }

    public Square getCurrentPosition(){
        return currentPosition;
    }

    public void move(Square newPosition){
        this.currentPosition = newPosition;
    }

    @Override
    public String toString() {
        return name;
    }
}
