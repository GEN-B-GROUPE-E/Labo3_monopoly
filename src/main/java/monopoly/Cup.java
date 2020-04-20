package monopoly;

import monopoly.squares.Square;

import java.util.ArrayList;
import java.util.List;

public class Cup {

    private List<Die> cup;
    private int total = 0;

    public Cup(int nbDice){
        cup = new ArrayList<>(nbDice);
        for(int i = 0; i < nbDice; i++){
            cup.add(new Die());
        }
    }

    public void rollCup(){
        total = 0;
        for(Die d : cup){
            d.roll();
            total += d.getFaceValue();
        }
    }

    public int getTotal(){return total;}

}
