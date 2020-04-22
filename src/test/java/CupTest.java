import monopoly.Cup;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertFalse;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CupTest {

    Cup cup = new Cup(2);

    @RepeatedTest(50)
    void totalFromCupShouldBeBetween2And12() {
        cup.rollCup();

        assertFalse(cup.getTotal() < 2 && cup.getTotal() > 12);
    }
}
