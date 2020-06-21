# Created by wdellw at 2020/5/29
Feature: start to play
  As a player,
  I want to move my Pacman around on the board;
  So that I can earn all points and win the game.

  Scenario: The player dies
    Given the game has started four,
    And my Pacman is next to a cell containing a ghost;
    When  I press an arrow key towards that square four;
    Then  my Pacman dies,
    And  the game is over.
