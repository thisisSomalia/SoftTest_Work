# Created by wdellw at 2020/5/29
Feature: start to play
  As a player,
  I want to move my Pacman around on the board;
  So that I can earn all points and win the game.

  Scenario: The player moves on empty square
    Given the game has started,
    And my Pacman is next to an empty square;
    When  I press an arrow key towards that square;
    Then  my Pacman can move to that square
    And my points remain the same.
