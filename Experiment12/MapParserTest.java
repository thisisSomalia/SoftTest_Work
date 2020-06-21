package nl.tudelft.jpacman.level;

import com.google.common.base.Verify;
import nl.tudelft.jpacman.PacmanConfigurationException;
import nl.tudelft.jpacman.board.BoardFactory;
import nl.tudelft.jpacman.board.Square;
import nl.tudelft.jpacman.npc.Ghost;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MapParserTest {
    private MapParser mapParser;
    private final BoardFactory boardCreator = mock(BoardFactory.class);
    private final LevelFactory levelCreator = mock(LevelFactory.class);

    @BeforeEach
    void setMapParser(){
        mapParser=new MapParser(levelCreator, boardCreator);

        when(boardCreator.createWall()).thenReturn(mock(Square.class));
        when(boardCreator.createGround()).thenReturn(mock(Square.class));

        when(levelCreator.createGhost()).thenReturn(mock(Ghost.class));
        when(levelCreator.createPellet()).thenReturn(mock(Pellet.class));
    }

    @DisplayName("null")
    @Test
    void testnullname(){

        assertThatThrownBy(()->{
            mapParser.parseMap((String)null);
            }
        ).isInstanceOf(NullPointerException.class);
    }

    @DisplayName("文件名为空")
    @Test
    void testname(){
        assertThatThrownBy(()->{
            mapParser.parseMap("");
            }
        ).isInstanceOf(PacmanConfigurationException.class);
    }

    @DisplayName("地图文件是否存在")
    @Test
    void testfilenotexists(){
        String mapName = "/test.txt";
        assertThatThrownBy(()->{
            mapParser.parseMap(mapName);
        }).isInstanceOf(PacmanConfigurationException.class).hasMessage("Could not get resource for: " + mapName);
    }

    @DisplayName("地图文件存在并合法")
    @Test
    void testexists() throws IOException {
        String mapName = "/simplemap.txt";
            mapParser.parseMap(mapName);
            verify(boardCreator,times(4)).createGround();
            verify(boardCreator,times(2)).createWall();
    }
    @DisplayName("地图文件是否包含其他非法字符")
    @Test
    void testfilehasother() throws IOException {
        String mapName = "/simplemap01.txt";
        assertThatThrownBy(()->{
            mapParser.parseMap(mapName);
        }).isInstanceOf(PacmanConfigurationException.class)
            .hasMessage("Invalid character at 6,0: R");

    }

}
