import monopoly.MonopolyGame;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class MonopolyGameTest {


    @Test
    public void gameShouldEndInReasonableTime()
    {
        MonopolyGame game = new MonopolyGame(4);
        assertTimeout(Duration.ofSeconds(15000), game::playGame);
    }
}
