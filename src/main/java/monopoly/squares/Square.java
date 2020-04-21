package monopoly.squares;

import monopoly.Player;

abstract public class Square {
    String name;
    private int id;

    public Square(int id){
        if(id < 0 || id >= 40)
        {
            throw new IllegalArgumentException("Id should be between 0 and 39");
        }
        this.id = id;
    }

    abstract public void landedOn(Player player);

    public int getId(){
        return id;
    }

    @Override
    public String toString() {
        return name;
    }
}