import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nl.tudelft.jpacman.Launcher;
import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.board.Square;
import nl.tudelft.jpacman.board.Unit;
import nl.tudelft.jpacman.game.Game;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.npc.Ghost;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class startup03 {
    private Launcher launcher;
    private Player player;
    private Ghost ghost;
    private Square square;
    private Square nextSquare;



    public Game getGame(){
        return launcher.getGame();
    }


    @Given("the game has started four,")
    public void theGameHasStarted() {
        launcher = new Launcher();
        launcher.withMapFile("/simplemap03.txt");
        launcher.launch();
        getGame().start();
        assertThat(getGame().isInProgress()).isTrue();

    }

    @And("my Pacman is next to a cell containing a ghost;")
    public void myPacmanIsNextToACellContainingAGhost() {
        List<Player> players = getGame().getPlayers();
        player = players.get(0);
        square = player.getSquare();
        nextSquare = square.getSquareAt(Direction.EAST);

        List<Unit> units = nextSquare.getOccupants();
        ghost = (Ghost) units.get(0);

        assertThat(units.size()).isEqualTo(1);
        assertThat(units.get(0)).isInstanceOf(Ghost.class);//判断nextquare上是不是Ghost

    }

    @When("I press an arrow key towards that square four;")
    public void iPressAnArrowKeyTowardsThatSquare() {
        getGame().move(player,Direction.EAST);
    }

    @Then("my Pacman dies,")
    public void myPacmanDies() {

        assertThat(player.isAlive()).isFalse();
        assertThat(player.getKiller()).isEqualTo(ghost);

        assertThat(square.getOccupants()).doesNotContain(player);
    }

    @And("the game is over.")
    public void theGameIsOver() {
        assertThat(getGame().isInProgress()).isFalse();
        getGame().stop();

    }
}
