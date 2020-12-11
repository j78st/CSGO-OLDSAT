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

    public Serial_game(int dif, int timer) {
        player = Game.player;
        map = Game.map;
        enigmas = Game.enigmas;
        actions = Game.actions;
        gears = Game.gears;
        scenario = Game.scenario;
        difficulty = dif;
        this.timer = timer;
    }

    public void setGameFromMemory() {
        Game.player = player;
        Game.map = map;
        Game.enigmas = enigmas;
        Game.actions = actions;
        Game.gears = gears;
        Game.scenario = scenario;
        Game.difficulty = difficulty;
        Game.timer = timer;
    }
}
