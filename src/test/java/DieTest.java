import monopoly.Die;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class DieTest {
    @RepeatedTest(50)
    void testRoll() {
        Die die = new Die();
        die.roll();
        assertFalse(die.getFaceValue() < 0 && die.getFaceValue() > 6);
    }
}
