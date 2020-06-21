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

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class startup02 {
    private Launcher launcher;
    private Player player;
    private Square square;
    private Square nextSquare;


    public Game getgame(){
        return launcher.getGame();
    }

    @Given("the game has started3,")
    public void the_game_has_started3() {
        launcher = new Launcher();
        launcher.withMapFile("/simplemap02.txt");
        launcher.launch();
        getgame().start();
        assertThat(getgame().isInProgress()).isTrue();//判断游戏是否运行
    }


    @Given("my Pacman is next to a cell containing a wall;")
    public void my_Pacman_is_next_to_a_cell_containing_a_wall() {
        List<Player> players = getgame().getPlayers();
        player = players.get(0);
        square = player.getSquare();
        nextSquare = square.getSquareAt(Direction.WEST);

        List<Unit> units = nextSquare.getOccupants();
        assertThat(units.size()).isEqualTo(0);//判断有没有对象



    }

    @When("I press an arrow key towards that cell;")
    public void i_press_an_arrow_key_towards_that_cell() {
        getgame().move(player,Direction.WEST);//向墙移动
    }

    @Then("the move is not conducted.")
    public void the_move_is_not_conducted() {
        assertThat(player.getSquare()).isEqualTo(square);
        assertThat(square.getOccupants()).containsExactly(player);//移动失败
        assertThat(nextSquare.getOccupants()).doesNotContain(player);
    }



}
