import monopoly.MonopolyGame;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class MonopolyGameTest {

    @Test
    public void gameShouldHaveBetween2And8Players()
    {
        assertAll(
                () ->assertThrows(IllegalArgumentException.class, ()->new MonopolyGame(9)),
                () ->assertThrows(IllegalArgumentException.class, ()->new MonopolyGame(1))
        );
    }

    @Test
    public void gameShouldEndInReasonableTime()
    {
        MonopolyGame game = new MonopolyGame(4);
        assertTimeout(Duration.ofSeconds(20), game::playGame);
    }
}
