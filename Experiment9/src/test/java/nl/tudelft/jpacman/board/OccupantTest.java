package nl.tudelft.jpacman.board;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Test suite to confirm that {@link Unit}s correctly (de)occupy squares.
 *
 * @author Jeroen Roosen 
 *
 */
class OccupantTest {

    /**
     * The unit under test.
     */
    private Unit unit;

    /**
     * Resets the unit under test.
     */
    @BeforeEach
    void setUp() {
        unit = new BasicUnit();
    }

    /**
     * Asserts that a unit has no square to start with.
     */
    @DisplayName("该单位没有")
    @Test
    void noStartSquare() {
        // Remove the following placeholder:
        assertThat(unit).isNotNull();
        assertThat(unit.hasSquare()).isFalse();
    }

    /**
     * Tests that the unit indeed has the target square as its base after
     * occupation.
     */
    @DisplayName("占领")
    @Test
    void testOccupy() {
        // Remove the following placeholder:
        assertThat(unit).isNotNull();
        Square square = new BasicSquare();
        unit.occupy(square);

        assertThat(unit.getSquare()).isEqualTo(square);
        assertThat(square.getOccupants()).contains(unit);
    }

    /**
     * Test that the unit indeed has the target square as its base after
     * double occupation.
     */
    @DisplayName("重新占领")
    @Test
    void testReoccupy() {
        // Remove the following placeholder:
        assertThat(unit).isNotNull();
        Square square = new BasicSquare();
        unit.occupy(square);
        unit.occupy(square);
        assertThat(unit.getSquare()).isEqualTo(square);
        assertThat(square.getOccupants()).contains(unit).containsOnlyOnce(unit);
    }
}
