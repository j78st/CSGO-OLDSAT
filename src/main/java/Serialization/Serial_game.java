package Serialization;

import Partie.*;

import java.util.ArrayList;

public class Serial_game {
    public Player player;
    public ArrayList<Room> map;
    public ArrayList<Enigma> enigmas;
    public ArrayList<Action> actions;
    public ArrayList<Gear> gears;
    public ArrayList<Text_scenario> scenario;
    public int difficulty;
    public int timer;

    public Serial_game() {
        player = Game.player;
        map = Game.map;
        enigmas = Game.enigmas;
        actions = Game.actions;
        gears = Game.gears;
        scenario = Game.scenario;
        difficulty = Game.difficulty;
        this.timer = Game.timer;
    }

    public Game createGameFromMemory() {
        Game game = new Game();
        game.player = player;
        game.map = map;
        game.enigmas = enigmas;
        game.actions = actions;
        game.gears = gears;
        game.scenario = scenario;
        game.difficulty = difficulty;
        game.timer = timer;
        return game;
    }
}
