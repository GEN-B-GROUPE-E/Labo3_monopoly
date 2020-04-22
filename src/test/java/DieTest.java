import monopoly.Die;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DieTest {

    Die die = new Die();

    @RepeatedTest(50)
    void rollDieShouldGiveBetween1And6() {
        die.roll();
        assertFalse(die.getFaceValue() < 0 && die.getFaceValue() > 6);
    }
}
