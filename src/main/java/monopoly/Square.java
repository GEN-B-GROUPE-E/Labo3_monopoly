package monopoly;

public class Square {
    private String name;
    private int id;
    //private static int nextId=1;

    public Square(int id){
        this.id = id;
        name = "Square"+ (id + 1);
    }
    public int getId(){
        return id;
    }

}