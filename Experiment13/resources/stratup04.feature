# Created by wdellw at 2020/5/29
Feature: start to play
  As a player,
  I want to move my Pacman around on the board;
  So that I can earn all points and win the game.

  Scenario: Player wins, extends S2.1
    Given the game has started five,
    When  I have eaten the last pellet;
    Then  I win the game.
