import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nl.tudelft.jpacman.Launcher;
import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.board.Square;
import nl.tudelft.jpacman.board.Unit;
import nl.tudelft.jpacman.game.Game;
import nl.tudelft.jpacman.level.Pellet;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.sprite.Sprite;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class startup01 {
    private Launcher launcher;
    private Player player;
    private Square square;
    private Square nextsquare;
    private Pellet pellet;
    private int score;

    private Game getgame(){
        return launcher.getGame();
    }


    @Given("the game has started,")
    public void the_game_has_started() {
        launcher = new Launcher();
        launcher.withMapFile("/simplemap02.txt");//使用测试地图
        launcher.launch();
        getgame().start();
        assertThat(getgame().isInProgress()).isTrue();//判断游戏是否运行
    }

    @Given("my Pacman is next to an empty square;")
    public void my_Pacman_is_next_to_an_empty_square() {
        List<Player> players = getgame().getPlayers();
        player = players.get(0);//获取player对象
        score = player.getScore();//获取当前分数
        square = player.getSquare();
        nextsquare = square.getSquareAt(Direction.EAST);//获取相邻的square对象

        List<Unit> units = nextsquare.getOccupants();//获取占领相邻对象的集合
        assertThat(units.size()).isEqualTo(0);//判断该集合是否为0，为零说明square上没有东西即空square


    }

    @When("I press an arrow key towards that square;")
    public void i_press_an_arrow_key_towards_that_square() {
        //assertThat(player.hasSquare()).isTrue();
        getgame().move(player,Direction.EAST);

    }

    @Then("my Pacman can move to that square")
    public void my_Pacman_can_move_to_that_square() {
      //  assertThat(player.hasSquare()).isTrue();
        assertThat(player.getSquare()).isEqualTo(nextsquare);

    }

    @Then("my points remain the same.")
    public void my_points_remain_the_same() {

        assertThat(nextsquare.getOccupants()).containsOnly(player);
        assertThat(player.getScore()).isEqualTo(score);

    }





}
