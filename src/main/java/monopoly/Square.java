package monopoly;

public class Square {
    private String name;
    private int id;

    public Square(int id){
        if(id < 0 || id >= 40)
        {
            throw new IllegalArgumentException("Id should be strictly positive");
        }
        this.id = id;
        name = "Square "+ (id + 1);
    }

    public int getId(){
        return id;
    }

    @Override
    public String toString() {
        return name;
    }
}