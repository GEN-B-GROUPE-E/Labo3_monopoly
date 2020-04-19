package monopoly;

import java.util.ArrayList;
import java.util.List;

public class MonopolyGame {
    private static final int NB_TURNS = 20;
    private static final int NB_DICE = 2;
    private List<Player> players = new ArrayList<>();
    private List<Die> dice = new ArrayList<>();
    private Board board;

    public MonopolyGame(int nbPlayer) {
        board = new Board();
        if (nbPlayer > 8 || nbPlayer < 2) {
            throw new IllegalArgumentException("Le nombre de players ne peut être inférieur à 2 ou supérieur à 8");
        }

        for (int idxDie = 0; idxDie < NB_DICE; ++idxDie) {
            dice.add(new Die());
        }

        for (int i = 0; i < nbPlayer; ++i) {
            players.add(new Player(i + 1, dice, board));
        }
    }

    public void playGame() {
        for (int idxTurn = 0; idxTurn < NB_TURNS; ++idxTurn) {
            playRound();
            System.out.println("#####  FIN DE TOUR #####\n");
        }
        System.out.println("***** FIN DU JEU *****");
    }

    private void playRound() {
        for (Player player : players) {
            System.out.println(String.format("===> Au %s de jouer", player));
            player.takeTurn();
        }
    }
}
