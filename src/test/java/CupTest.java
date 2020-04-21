import monopoly.Die;
import monopoly.Cup;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.assertFalse;

class CupTest {

    @RepeatedTest(50)
    void totalFromCupShouldBeBetween2And12() {
        Cup cup = new Cup(2);
        cup.rollCup();

        assertFalse(cup.getTotal() < 2 && cup.getTotal() > 12);
    }
}
