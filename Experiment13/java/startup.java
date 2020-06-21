import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nl.tudelft.jpacman.Launcher;
import nl.tudelft.jpacman.board.BoardFactory;
import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.board.Square;
import nl.tudelft.jpacman.board.Unit;
import nl.tudelft.jpacman.game.Game;
import nl.tudelft.jpacman.level.Pellet;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.sprite.Sprite;

import org.junit.jupiter.api.AfterEach;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class startup {
    private Launcher launcher;
    private Player player;
    private Square square;
    private Square nextsquare;
    private Pellet pellet;
    private int score;

    private Game getgame(){
        return launcher.getGame();
    }



    @Given("the game has started1,")
    public void the_game_has_started1() {
        launcher = new Launcher();
        launcher.withMapFile("/simplemap.txt");
        launcher.launch();

        getgame().start();
        assertThat(getgame().isInProgress()).isTrue();
    }

    @Given("my Pacman is next to a square containing a pellet1;")
    public void my_Pacman_is_next_to_a_square_containing_a_pellet1() {
        List<Player> players = getgame().getPlayers();
        player = players.get(0);
        score = player.getScore();
        square = player.getSquare();
        nextsquare = square.getSquareAt(Direction.EAST);


        List<Unit> units = nextsquare.getOccupants();
        pellet = (Pellet)units.get(0);

        assertThat(units.size()).isEqualTo(1);
        assertThat(units.get(0)).isInstanceOf(Pellet.class);
    }

    @When("I press an arrow key towards that square1;")
    public void i_press_an_arrow_key_towards_that_square1() {
        getgame().move(player, Direction.EAST);
    }

    @Then("my Pacman can move to that square1,")
    public void my_Pacman_can_move_to_that_square1() {
        assertThat(player.getSquare()).isEqualTo(nextsquare);
    }

    @Then("I earn the points for the pellet1,")
    public void i_earn_the_points_for_the_pellet1() {
        assertThat(score).isEqualTo(0);
        assertThat(player.getScore()).isEqualTo(10);
    }

    @Then("the pellet disappears from that square1.")
    public void the_pellet_disappears_from_that_square1() {
        assertThat(nextsquare.getOccupants()).containsExactly(player).doesNotContain(pellet);
    }






//
//    @Given("the game has started2,")
//    public void the_game_has_started2() {
//        launcher = new Launcher();
//        launcher.launch();
//        launcher.withMapFile("simplem02.txt");
//        getgame().start();
//        assertThat(getgame().isInProgress()).isTrue();
//    }
//
//    @Given("my Pacman is next to an empty square2;")
//    public void my_Pacman_is_next_to_an_empty_square2() {
//        List<Player> players = getgame().getPlayers();
//        player = players.get(0);
//        square = player.getSquare();
//        nextsquare = square.getSquareAt(Direction.WEST);
//
//        List<Unit> units = nextsquare.getOccupants();
//
//        assertThat(units.get(0)).isInstanceOf(Sprite.class);
//
//
//    }
//
//    @When("I press an arrow key towards that square2;")
//    public void i_press_an_arrow_key_towards_that_square2() {
//        getgame().move(player,Direction.WEST);
//    }
//
//    @Then("my Pacman can move to that square2")
//    public void my_Pacman_can_move_to_that_square2() {
//        assertThat(player.getSquare()).isEqualTo(nextsquare);
//    }
//
//    @Then("my points remain the same2.")
//    public void my_points_remain_the_same2() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//
//
//
//
//
//
//
//    @Given("the game has started3,")
//    public void the_game_has_started3() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//
//    @Given("my Pacman is next to a cell containing a wall3;")
//    public void my_Pacman_is_next_to_a_cell_containing_a_wall3() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//
//    @When("I press an arrow key towards that cell3;")
//    public void i_press_an_arrow_key_towards_that_cell3() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//
//    @Then("the move is not conducted3.")
//    public void the_move_is_not_conducted3() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//
//
//
//
//
//    @Given("the game has started4,")
//    public void the_game_has_started4() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//
//    @Given("my Pacman is next to a cell containing a ghost4;")
//    public void my_Pacman_is_next_to_a_cell_containing_a_ghost4() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//
//    @When("I press an arrow key towards that square4;")
//    public void i_press_an_arrow_key_towards_that_square4() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//
//    @Then("my Pacman dies4,")
//    public void my_Pacman_dies4() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//
//    @Then("the game is over4.")
//    public void the_game_is_over4() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//
//
//
//
//
//    @Given("the game has started5,")
//    public void the_game_has_started5() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//
//    @When("I have eaten the last pellet5;")
//    public void i_have_eaten_the_last_pellet5() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//
//    @Then("I win the game5.")
//    public void i_win_the_game5() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }

}
