package monopoly;

import monopoly.squares.Square;

import java.util.List;
import static java.lang.Math.min;

public class Player {

    private String name;
    private List<Die> dice;
    private Board board;
    private int cash;
    private Square currentLocation;



    public Player(int id, List<Die> dice, Board board){
        if(id < 0){
            throw new IllegalArgumentException("Invalid id for Player");
        }
        this.name = "Player"+id;
        this.dice = dice;
        this.board = board;
        this.cash = 0;
        this.currentLocation = board.getInitialLocation();
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
        System.out.println(String.format("%s est sur %s", this, currentLocation));
        System.out.println(String.format("%s lance le dé et fait %d", this, total));

        // calculate new square destination
        Square destination = board.getSquare(currentLocation, total);

        // set player to new square position
        setLocation(destination);
        System.out.println(String.format("%s se déplace sur %s", this, currentLocation));
        destination.landedOn(this);       // it 2
    }

    public void addCash(int amount){
        this.cash += amount;
        System.out.println(String.format("%s a reçu une somme de %d$", this, amount));
    }

    public void reduceCash(int worth){
        this.cash -= min(200, worth/10);
        System.out.println(String.format("%s a payé une taxe de %d", this, min(200, worth/10)));

    }

    public int getNetWorth(){
        return this.cash;
    }

    public Square getLocation(){
        return this.currentLocation;
    }

    public void setLocation(Square newLocation){
        this.currentLocation = newLocation;
    }


    @Override
    public String toString() {
        return name;
    }
}


