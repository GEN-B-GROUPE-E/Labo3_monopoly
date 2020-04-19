import monopoly.Die;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestDie {
    @Test
    void roll() {
        boolean isValueOutOfBound = false;
        Die die = new Die();
        die.roll();

        for(int i = 0 ; i < 1000; ++i){
            die.roll();
            if(die.getFaceValue() <0 && die.getFaceValue() > 6 ){
                isValueOutOfBound = true;
                break;
            }
        }
        assertFalse(isValueOutOfBound);
    }
}
