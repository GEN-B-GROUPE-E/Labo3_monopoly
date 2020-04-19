package monopoly;

import monopoly.Player;

public class Square {
    private String name;
    private int id;

    public Square(int id){
        if(id < 0 || id >= 40)
        {
            throw new IllegalArgumentException("Id should be between 0 and 39");
        }
        this.id = id;
        name = (id == 0) ? "GO" : "Square "+ (id);
    }

    public int getId(){
        return id;
    }

    @Override
    public String toString() {
        return name;
    }
}