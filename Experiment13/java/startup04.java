import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nl.tudelft.jpacman.Launcher;
import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.board.Square;
import nl.tudelft.jpacman.board.Unit;
import nl.tudelft.jpacman.game.Game;
import nl.tudelft.jpacman.level.Level;
import nl.tudelft.jpacman.level.Pellet;
import nl.tudelft.jpacman.level.Player;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class startup04 {
    private Launcher launcher;
    private Player player;
    private Pellet pellet;
    private Level level;
    private Square nextSquare;

    public Game getGame(){
        return launcher.getGame();
    }

    @Given("the game has started five,")
    public void theGameHasStarted() {
        launcher = new Launcher();
        launcher.withMapFile("/simplemap04.txt");
        launcher.launch();
        getGame().start();
        level = getGame().getLevel();
        assertThat(getGame().isInProgress()).isTrue();
    }

    @When("I have eaten the last pellet;")
    public void iHaveEatenTheLastPellet() {
        List<Player> players = getGame().getPlayers();
        player = players.get(0);
        Square square = player.getSquare();
        nextSquare = square.getSquareAt(Direction.EAST);
        List<Unit> units = nextSquare.getOccupants();
        pellet = (Pellet)units.get(0);

        assertThat(units.size()).isEqualTo(1);
        assertThat(units.get(0)).isInstanceOf(Pellet.class);

        getGame().move(player,Direction.EAST);


    }

    @Then("I win the game.")
    public void iWinTheGame() {
        assertThat(level.remainingPellets()).isEqualTo(0);
        assertThat(getGame().isInProgress()).isFalse();
    }
}
