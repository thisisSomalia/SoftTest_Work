Feature: start to play
  As a player,
  I want to move my Pacman around on the board;
  So that I can earn all points and win the game.

  Scenario: The move fails
    Given the game has started3,
    And my Pacman is next to a cell containing a wall;
    When  I press an arrow key towards that cell;
    Then  the move is not conducted.
