package Serialization;

import Interface.Settings.Engine;
import Partie.*;

import java.util.ArrayList;

public class Serial_game {
    public Player player;
    public ArrayList<Room> rooms;
    public ArrayList<Action> actions;
    public ArrayList<Enigma> enigmas;
    public ArrayList<Item> items;
    public ArrayList<Text_scenario> texts;
    public int difficulty;
    public int timer;

    public Serial_game() {
        player = Game.player;
        rooms = Game.rooms;
        actions = Game.actions;
        enigmas = Game.enigmas;
        items = Game.items;
        texts = Game.texts;
        difficulty = Game.difficulty;
        if (Engine.chrono != null) {
            timer = Engine.chrono.getTimeFullSeconds();
        }else{
            timer = 0;
        }

    }

    public void createGameFromMemory() {
        Game.player = player;
        Game.difficulty = difficulty;
        Game.rooms = rooms;
        Game.actions = actions;
        Game.enigmas = enigmas;
        Game.items = items;
        Game.texts = texts;
        Game.timer = timer;
    }
}
