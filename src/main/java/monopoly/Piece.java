package monopoly;

public class Piece {

    private String name;
    private Square currentPosition;

    public Piece(int id, Square currentPosition){
        this.name = "Piece"+id;
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
