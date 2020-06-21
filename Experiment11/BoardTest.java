package nl.tudelft.jpacman.board;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class BoardTest {
    private static final int MAX_WIDTH = 4;
    private static final int MAX_HEIGHt = 5;

    private static Square[][] squares = {
        { mock(Square.class), mock(Square.class), mock(Square.class), mock(Square.class), mock(Square.class) },
        { mock(Square.class), mock(Square.class), mock(Square.class), mock(Square.class), mock(Square.class) },
        { mock(Square.class), mock(Square.class), mock(Square.class), mock(Square.class), mock(Square.class) },
        { mock(Square.class), mock(Square.class), mock(Square.class), mock(Square.class), mock(Square.class) },
    };
    private static final Board board = new Board(squares);
    @Test
    void testwidthandheight(){
        assertThat(board.getHeight()).isEqualTo(MAX_HEIGHt);
        assertThat(board.getWidth()).isEqualTo(MAX_WIDTH);
    }

    @DisplayName("边界值测试用例")
    @ParameterizedTest
    @CsvSource({
        "2,0,true",
        "2,1,true",
        "2,3,true",
        "2,4,true",
        "2,5,false",
        "0,3,true",
        "1,3,true",
        "3,3,true",
        "4,3,false"
    })
    void withinBorders(int x, int y, boolean result) {
        assertThat(board.withinBorders(x ,y)).isEqualTo(result);
    }
}
