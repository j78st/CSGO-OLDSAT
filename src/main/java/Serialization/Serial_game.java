package Serialization;

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
        this.timer = Game.timer;
    }

    public Game createGameFromMemory() {
        Game game = new Game(player,difficulty);
        game.rooms = rooms;
        game.actions = actions;
        game.enigmas = enigmas;
        game.items = items;
        game.texts = texts;
        game.timer = timer;
        return game;
    }
}
